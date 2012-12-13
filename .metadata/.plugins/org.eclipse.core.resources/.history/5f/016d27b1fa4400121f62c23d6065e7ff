package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.Users;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface UsersDao
{
	void save(Users user);

	void delete(Users user);

	void update(Users user);

	Users findById(Integer userId);

	int count(String userName, Short userType, Boolean valid);

	List<Users> list(Integer rows, Integer page, String userName,
			Short userType, Boolean valid);

	boolean exist(String userName, String password);

	Users findByUserName(String userName);

	boolean exist(String userName);
}
