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

import ies.ncu.edu.cn.entity.InvoiceDetailEntity;
import ies.ncu.edu.cn.service.InvoiceDetailService;
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
@RequestMapping("invoicedetail")
public class InvoiceDetailController {
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailEntity> invoiceDetailList = invoiceDetailService.queryList(query);
		int total = invoiceDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{invoiceId}")
	@RequiresPermissions("invoicedetail:info")
	public R info(@PathVariable("invoiceId") Integer invoiceId){
		InvoiceDetailEntity invoiceDetail = invoiceDetailService.queryObject(invoiceId);
		
		return R.ok().put("invoiceDetail", invoiceDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetail:save")
	public R save(@RequestBody InvoiceDetailEntity invoiceDetail){
		invoiceDetailService.save(invoiceDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetail:update")
	public R update(@RequestBody InvoiceDetailEntity invoiceDetail){
		invoiceDetailService.update(invoiceDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetail:delete")
	public R delete(@RequestBody Integer[] invoiceIds){
		invoiceDetailService.deleteBatch(invoiceIds);
		
		return R.ok();
	}
	
}
