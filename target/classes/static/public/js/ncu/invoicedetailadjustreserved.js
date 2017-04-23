$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetailadjustreserved/list',
        datatype: "json",
        colModel: [			
			{ label: 'adjustId', name: 'adjustId', index: 'adjust_id', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '账户ID', name: 'accountId', index: 'account_id', width: 80 }, 			
			{ label: '账单存储桶S3的Bucket名称', name: 'bucketName', index: 'bucket_name', width: 80 }, 			
			{ label: '当月开始时间', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '账单月份', name: 'invoiceMonth', index: 'invoice_month', width: 80 }, 			
			{ label: '', name: 'adjustReservedInstanceId', index: 'adjust_reserved_instance_id', width: 80 }, 			
			{ label: '', name: 'adjustTag', index: 'adjust_tag', width: 80 }, 			
			{ label: '', name: 'adjustTime', index: 'adjust_time', width: 80 }, 			
			{ label: '', name: 'productType', index: 'product_type', width: 80 }, 			
			{ label: '', name: 'instanceRegion', index: 'instance_region', width: 80 }, 			
			{ label: '', name: 'availabilityZone', index: 'availability_zone', width: 80 }, 			
			{ label: '', name: 'instanceType', index: 'instance_type', width: 80 }, 			
			{ label: '', name: 'plantformType', index: 'plantform_type', width: 80 }, 			
			{ label: '', name: 'startTime', index: 'start_time', width: 80 }, 			
			{ label: '', name: 'durationYear', index: 'duration_year', width: 80 }, 			
			{ label: '', name: 'offeringPrice', index: 'offering_price', width: 80 }, 			
			{ label: '', name: 'rechargePrice', index: 'recharge_price', width: 80 }, 			
			{ label: '', name: 'offeringType', index: 'offering_type', width: 80 }, 			
			{ label: '', name: 'instanceCount', index: 'instance_count', width: 80 }, 			
			{ label: '', name: 'endTime', index: 'end_time', width: 80 }, 			
			{ label: '', name: 'isMutizone', index: 'is_mutizone', width: 80 }			
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
		invoiceDetailAdjustReserved: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetailAdjustReserved = {};
		},
		update: function (event) {
			var adjustId = getSelectedRow();
			if(adjustId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(adjustId)
		},
		saveOrUpdate: function (event) {
			var url = vm.invoiceDetailAdjustReserved.adjustId == null ? "../invoicedetailadjustreserved/save" : "../invoicedetailadjustreserved/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetailAdjustReserved),
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
			var adjustIds = getSelectedRows();
			if(adjustIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../invoicedetailadjustreserved/delete",
				    data: JSON.stringify(adjustIds),
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
		getInfo: function(adjustId){
			$.get("../invoicedetailadjustreserved/info/"+adjustId, function(r){
                vm.invoiceDetailAdjustReserved = r.invoiceDetailAdjustReserved;
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