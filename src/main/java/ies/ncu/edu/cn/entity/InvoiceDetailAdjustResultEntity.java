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
public class InvoiceDetailAdjustResultEntity implements Serializable {
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
	private String adjustResult;
	//
	private String adjustTime;
	//
	private String adjustTitle;
	//
	private String billTime;
	//调账维度
	private String tagName;

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
	public void setAdjustResult(String adjustResult) {
		this.adjustResult = adjustResult;
	}
	/**
	 * 获取：
	 */
	public String getAdjustResult() {
		return adjustResult;
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
	public void setAdjustTitle(String adjustTitle) {
		this.adjustTitle = adjustTitle;
	}
	/**
	 * 获取：
	 */
	public String getAdjustTitle() {
		return adjustTitle;
	}
	/**
	 * 设置：
	 */
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	/**
	 * 获取：
	 */
	public String getBillTime() {
		return billTime;
	}
	/**
	 * 设置：调账维度
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * 获取：调账维度
	 */
	public String getTagName() {
		return tagName;
	}
}
