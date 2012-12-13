package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CardState entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "card_state")
public class CardState implements java.io.Serializable
{

	// Fields

	private Short stateId;
	private String stateName;

	// Constructors

	/** default constructor */
	public CardState()
	{
	}

	/** full constructor */
	public CardState(String stateName)
	{
		this.stateName = stateName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "stateId", unique = true, nullable = false)
	public Short getStateId()
	{
		return this.stateId;
	}

	public void setStateId(Short stateId)
	{
		this.stateId = stateId;
	}

	@Column(name = "stateName", nullable = false, length = 10)
	public String getStateName()
	{
		return this.stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

}