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

import ies.ncu.edu.cn.entity.InvoiceDetailDescEntity;
import ies.ncu.edu.cn.service.InvoiceDetailDescService;
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
@RequestMapping("invoicedetaildesc")
public class InvoiceDetailDescController {
	@Autowired
	private InvoiceDetailDescService invoiceDetailDescService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("invoicedetaildesc:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<InvoiceDetailDescEntity> invoiceDetailDescList = invoiceDetailDescService.queryList(query);
		int total = invoiceDetailDescService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(invoiceDetailDescList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("invoicedetaildesc:info")
	public R info(@PathVariable("id") String id){
		InvoiceDetailDescEntity invoiceDetailDesc = invoiceDetailDescService.queryObject(id);
		
		return R.ok().put("invoiceDetailDesc", invoiceDetailDesc);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("invoicedetaildesc:save")
	public R save(@RequestBody InvoiceDetailDescEntity invoiceDetailDesc){
		invoiceDetailDescService.save(invoiceDetailDesc);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("invoicedetaildesc:update")
	public R update(@RequestBody InvoiceDetailDescEntity invoiceDetailDesc){
		invoiceDetailDescService.update(invoiceDetailDesc);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("invoicedetaildesc:delete")
	public R delete(@RequestBody String[] ids){
		invoiceDetailDescService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
