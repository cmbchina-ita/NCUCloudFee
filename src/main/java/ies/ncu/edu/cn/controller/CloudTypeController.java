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

import ies.ncu.edu.cn.entity.CloudTypeEntity;
import ies.ncu.edu.cn.service.CloudTypeService;
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
@RequestMapping("cloudtype")
public class CloudTypeController {
	@Autowired
	private CloudTypeService cloudTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cloudtype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CloudTypeEntity> cloudTypeList = cloudTypeService.queryList(query);
		int total = cloudTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(cloudTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{cloudId}")
	@RequiresPermissions("cloudtype:info")
	public R info(@PathVariable("cloudId") String cloudId){
		CloudTypeEntity cloudType = cloudTypeService.queryObject(cloudId);
		
		return R.ok().put("cloudType", cloudType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("cloudtype:save")
	public R save(@RequestBody CloudTypeEntity cloudType){
		cloudTypeService.save(cloudType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("cloudtype:update")
	public R update(@RequestBody CloudTypeEntity cloudType){
		cloudTypeService.update(cloudType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("cloudtype:delete")
	public R delete(@RequestBody String[] cloudIds){
		cloudTypeService.deleteBatch(cloudIds);
		
		return R.ok();
	}
	
}
