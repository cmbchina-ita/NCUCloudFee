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

import ies.ncu.edu.cn.entity.InvoiceDetailAdjustResultEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustResultService;
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
@RequestMapping("invoicedetailadjustresult")
public class InvoiceDetailAdjustResultController {
	@Autowired
	private InvoiceDetailAdjustResultService invoiceDetailAdjustResultService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetailadjustresult:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailAdjustResultEntity> invoiceDetailAdjustResultList = invoiceDetailAdjustResultService.queryList(query);
		int total = invoiceDetailAdjustResultService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailAdjustResultList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{adjustId}")
	@RequiresPermissions("invoicedetailadjustresult:info")
	public R info(@PathVariable("adjustId") String adjustId){
		InvoiceDetailAdjustResultEntity invoiceDetailAdjustResult = invoiceDetailAdjustResultService.queryObject(adjustId);
		
		return R.ok().put("invoiceDetailAdjustResult", invoiceDetailAdjustResult);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetailadjustresult:save")
	public R save(@RequestBody InvoiceDetailAdjustResultEntity invoiceDetailAdjustResult){
		invoiceDetailAdjustResultService.save(invoiceDetailAdjustResult);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetailadjustresult:update")
	public R update(@RequestBody InvoiceDetailAdjustResultEntity invoiceDetailAdjustResult){
		invoiceDetailAdjustResultService.update(invoiceDetailAdjustResult);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetailadjustresult:delete")
	public R delete(@RequestBody String[] adjustIds){
		invoiceDetailAdjustResultService.deleteBatch(adjustIds);
		
		return R.ok();
	}
	
}
