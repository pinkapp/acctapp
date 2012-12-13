package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.ContactInfo;
import cc.ywxm.service.ContactInfoService;
import cc.ywxm.utils.Constants;
import cc.ywxm.utils.PageableAction;

/**
 * 联系方式
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ContactInfoAction extends PageableAction
{
	private String userName;
	private String qq;
	private String phone;
	private String aliwangwang;
	private ContactInfo contactInfo;

	@Resource
	private ContactInfoService contactInfoService;

	public String contactInfo_get() throws IOException
	{
		if (userName == null)
		{
			userName = (String) session.get(Constants.USER_SESSIONID);
		}
		contactInfo = contactInfoService.findById(userName);
		if (contactInfo != null)
		{
			return SUCCESS;
		} else
		{
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();
			out.append("无数据");
			out.close();
			return NONE;
		}
	}

	public String contactInfo_get2() throws IOException, JSONException
	{
		if (userName == null)
		{
			userName = (String) session.get(Constants.USER_SESSIONID);
		}
		contactInfo = contactInfoService.findById(userName);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(contactInfo);
		out.append(jsonString);
		out.close();
		return NONE;
	}

	public String contactInfo_edit() throws IOException, JSONException
	{
		if (userName == null)
		{
			userName = (String) session.get(Constants.USER_SESSIONID);
		}
		try
		{
			contactInfoService.edit(userName, qq, phone, aliwangwang);
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

	public void setContactInfo(ContactInfo contactInfo)
	{
		this.contactInfo = contactInfo;
	}

	public ContactInfo getContactInfo()
	{
		return contactInfo;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAliwangwang()
	{
		return aliwangwang;
	}

	public void setAliwangwang(String aliwangwang)
	{
		this.aliwangwang = aliwangwang;
	}

}
