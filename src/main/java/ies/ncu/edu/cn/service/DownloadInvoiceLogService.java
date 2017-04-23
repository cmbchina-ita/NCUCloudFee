package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.DownloadInvoiceLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface DownloadInvoiceLogService {
	
	DownloadInvoiceLogEntity queryObject(String logId);
	
	List<DownloadInvoiceLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DownloadInvoiceLogEntity downloadInvoiceLog);
	
	void update(DownloadInvoiceLogEntity downloadInvoiceLog);
	
	void delete(String logId);
	
	void deleteBatch(String[] logIds);
}
