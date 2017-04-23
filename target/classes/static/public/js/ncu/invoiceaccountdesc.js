$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoiceaccountdesc/list',
        datatype: "json",
        colModel: [			
			{ label: 'invoiceAccountId', name: 'invoiceAccountId', index: 'invoice_account_id', width: 50, key: true },
			{ label: 'AWS账户ID', name: 'awsAccountId', index: 'aws_account_id', width: 80 }, 			
			{ label: 'AWS账户名称', name: 'awsAccountName', index: 'aws_account_name', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '总花费', name: 'totalCost', index: 'total_cost', width: 80 }, 			
			{ label: '付费主账户ID', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '出账月份', name: 'month', index: 'month', width: 80 }, 			
			{ label: '支持费用', name: 'supportCost', index: 'support_cost', width: 80 }			
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
		invoiceAccountDesc: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceAccountDesc = {};
		},
		update: function (event) {
			var invoiceAccountId = getSelectedRow();
			if(invoiceAccountId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(invoiceAccountId)
		},
		saveOrUpdate: function (event) {
			var url = vm.invoiceAccountDesc.invoiceAccountId == null ? "../invoiceaccountdesc/save" : "../invoiceaccountdesc/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceAccountDesc),
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
			var invoiceAccountIds = getSelectedRows();
			if(invoiceAccountIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../invoiceaccountdesc/delete",
				    data: JSON.stringify(invoiceAccountIds),
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
		getInfo: function(invoiceAccountId){
			$.get("../invoiceaccountdesc/info/"+invoiceAccountId, function(r){
                vm.invoiceAccountDesc = r.invoiceAccountDesc;
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