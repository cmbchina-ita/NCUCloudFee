package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.AccountDao;
import ies.ncu.edu.cn.entity.AccountEntity;
import ies.ncu.edu.cn.service.AccountService;



@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public AccountEntity queryObject(String accountId){
		return accountDao.queryObject(accountId);
	}
	
	@Override
	public List<AccountEntity> queryList(Map<String, Object> map){
		return accountDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return accountDao.queryTotal(map);
	}
	
	@Override
	public void save(AccountEntity account){
		accountDao.save(account);
	}
	
	@Override
	public void update(AccountEntity account){
		accountDao.update(account);
	}
	
	@Override
	public void delete(String accountId){
		accountDao.delete(accountId);
	}
	
	@Override
	public void deleteBatch(String[] accountIds){
		accountDao.deleteBatch(accountIds);
	}
	
}
