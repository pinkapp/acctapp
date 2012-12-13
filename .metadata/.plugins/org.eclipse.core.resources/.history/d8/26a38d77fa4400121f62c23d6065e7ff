package cc.ywxm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.UserTypeDao;
import cc.ywxm.model.UserType;
import cc.ywxm.utils.RSMapper;

@Repository
public class UserTypeDaoImpl implements UserTypeDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(UserType userType)
	{
		hibernateTemplate.update(userType);
	}

	public UserType findById(Short typeId)
	{
		return hibernateTemplate.get(UserType.class, typeId);
	}

	public void save(UserType userType)
	{
		hibernateTemplate.save(userType);
	}

	public void delete(UserType userType)
	{
		hibernateTemplate.delete(userType);
	}

	public int count(Object... args)
	{
		String sql = "select count(1) from user_type";
		return jdbcTemplate.queryForInt(sql, args);
	}

	public List<UserType> list()
	{
		String sql = "select * from user_type";
		return RSMapper.queryList(jdbcTemplate, sql, UserType.class);

	}

}
