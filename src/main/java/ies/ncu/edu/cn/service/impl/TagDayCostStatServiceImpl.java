package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.TagDayCostStatDao;
import ies.ncu.edu.cn.entity.TagDayCostStatEntity;
import ies.ncu.edu.cn.service.TagDayCostStatService;



@Service("tagDayCostStatService")
public class TagDayCostStatServiceImpl implements TagDayCostStatService {
	@Autowired
	private TagDayCostStatDao tagDayCostStatDao;
	
	@Override
	public TagDayCostStatEntity queryObject(String statId){
		return tagDayCostStatDao.queryObject(statId);
	}
	
	@Override
	public List<TagDayCostStatEntity> queryList(Map<String, Object> map){
		return tagDayCostStatDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tagDayCostStatDao.queryTotal(map);
	}
	
	@Override
	public void save(TagDayCostStatEntity tagDayCostStat){
		tagDayCostStatDao.save(tagDayCostStat);
	}
	
	@Override
	public void update(TagDayCostStatEntity tagDayCostStat){
		tagDayCostStatDao.update(tagDayCostStat);
	}
	
	@Override
	public void delete(String statId){
		tagDayCostStatDao.delete(statId);
	}
	
	@Override
	public void deleteBatch(String[] statIds){
		tagDayCostStatDao.deleteBatch(statIds);
	}
	
}
