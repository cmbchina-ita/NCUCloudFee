$(function () {
    $("#jqGrid").jqGrid({
        url: '../account/list',
        datatype: "json",
        colModel: [			
			{ label: 'accountId', name: 'accountId', index: 'ACCOUNT_ID', width: 50, key: true },
			{ label: '云提供商ID', name: 'cloudId', index: 'CLOUD_ID', width: 80 }, 			
			{ label: '账户名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '经办ID', name: 'operateUserId', index: 'OPERATE_USER_ID', width: 80 }, 			
			{ label: '状态', name: 'validate', index: 'validate', width: 80 }, 			
			{ label: '付款账户ID', name: 'rootAccountId', index: 'root_account_id', width: 80 }, 			
			{ label: '付款账户名称', name: 'rootAccountName', index: 'root_account_name', width: 80 }, 			
			{ label: '', name: 'cloudType', index: 'cloud_type', width: 80 }, 			
			{ label: '', name: 'isAssumeRole', index: 'is_assume_role', width: 80 }, 			
			{ label: '上月账单大小', name: 'lastMonthInvoiceSize', index: 'last_month_invoice_size', width: 80 }, 			
			{ label: '绑定云账号时间', name: 'createTime', index: 'create_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		account: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.account = {};
		},
		update: function (event) {
			var accountId = getSelectedRow();
			if(accountId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(accountId)
		},
		saveOrUpdate: function (event) {
			var url = vm.account.accountId == null ? "../account/save" : "../account/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.account),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var accountIds = getSelectedRows();
			if(accountIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../account/delete",
				    data: JSON.stringify(accountIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(accountId){
			$.get("../account/info/"+accountId, function(r){
                vm.account = r.account;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});