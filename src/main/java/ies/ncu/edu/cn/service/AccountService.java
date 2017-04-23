package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.AccountEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public interface AccountService {
	
	AccountEntity queryObject(String accountId);
	
	List<AccountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AccountEntity account);
	
	void update(AccountEntity account);
	
	void delete(String accountId);
	
	void deleteBatch(String[] accountIds);
}
