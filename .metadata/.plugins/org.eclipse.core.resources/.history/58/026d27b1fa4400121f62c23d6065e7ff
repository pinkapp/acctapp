package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.Cards;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface CardsDao
{
	void save(Cards card);

	void delete(Cards card);

	void update(Cards card);

	Cards findById(Integer cardId);

	int count(String cardType, String sn, Boolean valid);

	List<Cards> list(Integer rows, Integer page, String cardType, String sn,
			Boolean valid);
}
