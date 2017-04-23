$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetail/list',
        datatype: "json",
        colModel: [			
			{ label: 'invoiceId', name: 'invoiceId', index: 'invoice_id', width: 50, key: true },
			{ label: '主账户ID', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '链接账户ID', name: 'linkedAccountId', index: 'linked_account_id', width: 80 }, 			
			{ label: '记录类型', name: 'recordType', index: 'record_type', width: 80 }, 			
			{ label: '出账日期', name: 'invoiceDay', index: 'invoice_day', width: 80 }, 			
			{ label: '订阅ID', name: 'subscriptionId', index: 'subscription_id', width: 80 }, 			
			{ label: '产品名称', name: 'productName', index: 'product_name', width: 80 }, 			
			{ label: '使用类型', name: 'usageType', index: 'usage_type', width: 80 }, 			
			{ label: '操作', name: 'operation', index: 'operation', width: 80 }, 			
			{ label: '预留标志', name: 'reservedInstance', index: 'reserved_instance', width: 80 }, 			
			{ label: '栏目名称', name: 'itemDescription', index: 'item_description', width: 80 }, 			
			{ label: '标签名称', name: 'tagName', index: 'tag_name', width: 80 }, 			
			{ label: '标签值', name: 'tagValue', index: 'tag_value', width: 80 }, 			
			{ label: '税额', name: 'taxAmount', index: 'tax_amount', width: 80 }, 			
			{ label: '总金额', name: 'totalCost', index: 'total_cost', width: 80 }, 			
			{ label: '资源ID', name: 'resourceId', index: 'resource_id', width: 80 }, 			
			{ label: '使用量', name: 'usageQuantity', index: 'usage_quantity', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '可用区', name: 'az', index: 'AZ', width: 80 }, 			
			{ label: '平台', name: 'platform', index: 'platform', width: 80 }, 			
			{ label: '预留实例ID', name: 'riId', index: 'ri_id', width: 80 }			
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
		invoiceDetail: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetail = {};
		},
		update: function (event) {
			var invoiceId = getSelectedRow();
			if(invoiceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(invoiceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.invoiceDetail.invoiceId == null ? "../invoicedetail/save" : "../invoicedetail/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetail),
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
			var invoiceIds = getSelectedRows();
			if(invoiceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../invoicedetail/delete",
				    data: JSON.stringify(invoiceIds),
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
		getInfo: function(invoiceId){
			$.get("../invoicedetail/info/"+invoiceId, function(r){
                vm.invoiceDetail = r.invoiceDetail;
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