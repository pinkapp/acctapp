package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.GoodsPropDao;
import cc.ywxm.model.GoodsProp;
import cc.ywxm.utils.RSMapper;

@Repository
public class GoodsPropDaoImpl implements GoodsPropDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(GoodsProp goodsProp)
	{
		hibernateTemplate.update(goodsProp);
	}

	public GoodsProp findById(Short typeId)
	{
		return hibernateTemplate.get(GoodsProp.class, typeId);
	}

	public void save(GoodsProp goodsProp)
	{
		hibernateTemplate.save(goodsProp);
	}

	public void delete(GoodsProp goodsProp)
	{
		hibernateTemplate.delete(goodsProp);
	}

	public int count(String typeName, Boolean valid)
	{
		String sql = "select count(1) from goods_prop where 1 = 1";
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

	public List<GoodsProp> list(Integer rows, Integer page, String typeName,
			Boolean valid)
	{
		String sql = "select * from goods_prop where 1 = 1";
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
				GoodsProp.class, list.toArray());

	}

	@SuppressWarnings("unchecked")
	public List<GoodsProp> list()
	{
		return hibernateTemplate.findByExample(new GoodsProp());
	}

}
