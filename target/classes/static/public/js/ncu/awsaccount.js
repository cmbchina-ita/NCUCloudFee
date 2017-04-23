$(function () {
    $("#jqGrid").jqGrid({
        url: '../awsaccount/list',
        datatype: "json",
        colModel: [			
			{ label: 'accountId', name: 'accountId', index: 'ACCOUNT_ID', width: 50, key: true },
			{ label: '', name: 'region', index: 'region', width: 80 }, 			
			{ label: '', name: 'awsUserId', index: 'aws_user_id', width: 80 }, 			
			{ label: '', name: 'accessKeyId', index: 'access_key_id', width: 80 }, 			
			{ label: '', name: 'secretKey', index: 'secret_key', width: 80 }, 			
			{ label: 'Aws bucket_name', name: 'bucketName', index: 'bucket_name', width: 80 }, 			
			{ label: '', name: 'awsArn', index: 'aws_arn', width: 80 }			
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
		awsAccount: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.awsAccount = {};
		},
		update: function (event) {
			var accountId = getSelectedRow();
			if(accountId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(accountId)
		},
		saveOrUpdate: function (event) {
			var url = vm.awsAccount.accountId == null ? "../awsaccount/save" : "../awsaccount/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.awsAccount),
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
			var accountIds = getSelectedRows();
			if(accountIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../awsaccount/delete",
				    data: JSON.stringify(accountIds),
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
		getInfo: function(accountId){
			$.get("../awsaccount/info/"+accountId, function(r){
                vm.awsAccount = r.awsAccount;
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