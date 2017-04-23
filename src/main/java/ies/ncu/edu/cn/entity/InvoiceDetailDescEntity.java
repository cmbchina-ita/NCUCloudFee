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
public class InvoiceDetailDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private String id;
	//主账户ID
	private String payerAccountId;
	//月份
	private Integer month;
	//同步时间
	private String syncTime;
	//标签头
	private String tagTitle;
	//标签列
	private String tagColumn;
	//账单时间
	private String billTime;

	/**
	 * 设置：ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public String getId() {
		return id;
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
	 * 设置：月份
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * 获取：月份
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * 设置：同步时间
	 */
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
	/**
	 * 获取：同步时间
	 */
	public String getSyncTime() {
		return syncTime;
	}
	/**
	 * 设置：标签头
	 */
	public void setTagTitle(String tagTitle) {
		this.tagTitle = tagTitle;
	}
	/**
	 * 获取：标签头
	 */
	public String getTagTitle() {
		return tagTitle;
	}
	/**
	 * 设置：标签列
	 */
	public void setTagColumn(String tagColumn) {
		this.tagColumn = tagColumn;
	}
	/**
	 * 获取：标签列
	 */
	public String getTagColumn() {
		return tagColumn;
	}
	/**
	 * 设置：账单时间
	 */
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	/**
	 * 获取：账单时间
	 */
	public String getBillTime() {
		return billTime;
	}
}
