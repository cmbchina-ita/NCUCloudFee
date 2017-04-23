package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailAdjustResultDao;
import ies.ncu.edu.cn.entity.InvoiceDetailAdjustResultEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustResultService;



@Service("invoiceDetailAdjustResultService")
public class InvoiceDetailAdjustResultServiceImpl implements InvoiceDetailAdjustResultService {
	@Autowired
	private InvoiceDetailAdjustResultDao invoiceDetailAdjustResultDao;
	
	@Override
	public InvoiceDetailAdjustResultEntity queryObject(String adjustId){
		return invoiceDetailAdjustResultDao.queryObject(adjustId);
	}
	
	@Override
	public List<InvoiceDetailAdjustResultEntity> queryList(Map<String, Object> map){
		return invoiceDetailAdjustResultDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailAdjustResultDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailAdjustResultEntity invoiceDetailAdjustResult){
		invoiceDetailAdjustResultDao.save(invoiceDetailAdjustResult);
	}
	
	@Override
	public void update(InvoiceDetailAdjustResultEntity invoiceDetailAdjustResult){
		invoiceDetailAdjustResultDao.update(invoiceDetailAdjustResult);
	}
	
	@Override
	public void delete(String adjustId){
		invoiceDetailAdjustResultDao.delete(adjustId);
	}
	
	@Override
	public void deleteBatch(String[] adjustIds){
		invoiceDetailAdjustResultDao.deleteBatch(adjustIds);
	}
	
}
