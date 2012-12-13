package cc.ywxm.dao;

import cc.ywxm.model.UserTypeRights;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface UserTypeRightsDao
{
	 void save(UserTypeRights userTypeRights);

	// void delete(UserTypeRights userTypeRights);

	void update(UserTypeRights userTypeRights);

	UserTypeRights findById(Short typeId);

	// int count(Object... args);

	// List<UserTypeRights> list(Integer rows, Integer page, Object... args);
}
