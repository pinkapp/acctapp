package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.service.GoodsPropService;
import cc.ywxm.utils.PageableAction;

/**
 * 商品属性
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GoodsPropAction extends PageableAction
{
	private Short typeId;
	private String typeName;
	private String note;
	private Boolean valid;

	@Resource
	private GoodsPropService goodsPropService;

	/**
	 * 商品属性添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsProp_add() throws IOException, JSONException
	{
		try
		{
			goodsPropService.add(typeName, note, valid);
			message = "添加成功";
		} catch (Exception e)
		{
			message = "添加失败";
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
	 * 商品属性修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsProp_edit() throws IOException, JSONException
	{
		try
		{
			goodsPropService.edit(typeId, typeName, note, valid);
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

	public String goodsProp_remove() throws IOException, JSONException
	{
		try
		{
			goodsPropService.remove(typeId);
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
	 * 商品属性查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsProp_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsPropService.list(rows,
				page, typeName, valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}
	
	public String goodsProp_gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsPropService.list());
		out.append(jsonString);
		out.close();
		return NONE;
	}

	public Short getTypeId()
	{
		return typeId;
	}

	public void setTypeId(Short typeId)
	{
		this.typeId = typeId;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	public Boolean getValid()
	{
		return valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

}
