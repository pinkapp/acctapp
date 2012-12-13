package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.GoodsTypeDao;
import cc.ywxm.model.GoodsType;
import cc.ywxm.utils.RSMapper;

@Repository
public class GoodsTypeDaoImpl implements GoodsTypeDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(GoodsType goodsType)
	{
		hibernateTemplate.update(goodsType);
	}

	public GoodsType findById(Short typeId)
	{
		return hibernateTemplate.get(GoodsType.class, typeId);
	}

	public void save(GoodsType goodsType)
	{
		hibernateTemplate.save(goodsType);
	}

	public void delete(GoodsType goodsType)
	{
		hibernateTemplate.delete(goodsType);
	}

	public int count(String typeName, Boolean valid)
	{
		String sql = "select count(1) from goods_type where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (typeName != null)
		{
			sql = sql + " and typeName like ?";
			list.add("%" + typeName + "%");
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<GoodsType> list(Integer rows, Integer page, String typeName,
			Boolean valid)
	{
		String sql = "select * from goods_type where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (typeName != null)
		{
			sql = sql + " and typeName like ?";
			list.add("%" + typeName + "%");
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				GoodsType.class, list.toArray());

	}

	@SuppressWarnings("unchecked")
	public List<GoodsType> list()
	{
		return hibernateTemplate.findByExample(new GoodsType());
	}

}
