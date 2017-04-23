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

import ies.ncu.edu.cn.entity.ServiceDefEntity;
import ies.ncu.edu.cn.service.ServiceDefService;
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
@RequestMapping("servicedef")
public class ServiceDefController {
	@Autowired
	private ServiceDefService serviceDefService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("servicedef:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ServiceDefEntity> serviceDefList = serviceDefService.queryList(query);
		int total = serviceDefService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(serviceDefList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{serviceId}")
	@RequiresPermissions("servicedef:info")
	public R info(@PathVariable("serviceId") String serviceId){
		ServiceDefEntity serviceDef = serviceDefService.queryObject(serviceId);
		
		return R.ok().put("serviceDef", serviceDef);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("servicedef:save")
	public R save(@RequestBody ServiceDefEntity serviceDef){
		serviceDefService.save(serviceDef);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("servicedef:update")
	public R update(@RequestBody ServiceDefEntity serviceDef){
		serviceDefService.update(serviceDef);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("servicedef:delete")
	public R delete(@RequestBody String[] serviceIds){
		serviceDefService.deleteBatch(serviceIds);
		
		return R.ok();
	}
	
}
