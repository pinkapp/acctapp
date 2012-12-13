package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.CardsDao;
import cc.ywxm.model.Cards;
import cc.ywxm.utils.RSMapper;

@Repository
public class CardsDaoImpl implements CardsDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Cards card)
	{
		hibernateTemplate.update(card);
	}

	public Cards findById(Integer cardId)
	{
		return hibernateTemplate.get(Cards.class, cardId);
	}

	public void save(Cards card)
	{
		hibernateTemplate.save(card);
	}

	public void delete(Cards card)
	{
		hibernateTemplate.delete(card);
	}

	public int count(String cardType, String sn, Boolean valid)
	{
		String sql = "select count(1) from cards where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (cardType != null)
		{
			sql = sql + " and cardType = ?";
			list.add(cardType);
		}
		if (sn != null)
		{
			sql = sql + " and sn like ?";
			list.add("%" + sn + "%");
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<Cards> list(Integer rows, Integer page, String cardType,
			String sn, Boolean valid)
	{
		String sql = "SELECT t.cardId, t1.typeName AS cardType,t2.stateName cardState, t.valid, t.note, t.sn FROM cards t LEFT JOIN card_type t1 ON t.cardType = t1.typeId LEFT JOIN card_state t2 ON t.cardState = t2.stateId where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (cardType != null)
		{
			sql = sql + " and t.cardType = ?";
			list.add(cardType);
		}
		if (sn != null)
		{
			sql = sql + " and t.sn like ?";
			list.add("%" + sn + "%");
		}

		if (valid != null)
		{
			sql = sql + " and t.valid = ?";
			list.add(valid);
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page, Cards.class,
				list.toArray());

	}

}
