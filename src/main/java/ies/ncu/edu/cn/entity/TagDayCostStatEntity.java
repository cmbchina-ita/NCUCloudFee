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
public class TagDayCostStatEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//标签统计ID
	private String statId;
	//付费账户ID
	private String payAccountId;
	//云提供商ID
	private String cloudId;
	//统计日期，精确到日
	private String statDate;
	//标签名称
	private String tagName;
	//标签值
	private String tagValue;
	//日花费
	private BigDecimal dayCost;
	//数据状态
	private Integer dataState;
	//关联账户ID
	private String linkedAccountId;

	/**
	 * 设置：标签统计ID
	 */
	public void setStatId(String statId) {
		this.statId = statId;
	}
	/**
	 * 获取：标签统计ID
	 */
	public String getStatId() {
		return statId;
	}
	/**
	 * 设置：付费账户ID
	 */
	public void setPayAccountId(String payAccountId) {
		this.payAccountId = payAccountId;
	}
	/**
	 * 获取：付费账户ID
	 */
	public String getPayAccountId() {
		return payAccountId;
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
	 * 设置：统计日期，精确到日
	 */
	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}
	/**
	 * 获取：统计日期，精确到日
	 */
	public String getStatDate() {
		return statDate;
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
	 * 设置：日花费
	 */
	public void setDayCost(BigDecimal dayCost) {
		this.dayCost = dayCost;
	}
	/**
	 * 获取：日花费
	 */
	public BigDecimal getDayCost() {
		return dayCost;
	}
	/**
	 * 设置：数据状态
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态
	 */
	public Integer getDataState() {
		return dataState;
	}
	/**
	 * 设置：关联账户ID
	 */
	public void setLinkedAccountId(String linkedAccountId) {
		this.linkedAccountId = linkedAccountId;
	}
	/**
	 * 获取：关联账户ID
	 */
	public String getLinkedAccountId() {
		return linkedAccountId;
	}
}
