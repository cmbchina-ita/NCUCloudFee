package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailReservedDao;
import ies.ncu.edu.cn.entity.InvoiceDetailReservedEntity;
import ies.ncu.edu.cn.service.InvoiceDetailReservedService;



@Service("invoiceDetailReservedService")
public class InvoiceDetailReservedServiceImpl implements InvoiceDetailReservedService {
	@Autowired
	private InvoiceDetailReservedDao invoiceDetailReservedDao;
	
	@Override
	public InvoiceDetailReservedEntity queryObject(String reservedDescId){
		return invoiceDetailReservedDao.queryObject(reservedDescId);
	}
	
	@Override
	public List<InvoiceDetailReservedEntity> queryList(Map<String, Object> map){
		return invoiceDetailReservedDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailReservedDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailReservedEntity invoiceDetailReserved){
		invoiceDetailReservedDao.save(invoiceDetailReserved);
	}
	
	@Override
	public void update(InvoiceDetailReservedEntity invoiceDetailReserved){
		invoiceDetailReservedDao.update(invoiceDetailReserved);
	}
	
	@Override
	public void delete(String reservedDescId){
		invoiceDetailReservedDao.delete(reservedDescId);
	}
	
	@Override
	public void deleteBatch(String[] reservedDescIds){
		invoiceDetailReservedDao.deleteBatch(reservedDescIds);
	}
	
}
