$(function () {
    $("#jqGrid").jqGrid({
        url: '../downloadinvoicelog/list',
        datatype: "json",
        colModel: [			
			{ label: 'logId', name: 'logId', index: 'LOG_ID', width: 50, key: true },
			{ label: '账户ID', name: 'accountId', index: 'ACCOUNT_ID', width: 80 }, 			
			{ label: '用户ID', name: 'userId', index: 'USER_ID', width: 80 }, 			
			{ label: '请求类型', name: 'requestType', index: 'REQUEST_TYPE', width: 80 }, 			
			{ label: '同步ID', name: 'synId', index: 'syn_id', width: 80 }, 			
			{ label: '同步月份', name: 'syncMonth', index: 'SYNC_MONTH', width: 80 }, 			
			{ label: '请求内容', name: 'requestContent', index: 'REQUEST_CONTENT', width: 80 }, 			
			{ label: '处理标志', name: 'dealFlag', index: 'DEAL_FLAG', width: 80 }, 			
			{ label: '同步时间', name: 'syncTime', index: 'SYNC_TIME', width: 80 }			
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
		downloadInvoiceLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.downloadInvoiceLog = {};
		},
		update: function (event) {
			var logId = getSelectedRow();
			if(logId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(logId)
		},
		saveOrUpdate: function (event) {
			var url = vm.downloadInvoiceLog.logId == null ? "../downloadinvoicelog/save" : "../downloadinvoicelog/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.downloadInvoiceLog),
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
			var logIds = getSelectedRows();
			if(logIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../downloadinvoicelog/delete",
				    data: JSON.stringify(logIds),
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
		getInfo: function(logId){
			$.get("../downloadinvoicelog/info/"+logId, function(r){
                vm.downloadInvoiceLog = r.downloadInvoiceLog;
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