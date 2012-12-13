package cc.ywxm.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.ContactInfoDao;
import cc.ywxm.model.ContactInfo;

@Repository
public class ContactInfoDaoImpl implements ContactInfoDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	// @Resource
	// private JdbcTemplate jdbcTemplate;

	public void update(ContactInfo contactInfo)
	{
		hibernateTemplate.update(contactInfo);
	}

	public ContactInfo findById(String userName)
	{
		return hibernateTemplate.get(ContactInfo.class, userName);
	}

	public void save(ContactInfo contactInfo)
	{
		hibernateTemplate.save(contactInfo);
	}
	
	public void saveOrUpdate(ContactInfo contactInfo){
		hibernateTemplate.saveOrUpdate(contactInfo);
	}

	public void delete(ContactInfo contactInfo)
	{
		hibernateTemplate.delete(contactInfo);
	}

}
