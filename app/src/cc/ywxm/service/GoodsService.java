package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.Goods;

public interface GoodsService
{
	/**
	 * 添加商品
	 * 
	 * @param node
	 */
	void add(String goodsType, String goodsProp, Double goodsPrice,
			String note, Boolean valid);

	/**
	 * 删除商品
	 * 
	 * @param goodsId
	 *            商品ID
	 */
	void remove(Integer goodsId);

	/**
	 * 修改商品
	 * 
	 * @param goodsId
	 * @param goodsName
	 * @param note
	 * @param valid
	 */
	void edit(Integer goodsId, String goodsType, String goodsProp,
			Double goodsPrice, String note, Boolean valid);

	/**
	 * 查询商品
	 * 
	 * @param goodsId
	 *            商品ID
	 * @return
	 */
	Goods findById(Integer goodsId);

	/**
	 * 分页查询商品
	 * 
	 * @param rows
	 * @param page
	 * @param goodsName
	 * @param valid
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String goodsType,
			String goodsProp, Boolean valid);

	/**
	 * 
	 * @param goodsType
	 * @param goodsProp
	 * @param valid
	 * @return
	 */
	List<Goods> list(String goodsType, String goodsProp, Boolean valid);

}
