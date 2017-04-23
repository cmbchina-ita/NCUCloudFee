$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetailadjustresult/list',
        datatype: "json",
        colModel: [			
			{ label: 'adjustId', name: 'adjustId', index: 'adjust_id', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '账户ID', name: 'accountId', index: 'account_id', width: 80 }, 			
			{ label: '账单存储桶S3的Bucket名称', name: 'bucketName', index: 'bucket_name', width: 80 }, 			
			{ label: '当月开始时间', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '账单月份', name: 'invoiceMonth', index: 'invoice_month', width: 80 }, 			
			{ label: '', name: 'adjustResult', index: 'adjust_result', width: 80 }, 			
			{ label: '', name: 'adjustTime', index: 'adjust_time', width: 80 }, 			
			{ label: '', name: 'adjustTitle', index: 'adjust_title', width: 80 }, 			
			{ label: '', name: 'billTime', index: 'bill_time', width: 80 }, 			
			{ label: '调账维度', name: 'tagName', index: 'tag_name', width: 80 }			
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
		invoiceDetailAdjustResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetailAdjustResult = {};
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
			var url = vm.invoiceDetailAdjustResult.adjustId == null ? "../invoicedetailadjustresult/save" : "../invoicedetailadjustresult/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetailAdjustResult),
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
				    url: "../invoicedetailadjustresult/delete",
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
			$.get("../invoicedetailadjustresult/info/"+adjustId, function(r){
                vm.invoiceDetailAdjustResult = r.invoiceDetailAdjustResult;
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