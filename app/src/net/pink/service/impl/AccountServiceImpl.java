package net.pink.service.impl;

import java.util.Date;

import net.pink.dao.AccountDao;
import net.pink.model.Account;
import net.pink.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	public int add(Date date, String item, Short category, Double money,
			String note) {
		if (date == null) {
			return 2;
		}
		if (item == null) {
			return 3;
		}
		if (category == null) {
			return 4;
		}
		if (money == null) {
			return 5;
		}
		Account account = new Account(date, item, category, money, note);
		try {
			accountDao.save(account);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
