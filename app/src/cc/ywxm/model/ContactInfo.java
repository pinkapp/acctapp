package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ContactInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "contact_info")
public class ContactInfo implements java.io.Serializable
{

	// Fields

	private String userName;
	private String qq;
	private String phone;
	private String aliwangwang;

	// Constructors

	/** default constructor */
	public ContactInfo()
	{
	}
	
	public ContactInfo(String qq, String phone, String aliwangwang)
	{
		this.qq = qq;
		this.phone = phone;
		this.aliwangwang = aliwangwang;
	}
	
	
	/** full constructor */
	public ContactInfo(String userName, String qq, String phone,
			String aliwangwang)
	{
		super();
		this.userName = userName;
		this.qq = qq;
		this.phone = phone;
		this.aliwangwang = aliwangwang;
	}

	// Property accessors
	@Id
	@Column(name = "userName", unique = true, nullable = false, length = 20)
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "QQ", length = 11)
	public String getQq()
	{
		return this.qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	@Column(name = "phone", length = 20)
	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	@Column(name = "aliwangwang", length = 20)
	public String getAliwangwang()
	{
		return this.aliwangwang;
	}

	public void setAliwangwang(String aliwangwang)
	{
		this.aliwangwang = aliwangwang;
	}

}