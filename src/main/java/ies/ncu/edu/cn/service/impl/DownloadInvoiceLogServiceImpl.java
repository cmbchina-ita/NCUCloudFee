package ies.ncu.edu.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import ies.ncu.edu.cn.dao.DownloadInvoiceLogDao;
import ies.ncu.edu.cn.entity.DownloadInvoiceLogEntity;
import ies.ncu.edu.cn.service.DownloadInvoiceLogService;



@Service("downloadInvoiceLogService")
public class DownloadInvoiceLogServiceImpl implements DownloadInvoiceLogService {
	@Autowired
	private DownloadInvoiceLogDao downloadInvoiceLogDao;
	
	@Override
	public DownloadInvoiceLogEntity queryObject(String logId){
		return downloadInvoiceLogDao.queryObject(logId);
	}
	
	@Override
	public List<DownloadInvoiceLogEntity> queryList(Map<String, Object> map){
		return downloadInvoiceLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return downloadInvoiceLogDao.queryTotal(map);
	}
	
	@Override
	public void save(DownloadInvoiceLogEntity downloadInvoiceLog){
		downloadInvoiceLogDao.save(downloadInvoiceLog);
	}
	
	@Override
	public void update(DownloadInvoiceLogEntity downloadInvoiceLog){
		downloadInvoiceLogDao.update(downloadInvoiceLog);
	}
	
	@Override
	public void delete(String logId){
		downloadInvoiceLogDao.delete(logId);
	}
	
	@Override
	public void deleteBatch(String[] logIds){
		downloadInvoiceLogDao.deleteBatch(logIds);
	}
	
}
