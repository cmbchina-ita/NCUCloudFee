$(function () {
    $("#jqGrid").jqGrid({
        url: '../accountlinkaccount/list',
        datatype: "json",
        colModel: [			
			{ label: 'accountLinkId', name: 'accountLinkId', index: 'account_link_id', width: 50, key: true },
			{ label: '主账户ID', name: 'payAccountId', index: 'pay_account_id', width: 80 }, 			
			{ label: '主账户名称', name: 'payAccountName', index: 'pay_account_name', width: 80 }, 			
			{ label: '关联账户Id', name: 'linkAccountId', index: 'link_account_id', width: 80 }, 			
			{ label: '关联账户名称', name: 'linkAccountName', index: 'link_account_name', width: 80 }, 			
			{ label: '关联账户AK', name: 'linkAccessKey', index: 'link_access_key', width: 80 }, 			
			{ label: '关联账户SK', name: 'linkSecretKey', index: 'link_secret_key', width: 80 }, 			
			{ label: '预留实例状态', name: 'reservedStatus', index: 'reserved_status', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }			
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
		accountLinkaccount: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.accountLinkaccount = {};
		},
		update: function (event) {
			var accountLinkId = getSelectedRow();
			if(accountLinkId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(accountLinkId)
		},
		saveOrUpdate: function (event) {
			var url = vm.accountLinkaccount.accountLinkId == null ? "../accountlinkaccount/save" : "../accountlinkaccount/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.accountLinkaccount),
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
			var accountLinkIds = getSelectedRows();
			if(accountLinkIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../accountlinkaccount/delete",
				    data: JSON.stringify(accountLinkIds),
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
		getInfo: function(accountLinkId){
			$.get("../accountlinkaccount/info/"+accountLinkId, function(r){
                vm.accountLinkaccount = r.accountLinkaccount;
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