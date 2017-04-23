$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetailadjustlog/list',
        datatype: "json",
        colModel: [			
			{ label: 'adjustLogId', name: 'adjustLogId', index: 'adjust_log_id', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '账户ID', name: 'accountId', index: 'account_id', width: 80 }, 			
			{ label: '账单存储桶S3的Bucket名称', name: 'bucketName', index: 'bucket_name', width: 80 }, 			
			{ label: '当月开始时间', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '账单月份', name: 'invoiceMonth', index: 'invoice_month', width: 80 }, 			
			{ label: '', name: 'adjustResourceId', index: 'adjust_resource_id', width: 80 }, 			
			{ label: '', name: 'adjustResourceType', index: 'adjust_resource_type', width: 80 }, 			
			{ label: '', name: 'adjustStartTime', index: 'adjust_start_time', width: 80 }, 			
			{ label: '', name: 'adjustEndTime', index: 'adjust_end_time', width: 80 }, 			
			{ label: '', name: 'adjustTag', index: 'adjust_tag', width: 80 }, 			
			{ label: '', name: 'adjustResvered', index: 'adjust_resvered', width: 80 }, 			
			{ label: '', name: 'adjustExchangeId', index: 'adjust_exchange_id', width: 80 }, 			
			{ label: '', name: 'adjustMoney', index: 'adjust_money', width: 80 }, 			
			{ label: '', name: 'adjustTime', index: 'adjust_time', width: 80 }, 			
			{ label: '', name: 'adjustResultId', index: 'adjust_result_id', width: 80 }, 			
			{ label: '', name: 'adjustRemark', index: 'adjust_remark', width: 80 }			
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
		invoiceDetailAdjustLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetailAdjustLog = {};
		},
		update: function (event) {
			var adjustLogId = getSelectedRow();
			if(adjustLogId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(adjustLogId)
		},
		saveOrUpdate: function (event) {
			var url = vm.invoiceDetailAdjustLog.adjustLogId == null ? "../invoicedetailadjustlog/save" : "../invoicedetailadjustlog/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetailAdjustLog),
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
			var adjustLogIds = getSelectedRows();
			if(adjustLogIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../invoicedetailadjustlog/delete",
				    data: JSON.stringify(adjustLogIds),
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
		getInfo: function(adjustLogId){
			$.get("../invoicedetailadjustlog/info/"+adjustLogId, function(r){
                vm.invoiceDetailAdjustLog = r.invoiceDetailAdjustLog;
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