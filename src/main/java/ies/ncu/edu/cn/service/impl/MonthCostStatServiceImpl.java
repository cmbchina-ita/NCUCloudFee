package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.MonthCostStatDao;
import ies.ncu.edu.cn.entity.MonthCostStatEntity;
import ies.ncu.edu.cn.service.MonthCostStatService;



@Service("monthCostStatService")
public class MonthCostStatServiceImpl implements MonthCostStatService {
	@Autowired
	private MonthCostStatDao monthCostStatDao;
	
	@Override
	public MonthCostStatEntity queryObject(String statId){
		return monthCostStatDao.queryObject(statId);
	}
	
	@Override
	public List<MonthCostStatEntity> queryList(Map<String, Object> map){
		return monthCostStatDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return monthCostStatDao.queryTotal(map);
	}
	
	@Override
	public void save(MonthCostStatEntity monthCostStat){
		monthCostStatDao.save(monthCostStat);
	}
	
	@Override
	public void update(MonthCostStatEntity monthCostStat){
		monthCostStatDao.update(monthCostStat);
	}
	
	@Override
	public void delete(String statId){
		monthCostStatDao.delete(statId);
	}
	
	@Override
	public void deleteBatch(String[] statIds){
		monthCostStatDao.deleteBatch(statIds);
	}
	
}
