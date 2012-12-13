package net.pink.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.pink.service.AccountService;
import net.pink.utils.BaseAction;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 *
 * @author HuangDeCai
 * @since 2012-12-10 22:13:57
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AccountAction extends BaseAction {

	private Integer id;
	private String date;

	public void setDate(String date) {
		this.date = date;
	}

	private String item;
	private Short category;
	private Double money;
	private String note;
	@Autowired
	private AccountService accountService;

	/**
	 *
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String add() throws IOException, JSONException {
		String jsonString = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int code = accountService.add(d, item, category, money, note);
		jsonString = JSONUtil.serialize(code);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();
		return NONE;
	}

	public String getDate() {
		return date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Short getCategory() {
		return category;
	}

	public void setCategory(Short category) {
		this.category = category;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}