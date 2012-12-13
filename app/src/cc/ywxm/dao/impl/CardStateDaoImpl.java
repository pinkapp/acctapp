package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.CardStateDao;
import cc.ywxm.model.CardState;
import cc.ywxm.utils.RSMapper;

@Repository
public class CardStateDaoImpl implements CardStateDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(CardState cardState)
	{
		hibernateTemplate.update(cardState);
	}

	public CardState findById(Short typeId)
	{
		return hibernateTemplate.get(CardState.class, typeId);
	}

	public void save(CardState cardState)
	{
		hibernateTemplate.save(cardState);
	}

	public void delete(CardState cardState)
	{
		hibernateTemplate.delete(cardState);
	}

	public int count(String stateName)
	{
		String sql = "select count(1) from card_state where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (stateName != null)
		{
			sql = sql + " and stateName like ?";
			list.add("%" + stateName + "%");
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<CardState> list(Integer rows, Integer page, String stateName)
	{
		String sql = "SELECT * FROM card_state t where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (stateName != null)
		{
			sql = sql + " and t.stateName like ?";
			list.add("%" + stateName + "%");
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				CardState.class, list.toArray());

	}

	@SuppressWarnings("unchecked")
	public List<CardState> list()
	{
		return hibernateTemplate.findByExample(new CardState());
	}

}
