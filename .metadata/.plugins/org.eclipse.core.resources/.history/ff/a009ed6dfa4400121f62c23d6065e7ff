package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.UserTypeRights;
import cc.ywxm.service.UserTypeRightsService;
import cc.ywxm.utils.PageableAction;

/**
 * 用户类型权限（菜单ID、商品ID）
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserTypeRightsAction extends PageableAction
{
	private Short userType;
	private String rights;
	private String goodsIds;
	private UserTypeRights userTypeRights;
	@Resource
	private UserTypeRightsService userTypeRightsService;

	/**
	 * 用户类型权限信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String userTypeRights_get() throws IOException, JSONException
	{
		userTypeRights = userTypeRightsService.findbyId(userType);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(userTypeRights);
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 用户类型商品关联
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String userTypeRights_goodsIds_set() throws IOException, JSONException
	{
		try
		{
			userTypeRightsService.goodsId_set(userType, goodsIds);
			message = "操作成功";
		} catch (Exception e)
		{
			message = "操作失败";
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 用户类型菜单关联
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String userTypeRights_rights_set() throws IOException, JSONException
	{
		try
		{
			userTypeRightsService.rights_set(userType, rights);
			message = "操作成功";
		} catch (Exception e)
		{
			message = "操作失败";
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	public Short getUserType()
	{
		return userType;
	}

	public void setUserType(Short userType)
	{
		this.userType = userType;
	}

	public UserTypeRights getUserTypeRights()
	{
		return userTypeRights;
	}

	public void setUserTypeRights(UserTypeRights userTypeRights)
	{
		this.userTypeRights = userTypeRights;
	}

	public String getRights()
	{
		return rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}

	public String getGoodsIds()
	{
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds)
	{
		this.goodsIds = goodsIds;
	}

}
