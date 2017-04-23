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
public class ServiceDefEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//服务ID
	private String serviceId;
	//云提供商ID
	private String cloudId;
	//服务名称
	private String serviceName;
	//状态
	private Integer status;
	//定价单链接
	private String priceIntroUrl;
	//订单额
	private Integer orders;
	//描述
	private String description;
	//数据状态
	private Integer dataState;
	//服务编码
	private String serviceCode;

	/**
	 * 设置：服务ID
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * 获取：服务ID
	 */
	public String getServiceId() {
		return serviceId;
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
	 * 设置：服务名称
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * 获取：服务名称
	 */
	public String getServiceName() {
		return serviceName;
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
	 * 设置：定价单链接
	 */
	public void setPriceIntroUrl(String priceIntroUrl) {
		this.priceIntroUrl = priceIntroUrl;
	}
	/**
	 * 获取：定价单链接
	 */
	public String getPriceIntroUrl() {
		return priceIntroUrl;
	}
	/**
	 * 设置：订单额
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：订单额
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
	 * 设置：服务编码
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	/**
	 * 获取：服务编码
	 */
	public String getServiceCode() {
		return serviceCode;
	}
}
