package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.InvoiceDetailAdjustLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
public interface InvoiceDetailAdjustLogService {
	
	InvoiceDetailAdjustLogEntity queryObject(String adjustLogId);
	
	List<InvoiceDetailAdjustLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog);
	
	void update(InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog);
	
	void delete(String adjustLogId);
	
	void deleteBatch(String[] adjustLogIds);
}
