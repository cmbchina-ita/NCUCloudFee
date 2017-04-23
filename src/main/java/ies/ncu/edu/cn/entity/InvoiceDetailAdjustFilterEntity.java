package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public class InvoiceDetailAdjustFilterEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//调账iD
	private String adjustId;
	//用户ID
	private String userId;
	//账户ID
	private String accountId;
	//Bucket桶名
	private String bucketName;
	//主账户ID
	private String payerAccountId;
	//账单月份
	private Integer invoiceMonth;
	//调账资源ID
	private String adjustResourceId;
	//调账资源类型
	private String adjustResourceType;
	//调账起始时间
	private String adjustStartTime;
	//调账结束时间
	private String adjustEndTime;
	//调账标签
	private String adjustTag;
	//调账预留
	private String adjustResvered;
	//
	private String adjustExchangeId;
	//调账金额
	private String adjustMoney;
	//调账时间
	private String adjustTime;

	/**
	 * 设置：调账iD
	 */
	public void setAdjustId(String adjustId) {
		this.adjustId = adjustId;
	}
	/**
	 * 获取：调账iD
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
	 * 设置：Bucket桶名
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	/**
	 * 获取：Bucket桶名
	 */
	public String getBucketName() {
		return bucketName;
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
	 * 设置：调账资源ID
	 */
	public void setAdjustResourceId(String adjustResourceId) {
		this.adjustResourceId = adjustResourceId;
	}
	/**
	 * 获取：调账资源ID
	 */
	public String getAdjustResourceId() {
		return adjustResourceId;
	}
	/**
	 * 设置：调账资源类型
	 */
	public void setAdjustResourceType(String adjustResourceType) {
		this.adjustResourceType = adjustResourceType;
	}
	/**
	 * 获取：调账资源类型
	 */
	public String getAdjustResourceType() {
		return adjustResourceType;
	}
	/**
	 * 设置：调账起始时间
	 */
	public void setAdjustStartTime(String adjustStartTime) {
		this.adjustStartTime = adjustStartTime;
	}
	/**
	 * 获取：调账起始时间
	 */
	public String getAdjustStartTime() {
		return adjustStartTime;
	}
	/**
	 * 设置：调账结束时间
	 */
	public void setAdjustEndTime(String adjustEndTime) {
		this.adjustEndTime = adjustEndTime;
	}
	/**
	 * 获取：调账结束时间
	 */
	public String getAdjustEndTime() {
		return adjustEndTime;
	}
	/**
	 * 设置：调账标签
	 */
	public void setAdjustTag(String adjustTag) {
		this.adjustTag = adjustTag;
	}
	/**
	 * 获取：调账标签
	 */
	public String getAdjustTag() {
		return adjustTag;
	}
	/**
	 * 设置：调账预留
	 */
	public void setAdjustResvered(String adjustResvered) {
		this.adjustResvered = adjustResvered;
	}
	/**
	 * 获取：调账预留
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
	 * 设置：调账金额
	 */
	public void setAdjustMoney(String adjustMoney) {
		this.adjustMoney = adjustMoney;
	}
	/**
	 * 获取：调账金额
	 */
	public String getAdjustMoney() {
		return adjustMoney;
	}
	/**
	 * 设置：调账时间
	 */
	public void setAdjustTime(String adjustTime) {
		this.adjustTime = adjustTime;
	}
	/**
	 * 获取：调账时间
	 */
	public String getAdjustTime() {
		return adjustTime;
	}
}
