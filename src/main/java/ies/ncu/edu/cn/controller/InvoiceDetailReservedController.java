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

import ies.ncu.edu.cn.entity.InvoiceDetailReservedEntity;
import ies.ncu.edu.cn.service.InvoiceDetailReservedService;
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
 * @date 2017-04-23 14:08:08
 */
@RestController
@RequestMapping("invoicedetailreserved")
public class InvoiceDetailReservedController {
	@Autowired
	private InvoiceDetailReservedService invoiceDetailReservedService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetailreserved:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailReservedEntity> invoiceDetailReservedList = invoiceDetailReservedService.queryList(query);
		int total = invoiceDetailReservedService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailReservedList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{reservedDescId}")
	@RequiresPermissions("invoicedetailreserved:info")
	public R info(@PathVariable("reservedDescId") String reservedDescId){
		InvoiceDetailReservedEntity invoiceDetailReserved = invoiceDetailReservedService.queryObject(reservedDescId);
		
		return R.ok().put("invoiceDetailReserved", invoiceDetailReserved);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetailreserved:save")
	public R save(@RequestBody InvoiceDetailReservedEntity invoiceDetailReserved){
		invoiceDetailReservedService.save(invoiceDetailReserved);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetailreserved:update")
	public R update(@RequestBody InvoiceDetailReservedEntity invoiceDetailReserved){
		invoiceDetailReservedService.update(invoiceDetailReserved);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetailreserved:delete")
	public R delete(@RequestBody String[] reservedDescIds){
		invoiceDetailReservedService.deleteBatch(reservedDescIds);
		
		return R.ok();
	}
	
}
