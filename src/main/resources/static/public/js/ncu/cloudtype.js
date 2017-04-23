$(function () {
    $("#jqGrid").jqGrid({
        url: '../cloudtype/list',
        datatype: "json",
        colModel: [			
			{ label: 'cloudId', name: 'cloudId', index: 'CLOUD_ID', width: 50, key: true },
			{ label: '云提供商名称', name: 'cloudName', index: 'CLOUD_NAME', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'STATUS', width: 80 }, 			
			{ label: '官网链接', name: 'url', index: 'URL', width: 80 }, 			
			{ label: '订单状态', name: 'orders', index: 'ORDERS', width: 80 }, 			
			{ label: '描述', name: 'description', index: 'DESCRIPTION', width: 80 }, 			
			{ label: '数据状态：0-删除 1-正常', name: 'dataState', index: 'DATA_STATE', width: 80 }			
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
		cloudType: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.cloudType = {};
		},
		update: function (event) {
			var cloudId = getSelectedRow();
			if(cloudId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(cloudId)
		},
		saveOrUpdate: function (event) {
			var url = vm.cloudType.cloudId == null ? "../cloudtype/save" : "../cloudtype/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.cloudType),
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
			var cloudIds = getSelectedRows();
			if(cloudIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../cloudtype/delete",
				    data: JSON.stringify(cloudIds),
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
		getInfo: function(cloudId){
			$.get("../cloudtype/info/"+cloudId, function(r){
                vm.cloudType = r.cloudType;
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