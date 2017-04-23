package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.AccountLinkaccountDao;
import ies.ncu.edu.cn.entity.AccountLinkaccountEntity;
import ies.ncu.edu.cn.service.AccountLinkaccountService;



@Service("accountLinkaccountService")
public class AccountLinkaccountServiceImpl implements AccountLinkaccountService {
	@Autowired
	private AccountLinkaccountDao accountLinkaccountDao;
	
	@Override
	public AccountLinkaccountEntity queryObject(String accountLinkId){
		return accountLinkaccountDao.queryObject(accountLinkId);
	}
	
	@Override
	public List<AccountLinkaccountEntity> queryList(Map<String, Object> map){
		return accountLinkaccountDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return accountLinkaccountDao.queryTotal(map);
	}
	
	@Override
	public void save(AccountLinkaccountEntity accountLinkaccount){
		accountLinkaccountDao.save(accountLinkaccount);
	}
	
	@Override
	public void update(AccountLinkaccountEntity accountLinkaccount){
		accountLinkaccountDao.update(accountLinkaccount);
	}
	
	@Override
	public void delete(String accountLinkId){
		accountLinkaccountDao.delete(accountLinkId);
	}
	
	@Override
	public void deleteBatch(String[] accountLinkIds){
		accountLinkaccountDao.deleteBatch(accountLinkIds);
	}
	
}
