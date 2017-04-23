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

import ies.ncu.edu.cn.entity.InvoiceDetailAdjustFilterEntity;
import ies.ncu.edu.cn.service.InvoiceDetailAdjustFilterService;
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
@RequestMapping("invoicedetailadjustfilter")
public class InvoiceDetailAdjustFilterController {
	@Autowired
	private InvoiceDetailAdjustFilterService invoiceDetailAdjustFilterService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetailadjustfilter:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailAdjustFilterEntity> invoiceDetailAdjustFilterList = invoiceDetailAdjustFilterService.queryList(query);
		int total = invoiceDetailAdjustFilterService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailAdjustFilterList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{adjustId}")
	@RequiresPermissions("invoicedetailadjustfilter:info")
	public R info(@PathVariable("adjustId") String adjustId){
		InvoiceDetailAdjustFilterEntity invoiceDetailAdjustFilter = invoiceDetailAdjustFilterService.queryObject(adjustId);
		
		return R.ok().put("invoiceDetailAdjustFilter", invoiceDetailAdjustFilter);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetailadjustfilter:save")
	public R save(@RequestBody InvoiceDetailAdjustFilterEntity invoiceDetailAdjustFilter){
		invoiceDetailAdjustFilterService.save(invoiceDetailAdjustFilter);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetailadjustfilter:update")
	public R update(@RequestBody InvoiceDetailAdjustFilterEntity invoiceDetailAdjustFilter){
		invoiceDetailAdjustFilterService.update(invoiceDetailAdjustFilter);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetailadjustfilter:delete")
	public R delete(@RequestBody String[] adjustIds){
		invoiceDetailAdjustFilterService.deleteBatch(adjustIds);
		
		return R.ok();
	}
	
}
