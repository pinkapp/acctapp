package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.Goods;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface GoodsDao
{
	void save(Goods goods);

	void delete(Goods goods);

	void update(Goods goods);

	Goods findById(Integer goodsId);

	int count(String goodsType, String goodsProp, Boolean valid);

	List<Goods> list(Integer rows, Integer page, String goodsType, String goodsProp,
			Boolean valid);

	List<Goods> list(String goodsType, String goodsProp, Boolean valid);
}
