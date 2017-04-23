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

import ies.ncu.edu.cn.entity.AccountEntity;
import ies.ncu.edu.cn.service.AccountService;
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
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("account:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AccountEntity> accountList = accountService.queryList(query);
		int total = accountService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(accountList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{accountId}")
	@RequiresPermissions("account:info")
	public R info(@PathVariable("accountId") String accountId){
		AccountEntity account = accountService.queryObject(accountId);
		
		return R.ok().put("account", account);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("account:save")
	public R save(@RequestBody AccountEntity account){
		accountService.save(account);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("account:update")
	public R update(@RequestBody AccountEntity account){
		accountService.update(account);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("account:delete")
	public R delete(@RequestBody String[] accountIds){
		accountService.deleteBatch(accountIds);
		
		return R.ok();
	}
	
}
