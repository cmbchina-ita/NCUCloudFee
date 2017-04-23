package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 云账户与关联账户的关系
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public class AccountLinkaccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//关联ID
	private String accountLinkId;
	//主账户ID
	private String payAccountId;
	//主账户名称
	private String payAccountName;
	//关联账户Id
	private String linkAccountId;
	//关联账户名称
	private String linkAccountName;
	//关联账户AK
	private String linkAccessKey;
	//关联账户SK
	private String linkSecretKey;
	//预留实例状态
	private String reservedStatus;
	//修改时间
	private Date updateTime;

	/**
	 * 设置：关联ID
	 */
	public void setAccountLinkId(String accountLinkId) {
		this.accountLinkId = accountLinkId;
	}
	/**
	 * 获取：关联ID
	 */
	public String getAccountLinkId() {
		return accountLinkId;
	}
	/**
	 * 设置：主账户ID
	 */
	public void setPayAccountId(String payAccountId) {
		this.payAccountId = payAccountId;
	}
	/**
	 * 获取：主账户ID
	 */
	public String getPayAccountId() {
		return payAccountId;
	}
	/**
	 * 设置：主账户名称
	 */
	public void setPayAccountName(String payAccountName) {
		this.payAccountName = payAccountName;
	}
	/**
	 * 获取：主账户名称
	 */
	public String getPayAccountName() {
		return payAccountName;
	}
	/**
	 * 设置：关联账户Id
	 */
	public void setLinkAccountId(String linkAccountId) {
		this.linkAccountId = linkAccountId;
	}
	/**
	 * 获取：关联账户Id
	 */
	public String getLinkAccountId() {
		return linkAccountId;
	}
	/**
	 * 设置：关联账户名称
	 */
	public void setLinkAccountName(String linkAccountName) {
		this.linkAccountName = linkAccountName;
	}
	/**
	 * 获取：关联账户名称
	 */
	public String getLinkAccountName() {
		return linkAccountName;
	}
	/**
	 * 设置：关联账户AK
	 */
	public void setLinkAccessKey(String linkAccessKey) {
		this.linkAccessKey = linkAccessKey;
	}
	/**
	 * 获取：关联账户AK
	 */
	public String getLinkAccessKey() {
		return linkAccessKey;
	}
	/**
	 * 设置：关联账户SK
	 */
	public void setLinkSecretKey(String linkSecretKey) {
		this.linkSecretKey = linkSecretKey;
	}
	/**
	 * 获取：关联账户SK
	 */
	public String getLinkSecretKey() {
		return linkSecretKey;
	}
	/**
	 * 设置：预留实例状态
	 */
	public void setReservedStatus(String reservedStatus) {
		this.reservedStatus = reservedStatus;
	}
	/**
	 * 获取：预留实例状态
	 */
	public String getReservedStatus() {
		return reservedStatus;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
