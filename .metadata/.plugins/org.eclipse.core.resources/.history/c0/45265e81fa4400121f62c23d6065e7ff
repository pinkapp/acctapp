package cc.ywxm.service;

import cc.ywxm.model.ContactInfo;

public interface ContactInfoService
{
	/**
	 * 添加用户联系方式
	 * 
	 * @param node
	 */
	void add(Integer userId, String qq, String phone, String aliwangwang);

	/**
	 * 删除用户联系方式
	 * 
	 * @param userId
	 *            用户联系方式ID
	 */
	void remove(Integer userId);

	/**
	 * 修改用户联系方式
	 * 
	 * @param userName
	 * @param typeName
	 * @param note
	 * @param valid
	 */
	void edit(String userName, String qq, String phone, String aliwangwang);

	/**
	 * 查询用户联系方式
	 * 
	 * @param userName
	 *            用户联系方式ID-用户名
	 * @return
	 */
	ContactInfo findById(String userName);

}
