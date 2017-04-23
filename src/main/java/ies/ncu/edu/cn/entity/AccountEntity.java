package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//账户ID
	private String accountId;
	//云提供商ID
	private String cloudId;
	//账户名称
	private String name;
	//修改时间
	private Date updateTime;
	//经办ID
	private String operateUserId;
	//状态
	private String validate;
	//付款账户ID
	private String rootAccountId;
	//付款账户名称
	private String rootAccountName;
	//
	private Integer cloudType;
	//
	private Integer isAssumeRole;
	//上月账单大小
	private BigDecimal lastMonthInvoiceSize;
	//绑定云账号时间
	private Date createTime;

	/**
	 * 设置：账户ID
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * 获取：账户ID
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * 设置：云提供商ID
	 */
	public void setCloudId(String cloudId) {
		this.cloudId = cloudId;
	}
	/**
	 * 获取：云提供商ID
	 */
	public String getCloudId() {
		return cloudId;
	}
	/**
	 * 设置：账户名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：账户名称
	 */
	public String getName() {
		return name;
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
	/**
	 * 设置：经办ID
	 */
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}
	/**
	 * 获取：经办ID
	 */
	public String getOperateUserId() {
		return operateUserId;
	}
	/**
	 * 设置：状态
	 */
	public void setValidate(String validate) {
		this.validate = validate;
	}
	/**
	 * 获取：状态
	 */
	public String getValidate() {
		return validate;
	}
	/**
	 * 设置：付款账户ID
	 */
	public void setRootAccountId(String rootAccountId) {
		this.rootAccountId = rootAccountId;
	}
	/**
	 * 获取：付款账户ID
	 */
	public String getRootAccountId() {
		return rootAccountId;
	}
	/**
	 * 设置：付款账户名称
	 */
	public void setRootAccountName(String rootAccountName) {
		this.rootAccountName = rootAccountName;
	}
	/**
	 * 获取：付款账户名称
	 */
	public String getRootAccountName() {
		return rootAccountName;
	}
	/**
	 * 设置：
	 */
	public void setCloudType(Integer cloudType) {
		this.cloudType = cloudType;
	}
	/**
	 * 获取：
	 */
	public Integer getCloudType() {
		return cloudType;
	}
	/**
	 * 设置：
	 */
	public void setIsAssumeRole(Integer isAssumeRole) {
		this.isAssumeRole = isAssumeRole;
	}
	/**
	 * 获取：
	 */
	public Integer getIsAssumeRole() {
		return isAssumeRole;
	}
	/**
	 * 设置：上月账单大小
	 */
	public void setLastMonthInvoiceSize(BigDecimal lastMonthInvoiceSize) {
		this.lastMonthInvoiceSize = lastMonthInvoiceSize;
	}
	/**
	 * 获取：上月账单大小
	 */
	public BigDecimal getLastMonthInvoiceSize() {
		return lastMonthInvoiceSize;
	}
	/**
	 * 设置：绑定云账号时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：绑定云账号时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
