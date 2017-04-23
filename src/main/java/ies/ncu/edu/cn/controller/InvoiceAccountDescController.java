package ies.ncu.edu.cn.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.ncu.edu.cn.entity.InvoiceAccountDescEntity;
import ies.ncu.edu.cn.service.InvoiceAccountDescService;
/**
import ies.ncu.edu.cn.utils.PageUtils;
import ies.ncu.edu.cn.utils.Query;
import ies.ncu.edu.cn.utils.R;
*/
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
@RestController
@RequestMapping("invoiceaccountdesc")
public class InvoiceAccountDescController {
	@Autowired
	private InvoiceAccountDescService invoiceAccountDescService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoiceaccountdesc:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceAccountDescEntity> invoiceAccountDescList = invoiceAccountDescService.queryList(query);
		int total = invoiceAccountDescService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceAccountDescList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{invoiceAccountId}")
	@RequiresPermissions("invoiceaccountdesc:info")
	public R info(@PathVariable("invoiceAccountId") String invoiceAccountId){
		InvoiceAccountDescEntity invoiceAccountDesc = invoiceAccountDescService.queryObject(invoiceAccountId);
		
		return R.ok().put("invoiceAccountDesc", invoiceAccountDesc);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoiceaccountdesc:save")
	public R save(@RequestBody InvoiceAccountDescEntity invoiceAccountDesc){
		invoiceAccountDescService.save(invoiceAccountDesc);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoiceaccountdesc:update")
	public R update(@RequestBody InvoiceAccountDescEntity invoiceAccountDesc){
		invoiceAccountDescService.update(invoiceAccountDesc);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoiceaccountdesc:delete")
	public R delete(@RequestBody String[] invoiceAccountIds){
		invoiceAccountDescService.deleteBatch(invoiceAccountIds);
		
		return R.ok();
	}
	
}
