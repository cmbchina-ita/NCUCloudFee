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
public class InvoiceDetailAdjustLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String adjustLogId;
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
	private String adjustResourceId;
	//
	private String adjustResourceType;
	//
	private String adjustStartTime;
	//
	private String adjustEndTime;
	//
	private String adjustTag;
	//
	private String adjustResvered;
	//
	private String adjustExchangeId;
	//
	private String adjustMoney;
	//
	private String adjustTime;
	//
	private String adjustResultId;
	//
	private String adjustRemark;

	/**
	 * 设置：
	 */
	public void setAdjustLogId(String adjustLogId) {
		this.adjustLogId = adjustLogId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustLogId() {
		return adjustLogId;
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
	public void setAdjustResourceId(String adjustResourceId) {
		this.adjustResourceId = adjustResourceId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustResourceId() {
		return adjustResourceId;
	}
	/**
	 * 设置：
	 */
	public void setAdjustResourceType(String adjustResourceType) {
		this.adjustResourceType = adjustResourceType;
	}
	/**
	 * 获取：
	 */
	public String getAdjustResourceType() {
		return adjustResourceType;
	}
	/**
	 * 设置：
	 */
	public void setAdjustStartTime(String adjustStartTime) {
		this.adjustStartTime = adjustStartTime;
	}
	/**
	 * 获取：
	 */
	public String getAdjustStartTime() {
		return adjustStartTime;
	}
	/**
	 * 设置：
	 */
	public void setAdjustEndTime(String adjustEndTime) {
		this.adjustEndTime = adjustEndTime;
	}
	/**
	 * 获取：
	 */
	public String getAdjustEndTime() {
		return adjustEndTime;
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
	public void setAdjustResvered(String adjustResvered) {
		this.adjustResvered = adjustResvered;
	}
	/**
	 * 获取：
	 */
	public String getAdjustResvered() {
		return adjustResvered;
	}
	/**
	 * 设置：
	 */
	public void setAdjustExchangeId(String adjustExchangeId) {
		this.adjustExchangeId = adjustExchangeId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustExchangeId() {
		return adjustExchangeId;
	}
	/**
	 * 设置：
	 */
	public void setAdjustMoney(String adjustMoney) {
		this.adjustMoney = adjustMoney;
	}
	/**
	 * 获取：
	 */
	public String getAdjustMoney() {
		return adjustMoney;
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
	public void setAdjustResultId(String adjustResultId) {
		this.adjustResultId = adjustResultId;
	}
	/**
	 * 获取：
	 */
	public String getAdjustResultId() {
		return adjustResultId;
	}
	/**
	 * 设置：
	 */
	public void setAdjustRemark(String adjustRemark) {
		this.adjustRemark = adjustRemark;
	}
	/**
	 * 获取：
	 */
	public String getAdjustRemark() {
		return adjustRemark;
	}
}
