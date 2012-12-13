package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.GoodsDao;
import cc.ywxm.model.Goods;
import cc.ywxm.utils.RSMapper;

@Repository
public class GoodsDaoImpl implements GoodsDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Goods goods)
	{
		hibernateTemplate.update(goods);
	}

	public Goods findById(Integer goodsId)
	{
		return hibernateTemplate.get(Goods.class, goodsId);
	}

	public void save(Goods goods)
	{
		hibernateTemplate.save(goods);
	}

	public void delete(Goods goods)
	{
		hibernateTemplate.delete(goods);
	}

	public int count(String goodsType, String goodsProp, Boolean valid)
	{
		String sql = "select count(1) from goods where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (goodsType != null)
		{
			sql = sql + " and goodsType = ?";
			list.add(goodsType);
		}
		if (goodsProp != null)
		{
			sql = sql + " and goodsProp = ?";
			list.add(goodsProp);
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<Goods> list(Integer rows, Integer page, String goodsType,
			String goodsProp, Boolean valid)
	{
		String sql = "SELECT t.goodsId, t1.typeName AS goodsType, t2.typeName AS goodsProp, t.goodsPrice, t.valid, t.note FROM goods t LEFT JOIN goods_type t1 ON t.goodsType = t1.typeId LEFT JOIN goods_prop t2 ON t.goodsProp = t2.typeId where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (goodsType != null)
		{
			sql = sql + " and t.goodsType = ?";
			list.add(goodsType);
		}
		if (goodsProp != null)
		{
			sql = sql + " and t.goodsProp = ?";
			list.add(goodsProp);
		}
		if (valid != null)
		{
			sql = sql + " and t.valid = ?";
			list.add(valid);
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page, Goods.class,
				list.toArray());

	}

	public List<Goods> list(String goodsType, String goodsProp, Boolean valid)
	{
		String sql = "SELECT t.goodsId, t1.typeName AS goodsType, t2.typeName AS goodsProp, t.goodsPrice, t.valid, t.note FROM goods t LEFT JOIN goods_type t1 ON t.goodsType = t1.typeId LEFT JOIN goods_prop t2 ON t.goodsProp = t2.typeId where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (goodsType != null)
		{
			sql = sql + " and t.goodsType = ?";
			list.add(goodsType);
		}
		if (goodsProp != null)
		{
			sql = sql + " and t.goodsProp = ?";
			list.add(goodsProp);
		}
		if (valid != null)
		{
			sql = sql + " and t.valid = ?";
			list.add(valid);
		}
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, Goods.class,
				list.toArray());
	}

}
