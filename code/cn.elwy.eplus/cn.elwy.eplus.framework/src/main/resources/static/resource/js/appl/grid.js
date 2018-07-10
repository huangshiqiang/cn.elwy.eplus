/**
 * 系统管理--用户管理的单例对象
 */
var GridPage = {
	id : "managerTable",// 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1,
	deptid : 0
};

/**
 * 初始化表格的列
 */
GridPage.initColumn = function() {
	var columns = [ {
		field : 'selectItem',
		radio : true
	}, {
		title : 'id',
		field : 'id',
		visible : false,
		align : 'center',
		valign : 'middle'
	}, {
		title : '账号',
		field : 'account',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '姓名',
		field : 'name',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '性别',
		field : 'sexName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '角色',
		field : 'roleName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '部门',
		field : 'deptName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '邮箱',
		field : 'email',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '电话',
		field : 'phone',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '创建时间',
		field : 'createtime',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '状态',
		field : 'statusName',
		align : 'center',
		valign : 'middle',
		sortable : true
	} ];
	return columns;
};


/**
 * 检查是否选中
 */
GridPage.check = function() {
	var selected = $('#' + this.id).bootstrapTable('getSelections');
	if (selected.length == 0) {
		Feng.info("请先选中表格中的某一记录！");
		return false;
	} else {
		GridPage.seItem = selected[0];
		return true;
	}
};

/**
 * 点击添加管理员
 */
GridPage.openAddMgr = function() {
	var index = layer.open({
		type : 2,
		title : '添加管理员',
		area : [ '800px', '560px' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : Feng.ctxPath + '/mgr/user_add'
	});
	this.layerIndex = index;
};

/**
 * 点击修改按钮时
 * @param userId 管理员id
 */
GridPage.openChangeUser = function() {
	if (this.check()) {
		var index = layer.open({
			type : 2,
			title : '编辑管理员',
			area : [ '800px', '450px' ], // 宽高
			fix : false, // 不固定
			maxmin : true,
			content : Feng.ctxPath + '/mgr/user_edit/' + this.seItem.id
		});
		this.layerIndex = index;
	}
};

/**
 * 点击角色分配
 * @param
 */
GridPage.roleAssign = function() {
	if (this.check()) {
		var index = layer.open({
			type : 2,
			title : '角色分配',
			area : [ '300px', '400px' ], // 宽高
			fix : false, // 不固定
			maxmin : true,
			content : Feng.ctxPath + '/mgr/role_assign/' + this.seItem.id
		});
		this.layerIndex = index;
	}
};

/**
 * 删除用户
 */
GridPage.delGridPage = function() {
	if (this.check()) {

		var operation = function() {
			var userId = GridPage.seItem.id;
			var ajax = new $ax(Feng.ctxPath + "/mgr/delete", function() {
				Feng.success("删除成功!");
				GridPage.table.refresh();
			}, function(data) {
				Feng.error("删除失败!" + data.responseJSON.message + "!");
			});
			ajax.set("userId", userId);
			ajax.start();
		};

		Feng.confirm("是否删除用户" + GridPage.seItem.account + "?", operation);
	}
};

/**
 * 冻结用户账户
 * @param userId
 */
GridPage.freezeAccount = function() {
	if (this.check()) {
		var userId = this.seItem.id;
		var ajax = new $ax(Feng.ctxPath + "/mgr/freeze", function(data) {
			Feng.success("冻结成功!");
			GridPage.table.refresh();
		}, function(data) {
			Feng.error("冻结失败!" + data.responseJSON.message + "!");
		});
		ajax.set("userId", userId);
		ajax.start();
	}
};

/**
 * 解除冻结用户账户
 * @param userId
 */
GridPage.unfreeze = function() {
	if (this.check()) {
		var userId = this.seItem.id;
		var ajax = new $ax(Feng.ctxPath + "/mgr/unfreeze", function(data) {
			Feng.success("解除冻结成功!");
			GridPage.table.refresh();
		}, function(data) {
			Feng.error("解除冻结失败!");
		});
		ajax.set("userId", userId);
		ajax.start();
	}
}

/**
 * 重置密码
 */
GridPage.resetPwd = function() {
	if (this.check()) {
		var userId = this.seItem.id;
		parent.layer.confirm('是否重置密码为111111？', {
			btn : [ '确定', '取消' ],
			shade : false
		// 不显示遮罩
		}, function() {
			var ajax = new $ax(Feng.ctxPath + "/mgr/reset", function(data) {
				Feng.success("重置密码成功!");
			}, function(data) {
				Feng.error("重置密码失败!");
			});
			ajax.set("userId", userId);
			ajax.start();
		});
	}
};

GridPage.resetSearch = function() {
	$("#name").val("");
	$("#beginTime").val("");
	$("#endTime").val("");

	GridPage.search();
}

GridPage.search = function() {
	var queryData = {};

	queryData['deptid'] = GridPage.deptid;
	queryData['name'] = $("#name").val();
	queryData['beginTime'] = $("#beginTime").val();
	queryData['endTime'] = $("#endTime").val();

	GridPage.table.refresh({
		query : queryData
	});
}

GridPage.onClickDept = function(e, treeId, treeNode) {
	GridPage.deptid = treeNode.id;
	GridPage.search();
};

$(function() {
	var defaultColunms = GridPage.initColumn();
	var table = new BSTable("managerTable", "/mgr/list", defaultColunms);
	table.setPaginationType("client");
	GridPage.table = table.init();
	var ztree = new $ZTree("deptTree", "/dept/tree");
	ztree.bindOnClick(GridPage.onClickDept);
	ztree.init();
});

$(document).ready(function() {
	$.jgrid.defaults.styleUI = "Bootstrap";
	gridTable();
	dbObjectTable();
});

function gridTable() {
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
}

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
	layer.confirm('确认要彻底删除数据吗?', {
		icon : 3,
		title : '系统提示'
	}, function(index) {
		window.location = "/jeeplus/a/sys/user/deleteAll?ids=" + ids;
		top.layer.close(index);
	});

}

$(document).ready(function() {
	$("#importButton").click(function() {
		layer.open({
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
		layer.confirm('确认要导出Excel吗?', {
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
$(window).bind("resize", function() {
	var width = $(".jqGrid_wrapper").width();
	$("#table_grid_list").setGridWidth(width);
});

function dbObjectTable() {
	jQuery("#table_dbObject_list").jqGrid({
		url : ctx + '/dbObject/list.json',
		datatype : "json",
		colNames : [ "对象名称", "对象类型", "对象描述" ],
		colModel : [ {
			name : "name",
			index : "name",
			frozen : true,
			editable : false,
			width : 90
		}, {
			name : "type",
			index : "type",
			editable : false,
			width : 80,
			align : "right"
		}, {
			name : "realName",
			index : "realName",
			editable : false,
			width : 80,
			align : "right",
			sorttype : "float"
		} ],
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : '#pager_dbObject_list',
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
		viewrecords : false,
		sortorder : "desc",
		multiselect : false,
		rownumbers : false,
		autowidth : true,
		height : "100%",
		rownumWidth : 20,
		subGrid : false
	// 是否启用子表格
	});
	jQuery("#table_dbObject_list").jqGrid('navGrid', "#pager_dbObject_list", {
		edit : false,
		add : false,
		del : false
	});
}
$("#searchButton1").click(function() {
	$("#table_dbObject_list").jqGrid('searchGrid', {
		sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
	});

});
