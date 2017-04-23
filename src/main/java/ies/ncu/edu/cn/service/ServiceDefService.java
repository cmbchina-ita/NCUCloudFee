package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.ServiceDefEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface ServiceDefService {
	
	ServiceDefEntity queryObject(String serviceId);
	
	List<ServiceDefEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ServiceDefEntity serviceDef);
	
	void update(ServiceDefEntity serviceDef);
	
	void delete(String serviceId);
	
	void deleteBatch(String[] serviceIds);
}
