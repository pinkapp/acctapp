package net.pink.dao.impl;

import java.util.List;

import net.pink.dao.AccountDao;
import net.pink.model.Account;
import net.pink.utils.RSMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void update(Account card) {
		hibernateTemplate.update(card);
	}

	public void save(Account card) {
		hibernateTemplate.save(card);
	}

	public void delete(Account card) {
		hibernateTemplate.delete(card);
	}

	public Account get(Integer id) {
		return (Account) hibernateTemplate.get(Account.class, id);
	}

	public Account load(Integer id) {
		return (Account) hibernateTemplate.load(Account.class, id);
	}

	public List<Account> list() {
		String sql = "SELECT `id`, `date_` as date, `item`, `category`, `money`, `note` FROM `accounts`";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, Account.class);
	}

}
