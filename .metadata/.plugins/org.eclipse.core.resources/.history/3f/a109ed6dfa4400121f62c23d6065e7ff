package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.service.GoodsTypeService;
import cc.ywxm.utils.PageableAction;

/**
 * 商品类型
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GoodsTypeAction extends PageableAction
{
	private Short typeId;
	private String typeName;
	private String note;
	private Boolean valid;

	@Resource
	private GoodsTypeService goodsTypeService;

	/**
	 * 商品类型添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsType_add() throws IOException, JSONException
	{
		try
		{
			goodsTypeService.add(typeName, note, valid);
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
	 * 商品类型修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsType_edit() throws IOException, JSONException
	{
		try
		{
			goodsTypeService.edit(typeId, typeName, note, valid);
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

	public String goodsType_remove() throws IOException, JSONException
	{
		try
		{
			goodsTypeService.remove(typeId);
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
	 * 商品类型查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsType_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsTypeService.list(rows,
				page, typeName, valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}
	
	/**
	 * 商品类型列表
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goodsType_gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsTypeService.list());
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
