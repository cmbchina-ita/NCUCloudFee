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
public class DownloadInvoiceLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//日志ID
	private String logId;
	//账户ID
	private String accountId;
	//用户ID
	private String userId;
	//请求类型
	private String requestType;
	//同步ID
	private String synId;
	//同步月份
	private String syncMonth;
	//请求内容
	private String requestContent;
	//处理标志
	private Integer dealFlag;
	//同步时间
	private Date syncTime;

	/**
	 * 设置：日志ID
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	/**
	 * 获取：日志ID
	 */
	public String getLogId() {
		return logId;
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
	 * 设置：请求类型
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * 获取：请求类型
	 */
	public String getRequestType() {
		return requestType;
	}
	/**
	 * 设置：同步ID
	 */
	public void setSynId(String synId) {
		this.synId = synId;
	}
	/**
	 * 获取：同步ID
	 */
	public String getSynId() {
		return synId;
	}
	/**
	 * 设置：同步月份
	 */
	public void setSyncMonth(String syncMonth) {
		this.syncMonth = syncMonth;
	}
	/**
	 * 获取：同步月份
	 */
	public String getSyncMonth() {
		return syncMonth;
	}
	/**
	 * 设置：请求内容
	 */
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	/**
	 * 获取：请求内容
	 */
	public String getRequestContent() {
		return requestContent;
	}
	/**
	 * 设置：处理标志
	 */
	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}
	/**
	 * 获取：处理标志
	 */
	public Integer getDealFlag() {
		return dealFlag;
	}
	/**
	 * 设置：同步时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	/**
	 * 获取：同步时间
	 */
	public Date getSyncTime() {
		return syncTime;
	}
}
