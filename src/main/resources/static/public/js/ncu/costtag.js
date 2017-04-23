$(function () {
    $("#jqGrid").jqGrid({
        url: '../costtag/list',
        datatype: "json",
        colModel: [			
			{ label: 'tagId', name: 'tagId', index: 'TAG_ID', width: 50, key: true },
			{ label: '付费账户ID', name: 'payAccountId', index: 'PAY_ACCOUNT_ID', width: 80 }, 			
			{ label: '云提供商ID', name: 'cloudId', index: 'CLOUD_ID', width: 80 }, 			
			{ label: '标签名称', name: 'tagName', index: 'TAG_NAME', width: 80 }, 			
			{ label: '标签值', name: 'tagValue', index: 'TAG_VALUE', width: 80 }, 			
			{ label: '标签顺序', name: 'tagOrder', index: 'TAG_ORDER', width: 80 }, 			
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
		costTag: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.costTag = {};
		},
		update: function (event) {
			var tagId = getSelectedRow();
			if(tagId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(tagId)
		},
		saveOrUpdate: function (event) {
			var url = vm.costTag.tagId == null ? "../costtag/save" : "../costtag/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.costTag),
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
			var tagIds = getSelectedRows();
			if(tagIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../costtag/delete",
				    data: JSON.stringify(tagIds),
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
		getInfo: function(tagId){
			$.get("../costtag/info/"+tagId, function(r){
                vm.costTag = r.costTag;
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