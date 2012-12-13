package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.UserType;
import cc.ywxm.model.Users;
import cc.ywxm.service.UserTypeService;
import cc.ywxm.service.UsersService;
import cc.ywxm.utils.Constants;
import cc.ywxm.utils.PageableAction;
import cc.ywxm.utils.WebUtils;

/**
 * 用户（管理员、代理、厂商等）
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UsersAction extends PageableAction
{
	private Integer userId;
	private String userName;
	private String password;
	private Short userType;
	private Double account;
	private String userProp;
	private String note;
	private Boolean valid;
	private String pwd;

	@Resource
	private UsersService userService;
	@Resource
	private UserTypeService userTypeService;

	/**
	 * 会话信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String getSession() throws IOException, JSONException
	{
		Object userSession = session.get(Constants.USER_SESSIONID);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(JSONUtil.serialize(userSession));
		out.close();
		return NONE;
	}

	/**
	 * 会话详细信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String getSessionInfo() throws IOException, JSONException
	{
		Object userSession = session.get(Constants.USER_SESSIONID);
		Users user = userService.findByUserName((String) userSession);
		String ipAddress = WebUtils.getIpAddr(request);
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("userName", userSession);
		info.put("ipAddress", ipAddress);
		String utstr = "未知";
		if (user.getUserType() != null)
		{
			List<UserType> userTypelist = userTypeService.list();
			Map<Short, String> map = new HashMap<Short, String>();
			for (UserType ut : userTypelist)
			{
				map.put(ut.getTypeId(), ut.getTypeName());
			}
			utstr = map.get(user.getUserType());
		}
		info.put("userType", utstr);
		info.put("userTypeId", user.getUserType());
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(JSONUtil.serialize(info));
		out.close();
		return NONE;
	}

	/**
	 * 登入
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String login() throws IOException, JSONException
	{
		int code = userService.login(userName, password);
		if (code == 1)
		{
			session.put(Constants.USER_SESSIONID, userName);
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(JSONUtil.serialize(code));
		out.close();
		return NONE;

	}

	/**
	 * 登出
	 * 
	 * @return
	 * @throws IOException
	 */
	public String logout() throws IOException
	{
		session.remove(Constants.USER_SESSIONID);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(null);
		out.close();
		return NONE;

	}

	/**
	 * 代理添加
	 * 
	 * @return
	 * @throws IOException
	 */
	public String password_edit() throws IOException
	{
		userName = (String) session.get(Constants.USER_SESSIONID);
		int code = userService.password_edit(userName, pwd, password);
		switch (code)
		{
		case 1:
			message = "修改成功";
			break;
		case 2:
			message = "修改失败，原密码错误";
			break;
		default:
			message = "修改失败";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 客户添加
	 * 
	 * @return
	 * @throws IOException
	 */
	public String customer_add() throws IOException
	{
		int checkCode = userService.checkUserName(userName);
		switch (checkCode)
		{
		case 0:
			try
			{
				userService.add(userName, password,
						new Integer(4).shortValue(), account, userProp, valid,
						note);
				message = "添加成功";
			} catch (Exception e)
			{
				message = "添加失败";
				e.printStackTrace();
			}

			break;
		case 1:
			message = "添加失败，用户名重复";
			break;
		default:
			message = "添加失败，用户名错误";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 客户查询
	 * 
	 * @return
	 */
	public String customer_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(userService.list(rows, page,
				userName, new Integer(4).shortValue(), valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 客户删除
	 * 
	 * @return
	 * @throws IOException
	 */
	public String customer_remove() throws IOException
	{
		try
		{
			userService.remove(userId);
			message = "删除成功";
		} catch (Exception e)
		{
			message = "删除失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 客户修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String customer_edit() throws IOException, JSONException
	{
		try
		{
			userService.edit(userId, userName, account, userProp, valid, note);
			message = "修改成功";
		} catch (Exception e)
		{
			message = "修改失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 厂商添加
	 * 
	 * @return
	 * @throws IOException
	 */
	public String firm_add() throws IOException
	{
		int checkCode = userService.checkUserName(userName);
		switch (checkCode)
		{
		case 0:
			try
			{
				userService.add(userName, password,
						new Integer(2).shortValue(), account, userProp, valid,
						note);
				message = "添加成功";
			} catch (Exception e)
			{
				message = "添加失败";
				e.printStackTrace();
			}

			break;
		case 1:
			message = "添加失败，用户名重复";
			break;
		default:
			message = "添加失败，用户名错误";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 厂商查询
	 * 
	 * @return
	 */
	public String firm_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(userService.list(rows, page,
				userName, new Integer(2).shortValue(), valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 厂商删除
	 * 
	 * @return
	 * @throws IOException
	 */
	public String firm_remove() throws IOException
	{
		try
		{
			userService.remove(userId);
			message = "删除成功";
		} catch (Exception e)
		{
			message = "删除失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 厂商修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String firm_edit() throws IOException, JSONException
	{
		try
		{
			userService.edit(userId, userName, account, userProp, valid, note);
			message = "修改成功";
		} catch (Exception e)
		{
			message = "修改失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 代理添加
	 * 
	 * @return
	 * @throws IOException
	 */
	public String agency_add() throws IOException
	{
		int checkCode = userService.checkUserName(userName);
		switch (checkCode)
		{
		case 0:
			try
			{
				userService.add(userName, password,
						new Integer(3).shortValue(), account, userProp, valid,
						note);
				message = "添加成功";
			} catch (Exception e)
			{
				message = "添加失败";
				e.printStackTrace();
			}

			break;
		case 1:
			message = "添加失败，用户名重复";
			break;
		default:
			message = "添加失败，用户名错误";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 代理查询
	 * 
	 * @return
	 */
	public String agency_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(userService.list(rows, page,
				userName, new Integer(3).shortValue(), valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 代理删除
	 * 
	 * @return
	 * @throws IOException
	 */
	public String agency_remove() throws IOException
	{
		try
		{
			userService.remove(userId);
			message = "删除成功";
		} catch (Exception e)
		{
			message = "删除失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 代理修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String agency_edit() throws IOException, JSONException
	{
		try
		{
			userService.edit(userId, userName, account, userProp, valid, note);
			message = "修改成功";
		} catch (Exception e)
		{
			message = "修改失败";
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Short getUserType()
	{
		return userType;
	}

	public void setUserType(Short userType)
	{
		this.userType = userType;
	}

	public Double getAccount()
	{
		return account;
	}

	public void setAccount(Double account)
	{
		this.account = account;
	}

	public String getUserProp()
	{
		return userProp;
	}

	public void setUserProp(String userProp)
	{
		this.userProp = userProp;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Boolean getValid()
	{
		return valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

}
