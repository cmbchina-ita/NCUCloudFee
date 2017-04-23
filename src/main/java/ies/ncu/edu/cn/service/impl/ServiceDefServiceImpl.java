package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.ServiceDefDao;
import ies.ncu.edu.cn.entity.ServiceDefEntity;
import ies.ncu.edu.cn.service.ServiceDefService;



@Service("serviceDefService")
public class ServiceDefServiceImpl implements ServiceDefService {
	@Autowired
	private ServiceDefDao serviceDefDao;
	
	@Override
	public ServiceDefEntity queryObject(String serviceId){
		return serviceDefDao.queryObject(serviceId);
	}
	
	@Override
	public List<ServiceDefEntity> queryList(Map<String, Object> map){
		return serviceDefDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return serviceDefDao.queryTotal(map);
	}
	
	@Override
	public void save(ServiceDefEntity serviceDef){
		serviceDefDao.save(serviceDef);
	}
	
	@Override
	public void update(ServiceDefEntity serviceDef){
		serviceDefDao.update(serviceDef);
	}
	
	@Override
	public void delete(String serviceId){
		serviceDefDao.delete(serviceId);
	}
	
	@Override
	public void deleteBatch(String[] serviceIds){
		serviceDefDao.deleteBatch(serviceIds);
	}
	
}
