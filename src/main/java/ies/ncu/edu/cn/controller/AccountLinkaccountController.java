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

import ies.ncu.edu.cn.entity.AccountLinkaccountEntity;
import ies.ncu.edu.cn.service.AccountLinkaccountService;
/**
import ies.ncu.edu.cn.utils.PageUtils;
import ies.ncu.edu.cn.utils.Query;
import ies.ncu.edu.cn.utils.R;
*/
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 云账户与关联账户的关系
 * 
 * @author luoyijie
 * @email 1871487704@qq.com
 * @date 2017-04-23 14:08:08
 */
@RestController
@RequestMapping("accountlinkaccount")
public class AccountLinkaccountController {
	@Autowired
	private AccountLinkaccountService accountLinkaccountService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("accountlinkaccount:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AccountLinkaccountEntity> accountLinkaccountList = accountLinkaccountService.queryList(query);
		int total = accountLinkaccountService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(accountLinkaccountList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{accountLinkId}")
	@RequiresPermissions("accountlinkaccount:info")
	public R info(@PathVariable("accountLinkId") String accountLinkId){
		AccountLinkaccountEntity accountLinkaccount = accountLinkaccountService.queryObject(accountLinkId);
		
		return R.ok().put("accountLinkaccount", accountLinkaccount);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("accountlinkaccount:save")
	public R save(@RequestBody AccountLinkaccountEntity accountLinkaccount){
		accountLinkaccountService.save(accountLinkaccount);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("accountlinkaccount:update")
	public R update(@RequestBody AccountLinkaccountEntity accountLinkaccount){
		accountLinkaccountService.update(accountLinkaccount);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("accountlinkaccount:delete")
	public R delete(@RequestBody String[] accountLinkIds){
		accountLinkaccountService.deleteBatch(accountLinkIds);
		
		return R.ok();
	}
	
}
