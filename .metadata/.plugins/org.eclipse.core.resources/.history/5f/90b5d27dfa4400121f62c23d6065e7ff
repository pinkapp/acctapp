package cc.ywxm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.UserTypeDao;
import cc.ywxm.model.UserType;
import cc.ywxm.service.UserTypeService;

@Transactional
@Service
public class UserTypeServiceImpl implements UserTypeService
{
	@Resource
	private UserTypeDao userTypeDao;

	public void add(UserType userType)
	{
		if (userType != null)
		{
			userTypeDao.save(userType);
		}
	}

	public void remove(Short typeId)
	{
		if (typeId != null)
		{
			UserType userType = userTypeDao.findById(typeId);
			userTypeDao.delete(userType);
		}
	}

	public void edit(Short typeId, UserType newUserType)
	{
		if (typeId != null && newUserType != null)
		{
			UserType userType = userTypeDao.findById(typeId);
			if (newUserType.getTypeName() != null)
			{
				userType.setTypeName(newUserType.getTypeName());
			}
			if (newUserType.getValid() != null)
			{
				userType.setValid(newUserType.getValid());
			}
			if (newUserType.getNote() != null)
			{
				userType.setNote(newUserType.getNote());
			}
			userTypeDao.update(userType);
		}
	}

	public UserType findById(Short typeId)
	{
		return null;
	}

	public List<UserType> list()
	{
		return userTypeDao.list();
	}

	public void edit(Short typeId, String typeName, String note, Boolean valid)
	{
		if (typeId != null)
		{
			UserType userType = userTypeDao.findById(typeId);
			if (typeName != null)
			{
				userType.setTypeName(typeName);
			}
			if (note != null)
			{
				userType.setNote(note);
			}
			if (valid != null)
			{
				userType.setValid(valid);
			}
			userTypeDao.update(userType);
		}
	}

}
