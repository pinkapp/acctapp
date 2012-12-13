package cc.ywxm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.ContactInfoDao;
import cc.ywxm.model.ContactInfo;
import cc.ywxm.service.ContactInfoService;

@Transactional
@Service
public class ContactInfoServiceImpl implements ContactInfoService
{
	@Resource
	private ContactInfoDao contactInfoDao;

	public void add(Integer userId, String qq, String phone, String aliwangwang)
	{
	}

	public void remove(Integer userId)
	{

	}

	public void edit(String userName, String qq, String phone,
			String aliwangwang)
	{
		if (userName != null)
		{
			ContactInfo contactInfo = contactInfoDao.findById(userName);
			if (contactInfo == null)
			{
				contactInfo = new ContactInfo(userName, qq, phone, aliwangwang);
				contactInfoDao.save(contactInfo);
			} else
			{
				contactInfo.setAliwangwang(aliwangwang);
				contactInfo.setQq(qq);
				contactInfo.setPhone(phone);
				contactInfoDao.saveOrUpdate(contactInfo);
			}

		}
	}

	public ContactInfo findById(String userName)
	{
		if (userName != null)
		{
			return contactInfoDao.findById(userName);
		} else
		{
			return null;
		}
	}

}
