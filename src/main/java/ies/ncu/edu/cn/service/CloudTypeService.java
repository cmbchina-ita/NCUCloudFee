package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.CloudTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface CloudTypeService {
	
	CloudTypeEntity queryObject(String cloudId);
	
	List<CloudTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CloudTypeEntity cloudType);
	
	void update(CloudTypeEntity cloudType);
	
	void delete(String cloudId);
	
	void deleteBatch(String[] cloudIds);
}
