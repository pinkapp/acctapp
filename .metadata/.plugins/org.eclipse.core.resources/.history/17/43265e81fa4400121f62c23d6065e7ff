package cc.ywxm.service;

import java.util.List;

import cc.ywxm.model.Menus;

public interface MenusService
{
	/**
	 * 添加菜单
	 * 
	 * @param node
	 */
	void add(Menus node);

	/**
	 * 删除菜单
	 * 
	 * @param nodeId
	 *            菜单ID
	 */
	void remove(Integer nodeId);

	/**
	 * 编辑菜单
	 * 
	 * @param nodeId
	 *            菜单ID
	 * @param newNodes
	 */
	void edit(Integer nodeId, Menus newNodes);

	/**
	 * 查询菜单
	 * 
	 * @param nodeId
	 *            菜单ID
	 * @return
	 */
	Menus findById(Integer nodeId);
	
	/**
	 * 指定父菜单ID查询子菜单列表
	 * 
	 * @param parentId
	 * @return 菜单列表
	 */
	List<Menus> list(Integer parentId);

	Boolean has_child(Integer id);

}
