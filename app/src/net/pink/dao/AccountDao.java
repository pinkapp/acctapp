package net.pink.dao;

import java.util.List;

import net.pink.model.Account;

/**
 * 数据库原子操作
 *
 * @author hdc
 *
 */
public interface AccountDao
{
	void save(Account account);

	void delete(Account account);

	void update(Account account);

	Account get(Integer id);

	Account load(Integer id);

	List<Account> list();

}
