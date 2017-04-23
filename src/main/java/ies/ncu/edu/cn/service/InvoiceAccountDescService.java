package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.InvoiceAccountDescEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface InvoiceAccountDescService {
	
	InvoiceAccountDescEntity queryObject(String invoiceAccountId);
	
	List<InvoiceAccountDescEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InvoiceAccountDescEntity invoiceAccountDesc);
	
	void update(InvoiceAccountDescEntity invoiceAccountDesc);
	
	void delete(String invoiceAccountId);
	
	void deleteBatch(String[] invoiceAccountIds);
}
