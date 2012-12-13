package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nodes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menus")
public class Menus implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String name;
	private String link;
	private String state;
	private Integer parentId;

	// Constructors

	/** default constructor */
	public Menus()
	{
	}

	/** full constructor */
	public Menus(String name, String link, String state, Integer parentId)
	{
		this.name = name;
		this.link = link;
		this.state = state;
		this.parentId = parentId;
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

	@Column(name = "name", nullable = false, length = 10)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "link", nullable = false, length = 50)
	public String getLink()
	{
		return this.link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	@Column(name = "state", nullable = false, length = 10)
	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	@Column(name = "parentId", nullable = false)
	public Integer getParentId()
	{
		return this.parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

}