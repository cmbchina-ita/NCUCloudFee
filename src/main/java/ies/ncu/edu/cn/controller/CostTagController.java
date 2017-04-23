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

import ies.ncu.edu.cn.entity.CostTagEntity;
import ies.ncu.edu.cn.service.CostTagService;
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
@RequestMapping("costtag")
public class CostTagController {
	@Autowired
	private CostTagService costTagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("costtag:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CostTagEntity> costTagList = costTagService.queryList(query);
		int total = costTagService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(costTagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{tagId}")
	@RequiresPermissions("costtag:info")
	public R info(@PathVariable("tagId") String tagId){
		CostTagEntity costTag = costTagService.queryObject(tagId);
		
		return R.ok().put("costTag", costTag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("costtag:save")
	public R save(@RequestBody CostTagEntity costTag){
		costTagService.save(costTag);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("costtag:update")
	public R update(@RequestBody CostTagEntity costTag){
		costTagService.update(costTag);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("costtag:delete")
	public R delete(@RequestBody String[] tagIds){
		costTagService.deleteBatch(tagIds);
		
		return R.ok();
	}
	
}
