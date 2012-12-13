package cc.ywxm.service;

import java.util.Map;

import cc.ywxm.model.Cards;

public interface CardsService
{
	/**
	 * 添加充值卡
	 * 
	 * @param node
	 */
	void add(String cardType, String note, Boolean valid);

	/**
	 * 删除充值卡
	 * 
	 * @param cardId
	 *            充值卡ID
	 */
	void remove(Integer cardId);

	/**
	 * 修改充值卡
	 * 
	 * @param cardId
	 * @param cardType
	 * @param cardState
	 * @param note
	 * @param valid
	 */
	void edit(Integer cardId, String cardType, String cardState, String note,
			Boolean valid);

	/**
	 * 查询充值卡
	 * 
	 * @param cardId
	 *            充值卡ID
	 * @return
	 */
	Cards findById(Integer cardId);

	/**
	 * 分页查询充值卡
	 * 
	 * @param rows
	 * @param page
	 * @param cardType
	 * @param sn
	 * @param valid
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String cardType,
			String sn, Boolean valid);

}
