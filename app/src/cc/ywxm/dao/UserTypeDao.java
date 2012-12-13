package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.UserType;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface UserTypeDao
{
	void save(UserType userType);

	void delete(UserType userType);

	void update(UserType userType);

	UserType findById(Short typeId);

	int count(Object... args);

	List<UserType> list();
}
