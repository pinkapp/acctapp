package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.GoodsProp;

public interface GoodsPropService
{
	/**
	 * 添加商品属性
	 * 
	 * @param node
	 */
	void add(String typeName, String note, Boolean valid);

	/**
	 * 删除商品属性
	 * 
	 * @param typeId
	 *            商品属性ID
	 */
	void remove(Short typeId);

	/**
	 * 修改商品属性
	 * 
	 * @param typeId
	 * @param typeName
	 * @param note
	 * @param valid
	 */
	void edit(Short typeId, String typeName, String note, Boolean valid);

	/**
	 * 查询商品属性
	 * 
	 * @param typeId
	 *            商品属性ID
	 * @return
	 */
	GoodsProp findById(Short typeId);

	/**
	 * 分页查询商品属性
	 * 
	 * @param rows
	 * @param page
	 * @param typeName
	 * @param valid
	 * @return
	 */
	Map<String, Object> list(Integer rows, Integer page, String typeName,
			Boolean valid);

	List<GoodsProp> list();

}
