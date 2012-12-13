package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.GoodsProp;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface GoodsPropDao
{
	void save(GoodsProp goodsProp);

	void delete(GoodsProp goodsProp);

	void update(GoodsProp goodsProp);

	GoodsProp findById(Short typeId);

	int count(String typeName, Boolean valid);

	List<GoodsProp> list(Integer rows, Integer page, String typeName,
			Boolean valid);

	List<GoodsProp> list();
}
