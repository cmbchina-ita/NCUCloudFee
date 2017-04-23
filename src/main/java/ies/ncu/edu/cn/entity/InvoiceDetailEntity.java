package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public class InvoiceDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//出账ID
	private Integer invoiceId;
	//主账户ID
	private String payerAccountId;
	//链接账户ID
	private String linkedAccountId;
	//记录类型
	private String recordType;
	//出账日期
	private Integer invoiceDay;
	//订阅ID
	private String subscriptionId;
	//产品名称
	private String productName;
	//使用类型
	private String usageType;
	//操作
	private String operation;
	//预留标志
	private String reservedInstance;
	//栏目名称
	private String itemDescription;
	//标签名称
	private String tagName;
	//标签值
	private String tagValue;
	//税额
	private Float taxAmount;
	//总金额
	private Float totalCost;
	//资源ID
	private String resourceId;
	//使用量
	private Float usageQuantity;
	//修改时间
	private Date updateTime;
	//可用区
	private String az;
	//平台
	private String platform;
	//预留实例ID
	private String riId;

	/**
	 * 设置：出账ID
	 */
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	/**
	 * 获取：出账ID
	 */
	public Integer getInvoiceId() {
		return invoiceId;
	}
	/**
	 * 设置：主账户ID
	 */
	public void setPayerAccountId(String payerAccountId) {
		this.payerAccountId = payerAccountId;
	}
	/**
	 * 获取：主账户ID
	 */
	public String getPayerAccountId() {
		return payerAccountId;
	}
	/**
	 * 设置：链接账户ID
	 */
	public void setLinkedAccountId(String linkedAccountId) {
		this.linkedAccountId = linkedAccountId;
	}
	/**
	 * 获取：链接账户ID
	 */
	public String getLinkedAccountId() {
		return linkedAccountId;
	}
	/**
	 * 设置：记录类型
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	/**
	 * 获取：记录类型
	 */
	public String getRecordType() {
		return recordType;
	}
	/**
	 * 设置：出账日期
	 */
	public void setInvoiceDay(Integer invoiceDay) {
		this.invoiceDay = invoiceDay;
	}
	/**
	 * 获取：出账日期
	 */
	public Integer getInvoiceDay() {
		return invoiceDay;
	}
	/**
	 * 设置：订阅ID
	 */
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	/**
	 * 获取：订阅ID
	 */
	public String getSubscriptionId() {
		return subscriptionId;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：使用类型
	 */
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	/**
	 * 获取：使用类型
	 */
	public String getUsageType() {
		return usageType;
	}
	/**
	 * 设置：操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：操作
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：预留标志
	 */
	public void setReservedInstance(String reservedInstance) {
		this.reservedInstance = reservedInstance;
	}
	/**
	 * 获取：预留标志
	 */
	public String getReservedInstance() {
		return reservedInstance;
	}
	/**
	 * 设置：栏目名称
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	/**
	 * 获取：栏目名称
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * 设置：标签名称
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * 获取：标签名称
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * 设置：标签值
	 */
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	/**
	 * 获取：标签值
	 */
	public String getTagValue() {
		return tagValue;
	}
	/**
	 * 设置：税额
	 */
	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}
	/**
	 * 获取：税额
	 */
	public Float getTaxAmount() {
		return taxAmount;
	}
	/**
	 * 设置：总金额
	 */
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * 获取：总金额
	 */
	public Float getTotalCost() {
		return totalCost;
	}
	/**
	 * 设置：资源ID
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取：资源ID
	 */
	public String getResourceId() {
		return resourceId;
	}
	/**
	 * 设置：使用量
	 */
	public void setUsageQuantity(Float usageQuantity) {
		this.usageQuantity = usageQuantity;
	}
	/**
	 * 获取：使用量
	 */
	public Float getUsageQuantity() {
		return usageQuantity;
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
	 * 设置：可用区
	 */
	public void setAz(String az) {
		this.az = az;
	}
	/**
	 * 获取：可用区
	 */
	public String getAz() {
		return az;
	}
	/**
	 * 设置：平台
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * 获取：平台
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * 设置：预留实例ID
	 */
	public void setRiId(String riId) {
		this.riId = riId;
	}
	/**
	 * 获取：预留实例ID
	 */
	public String getRiId() {
		return riId;
	}
}
