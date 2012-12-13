package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.CardState;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface CardStateDao
{
	void save(CardState cardState);

	void delete(CardState cardState);

	void update(CardState cardState);

	CardState findById(Short stateId);

	int count(String stateName);

	List<CardState> list(Integer rows, Integer page, String stateName);

	List<CardState> list();
}
