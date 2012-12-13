package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.Menus;

public interface MenusDao
{
	void save(Menus node);

	void delete(Menus node);

	void update(Menus node);

	Menus findById(Integer nodeId);

	List<Menus> findByParentId(Integer parentId);

	List<Menus> listLeaf();

	List<Menus> list();
}
