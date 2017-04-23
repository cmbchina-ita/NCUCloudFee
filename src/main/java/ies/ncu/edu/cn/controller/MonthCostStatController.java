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

import ies.ncu.edu.cn.entity.MonthCostStatEntity;
import ies.ncu.edu.cn.service.MonthCostStatService;
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
 * @date 2017-04-23 14:08:20
 */
@RestController
@RequestMapping("monthcoststat")
public class MonthCostStatController {
	@Autowired
	private MonthCostStatService monthCostStatService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("monthcoststat:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MonthCostStatEntity> monthCostStatList = monthCostStatService.queryList(query);
		int total = monthCostStatService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(monthCostStatList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{statId}")
	@RequiresPermissions("monthcoststat:info")
	public R info(@PathVariable("statId") String statId){
		MonthCostStatEntity monthCostStat = monthCostStatService.queryObject(statId);
		
		return R.ok().put("monthCostStat", monthCostStat);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("monthcoststat:save")
	public R save(@RequestBody MonthCostStatEntity monthCostStat){
		monthCostStatService.save(monthCostStat);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("monthcoststat:update")
	public R update(@RequestBody MonthCostStatEntity monthCostStat){
		monthCostStatService.update(monthCostStat);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("monthcoststat:delete")
	public R delete(@RequestBody String[] statIds){
		monthCostStatService.deleteBatch(statIds);
		
		return R.ok();
	}
	
}
