package cc.ywxm.service;

import java.util.List;

import cc.ywxm.model.UserType;

public interface UserTypeService
{
	/**
	 * 添加用户类型
	 * 
	 * @param node
	 */
	void add(UserType userType);

	/**
	 * 删除用户类型
	 * 
	 * @param typeId
	 *            用户类型ID
	 */
	void remove(Short typeId);

	/**
	 * 编辑用户类型
	 * 
	 * @param typeId
	 *            用户类型ID
	 * @param newNodes
	 */
	void edit(Short typeId, UserType newUserType);

	void edit(Short typeId, String typeName, String note, Boolean valid);

	/**
	 * 查询用户类型
	 * 
	 * @param typeId
	 *            用户类型ID
	 * @return
	 */
	UserType findById(Short typeId);

	/**
	 * @return 用户类型列表
	 */
	List<UserType> list();


}
