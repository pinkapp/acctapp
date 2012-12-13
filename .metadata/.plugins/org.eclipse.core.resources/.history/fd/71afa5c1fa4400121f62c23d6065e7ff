package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * District entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "district")
public class District implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private Short level;
	private Boolean usetype;
	private Integer upid;
	private Short displayorder;

	// Constructors

	/** default constructor */
	public District()
	{
	}

	/** full constructor */
	public District(String name, Short level, Boolean usetype, Integer upid,
			Short displayorder)
	{
		this.name = name;
		this.level = level;
		this.usetype = usetype;
		this.upid = upid;
		this.displayorder = displayorder;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "level", nullable = false)
	public Short getLevel()
	{
		return this.level;
	}

	public void setLevel(Short level)
	{
		this.level = level;
	}

	@Column(name = "usetype", nullable = false)
	public Boolean getUsetype()
	{
		return this.usetype;
	}

	public void setUsetype(Boolean usetype)
	{
		this.usetype = usetype;
	}

	@Column(name = "upid", nullable = false)
	public Integer getUpid()
	{
		return this.upid;
	}

	public void setUpid(Integer upid)
	{
		this.upid = upid;
	}

	@Column(name = "displayorder", nullable = false)
	public Short getDisplayorder()
	{
		return this.displayorder;
	}

	public void setDisplayorder(Short displayorder)
	{
		this.displayorder = displayorder;
	}

}