package ies.ncu.edu.cn.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public class MonthCostStatEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//月总花费统计ID
	private String statId;
	//付费账户ID
	private String payAccountId;
	//云提供商ID
	private String cloudId;
	//精确到月份
	private String statMonth;
	//本月实际花费
	private BigDecimal thisMonthCost;
	//本月预计花费
	private BigDecimal thisMonthExpectCost;
	//上月总花费
	private BigDecimal lastMonthCost;
	//前三月月均花费
	private BigDecimal averageCost3;
	//数据状态：0-删除 1-正常
	private Integer dataState;
	//关联账户ID
	private String linkedAccountId;
	//抵扣花费
	private BigDecimal monthDeductedCost;

	/**
	 * 设置：月总花费统计ID
	 */
	public void setStatId(String statId) {
		this.statId = statId;
	}
	/**
	 * 获取：月总花费统计ID
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
	 * 设置：精确到月份
	 */
	public void setStatMonth(String statMonth) {
		this.statMonth = statMonth;
	}
	/**
	 * 获取：精确到月份
	 */
	public String getStatMonth() {
		return statMonth;
	}
	/**
	 * 设置：本月实际花费
	 */
	public void setThisMonthCost(BigDecimal thisMonthCost) {
		this.thisMonthCost = thisMonthCost;
	}
	/**
	 * 获取：本月实际花费
	 */
	public BigDecimal getThisMonthCost() {
		return thisMonthCost;
	}
	/**
	 * 设置：本月预计花费
	 */
	public void setThisMonthExpectCost(BigDecimal thisMonthExpectCost) {
		this.thisMonthExpectCost = thisMonthExpectCost;
	}
	/**
	 * 获取：本月预计花费
	 */
	public BigDecimal getThisMonthExpectCost() {
		return thisMonthExpectCost;
	}
	/**
	 * 设置：上月总花费
	 */
	public void setLastMonthCost(BigDecimal lastMonthCost) {
		this.lastMonthCost = lastMonthCost;
	}
	/**
	 * 获取：上月总花费
	 */
	public BigDecimal getLastMonthCost() {
		return lastMonthCost;
	}
	/**
	 * 设置：前三月月均花费
	 */
	public void setAverageCost3(BigDecimal averageCost3) {
		this.averageCost3 = averageCost3;
	}
	/**
	 * 获取：前三月月均花费
	 */
	public BigDecimal getAverageCost3() {
		return averageCost3;
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
	/**
	 * 设置：抵扣花费
	 */
	public void setMonthDeductedCost(BigDecimal monthDeductedCost) {
		this.monthDeductedCost = monthDeductedCost;
	}
	/**
	 * 获取：抵扣花费
	 */
	public BigDecimal getMonthDeductedCost() {
		return monthDeductedCost;
	}
}
