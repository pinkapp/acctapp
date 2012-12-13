package cc.ywxm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.MenusDao;
import cc.ywxm.dao.UserTypeRightsDao;
import cc.ywxm.model.Menus;
import cc.ywxm.model.UserTypeRights;
import cc.ywxm.service.UserTypeRightsService;

@Transactional
@Service
public class UserTypeRightsServiceImpl implements UserTypeRightsService
{
	@Resource
	private UserTypeRightsDao userTypeRightsDao;
	@Resource
	private MenusDao menusDao;

	public List<Integer> listRights(Short userType)
	{
		if (userType != null)
		{
			UserTypeRights userTypeRights=null;
			try {
				userTypeRights = userTypeRightsDao
						.findById(userType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (userTypeRights != null)
			{
				String rights = userTypeRights.getRights();
				if (rights != null)
				{
					List<Integer> listRights = new ArrayList<Integer>();
					if ("全部".equals(rights.trim()))
					{
						List<Menus> listMenus = menusDao.list();
						for (Menus menus : listMenus)
						{
							listRights.add(menus.getId());
						}
					} else
					{
						if (!rights.trim().equals(""))
						{
							String[] strs = rights.split(",");

							for (String str : strs)
							{
								listRights.add(Integer.parseInt(str));
							}
						}
					}
					return listRights;
				}
			}
		}
		return null;
	}

	public void editRights(Short userType, String rights)
	{
		if (userType != null && rights != null)
		{
			UserTypeRights userTypeRights = userTypeRightsDao
					.findById(userType);
			rights = rights.replace(" ", "");
			if (rights.equals(""))
				userTypeRights.setRights(null);
			else
			{
				userTypeRights.setRights(rights);
			}
			userTypeRightsDao.update(userTypeRights);
		}
	}

	public UserTypeRights findbyId(Short userType)
	{
		if (userType != null)
		{
			return userTypeRightsDao.findById(userType);
		}
		return null;
	}

	public void edit(Short userType, String rights, String goodsIds)
	{
		if (userType != null)
		{
			UserTypeRights userTypeRights = userTypeRightsDao
					.findById(userType);
			if (userTypeRights == null)
			{
				userTypeRights = new UserTypeRights(userType, rights, goodsIds);
				userTypeRightsDao.save(userTypeRights);
			} else
			{
				userTypeRights.setRights(rights);
				userTypeRights.setGoodsIds(goodsIds);
				userTypeRightsDao.update(userTypeRights);
			}
		}
	}

	public void rights_set(Short userType, String rights)
	{
		if (userType != null)
		{
			UserTypeRights userTypeRights = userTypeRightsDao
					.findById(userType);
			if (rights != null)
			{
				rights = rights.replace(" ", "");
			}
			if (userTypeRights == null)
			{
				userTypeRights = new UserTypeRights(userType, rights, null);
				userTypeRightsDao.save(userTypeRights);
			} else
			{
				userTypeRights.setRights(rights);
				userTypeRightsDao.update(userTypeRights);
			}
		}
	}

	public void goodsId_set(Short userType, String goodsIds)
	{
		if (userType != null)
		{
			UserTypeRights userTypeRights = userTypeRightsDao
					.findById(userType);
			if (goodsIds != null)
			{
				goodsIds = goodsIds.replace(" ", "");
			}
			if (userTypeRights == null)
			{
				userTypeRights = new UserTypeRights(userType, null, goodsIds);
				userTypeRightsDao.save(userTypeRights);
			} else
			{
				userTypeRights.setGoodsIds(goodsIds);
				userTypeRightsDao.update(userTypeRights);
			}
		}
	}

}
