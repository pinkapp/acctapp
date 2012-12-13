package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable
{

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private Short userType;
	private Double account;
	private String userProp;
	private Boolean valid;
	private String note;

	// Constructors

	/** default constructor */
	public Users()
	{
	}

	/** minimal constructor */
	public Users(String userName, String password, Short userType)
	{
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	/** full constructor */
	public Users(String userName, String password, Short userType,
			Double account, String userProp, Boolean valid, String note)
	{
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.account = account;
		this.userProp = userProp;
		this.valid = valid;
		this.note = note;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Column(name = "userName", nullable = false, length = 20)
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "userType", nullable = false)
	public Short getUserType()
	{
		return this.userType;
	}

	public void setUserType(Short userType)
	{
		this.userType = userType;
	}

	@Column(name = "account", precision = 22, scale = 0)
	public Double getAccount()
	{
		return this.account;
	}

	public void setAccount(Double account)
	{
		this.account = account;
	}

	@Column(name = "userProp", length = 10)
	public String getUserProp()
	{
		return this.userProp;
	}

	public void setUserProp(String userProp)
	{
		this.userProp = userProp;
	}

	@Column(name = "valid")
	public Boolean getValid()
	{
		return this.valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	@Column(name = "note", length = 100)
	public String getNote()
	{
		return this.note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

}