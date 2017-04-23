package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public class InvoiceAccountDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//发票账户ID
	private String invoiceAccountId;
	//AWS账户ID
	private String awsAccountId;
	//AWS账户名称
	private String awsAccountName;
	//修改时间
	private Date updateTime;
	//总花费
	private BigDecimal totalCost;
	//付费主账户ID
	private String payerAccountId;
	//出账月份
	private String month;
	//支持费用
	private BigDecimal supportCost;

	/**
	 * 设置：发票账户ID
	 */
	public void setInvoiceAccountId(String invoiceAccountId) {
		this.invoiceAccountId = invoiceAccountId;
	}
	/**
	 * 获取：发票账户ID
	 */
	public String getInvoiceAccountId() {
		return invoiceAccountId;
	}
	/**
	 * 设置：AWS账户ID
	 */
	public void setAwsAccountId(String awsAccountId) {
		this.awsAccountId = awsAccountId;
	}
	/**
	 * 获取：AWS账户ID
	 */
	public String getAwsAccountId() {
		return awsAccountId;
	}
	/**
	 * 设置：AWS账户名称
	 */
	public void setAwsAccountName(String awsAccountName) {
		this.awsAccountName = awsAccountName;
	}
	/**
	 * 获取：AWS账户名称
	 */
	public String getAwsAccountName() {
		return awsAccountName;
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
	 * 设置：总花费
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * 获取：总花费
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	/**
	 * 设置：付费主账户ID
	 */
	public void setPayerAccountId(String payerAccountId) {
		this.payerAccountId = payerAccountId;
	}
	/**
	 * 获取：付费主账户ID
	 */
	public String getPayerAccountId() {
		return payerAccountId;
	}
	/**
	 * 设置：出账月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取：出账月份
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 设置：支持费用
	 */
	public void setSupportCost(BigDecimal supportCost) {
		this.supportCost = supportCost;
	}
	/**
	 * 获取：支持费用
	 */
	public BigDecimal getSupportCost() {
		return supportCost;
	}
}
