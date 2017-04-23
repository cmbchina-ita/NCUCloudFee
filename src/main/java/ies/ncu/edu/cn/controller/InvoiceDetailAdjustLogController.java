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

import ies.ncu.edu.cn.entity.InvoiceDetailAdjustLogEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustLogService;
/**
import ies.ncu.edu.cn.utils.PageUtils;
import ies.ncu.edu.cn.utils.Query;
import ies.ncu.edu.cn.utils.R;
*/
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:20
 */
@RestController
@RequestMapping("invoicedetailadjustlog")
public class InvoiceDetailAdjustLogController {
	@Autowired
	private InvoiceDetailAdjustLogService invoiceDetailAdjustLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetailadjustlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailAdjustLogEntity> invoiceDetailAdjustLogList = invoiceDetailAdjustLogService.queryList(query);
		int total = invoiceDetailAdjustLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailAdjustLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{adjustLogId}")
	@RequiresPermissions("invoicedetailadjustlog:info")
	public R info(@PathVariable("adjustLogId") String adjustLogId){
		InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog = invoiceDetailAdjustLogService.queryObject(adjustLogId);
		
		return R.ok().put("invoiceDetailAdjustLog", invoiceDetailAdjustLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetailadjustlog:save")
	public R save(@RequestBody InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog){
		invoiceDetailAdjustLogService.save(invoiceDetailAdjustLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetailadjustlog:update")
	public R update(@RequestBody InvoiceDetailAdjustLogEntity invoiceDetailAdjustLog){
		invoiceDetailAdjustLogService.update(invoiceDetailAdjustLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetailadjustlog:delete")
	public R delete(@RequestBody String[] adjustLogIds){
		invoiceDetailAdjustLogService.deleteBatch(adjustLogIds);
		
		return R.ok();
	}
	
}
