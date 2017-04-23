package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public class CostTagEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//标签ID
	private String tagId;
	//付费账户ID
	private String payAccountId;
	//云提供商ID
	private String cloudId;
	//标签名称
	private String tagName;
	//标签值
	private String tagValue;
	//标签顺序
	private Integer tagOrder;
	//数据状态：0-删除 1-正常
	private Integer dataState;

	/**
	 * 设置：标签ID
	 */
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	/**
	 * 获取：标签ID
	 */
	public String getTagId() {
		return tagId;
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
	 * 设置：标签顺序
	 */
	public void setTagOrder(Integer tagOrder) {
		this.tagOrder = tagOrder;
	}
	/**
	 * 获取：标签顺序
	 */
	public Integer getTagOrder() {
		return tagOrder;
	}
	/**
	 * 设置：数据状态：0-删除 1-正常
	 */
	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
	/**
	 * 获取：数据状态：0-删除 1-正常
	 */
	public Integer getDataState() {
		return dataState;
	}
}
