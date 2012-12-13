package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.model.Menus;
import cc.ywxm.model.Node;
import cc.ywxm.model.Users;
import cc.ywxm.service.MenusService;
import cc.ywxm.service.UserTypeRightsService;
import cc.ywxm.service.UsersService;
import cc.ywxm.utils.Constants;
import cc.ywxm.utils.PageableAction;

/**
 * 树形菜单（权限设置）（tree）
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class NodesAction extends PageableAction
{
	private Menus node;
	private Integer id;
	private Short userTypeId;
	private String rights;

	@Resource
	private MenusService menusService;
	@Resource
	private UserTypeRightsService userTypeRightsService;
	@Resource
	private UsersService usersService;

	/**
	 * 树形菜单数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String tree_menu_getdata() throws IOException, JSONException
	{
		if (id == null)
		{
			id = 0;
		}
		List<Integer> rights = null;
		if (userTypeId != null)
		{
			rights = userTypeRightsService.listRights(userTypeId);
		} else
		{
			Users user = usersService.findByUserName((String) session
					.get(Constants.USER_SESSIONID));
			rights = userTypeRightsService.listRights(user.getUserType());
		}
		List<Menus> menu_list = menusService.list(id);
		List<Menus> filter_menu_list = new ArrayList<Menus>();
		for (Menus menus : menu_list)
		{
			if (rights != null && rights.contains(menus.getId().intValue()))
			{
				filter_menu_list.add(menus);
			}
		}
		List<Node> nodes = new ArrayList<Node>();
		for (Menus menu : filter_menu_list)
		{
			Boolean has_child = menusService.has_child(menu.getId());
			nodes.add(new Node(menu.getId(), menu.getName(),
					has_child ? "closed" : "open", menu));
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONUtil.serialize(nodes);
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 树形菜单数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String tree_menu_getdata2() throws IOException, JSONException
	{
		Node all = new Node(0, "全部", null);
		fetchChilren(all);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		List<Node> all_list = new ArrayList<Node>();
		all.setState(null);
		List<Integer> checkIds = userTypeRightsService.listRights(userTypeId);
		checkNode(all, checkIds);
		all_list.add(all);
		String jsonString = JSONUtil.serialize(all_list, null, null, true,
				true, true);
		// System.out.println(jsonString);
		out.append(jsonString);
		out.close();
		return NONE;
	}

	/**
	 * 权限设置（仅管理员）
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String editRight() throws IOException, JSONException
	{
		Users user = usersService.findByUserName((String) session
				.get(Constants.USER_SESSIONID));
		if (user.getUserType() == 1)
		{
			try
			{
				userTypeRightsService.editRights(userTypeId, rights);
				message = "1";
			} catch (Exception e)
			{
				message = "2";
				e.printStackTrace();
			}
		} else
		{
			message = "0";
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

	private void checkNode(Node node, List<Integer> checkIds)
	{
		if (checkIds != null && checkIds.contains(node.getId()))
		{
			node.setChecked(true);
		}
		if (node.getChildren() != null)
		{
			node.setChecked(null);
			for (Node n : node.getChildren())
			{
				checkNode(n, checkIds);
			}
		}
	}

	private void fetchChilren(Node node)
	{
		List<Menus> menu_list = menusService.list(node.getId());
		if (menu_list != null && menu_list.size() != 0)
		{
			node.setState("closed");
			List<Node> children = new ArrayList<Node>();
			for (Menus menus : menu_list)
			{
				Node child = new Node(menus.getId(), menus.getName(), null);
				children.add(child);
				fetchChilren(child);

			}
			node.setChildren(children);
		}
	}

	public Menus getNodes()
	{
		return node;
	}

	public void setNodes(Menus node)
	{
		this.node = node;
	}

	public Menus getNode()
	{
		return node;
	}

	public void setNode(Menus node)
	{
		this.node = node;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Short getUserTypeId()
	{
		return userTypeId;
	}

	public void setUserTypeId(Short userTypeId)
	{
		this.userTypeId = userTypeId;
	}

	public String getRights()
	{
		return rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}
}
