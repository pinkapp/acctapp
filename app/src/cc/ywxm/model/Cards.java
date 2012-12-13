package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cards entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cards")
public class Cards implements java.io.Serializable
{

	// Fields

	private Integer cardId;
	private String cardType;
	private Boolean valid;
	private String note;
	private String cardState;
	private String sn;

	// Constructors

	/** default constructor */
	public Cards()
	{
	}

	/** minimal constructor */
	public Cards(String cardType, Boolean valid, String cardState, String sn)
	{
		this.cardType = cardType;
		this.valid = valid;
		this.cardState = cardState;
		this.sn = sn;
	}

	/** full constructor */
	public Cards(String cardType, Boolean valid, String note, String cardState,
			String sn)
	{
		this.cardType = cardType;
		this.valid = valid;
		this.note = note;
		this.cardState = cardState;
		this.sn = sn;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cardId", unique = true, nullable = false)
	public Integer getCardId()
	{
		return this.cardId;
	}

	public void setCardId(Integer cardId)
	{
		this.cardId = cardId;
	}

	@Column(name = "cardType", nullable = false)
	public String getCardType()
	{
		return this.cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
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

	@Column(name = "cardState", nullable = false)
	public String getCardState()
	{
		return this.cardState;
	}

	public void setCardState(String cardState)
	{
		this.cardState = cardState;
	}

	@Column(name = "sn", nullable = false, length = 10)
	public String getSn()
	{
		return this.sn;
	}

	public void setSn(String sn)
	{
		this.sn = sn;
	}

}