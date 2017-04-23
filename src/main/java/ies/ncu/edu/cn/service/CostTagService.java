package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.CostTagEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public interface CostTagService {
	
	CostTagEntity queryObject(String tagId);
	
	List<CostTagEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CostTagEntity costTag);
	
	void update(CostTagEntity costTag);
	
	void delete(String tagId);
	
	void deleteBatch(String[] tagIds);
}
