package cc.ywxm.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.UserTypeRightsDao;
import cc.ywxm.model.UserTypeRights;

@Repository
public class UserTypeRightsDaoImpl implements UserTypeRightsDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	// @Resource
	// private JdbcTemplate jdbcTemplate;

	public void update(UserTypeRights userTypeRights)
	{
		hibernateTemplate.update(userTypeRights);
	}

	public UserTypeRights findById(Short userType)
	{
		return hibernateTemplate.get(UserTypeRights.class, userType);
	}

	public void save(UserTypeRights userTypeRights)
	{
		hibernateTemplate.save(userTypeRights);
	}

	// public void delete(UserTypeRights userTypeRights)
	// {
	// hibernateTemplate.delete(userTypeRights);
	// }

	// public int count(Object... args)
	// {
	// String sql = "select count(1) from goods_type";
	// return jdbcTemplate.queryForInt(sql, args);
	// }
	//
	// public List<UserTypeRights> list(Integer rows, Integer page, Object...
	// args)
	// {
	// String sql = "select * from goods_type";
	// return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
	// UserTypeRights.class, args);
	//
	// }

}
