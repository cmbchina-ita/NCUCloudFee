$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetailreserved/list',
        datatype: "json",
        colModel: [			
			{ label: 'reservedDescId', name: 'reservedDescId', index: 'reserved_desc_id', width: 50, key: true },
			{ label: '主账户ID', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '账单月份', name: 'invoiceMonth', index: 'invoice_month', width: 80 }, 			
			{ label: '', name: 'reservedInstanceId', index: 'reserved_instance_id', width: 80 }, 			
			{ label: '产品类型', name: 'productType', index: 'product_type', width: 80 }, 			
			{ label: '所属区域', name: 'instanceRegion', index: 'instance_region', width: 80 }, 			
			{ label: '可用区', name: 'availabilityZone', index: 'availability_zone', width: 80 }, 			
			{ label: '实例类型', name: 'instanceType', index: 'instance_type', width: 80 }, 			
			{ label: '平台类型', name: 'plantformType', index: 'plantform_type', width: 80 }, 			
			{ label: '开始时间', name: 'startTime', index: 'start_time', width: 80 }, 			
			{ label: '预留年份', name: 'durationYear', index: 'duration_year', width: 80 }, 			
			{ label: '优惠价格', name: 'offeringPrice', index: 'offering_price', width: 80 }, 			
			{ label: '续价', name: 'rechargePrice', index: 'recharge_price', width: 80 }, 			
			{ label: '优惠类型', name: 'offeringType', index: 'offering_type', width: 80 }, 			
			{ label: '', name: 'instanceCount', index: 'instance_count', width: 80 }, 			
			{ label: '结束时间', name: 'endTime', index: 'end_time', width: 80 }, 			
			{ label: '多区标志', name: 'isMutizone', index: 'is_mutizone', width: 80 }			
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
		invoiceDetailReserved: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetailReserved = {};
		},
		update: function (event) {
			var reservedDescId = getSelectedRow();
			if(reservedDescId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(reservedDescId)
		},
		saveOrUpdate: function (event) {
			var url = vm.invoiceDetailReserved.reservedDescId == null ? "../invoicedetailreserved/save" : "../invoicedetailreserved/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetailReserved),
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
			var reservedDescIds = getSelectedRows();
			if(reservedDescIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../invoicedetailreserved/delete",
				    data: JSON.stringify(reservedDescIds),
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
		getInfo: function(reservedDescId){
			$.get("../invoicedetailreserved/info/"+reservedDescId, function(r){
                vm.invoiceDetailReserved = r.invoiceDetailReserved;
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