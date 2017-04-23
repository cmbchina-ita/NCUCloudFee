$(function () {
    $("#jqGrid").jqGrid({
        url: '../invoicedetailadjustfilter/list',
        datatype: "json",
        colModel: [			
			{ label: 'adjustId', name: 'adjustId', index: 'adjust_id', width: 50, key: true },
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '账户ID', name: 'accountId', index: 'account_id', width: 80 }, 			
			{ label: 'Bucket桶名', name: 'bucketName', index: 'bucket_name', width: 80 }, 			
			{ label: '主账户ID', name: 'payerAccountId', index: 'payer_account_id', width: 80 }, 			
			{ label: '账单月份', name: 'invoiceMonth', index: 'invoice_month', width: 80 }, 			
			{ label: '调账资源ID', name: 'adjustResourceId', index: 'adjust_resource_id', width: 80 }, 			
			{ label: '调账资源类型', name: 'adjustResourceType', index: 'adjust_resource_type', width: 80 }, 			
			{ label: '调账起始时间', name: 'adjustStartTime', index: 'adjust_start_time', width: 80 }, 			
			{ label: '调账结束时间', name: 'adjustEndTime', index: 'adjust_end_time', width: 80 }, 			
			{ label: '调账标签', name: 'adjustTag', index: 'adjust_tag', width: 80 }, 			
			{ label: '调账预留', name: 'adjustResvered', index: 'adjust_resvered', width: 80 }, 			
			{ label: '', name: 'adjustExchangeId', index: 'adjust_exchange_id', width: 80 }, 			
			{ label: '调账金额', name: 'adjustMoney', index: 'adjust_money', width: 80 }, 			
			{ label: '调账时间', name: 'adjustTime', index: 'adjust_time', width: 80 }			
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
		invoiceDetailAdjustFilter: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.invoiceDetailAdjustFilter = {};
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
			var url = vm.invoiceDetailAdjustFilter.adjustId == null ? "../invoicedetailadjustfilter/save" : "../invoicedetailadjustfilter/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.invoiceDetailAdjustFilter),
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
				    url: "../invoicedetailadjustfilter/delete",
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
			$.get("../invoicedetailadjustfilter/info/"+adjustId, function(r){
                vm.invoiceDetailAdjustFilter = r.invoiceDetailAdjustFilter;
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