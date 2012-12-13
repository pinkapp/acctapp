package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CardType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "card_type")
public class CardType implements java.io.Serializable
{

	// Fields

	private Short typeId;
	private String typeName;
	private String goodsType;
	private Integer faceValue;
	private Double price;
	private Boolean valid;
	private String note;

	// Constructors

	/** default constructor */
	public CardType()
	{
	}

	/** minimal constructor */
	public CardType(String typeName, String goodsType)
	{
		this.typeName = typeName;
		this.goodsType = goodsType;
	}

	/** full constructor */
	public CardType(String typeName, String goodsType, Integer faceValue,
			Double price, Boolean valid, String note)
	{
		this.typeName = typeName;
		this.goodsType = goodsType;
		this.faceValue = faceValue;
		this.price = price;
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

	@Column(name = "goodsType", nullable = false)
	public String getGoodsType()
	{
		return this.goodsType;
	}

	public void setGoodsType(String goodsType)
	{
		this.goodsType = goodsType;
	}

	@Column(name = "faceValue")
	public Integer getFaceValue()
	{
		return this.faceValue;
	}

	public void setFaceValue(Integer faceValue)
	{
		this.faceValue = faceValue;
	}

	@Column(name = "price",  precision = 22, scale = 0)
	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
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