package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailDao;
import ies.ncu.edu.cn.entity.InvoiceDetailEntity;
import ies.ncu.edu.cn.service.InvoiceDetailService;



@Service("invoiceDetailService")
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	@Autowired
	private InvoiceDetailDao invoiceDetailDao;
	
	@Override
	public InvoiceDetailEntity queryObject(Integer invoiceId){
		return invoiceDetailDao.queryObject(invoiceId);
	}
	
	@Override
	public List<InvoiceDetailEntity> queryList(Map<String, Object> map){
		return invoiceDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailEntity invoiceDetail){
		invoiceDetailDao.save(invoiceDetail);
	}
	
	@Override
	public void update(InvoiceDetailEntity invoiceDetail){
		invoiceDetailDao.update(invoiceDetail);
	}
	
	@Override
	public void delete(Integer invoiceId){
		invoiceDetailDao.delete(invoiceId);
	}
	
	@Override
	public void deleteBatch(Integer[] invoiceIds){
		invoiceDetailDao.deleteBatch(invoiceIds);
	}
	
}
