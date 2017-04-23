package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.AccountLinkaccountEntity;

import java.util.List;
import java.util.Map;

/**
 * 云账户与关联账户的关系
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface AccountLinkaccountService {
	
	AccountLinkaccountEntity queryObject(String accountLinkId);
	
	List<AccountLinkaccountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AccountLinkaccountEntity accountLinkaccount);
	
	void update(AccountLinkaccountEntity accountLinkaccount);
	
	void delete(String accountLinkId);
	
	void deleteBatch(String[] accountLinkIds);
}
