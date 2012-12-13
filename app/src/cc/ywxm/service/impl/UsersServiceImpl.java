package cc.ywxm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.UsersDao;
import cc.ywxm.model.Users;
import cc.ywxm.service.UsersService;
import cc.ywxm.utils.PasswordUtils;

@Transactional
@Service
public class UsersServiceImpl implements UsersService
{
	@Resource
	private UsersDao userDao;

	public int login(String userName, String password)
	{
		if (userName == null || password == null)
		{
			return 0;
		}
		password = PasswordUtils.generatePassword(password);
		boolean b = userDao.exist(userName, password);
		if (!b)
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	public void add(Users user)
	{
		if (user != null)
		{
			userDao.save(user);
		}
	}

	public void add(String userName, String password, Short userType,
			Double account, String userProp, Boolean valid, String note)
	{
		if (password != null && !"".equals(password))
		{
			password = PasswordUtils.generatePassword(password);
		}
		Users user = new Users(userName, password, userType, account, userProp,
				valid, note);
		userDao.save(user);
	}

	public void remove(Integer userId)
	{
		if (userId != null)
		{
			Users user = userDao.findById(userId);
			userDao.delete(user);
		}
	}

	public Users findById(Integer userId)
	{
		return null;
	}

	public Map<String, Object> list(Integer rows, Integer page,
			String userName, Short userType, Boolean valid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", userDao.list(rows, page, userName, userType, valid));
		map.put("total", userDao.count(userName, userType, valid));
		return map;
	}

	public void edit(Integer userId, String userName, Double account,
			String userProp, Boolean valid, String note)
	{
		if (userId != null)
		{
			Users user = userDao.findById(userId);
			user.setUserName(userName);
			user.setAccount(account);
			user.setNote(note);
			user.setValid(valid);
			user.setUserProp(userProp);
			userDao.update(user);
		}
	}

	public Users findByUserName(String userName)
	{
		return userDao.findByUserName(userName);
	}

	public int checkUserName(String userName)
	{
		return userDao.exist(userName) ? 1 : 0;
	}

	public int password_edit(String userName, String pwd, String password)
	{
		if (userName == null || pwd == null || password == null)
		{
			return 0;
		}
		if (!userDao.exist(userName, PasswordUtils.generatePassword(pwd)))
		{
			// 原密码错误
			return 2;
		} else
		{
			password = PasswordUtils.generatePassword(password);
			Users user = userDao.findByUserName(userName);
			user.setPassword(password);
			userDao.update(user);
			return 1;
		}

	}

}
