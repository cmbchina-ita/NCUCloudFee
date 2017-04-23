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

import ies.ncu.edu.cn.entity.InvoiceDetailAdjustReservedEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustReservedService;
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
@RequestMapping("invoicedetailadjustreserved")
public class InvoiceDetailAdjustReservedController {
	@Autowired
	private InvoiceDetailAdjustReservedService invoiceDetailAdjustReservedService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetailadjustreserved:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailAdjustReservedEntity> invoiceDetailAdjustReservedList = invoiceDetailAdjustReservedService.queryList(query);
		int total = invoiceDetailAdjustReservedService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailAdjustReservedList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{adjustId}")
	@RequiresPermissions("invoicedetailadjustreserved:info")
	public R info(@PathVariable("adjustId") String adjustId){
		InvoiceDetailAdjustReservedEntity invoiceDetailAdjustReserved = invoiceDetailAdjustReservedService.queryObject(adjustId);
		
		return R.ok().put("invoiceDetailAdjustReserved", invoiceDetailAdjustReserved);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetailadjustreserved:save")
	public R save(@RequestBody InvoiceDetailAdjustReservedEntity invoiceDetailAdjustReserved){
		invoiceDetailAdjustReservedService.save(invoiceDetailAdjustReserved);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetailadjustreserved:update")
	public R update(@RequestBody InvoiceDetailAdjustReservedEntity invoiceDetailAdjustReserved){
		invoiceDetailAdjustReservedService.update(invoiceDetailAdjustReserved);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetailadjustreserved:delete")
	public R delete(@RequestBody String[] adjustIds){
		invoiceDetailAdjustReservedService.deleteBatch(adjustIds);
		
		return R.ok();
	}
	
}
