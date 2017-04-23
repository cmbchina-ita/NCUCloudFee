package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.InvoiceDetailAdjustLogDao;
import ies.ncu.edu.cn.entity.InvoiceDetailAdjustLogEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustLogService;



@Service("invoiceDetailAdjustLogService")
public class InvoiceDetailAdjustLogServiceImpl implements InvoiceDetailAdjustLogService {
	@Autowired
	private InvoiceDetailAdjustLogDao invoiceDetailAdjustLogDao;
	
	@Override
	public InvoiceDetailAdjustLogEntity queryObject(String adjustLogId){
		return invoiceDetailAdjustLogDao.queryObject(adjustLogId);
	}
	
	@Override
	public List<InvoiceDetailAdjustLogEntity> queryList(Map<String, Object> map){
		return invoiceDetailAdjustLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return invoiceDetailAdjustLogDao.queryTotal(map);
	}
	
	@Override
	public void save(InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog){
		invoiceDetailAdjustLogDao.save(invoiceDetailAdjustLog);
	}
	
	@Override
	public void update(InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog){
		invoiceDetailAdjustLogDao.update(invoiceDetailAdjustLog);
	}
	
	@Override
	public void delete(String adjustLogId){
		invoiceDetailAdjustLogDao.delete(adjustLogId);
	}
	
	@Override
	public void deleteBatch(String[] adjustLogIds){
		invoiceDetailAdjustLogDao.deleteBatch(adjustLogIds);
	}
	
}
