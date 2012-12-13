package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsProp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_prop")
public class GoodsProp implements java.io.Serializable
{

	// Fields

	private Short typeId;
	private String typeName;
	private Boolean valid;
	private String note;

	// Constructors

	/** default constructor */
	public GoodsProp()
	{
	}

	/** minimal constructor */
	public GoodsProp(String typeName, Boolean valid)
	{
		this.typeName = typeName;
		this.valid = valid;
	}

	/** full constructor */
	public GoodsProp(String typeName, Boolean valid, String note)
	{
		this.typeName = typeName;
		this.valid = valid;
		this.note = note;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "typeId", unique = true, nullable = false)
	public Short getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Short typeId)
	{
		this.typeId = typeId;
	}

	@Column(name = "typeName", nullable = false, length = 10)
	public String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	@Column(name = "valid", nullable = false)
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