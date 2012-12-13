package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods")
public class Goods implements java.io.Serializable
{

	// Fields

	private Integer goodsId;
	private String goodsType;
	private String goodsProp;
	private Double goodsPrice;
	private Boolean valid;
	private String note;

	// Constructors

	/** default constructor */
	public Goods()
	{
	}

	/** minimal constructor */
	public Goods(String goodsType, String goodsProp, Boolean valid)
	{
		this.goodsType = goodsType;
		this.goodsProp = goodsProp;
		this.valid = valid;
	}

	/** full constructor */
	public Goods(String goodsType, String goodsProp, Double goodsPrice,
			Boolean valid, String note)
	{
		this.goodsType = goodsType;
		this.goodsProp = goodsProp;
		this.goodsPrice = goodsPrice;
		this.valid = valid;
		this.note = note;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "goodsId", unique = true, nullable = false)
	public Integer getGoodsId()
	{
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
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

	@Column(name = "goodsProp", nullable = false)
	public String getGoodsProp()
	{
		return this.goodsProp;
	}

	public void setGoodsProp(String goodsProp)
	{
		this.goodsProp = goodsProp;
	}

	@Column(name = "goodsPrice", precision = 22, scale = 0)
	public Double getGoodsPrice()
	{
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice)
	{
		this.goodsPrice = goodsPrice;
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