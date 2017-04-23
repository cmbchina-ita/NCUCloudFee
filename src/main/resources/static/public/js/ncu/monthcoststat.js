$(function () {
    $("#jqGrid").jqGrid({
        url: '../monthcoststat/list',
        datatype: "json",
        colModel: [			
			{ label: 'statId', name: 'statId', index: 'STAT_ID', width: 50, key: true },
			{ label: '付费账户ID', name: 'payAccountId', index: 'PAY_ACCOUNT_ID', width: 80 }, 			
			{ label: '云提供商ID', name: 'cloudId', index: 'CLOUD_ID', width: 80 }, 			
			{ label: '精确到月份', name: 'statMonth', index: 'STAT_MONTH', width: 80 }, 			
			{ label: '本月实际花费', name: 'thisMonthCost', index: 'THIS_MONTH_COST', width: 80 }, 			
			{ label: '本月预计花费', name: 'thisMonthExpectCost', index: 'THIS_MONTH_EXPECT_COST', width: 80 }, 			
			{ label: '上月总花费', name: 'lastMonthCost', index: 'LAST_MONTH_COST', width: 80 }, 			
			{ label: '前三月月均花费', name: 'averageCost3', index: 'AVERAGE_COST_3', width: 80 }, 			
			{ label: '数据状态：0-删除 1-正常', name: 'dataState', index: 'DATA_STATE', width: 80 }, 			
			{ label: '关联账户ID', name: 'linkedAccountId', index: 'LINKED_ACCOUNT_ID', width: 80 }, 			
			{ label: '抵扣花费', name: 'monthDeductedCost', index: 'MONTH_DEDUCTED_COST', width: 80 }			
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
		monthCostStat: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.monthCostStat = {};
		},
		update: function (event) {
			var statId = getSelectedRow();
			if(statId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(statId)
		},
		saveOrUpdate: function (event) {
			var url = vm.monthCostStat.statId == null ? "../monthcoststat/save" : "../monthcoststat/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.monthCostStat),
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
			var statIds = getSelectedRows();
			if(statIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../monthcoststat/delete",
				    data: JSON.stringify(statIds),
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
		getInfo: function(statId){
			$.get("../monthcoststat/info/"+statId, function(r){
                vm.monthCostStat = r.monthCostStat;
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