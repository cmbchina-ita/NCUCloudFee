package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailAdjustFilterDao;
import ies.ncu.edu.cn.entity.InvoiceDetailAdjustFilterEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustFilterService;



@Service("invoiceDetailAdjustFilterService")
public class InvoiceDetailAdjustFilterServiceImpl implements InvoiceDetailAdjustFilterService {
	@Autowired
	private InvoiceDetailAdjustFilterDao invoiceDetailAdjustFilterDao;
	
	@Override
	public InvoiceDetailAdjustFilterEntity queryObject(String adjustId){
		return invoiceDetailAdjustFilterDao.queryObject(adjustId);
	}
	
	@Override
	public List<InvoiceDetailAdjustFilterEntity> queryList(Map<String, Object> map){
		return invoiceDetailAdjustFilterDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailAdjustFilterDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailAdjustFilterEntity invoiceDetailAdjustFilter){
		invoiceDetailAdjustFilterDao.save(invoiceDetailAdjustFilter);
	}
	
	@Override
	public void update(InvoiceDetailAdjustFilterEntity invoiceDetailAdjustFilter){
		invoiceDetailAdjustFilterDao.update(invoiceDetailAdjustFilter);
	}
	
	@Override
	public void delete(String adjustId){
		invoiceDetailAdjustFilterDao.delete(adjustId);
	}
	
	@Override
	public void deleteBatch(String[] adjustIds){
		invoiceDetailAdjustFilterDao.deleteBatch(adjustIds);
	}
	
}
