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
public class AwsAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String accountId;
	//
	private String region;
	//
	private String awsUserId;
	//
	private String accessKeyId;
	//
	private String secretKey;
	//Aws bucket_name
	private String bucketName;
	//
	private String awsArn;

	/**
	 * 设置：
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * 获取：
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * 设置：
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 获取：
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * 设置：
	 */
	public void setAwsUserId(String awsUserId) {
		this.awsUserId = awsUserId;
	}
	/**
	 * 获取：
	 */
	public String getAwsUserId() {
		return awsUserId;
	}
	/**
	 * 设置：
	 */
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	/**
	 * 获取：
	 */
	public String getAccessKeyId() {
		return accessKeyId;
	}
	/**
	 * 设置：
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	/**
	 * 获取：
	 */
	public String getSecretKey() {
		return secretKey;
	}
	/**
	 * 设置：Aws bucket_name
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	/**
	 * 获取：Aws bucket_name
	 */
	public String getBucketName() {
		return bucketName;
	}
	/**
	 * 设置：
	 */
	public void setAwsArn(String awsArn) {
		this.awsArn = awsArn;
	}
	/**
	 * 获取：
	 */
	public String getAwsArn() {
		return awsArn;
	}
}
