package net.pink.dao.impl;

import javax.annotation.Resource;

import net.pink.dao.AccountDao;
import net.pink.model.Account;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Account card)
	{
		hibernateTemplate.update(card);
	}

	public void save(Account card)
	{
		hibernateTemplate.save(card);
	}

	public void delete(Account card)
	{
		hibernateTemplate.delete(card);
	}

	public Account get(Integer id) {
		return (Account)hibernateTemplate.get(Account.class, id);
	}

	public Account load(Integer id) {
		return (Account)hibernateTemplate.load(Account.class, id);
	}


}
