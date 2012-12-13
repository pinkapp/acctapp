package cc.ywxm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.UsersDao;
import cc.ywxm.model.Users;
import cc.ywxm.utils.RSMapper;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Users user) {
		hibernateTemplate.update(user);
	}

	public Users findById(Integer userId) {
		return hibernateTemplate.get(Users.class, userId);
	}

	public void save(Users user) {
		hibernateTemplate.save(user);
	}

	public void delete(Users user) {
		hibernateTemplate.delete(user);
	}

	public int count(String userName, Short userType, Boolean valid) {
		String sql = "select count(1) from users where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (userName != null) {
			sql = sql + " and userName = ?";
			list.add(userName);
		}
		if (userType != null) {
			sql = sql + " and userType = ?";
			list.add(userType);
		}
		if (valid != null) {
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<Users> list(Integer rows, Integer page, String userName,
			Short userType, Boolean valid) {

		String sql = "select * from users where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (userName != null) {
			sql = sql + " and userName like ?";
			list.add("%" + userName + "%");
		}
		if (userType != null) {
			sql = sql + " and userType = ?";
			list.add(userType);
		}
		if (valid != null) {
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page, Users.class,
				list.toArray());

	}

	public boolean exist(String userName, String password) {
		System.out.println("userName:" + userName);
		int count = jdbcTemplate
				.queryForInt(
						"select count(1) from users where userName = ? and password = ?",
						userName, password);
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Users findByUserName(String userName) {
		String sql = "select * from users where userName = ?";
		return RSMapper.query(jdbcTemplate, sql, Users.class, userName);
	}

	public boolean exist(String userName) {
		int count = jdbcTemplate.queryForInt(
				"select count(1) from users where userName = ?", userName);
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

}
