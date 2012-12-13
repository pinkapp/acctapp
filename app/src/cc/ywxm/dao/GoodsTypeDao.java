package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.GoodsType;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface GoodsTypeDao
{
	void save(GoodsType goodsType);

	void delete(GoodsType goodsType);

	void update(GoodsType goodsType);

	GoodsType findById(Short typeId);

	int count(String typeName, Boolean valid);

	List<GoodsType> list(Integer rows, Integer page, String typeName,
			Boolean valid);

	List<GoodsType> list();
}
