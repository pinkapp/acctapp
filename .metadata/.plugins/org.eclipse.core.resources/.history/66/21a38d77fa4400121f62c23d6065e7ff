package cc.ywxm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.MenusDao;
import cc.ywxm.model.Menus;
import cc.ywxm.utils.RSMapper;

@Repository
public class MenusDaoImpl implements MenusDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Menus hero)
	{
		hibernateTemplate.save(hero);
	}

	public Menus findById(Integer heroId)
	{
		return hibernateTemplate.get(Menus.class, heroId);
	}

	public void save(Menus hero)
	{
		hibernateTemplate.save(hero);
	}

	public void delete(Menus hero)
	{
		hibernateTemplate.delete(hero);
	}

	@SuppressWarnings("unchecked")
	public List<Menus> findByParentId(Integer parentId)
	{
		try
		{
			return hibernateTemplate.find("from " + Menus.class.getName()
					+ " WHERE parentId = ? order by id", parentId);
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Menus> listLeaf()
	{
		String sql = "SELECT * FROM menus WHERE id NOT IN(SELECT parentId FROM menus)";
		return RSMapper.queryList(jdbcTemplate, sql, Menus.class);
	}

	public List<Menus> list()
	{
		String sql = "SELECT * FROM menus";
		return RSMapper.queryList(jdbcTemplate, sql, Menus.class);
	}

}
