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

import ies.ncu.edu.cn.entity.TagDayCostStatEntity;
import ies.ncu.edu.cn.service.TagDayCostStatService;
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
@RequestMapping("tagdaycoststat")
public class TagDayCostStatController {
	@Autowired
	private TagDayCostStatService tagDayCostStatService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("tagdaycoststat:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TagDayCostStatEntity> tagDayCostStatList = tagDayCostStatService.queryList(query);
		int total = tagDayCostStatService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tagDayCostStatList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{statId}")
	@RequiresPermissions("tagdaycoststat:info")
	public R info(@PathVariable("statId") String statId){
		TagDayCostStatEntity tagDayCostStat = tagDayCostStatService.queryObject(statId);
		
		return R.ok().put("tagDayCostStat", tagDayCostStat);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("tagdaycoststat:save")
	public R save(@RequestBody TagDayCostStatEntity tagDayCostStat){
		tagDayCostStatService.save(tagDayCostStat);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("tagdaycoststat:update")
	public R update(@RequestBody TagDayCostStatEntity tagDayCostStat){
		tagDayCostStatService.update(tagDayCostStat);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("tagdaycoststat:delete")
	public R delete(@RequestBody String[] statIds){
		tagDayCostStatService.deleteBatch(statIds);
		
		return R.ok();
	}
	
}
