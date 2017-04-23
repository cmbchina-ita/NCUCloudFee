package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.TagDayCostStatEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface TagDayCostStatService {
	
	TagDayCostStatEntity queryObject(String statId);
	
	List<TagDayCostStatEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TagDayCostStatEntity tagDayCostStat);
	
	void update(TagDayCostStatEntity tagDayCostStat);
	
	void delete(String statId);
	
	void deleteBatch(String[] statIds);
}
