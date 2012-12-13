package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.Cards;
import cc.ywxm.service.CardsService;
import cc.ywxm.utils.PageableAction;

/**
 * 充值卡
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CardsAction extends PageableAction
{
	private Integer cardId;
	private String cardType;
	private String cardState;
	private String sn;
	private String note;
	private Boolean valid;
	private Cards card;

	@Resource
	private CardsService cardService;

	/**
	 * 充值卡添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cards_add() throws IOException, JSONException
	{
		if ("".equals(cardType))
		{
			message = "添加失败，充值卡类型不存在";
		} else
		{
			try
			{
				cardService.add(cardType, note, valid);
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
	 * 充值卡修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cards_edit() throws IOException, JSONException
	{
		if ("".equals(cardType))
		{
			message = "修改失败，充值卡类型不存在";
		} else
		{
			try
			{
				cardService.edit(cardId, cardType, cardState, note, valid);
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
	 * 充值卡删除
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cards_remove() throws IOException, JSONException
	{
		try
		{
			cardService.remove(cardId);
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
	 * 充值卡查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cards_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(cardService.list(rows, page,
				cardType, sn, valid));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 充值卡信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cards_get() throws IOException, JSONException
	{
		card = cardService.findById(cardId);
		return SUCCESS;
	}

	public Integer getCardId()
	{
		return cardId;
	}

	public void setCardId(Integer cardId)
	{
		this.cardId = cardId;
	}

	public String getCardType()
	{
		return cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public String getCardState()
	{
		return cardState;
	}

	public void setCardState(String cardState)
	{
		this.cardState = cardState;
	}

	public String getSn()
	{
		return sn;
	}

	public void setSn(String sn)
	{
		this.sn = sn;
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

	public Cards getCard()
	{
		return card;
	}

	public void setCard(Cards card)
	{
		this.card = card;
	}

}
