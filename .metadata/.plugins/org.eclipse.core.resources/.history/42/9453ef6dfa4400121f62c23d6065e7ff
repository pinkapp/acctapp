package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.CardType;
import cc.ywxm.service.CardTypeService;
import cc.ywxm.utils.PageableAction;

/**
 * 充值卡类型
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CardTypeAction extends PageableAction
{
	private Short typeId;
	private String typeName;
	private String goodsType;
	private Integer faceValue;
	private Double price;
	private String note;
	private Boolean valid;
	private CardType cardType;

	@Resource
	private CardTypeService cardTypeService;

	/**
	 * 充值卡类型添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardType_add() throws IOException, JSONException
	{
		if ("".equals(goodsType))
		{
			message = "添加失败，商品类型不存在";
		} else
		{
			try
			{
				cardTypeService.add(typeName, goodsType, faceValue, price,
						note, valid);
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
	 * 充值卡类型修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardType_edit() throws IOException, JSONException
	{
		if ("".equals(goodsType))
		{
			message = "修改失败，商品类型不存在";
		} else
		{
			try
			{
				cardTypeService.edit(typeId, typeName, goodsType, faceValue,
						price, note, valid);
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

	public String cardType_remove() throws IOException, JSONException
	{
		try
		{
			cardTypeService.remove(typeId);
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
	 * 充值卡类型查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardType_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(cardTypeService.list(rows, page,
				typeName, goodsType, valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 充值卡类型列表
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardType_gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(cardTypeService.list());
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 充值卡类型信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardType_get() throws IOException, JSONException
	{
		cardType = cardTypeService.findById(typeId);
		return SUCCESS;
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

	public String getGoodsType()
	{
		return goodsType;
	}

	public void setGoodsType(String goodsType)
	{
		this.goodsType = goodsType;
	}

	public Integer getFaceValue()
	{
		return faceValue;
	}

	public void setFaceValue(Integer faceValue)
	{
		this.faceValue = faceValue;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
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

	public CardType getCardType()
	{
		return cardType;
	}

	public void setCardType(CardType cardType)
	{
		this.cardType = cardType;
	}

}
