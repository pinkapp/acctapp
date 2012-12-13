package net.pink.interceptor;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.pink.utils.Constants;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import cc.ywxm.service.UsersService;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@Component
public class SafeInterceptor implements Interceptor
{

	private static final long serialVersionUID = 6783914372473093519L;
	private List<String> actions = new ArrayList<String>();
	@Autowired
	private UsersService usersService;

	public void destroy()
	{

	}

	public void init()
	{
		actions.add("login");
		actions.add("getSession");
	}

	/**
	 * 后台安全拦截器，防止非法操作
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{
		System.out.println("begin check login interceptor!");
		String actionName = actionInvocation.getProxy().getActionName();
		String namespace = actionInvocation.getProxy().getNamespace();
		if (actions.contains(actionName))
		{
			System.out.println(namespace + "/" + actionName
					+ " pass! because this is a vip!");
			return actionInvocation.invoke();
		}
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();

		String userId = (String) session.get(Constants.USER_SESSIONID);
		if (userId != null)
		{
			System.out.println(namespace + "/" + actionName
					+ " pass! because this is a logined user!");
			return actionInvocation.invoke();
		} else
		{
			HttpServletRequest request = (HttpServletRequest) actionInvocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
			Cookie[] cookies = request.getCookies();
			// 检测cookies中是否存在验证登录的cookie，有则尝试登录，并调用action
			if (cookies != null)
			{
				for (Cookie cookie : cookies)
				{
					if (Constants.AUTH_COOKIE.equals(cookie.getName()))
					{
						String auth = cookie.getValue();
						BASE64Decoder decoder = new BASE64Decoder();
						auth = new String(decoder.decodeBuffer(auth));
						auth = URLDecoder.decode(auth, "utf-8");
						String[] auths = auth.split(",");
						if (auths.length == 2)
						{
							int f = usersService.login(auths[0], auths[1]);
							if (f > 0)
							{
								session.put(Constants.USER_SESSIONID, f);
								// String loginIP = WebUtils.getIpAddr(request);
								// usersService.updateLoginInfo(f, loginIP);
								System.out.println(namespace + "/" + actionName
										+ " pass! because autologin!");
								return actionInvocation.invoke();
							}
						}

					}
				}
			}
			StringBuffer url = request.getRequestURL();
			String queryString = request.getQueryString();
			if (request.getQueryString() != null)
			{
				url.append("?" + queryString);
			}
			System.out.println(namespace + "/" + actionName
					+ " don't pass! because unlogin!");
			request.setAttribute("prepage", url.toString());
			HttpServletResponse response = (HttpServletResponse) actionInvocation
					.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
			try
			{
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Cache-Control", "no-cache");
				PrintWriter out = response.getWriter();
				out.append("非法请求");
				out.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}
}