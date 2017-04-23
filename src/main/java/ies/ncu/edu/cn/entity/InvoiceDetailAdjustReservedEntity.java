package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public class InvoiceDetailAdjustReservedEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String adjustId;
	//用户ID
	private String userId;
	//账户ID
	private String accountId;
	//账单存储桶S3的Bucket名称
	private String bucketName;
	//当月开始时间
	private String payerAccountId;
	//账单月份
	private Integer invoiceMonth;
	//
	private String adjustReservedInstanceId;
	//
	private String adjustTag;
	//
	private String adjustTime;
	//
	private String productType;
	//
	private String instanceRegion;
	//
	private String availabilityZone;
	//
	private String instanceType;
	//
	private String plantformType;
	//
	private String startTime;
	//
	private String durationYear;
	//
	private String offeringPrice;
	//
	private String rechargePrice;
	//
	private String offeringType;
	//
	private String instanceCount;
	//
	private String endTime;
	//
	private String isMutizone;

	/**
	 * 设置：
	 */
	public void setAdjustId(String adjustId) {
		this.adjustId = adjustId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustId() {
		return adjustId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
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
	 * 设置：账单存储桶S3的Bucket名称
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	/**
	 * 获取：账单存储桶S3的Bucket名称
	 */
	public String getBucketName() {
		return bucketName;
	}
	/**
	 * 设置：当月开始时间
	 */
	public void setPayerAccountId(String payerAccountId) {
		this.payerAccountId = payerAccountId;
	}
	/**
	 * 获取：当月开始时间
	 */
	public String getPayerAccountId() {
		return payerAccountId;
	}
	/**
	 * 设置：账单月份
	 */
	public void setInvoiceMonth(Integer invoiceMonth) {
		this.invoiceMonth = invoiceMonth;
	}
	/**
	 * 获取：账单月份
	 */
	public Integer getInvoiceMonth() {
		return invoiceMonth;
	}
	/**
	 * 设置：
	 */
	public void setAdjustReservedInstanceId(String adjustReservedInstanceId) {
		this.adjustReservedInstanceId = adjustReservedInstanceId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustReservedInstanceId() {
		return adjustReservedInstanceId;
	}
	/**
	 * 设置：
	 */
	public void setAdjustTag(String adjustTag) {
		this.adjustTag = adjustTag;
	}
	/**
	 * 获取：
	 */
	public String getAdjustTag() {
		return adjustTag;
	}
	/**
	 * 设置：
	 */
	public void setAdjustTime(String adjustTime) {
		this.adjustTime = adjustTime;
	}
	/**
	 * 获取：
	 */
	public String getAdjustTime() {
		return adjustTime;
	}
	/**
	 * 设置：
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：
	 */
	public void setInstanceRegion(String instanceRegion) {
		this.instanceRegion = instanceRegion;
	}
	/**
	 * 获取：
	 */
	public String getInstanceRegion() {
		return instanceRegion;
	}
	/**
	 * 设置：
	 */
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}
	/**
	 * 获取：
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}
	/**
	 * 设置：
	 */
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	/**
	 * 获取：
	 */
	public String getInstanceType() {
		return instanceType;
	}
	/**
	 * 设置：
	 */
	public void setPlantformType(String plantformType) {
		this.plantformType = plantformType;
	}
	/**
	 * 获取：
	 */
	public String getPlantformType() {
		return plantformType;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setDurationYear(String durationYear) {
		this.durationYear = durationYear;
	}
	/**
	 * 获取：
	 */
	public String getDurationYear() {
		return durationYear;
	}
	/**
	 * 设置：
	 */
	public void setOfferingPrice(String offeringPrice) {
		this.offeringPrice = offeringPrice;
	}
	/**
	 * 获取：
	 */
	public String getOfferingPrice() {
		return offeringPrice;
	}
	/**
	 * 设置：
	 */
	public void setRechargePrice(String rechargePrice) {
		this.rechargePrice = rechargePrice;
	}
	/**
	 * 获取：
	 */
	public String getRechargePrice() {
		return rechargePrice;
	}
	/**
	 * 设置：
	 */
	public void setOfferingType(String offeringType) {
		this.offeringType = offeringType;
	}
	/**
	 * 获取：
	 */
	public String getOfferingType() {
		return offeringType;
	}
	/**
	 * 设置：
	 */
	public void setInstanceCount(String instanceCount) {
		this.instanceCount = instanceCount;
	}
	/**
	 * 获取：
	 */
	public String getInstanceCount() {
		return instanceCount;
	}
	/**
	 * 设置：
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：
	 */
	public void setIsMutizone(String isMutizone) {
		this.isMutizone = isMutizone;
	}
	/**
	 * 获取：
	 */
	public String getIsMutizone() {
		return isMutizone;
	}
}
