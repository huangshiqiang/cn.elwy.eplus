$(document).ready(function() {
	$.jgrid.defaults.styleUI = "Bootstrap";
	jQuery("#table_grid_list").jqGrid({
		url : ctx + '/grid/list.json',
		datatype : "json",
		colNames : [ " ", "表名", "描述", "类名", "主表", "表类型", "同步数据库" ],
		colModel : [ {
			name : 'myac',
			index : '',
			width : 80,
			fixed : true,
			sortable : false,
			resize : false,
			formatter : 'actions',
			frozen : true,
			formatoptions : {
				keys : true
			// delbutton: false,//disable delete button
			// delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
			// editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
			}
		}, {
			name : "className",
			index : "className",
			frozen : true,
			editable : true,
			width : 90
		}, {
			name : "code",
			index : "code",
			editable : true,
			width : 100
		}, {
			name : "type",
			index : "type",
			editable : true,
			width : 80,
			align : "right"
		}, {
			name : "realName",
			index : "realName",
			editable : true,
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			name : "birthday",
			index : "birthday",
			editable : true,
			width : 80,
			align : "right"
		}, {
			name : "nickname",
			index : "nickname",
			editable : true,
			width : 100,
			sortable : false
		} ],
		rowNum : 2,
		rowList : [ 2, 20, 30 ],
		pager : '#pager_grid_list',
		jsonReader : {
			root : "datas",
			page : "pageNo",
			total : "totalPage",
			records : "totalRecord",
			repeatitems : true,
			cell : "cell",
			id : "id",
			userdata : "userdata"
		},
		sortname : 'id',
		viewrecords : true,
		sortorder : "desc",
		caption : "Resizable columns",

		multiselect : true,
		rownumbers : true,
		autowidth : true,
		height : "100%",
		rownumWidth : 35, // the width of the row numbers columns
		subGrid : false
	// 是否启用子表格

	});
	jQuery("#table_grid_list").jqGrid('navGrid', "#pager_grid_list", {
		edit : false,
		add : false,
		del : false
	});

	// $("#table_grid_list").setSelection(4, true);
	// $(window).bind("resize", function() {
	// var width = $(".jqGrid_wrapper").width();
	// $("#table_list_1").setGridWidth(width);
	// $("#table_grid_list").setGridWidth(width)
	// })

	// $("#table_grid_list").jqGrid('setFrozenColumns');
});

function newRecord() {
	$("#inputForm");
	layer.open({
		type : 1,
		title : '应用信息',
		// skin : 'layui-layer-rim', // 加上边框
		area : [ '800px', '500px' ],
		// shade : 0,
		maxmin : true,
		// anim: 2,
		content : $("#inputForm"),
		btn : [ '确定', '关闭' ],
	// yes : function() {
	// $(that).click(); // 此处只是为了演示，实际使用可以剔除
	// },
	// btn2 : function() {
	// layer.closeAll();
	// },
	// zIndex : layer.zIndex,
	// success : function(layero) {
	// layer.setTop(layero); // 重点2
	// }
	});
	//	
	// layer.open({
	// type: 2,
	// title: '欢迎页',
	// maxmin: true,
	// area: ['800px', '500px'],
	// content: 'http://layer.layui.com/test/welcome.html',
	// btn : [ '确定', '关闭' ],
	// end: function(){
	// layer.tips('Hi', '#about', {tips: 1})
	// }
	// });

	// openDialog("添加" + '表单', ctx + '/grid/list.json', "800px", "500px", "");
	// openDialog("新增" + '用户', "/jeeplus/a/sys/user/form", "800px", "625px", "officeContent");
}

function editRecord() {
	var ids = $("#table_grid_list").jqGrid('getGridParam', 'selarrrow');
	var size = ids.size();
	if (size != 1) {
		layer.alert('请选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
	var id = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");
	openDialog("修改" + '用户', "/jeeplus/a/sys/user/form?id=" + id, "800px", "680px", "officeContent");
}

function deleteRecord() {

	// var url = $(this).attr('data-url');
	var str = "";
	var ids = "";
	$("#contentTable tbody tr td input.i-checks:checkbox").each(function() {
		if (true == $(this).is(':checked')) {
			str += $(this).attr("id") + ",";
		}
	});
	if (str.substr(str.length - 1) == ',') {
		ids = str.substr(0, str.length - 1);
	}
	if (ids == "") {
		top.layer.alert('请至少选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
	top.layer.confirm('确认要彻底删除数据吗?', {
		icon : 3,
		title : '系统提示'
	}, function(index) {
		window.location = "/jeeplus/a/sys/user/deleteAll?ids=" + ids;
		top.layer.close(index);
	});

}

$(document).ready(function() {
	$("#importButton").click(function() {
		top.layer.open({
			type : 1,
			area : [ 500, 300 ],
			title : "导入数据",
			content : $("#importBox").html(),
			btn : [ '下载模板', '确定', '关闭' ],
			btn1 : function(index, layero) {
				window.location.href = '/jeeplus/a/sys/user/import/template';
			},
			btn2 : function(index, layero) {
				var inputForm = top.$("#importForm");
				var top_iframe = top.getActiveTab().attr("name");// 获取当前active的tab的iframe
				inputForm.attr("target", top_iframe);// 表单提交成功后，从服务器返回的url在当前tab中展示
				top.$("#importForm").submit();
				top.layer.close(index);
			},

			btn3 : function(index) {
				top.layer.close(index);
			}
		});
	});

	$("#exportButton").click(function() {
		top.layer.confirm('确认要导出Excel吗?', {
			icon : 3,
			title : '系统提示'
		}, function(index) {
			// do something
			// 导出之前备份
			var url = $("#searchForm").attr("action");
			var pageNo = $("#pageNo").val();
			var pageSize = $("#pageSize").val();
			// 导出excel
			$("#searchForm").attr("action", "/jeeplus/a/sys/user/export");
			$("#pageNo").val(-1);
			$("#pageSize").val(-1);
			$("#searchForm").submit();

			// 导出excel之后还原
			$("#searchForm").attr("action", url);
			$("#pageNo").val(pageNo);
			$("#pageSize").val(pageSize);
			top.layer.close(index);
		});
	});

});

$("#searchButton").click(function() {
	$("#table_grid_list").jqGrid('searchGrid', {
		sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
	});
});
