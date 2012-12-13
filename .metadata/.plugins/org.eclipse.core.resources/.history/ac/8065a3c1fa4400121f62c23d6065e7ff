package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserTypeRights entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_type_rights")
public class UserTypeRights implements java.io.Serializable
{

	// Fields

	private Short userType;
	private String rights;
	private String goodsIds;

	// Constructors

	/** default constructor */
	public UserTypeRights()
	{
	}

	/** full constructor */
	public UserTypeRights(String rights, String goodsIds)
	{
		this.rights = rights;
		this.goodsIds = goodsIds;
	}
	
	

	public UserTypeRights(Short userType, String rights, String goodsIds)
	{
		super();
		this.userType = userType;
		this.rights = rights;
		this.goodsIds = goodsIds;
	}

	// Property accessors
	@Id
	@Column(name = "userType", unique = true, nullable = false)
	public Short getUserType()
	{
		return this.userType;
	}

	public void setUserType(Short userType)
	{
		this.userType = userType;
	}

	@Column(name = "rights", length = 1000)
	public String getRights()
	{
		return this.rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}

	@Column(name = "goodsIds", length = 1000)
	public String getGoodsIds()
	{
		return this.goodsIds;
	}

	public void setGoodsIds(String goodsIds)
	{
		this.goodsIds = goodsIds;
	}

}