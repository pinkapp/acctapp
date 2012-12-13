package net.pink.service;

import java.util.Date;

public interface AccountService {
	/**
	 * 添加账目
	 * 
	 * @param date
	 * @param item
	 * @param category
	 * @param money
	 * @param note
	 * @return
	 */
	int add(Date date, String item, Short category, Double money, String note);

}
