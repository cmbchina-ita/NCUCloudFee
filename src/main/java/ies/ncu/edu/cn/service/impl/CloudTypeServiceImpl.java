package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.CloudTypeDao;
import ies.ncu.edu.cn.entity.CloudTypeEntity;
import ies.ncu.edu.cn.service.CloudTypeService;



@Service("cloudTypeService")
public class CloudTypeServiceImpl implements CloudTypeService {
	@Autowired
	private CloudTypeDao cloudTypeDao;
	
	@Override
	public CloudTypeEntity queryObject(String cloudId){
		return cloudTypeDao.queryObject(cloudId);
	}
	
	@Override
	public List<CloudTypeEntity> queryList(Map<String, Object> map){
		return cloudTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return cloudTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(CloudTypeEntity cloudType){
		cloudTypeDao.save(cloudType);
	}
	
	@Override
	public void update(CloudTypeEntity cloudType){
		cloudTypeDao.update(cloudType);
	}
	
	@Override
	public void delete(String cloudId){
		cloudTypeDao.delete(cloudId);
	}
	
	@Override
	public void deleteBatch(String[] cloudIds){
		cloudTypeDao.deleteBatch(cloudIds);
	}
	
}
