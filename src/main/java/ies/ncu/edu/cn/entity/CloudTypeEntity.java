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
public class CloudTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//云提供商ID
	private String cloudId;
	//云提供商名称
	private String cloudName;
	//状态
	private Integer status;
	//官网链接
	private String url;
	//订单状态
	private Integer orders;
	//描述
	private String description;
	//数据状态：0-删除 1-正常
	private Integer dataState;

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
	 * 设置：云提供商名称
	 */
	public void setCloudName(String cloudName) {
		this.cloudName = cloudName;
	}
	/**
	 * 获取：云提供商名称
	 */
	public String getCloudName() {
		return cloudName;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：官网链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：官网链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrders() {
		return orders;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
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
