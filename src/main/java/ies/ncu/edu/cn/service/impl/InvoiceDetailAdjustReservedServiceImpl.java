package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailAdjustReservedDao;
import ies.ncu.edu.cn.entity.InvoiceDetailAdjustReservedEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustReservedService;



@Service("invoiceDetailAdjustReservedService")
public class InvoiceDetailAdjustReservedServiceImpl implements InvoiceDetailAdjustReservedService {
	@Autowired
	private InvoiceDetailAdjustReservedDao invoiceDetailAdjustReservedDao;
	
	@Override
	public InvoiceDetailAdjustReservedEntity queryObject(String adjustId){
		return invoiceDetailAdjustReservedDao.queryObject(adjustId);
	}
	
	@Override
	public List<InvoiceDetailAdjustReservedEntity> queryList(Map<String, Object> map){
		return invoiceDetailAdjustReservedDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailAdjustReservedDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailAdjustReservedEntity invoiceDetailAdjustReserved){
		invoiceDetailAdjustReservedDao.save(invoiceDetailAdjustReserved);
	}
	
	@Override
	public void update(InvoiceDetailAdjustReservedEntity invoiceDetailAdjustReserved){
		invoiceDetailAdjustReservedDao.update(invoiceDetailAdjustReserved);
	}
	
	@Override
	public void delete(String adjustId){
		invoiceDetailAdjustReservedDao.delete(adjustId);
	}
	
	@Override
	public void deleteBatch(String[] adjustIds){
		invoiceDetailAdjustReservedDao.deleteBatch(adjustIds);
	}
	
}
