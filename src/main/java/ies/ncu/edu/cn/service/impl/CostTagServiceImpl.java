package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.CostTagDao;
import ies.ncu.edu.cn.entity.CostTagEntity;
import ies.ncu.edu.cn.service.CostTagService;



@Service("costTagService")
public class CostTagServiceImpl implements CostTagService {
	@Autowired
	private CostTagDao costTagDao;
	
	@Override
	public CostTagEntity queryObject(String tagId){
		return costTagDao.queryObject(tagId);
	}
	
	@Override
	public List<CostTagEntity> queryList(Map<String, Object> map){
		return costTagDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return costTagDao.queryTotal(map);
	}
	
	@Override
	public void save(CostTagEntity costTag){
		costTagDao.save(costTag);
	}
	
	@Override
	public void update(CostTagEntity costTag){
		costTagDao.update(costTag);
	}
	
	@Override
	public void delete(String tagId){
		costTagDao.delete(tagId);
	}
	
	@Override
	public void deleteBatch(String[] tagIds){
		costTagDao.deleteBatch(tagIds);
	}
	
}
