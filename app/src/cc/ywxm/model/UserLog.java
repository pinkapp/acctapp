package cc.ywxm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_log")
public class UserLog implements java.io.Serializable
{

	// Fields

	private Long logId;
	private Integer userId;
	private String logInfo;
	private Integer logTime;
	private String ipAddress;

	// Constructors

	/** default constructor */
	public UserLog()
	{
	}

	/** minimal constructor */
	public UserLog(Integer userId, String logInfo, Integer logTime)
	{
		this.userId = userId;
		this.logInfo = logInfo;
		this.logTime = logTime;
	}

	/** full constructor */
	public UserLog(Integer userId, String logInfo, Integer logTime,
			String ipAddress)
	{
		this.userId = userId;
		this.logInfo = logInfo;
		this.logTime = logTime;
		this.ipAddress = ipAddress;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "logId", unique = true, nullable = false)
	public Long getLogId()
	{
		return this.logId;
	}

	public void setLogId(Long logId)
	{
		this.logId = logId;
	}

	@Column(name = "userId", nullable = false)
	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Column(name = "logInfo", nullable = false, length = 100)
	public String getLogInfo()
	{
		return this.logInfo;
	}

	public void setLogInfo(String logInfo)
	{
		this.logInfo = logInfo;
	}

	@Column(name = "logTime", nullable = false)
	public Integer getLogTime()
	{
		return this.logTime;
	}

	public void setLogTime(Integer logTime)
	{
		this.logTime = logTime;
	}

	@Column(name = "ipAddress", length = 20)
	public String getIpAddress()
	{
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

}