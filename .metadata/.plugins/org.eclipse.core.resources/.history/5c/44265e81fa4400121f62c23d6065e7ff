package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.CardState;

public interface CardStateService
{
	/**
	 * 添加充值卡状态
	 * 
	 * @param stateName
	 */
	void add(String stateName);

	/**
	 * 删除充值卡状态
	 * 
	 * @param stateId
	 *            充值卡状态ID
	 */
	void remove(Short stateId);

	/**
	 * 修改充值卡状态
	 * 
	 * @param stateId
	 * @param stateName
	 */
	void edit(Short stateId, String stateName);

	/**
	 * 查询充值卡状态
	 * 
	 * @param stateId
	 *            充值卡状态ID
	 * @return
	 */
	CardState findById(Short stateId);

	/**
	 * 分页查询充值卡状态
	 * @param rows
	 * @param page
	 * @param stateName
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String stateName);

	/**
	 * 充值卡状态列表
	 * 
	 * @return
	 */
	List<CardState> list();

}
