package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceAccountDescDao;
import ies.ncu.edu.cn.entity.InvoiceAccountDescEntity;
import ies.ncu.edu.cn.service.InvoiceAccountDescService;



@Service("invoiceAccountDescService")
public class InvoiceAccountDescServiceImpl implements InvoiceAccountDescService {
	@Autowired
	private InvoiceAccountDescDao invoiceAccountDescDao;
	
	@Override
	public InvoiceAccountDescEntity queryObject(String invoiceAccountId){
		return invoiceAccountDescDao.queryObject(invoiceAccountId);
	}
	
	@Override
	public List<InvoiceAccountDescEntity> queryList(Map<String, Object> map){
		return invoiceAccountDescDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceAccountDescDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceAccountDescEntity invoiceAccountDesc){
		invoiceAccountDescDao.save(invoiceAccountDesc);
	}
	
	@Override
	public void update(InvoiceAccountDescEntity invoiceAccountDesc){
		invoiceAccountDescDao.update(invoiceAccountDesc);
	}
	
	@Override
	public void delete(String invoiceAccountId){
		invoiceAccountDescDao.delete(invoiceAccountId);
	}
	
	@Override
	public void deleteBatch(String[] invoiceAccountIds){
		invoiceAccountDescDao.deleteBatch(invoiceAccountIds);
	}
	
}
