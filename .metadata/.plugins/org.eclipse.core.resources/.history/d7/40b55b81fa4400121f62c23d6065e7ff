package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.GoodsType;

public interface GoodsTypeService
{
	/**
	 * 添加商品类型
	 * 
	 * @param node
	 */
	void add(String typeName, String note, Boolean valid);

	/**
	 * 删除商品类型
	 * 
	 * @param typeId
	 *            商品类型ID
	 */
	void remove(Short typeId);

	/**
	 * 修改商品类型
	 * 
	 * @param typeId
	 * @param typeName
	 * @param note
	 * @param valid
	 */
	void edit(Short typeId, String typeName, String note, Boolean valid);

	/**
	 * 查询商品类型
	 * 
	 * @param typeId
	 *            商品类型ID
	 * @return
	 */
	GoodsType findById(Short typeId);

	/**
	 * 分页查询商品类型
	 * 
	 * @param rows
	 * @param page
	 * @param typeName
	 * @param valid
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String typeName,
			Boolean valid);

	/**
	 * 商品类型列表
	 * 
	 * @return
	 */
	List<GoodsType> list();

}
