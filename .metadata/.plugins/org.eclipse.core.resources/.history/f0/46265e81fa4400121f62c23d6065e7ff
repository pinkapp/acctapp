package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.CardType;

public interface CardTypeService
{
	/**
	 * 添加充值卡类型
	 * 
	 * @param typeName
	 * @param goodsType
	 * @param faceValue
	 * @param price
	 * @param note
	 * @param valid
	 */
	void add(String typeName, String goodsType, Integer faceValue,
			Double price, String note, Boolean valid);

	/**
	 * 删除充值卡类型
	 * 
	 * @param typeId
	 *            充值卡类型ID
	 */
	void remove(Short typeId);

	/**
	 * 修改充值卡类型
	 * 
	 * @param typeId
	 * @param typeName
	 * @param goodsType
	 * @param faceValue
	 * @param price
	 * @param note
	 * @param valid
	 */
	void edit(Short typeId, String typeName, String goodsType,
			Integer faceValue, Double price, String note, Boolean valid);

	/**
	 * 查询充值卡类型
	 * 
	 * @param typeId
	 *            充值卡类型ID
	 * @return
	 */
	CardType findById(Short typeId);

	/**
	 * 分页查询充值卡类型
	 * 
	 * @param rows
	 * @param page
	 * @param typeName
	 * @param valid
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String typeName,
			String goodsType, Boolean valid);

	/**
	 * 充值卡类型列表
	 * 
	 * @return
	 */
	List<CardType> list();

}
