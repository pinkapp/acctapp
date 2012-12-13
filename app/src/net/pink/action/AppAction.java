package net.pink.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import net.pink.utils.BaseAction;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
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
public class AppAction extends BaseAction {
	private String param = "";
	private Integer id;

	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String gets() throws IOException, JSONException {
		String jsonString = "";
		Map<String,Integer> map= new HashMap<String,Integer>();
		map.put("test", 1);
		map.put("test1", 1);
		map.put("test2", 1);
		map.put("test3", 1);
		map.put("test4", 1);
		map.put("test5", 1);
		map.put("aaa", id);
		jsonString = JSONUtil.serialize(map);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();
		return NONE;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}