package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.Goods;
import cc.ywxm.service.GoodsService;
import cc.ywxm.utils.PageableAction;

/**
 * 商品
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GoodsAction extends PageableAction
{
	private Integer goodsId;
	private String goodsType;
	private String goodsProp;
	private Double goodsPrice;
	private String note;
	private Boolean valid;
	private Goods goods;

	@Resource
	private GoodsService goodsService;

	/**
	 * 商品添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goods_add() throws IOException, JSONException
	{
		if ("".equals(goodsType))
		{
			message = "添加失败，商品类型不存在";
		} else if ("".equals(goodsProp))
		{
			message = "添加失败，商品属性不存在";
		} else
		{
			try
			{
				goodsService.add(goodsType, goodsProp, goodsPrice, note, valid);
				message = "添加成功";
			} catch (Exception e)
			{
				message = "添加失败";
				e.printStackTrace();
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 商品修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goods_edit() throws IOException, JSONException
	{
		if ("".equals(goodsType))
		{
			message = "修改失败，商品类型不存在";
		} else if ("".equals(goodsProp))
		{
			message = "修改失败，商品属性不存在";
		} else
		{
			try
			{
				goodsService.edit(goodsId, goodsType, goodsProp, goodsPrice,
						note, valid);
				message = "修改成功";
			} catch (Exception e)
			{
				message = "修改失败";
				e.printStackTrace();
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	/**
	 * 商品删除
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goods_remove() throws IOException, JSONException
	{
		try
		{
			goodsService.remove(goodsId);
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
	 * 商品查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goods_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsService.list(rows, page,
				goodsType, goodsProp, valid));
		System.out.println(jsonString);
		out.append(jsonString);
		out.close();
		return NONE;
	}
	
	public String goods_gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(goodsService.list(goodsType, goodsProp, valid));
		System.out.println(jsonString);
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 商品信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String goods_get() throws IOException, JSONException
	{
		goods = goodsService.findById(goodsId);
		return SUCCESS;
	}

	public Integer getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getGoodsType()
	{
		return goodsType;
	}

	public void setGoodsType(String goodsType)
	{
		this.goodsType = goodsType;
	}

	public String getGoodsProp()
	{
		return goodsProp;
	}

	public void setGoodsProp(String goodsProp)
	{
		this.goodsProp = goodsProp;
	}

	public Double getGoodsPrice()
	{
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice)
	{
		this.goodsPrice = goodsPrice;
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

	public Goods getGoods()
	{
		return goods;
	}

	public void setGoods(Goods goods)
	{
		this.goods = goods;
	}
}
