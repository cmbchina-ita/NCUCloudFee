package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.InvoiceDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface InvoiceDetailService {
	
	InvoiceDetailEntity queryObject(Integer invoiceId);
	
	List<InvoiceDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InvoiceDetailEntity invoiceDetail);
	
	void update(InvoiceDetailEntity invoiceDetail);
	
	void delete(Integer invoiceId);
	
	void deleteBatch(Integer[] invoiceIds);
}
