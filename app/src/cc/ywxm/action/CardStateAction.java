package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.CardState;
import cc.ywxm.service.CardStateService;
import cc.ywxm.utils.PageableAction;

/**
 * 充值卡状态
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CardStateAction extends PageableAction
{
	private Short stateId;
	private String stateName;
	private CardState cardState;

	@Resource
	private CardStateService cardStateService;

	/**
	 * 充值卡状态添加
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardState_add() throws IOException, JSONException
	{
		try
		{
			cardStateService.add(stateName);
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
	 * 充值卡状态修改
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardState_edit() throws IOException, JSONException
	{
		try
		{
			cardStateService.edit(stateId, stateName);
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

	public String cardState_remove() throws IOException, JSONException
	{
		try
		{
			cardStateService.remove(stateId);
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
	 * 充值卡状态查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardState_query() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(cardStateService.list(rows,
				page, stateName));
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 充值卡状态列表
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardState_gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(cardStateService.list());
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 充值卡状态信息
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String cardState_get() throws IOException, JSONException
	{
		cardState = cardStateService.findById(stateId);
		return SUCCESS;
	}

	public Short getStateId()
	{
		return stateId;
	}

	public void setStateId(Short stateId)
	{
		this.stateId = stateId;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	public CardState getCardState()
	{
		return cardState;
	}

	public void setCardState(CardState cardState)
	{
		this.cardState = cardState;
	}

}
