$(function () {
    $("#jqGrid").jqGrid({
        url: '../servicedef/list',
        datatype: "json",
        colModel: [			
			{ label: 'serviceId', name: 'serviceId', index: 'SERVICE_ID', width: 50, key: true },
			{ label: '云提供商ID', name: 'cloudId', index: 'CLOUD_ID', width: 80 }, 			
			{ label: '服务名称', name: 'serviceName', index: 'SERVICE_NAME', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'STATUS', width: 80 }, 			
			{ label: '定价单链接', name: 'priceIntroUrl', index: 'PRICE_INTRO_URL', width: 80 }, 			
			{ label: '订单额', name: 'orders', index: 'ORDERS', width: 80 }, 			
			{ label: '描述', name: 'description', index: 'DESCRIPTION', width: 80 }, 			
			{ label: '数据状态', name: 'dataState', index: 'DATA_STATE', width: 80 }, 			
			{ label: '服务编码', name: 'serviceCode', index: 'SERVICE_CODE', width: 80 }			
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
		serviceDef: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.serviceDef = {};
		},
		update: function (event) {
			var serviceId = getSelectedRow();
			if(serviceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(serviceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.serviceDef.serviceId == null ? "../servicedef/save" : "../servicedef/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.serviceDef),
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
			var serviceIds = getSelectedRows();
			if(serviceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../servicedef/delete",
				    data: JSON.stringify(serviceIds),
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
		getInfo: function(serviceId){
			$.get("../servicedef/info/"+serviceId, function(r){
                vm.serviceDef = r.serviceDef;
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