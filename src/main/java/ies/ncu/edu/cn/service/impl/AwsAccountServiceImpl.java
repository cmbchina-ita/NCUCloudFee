package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.AwsAccountDao;
import ies.ncu.edu.cn.entity.AwsAccountEntity;
import ies.ncu.edu.cn.service.AwsAccountService;



@Service("awsAccountService")
public class AwsAccountServiceImpl implements AwsAccountService {
	@Autowired
	private AwsAccountDao awsAccountDao;
	
	@Override
	public AwsAccountEntity queryObject(String accountId){
		return awsAccountDao.queryObject(accountId);
	}
	
	@Override
	public List<AwsAccountEntity> queryList(Map<String, Object> map){
		return awsAccountDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return awsAccountDao.queryTotal(map);
	}
	
	@Override
	public void save(AwsAccountEntity awsAccount){
		awsAccountDao.save(awsAccount);
	}
	
	@Override
	public void update(AwsAccountEntity awsAccount){
		awsAccountDao.update(awsAccount);
	}
	
	@Override
	public void delete(String accountId){
		awsAccountDao.delete(accountId);
	}
	
	@Override
	public void deleteBatch(String[] accountIds){
		awsAccountDao.deleteBatch(accountIds);
	}
	
}
