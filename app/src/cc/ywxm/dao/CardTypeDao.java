package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.CardType;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface CardTypeDao
{
	void save(CardType cardType);

	void delete(CardType cardType);

	void update(CardType cardType);

	CardType findById(Short typeId);

	int count(String typeName,String goodsType, Boolean valid);

	List<CardType> list(Integer rows, Integer page, String typeName,String goodsType,
			Boolean valid);

	List<CardType> list();
}
