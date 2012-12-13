package cc.ywxm.service;

import java.util.Map;

import cc.ywxm.model.Users;

public interface UsersService
{
	/**
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录状态码
	 */
	int login(String userName, String password);

	/**
	 * 添加用户
	 * 
	 * @param node
	 */
	void add(Users user);

	/**
	 * 添加代理
	 * 
	 * @param userName
	 * @param password
	 * @param account
	 * @param userProp
	 * @param valid
	 * @param note
	 */
	void add(String userName, String password, Short userType, Double account,
			String userProp, Boolean valid, String note);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 *            用户ID
	 */
	void remove(Integer userId);

	/**
	 * 编辑用户
	 * 
	 * @param userId
	 * @param userName
	 * @param note
	 * @param valid
	 */
	void edit(Integer userId, String userName, Double account, String userProp,
			Boolean valid, String note);

	/**
	 * 查询用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	Users findById(Integer userId);

	Users findByUserName(String userName);

	Map<String, Object> list(Integer rows, Integer page, String userName,
			Short userType, Boolean valid);

	/**
	 * 检查用户名
	 * 
	 * @param userName
	 * @return
	 */
	int checkUserName(String userName);

	/**
	 * 修改密码
	 * 
	 * @param userName
	 * @param pwd
	 * @param password
	 * @return
	 */

	int password_edit(String userName, String pwd, String password);

}
