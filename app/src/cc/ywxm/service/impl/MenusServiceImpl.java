package cc.ywxm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.MenusDao;
import cc.ywxm.model.Menus;
import cc.ywxm.service.MenusService;

@Transactional
@Service
public class MenusServiceImpl implements MenusService
{
	@Resource
	private MenusDao menusDao;

	public void add(Menus node)
	{

	}

	public void remove(Integer nodeId)
	{

	}

	public void edit(Integer nodeId, Menus newNodes)
	{

	}

	public Menus findById(Integer nodeId)
	{
		return null;
	}

	public List<Menus> list(Integer parentId)
	{
		if (parentId != null)
		{
			return menusDao.findByParentId(parentId);
		} else
		{
			return null;
		}
	}

	public Boolean has_child(Integer id)
	{
		List<Menus> menu_list = menusDao.findByParentId(id);
		if (menu_list == null || menu_list.size() == 0)
		{
			return false;
		}
		return true;
	}

}
