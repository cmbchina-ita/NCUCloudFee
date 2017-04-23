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
public class InvoiceDetailReservedEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String reservedDescId;
	//主账户ID
	private String payerAccountId;
	//账单月份
	private Integer invoiceMonth;
	//
	private String reservedInstanceId;
	//产品类型
	private String productType;
	//所属区域
	private String instanceRegion;
	//可用区
	private String availabilityZone;
	//实例类型
	private String instanceType;
	//平台类型
	private String plantformType;
	//开始时间
	private String startTime;
	//预留年份
	private String durationYear;
	//优惠价格
	private String offeringPrice;
	//续价
	private String rechargePrice;
	//优惠类型
	private String offeringType;
	//
	private String instanceCount;
	//结束时间
	private String endTime;
	//多区标志
	private String isMutizone;

	/**
	 * 设置：
	 */
	public void setReservedDescId(String reservedDescId) {
		this.reservedDescId = reservedDescId;
	}
	/**
	 * 获取：
	 */
	public String getReservedDescId() {
		return reservedDescId;
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
	 * 设置：
	 */
	public void setReservedInstanceId(String reservedInstanceId) {
		this.reservedInstanceId = reservedInstanceId;
	}
	/**
	 * 获取：
	 */
	public String getReservedInstanceId() {
		return reservedInstanceId;
	}
	/**
	 * 设置：产品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：产品类型
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：所属区域
	 */
	public void setInstanceRegion(String instanceRegion) {
		this.instanceRegion = instanceRegion;
	}
	/**
	 * 获取：所属区域
	 */
	public String getInstanceRegion() {
		return instanceRegion;
	}
	/**
	 * 设置：可用区
	 */
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}
	/**
	 * 获取：可用区
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}
	/**
	 * 设置：实例类型
	 */
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	/**
	 * 获取：实例类型
	 */
	public String getInstanceType() {
		return instanceType;
	}
	/**
	 * 设置：平台类型
	 */
	public void setPlantformType(String plantformType) {
		this.plantformType = plantformType;
	}
	/**
	 * 获取：平台类型
	 */
	public String getPlantformType() {
		return plantformType;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：预留年份
	 */
	public void setDurationYear(String durationYear) {
		this.durationYear = durationYear;
	}
	/**
	 * 获取：预留年份
	 */
	public String getDurationYear() {
		return durationYear;
	}
	/**
	 * 设置：优惠价格
	 */
	public void setOfferingPrice(String offeringPrice) {
		this.offeringPrice = offeringPrice;
	}
	/**
	 * 获取：优惠价格
	 */
	public String getOfferingPrice() {
		return offeringPrice;
	}
	/**
	 * 设置：续价
	 */
	public void setRechargePrice(String rechargePrice) {
		this.rechargePrice = rechargePrice;
	}
	/**
	 * 获取：续价
	 */
	public String getRechargePrice() {
		return rechargePrice;
	}
	/**
	 * 设置：优惠类型
	 */
	public void setOfferingType(String offeringType) {
		this.offeringType = offeringType;
	}
	/**
	 * 获取：优惠类型
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
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：多区标志
	 */
	public void setIsMutizone(String isMutizone) {
		this.isMutizone = isMutizone;
	}
	/**
	 * 获取：多区标志
	 */
	public String getIsMutizone() {
		return isMutizone;
	}
}
