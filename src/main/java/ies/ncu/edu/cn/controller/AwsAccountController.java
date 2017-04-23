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

import ies.ncu.edu.cn.entity.AwsAccountEntity;
import ies.ncu.edu.cn.service.AwsAccountService;
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
@RequestMapping("awsaccount")
public class AwsAccountController {
	@Autowired
	private AwsAccountService awsAccountService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("awsaccount:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AwsAccountEntity> awsAccountList = awsAccountService.queryList(query);
		int total = awsAccountService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(awsAccountList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{accountId}")
	@RequiresPermissions("awsaccount:info")
	public R info(@PathVariable("accountId") String accountId){
		AwsAccountEntity awsAccount = awsAccountService.queryObject(accountId);
		
		return R.ok().put("awsAccount", awsAccount);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("awsaccount:save")
	public R save(@RequestBody AwsAccountEntity awsAccount){
		awsAccountService.save(awsAccount);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("awsaccount:update")
	public R update(@RequestBody AwsAccountEntity awsAccount){
		awsAccountService.update(awsAccount);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("awsaccount:delete")
	public R delete(@RequestBody String[] accountIds){
		awsAccountService.deleteBatch(accountIds);
		
		return R.ok();
	}
	
}
