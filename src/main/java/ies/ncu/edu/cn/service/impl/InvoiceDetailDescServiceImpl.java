package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailDescDao;
import ies.ncu.edu.cn.entity.InvoiceDetailDescEntity;
import ies.ncu.edu.cn.service.InvoiceDetailDescService;



@Service("invoiceDetailDescService")
public class InvoiceDetailDescServiceImpl implements InvoiceDetailDescService {
	@Autowired
	private InvoiceDetailDescDao invoiceDetailDescDao;
	
	@Override
	public InvoiceDetailDescEntity queryObject(String id){
		return invoiceDetailDescDao.queryObject(id);
	}
	
	@Override
	public List<InvoiceDetailDescEntity> queryList(Map<String, Object> map){
		return invoiceDetailDescDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailDescDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailDescEntity invoiceDetailDesc){
		invoiceDetailDescDao.save(invoiceDetailDesc);
	}
	
	@Override
	public void update(InvoiceDetailDescEntity invoiceDetailDesc){
		invoiceDetailDescDao.update(invoiceDetailDesc);
	}
	
	@Override
	public void delete(String id){
		invoiceDetailDescDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		invoiceDetailDescDao.deleteBatch(ids);
	}
	
}
