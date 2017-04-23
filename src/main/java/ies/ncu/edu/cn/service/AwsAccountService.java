package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.AwsAccountEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public interface AwsAccountService {
	
	AwsAccountEntity queryObject(String accountId);
	
	List<AwsAccountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AwsAccountEntity awsAccount);
	
	void update(AwsAccountEntity awsAccount);
	
	void delete(String accountId);
	
	void deleteBatch(String[] accountIds);
}
