package ies.ncu.edu.cn.service;

import ies.ncu.edu.cn.entity.InvoiceDetailDescEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
public interface InvoiceDetailDescService {
	
	InvoiceDetailDescEntity queryObject(String id);
	
	List<InvoiceDetailDescEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InvoiceDetailDescEntity invoiceDetailDesc);
	
	void update(InvoiceDetailDescEntity invoiceDetailDesc);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
