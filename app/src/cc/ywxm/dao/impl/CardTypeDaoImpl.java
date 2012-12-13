package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.CardTypeDao;
import cc.ywxm.model.CardType;
import cc.ywxm.utils.RSMapper;

@Repository
public class CardTypeDaoImpl implements CardTypeDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(CardType cardType)
	{
		hibernateTemplate.update(cardType);
	}

	public CardType findById(Short typeId)
	{
		return hibernateTemplate.get(CardType.class, typeId);
	}

	public void save(CardType cardType)
	{
		hibernateTemplate.save(cardType);
	}

	public void delete(CardType cardType)
	{
		hibernateTemplate.delete(cardType);
	}

	public int count(String typeName, String goodsType, Boolean valid)
	{
		String sql = "select count(1) from card_type where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (typeName != null)
		{
			sql = sql + " and typeName like ?";
			list.add("%" + typeName + "%");
		}
		if (goodsType != null)
		{
			sql = sql + " and goodsType = ?";
			list.add(goodsType);
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<CardType> list(Integer rows, Integer page, String typeName,
			String goodsType, Boolean valid)
	{
		String sql = "SELECT t.typeId, t.typeName, t1.typeName AS goodsType, t.faceValue, t.price, t.valid, t.note FROM card_type t LEFT JOIN goods_type t1 ON t.goodsType = t1.typeId where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (typeName != null)
		{
			sql = sql + " and t.typeName like ?";
			list.add("%" + typeName + "%");
		}
		if (goodsType != null)
		{
			sql = sql + " and t.goodsType = ?";
			list.add(goodsType);
		}
		if (valid != null)
		{
			sql = sql + " and t.valid = ?";
			list.add(valid);
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				CardType.class, list.toArray());

	}

	@SuppressWarnings("unchecked")
	public List<CardType> list()
	{
		return hibernateTemplate.findByExample(new CardType());
	}

}
