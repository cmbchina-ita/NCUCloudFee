package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.MonthCostStatEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public interface MonthCostStatService {
	
	MonthCostStatEntity queryObject(String statId);
	
	List<MonthCostStatEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MonthCostStatEntity monthCostStat);
	
	void update(MonthCostStatEntity monthCostStat);
	
	void delete(String statId);
	
	void deleteBatch(String[] statIds);
}
