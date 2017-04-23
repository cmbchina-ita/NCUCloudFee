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

import ies.ncu.edu.cn.entity.DownloadInvoiceLogEntity;
import ies.ncu.edu.cn.service.DownloadInvoiceLogService;
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
@RequestMapping("downloadinvoicelog")
public class DownloadInvoiceLogController {
	@Autowired
	private DownloadInvoiceLogService downloadInvoiceLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("downloadinvoicelog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DownloadInvoiceLogEntity> downloadInvoiceLogList = downloadInvoiceLogService.queryList(query);
		int total = downloadInvoiceLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(downloadInvoiceLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{logId}")
	@RequiresPermissions("downloadinvoicelog:info")
	public R info(@PathVariable("logId") String logId){
		DownloadInvoiceLogEntity downloadInvoiceLog = downloadInvoiceLogService.queryObject(logId);
		
		return R.ok().put("downloadInvoiceLog", downloadInvoiceLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("downloadinvoicelog:save")
	public R save(@RequestBody DownloadInvoiceLogEntity downloadInvoiceLog){
		downloadInvoiceLogService.save(downloadInvoiceLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("downloadinvoicelog:update")
	public R update(@RequestBody DownloadInvoiceLogEntity downloadInvoiceLog){
		downloadInvoiceLogService.update(downloadInvoiceLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("downloadinvoicelog:delete")
	public R delete(@RequestBody String[] logIds){
		downloadInvoiceLogService.deleteBatch(logIds);
		
		return R.ok();
	}
	
}
