// 重置GridWrapper的高度
// id 为最接近table的div的id
$(function() {

	$('button[data-btn-type="add"]').on("click", function() {
		$('.direct-chat').toggleClass('panels-side-open');
		// $('.right-side').addClass('panels-detail-open');
	});
	$('button[data-btn-type="delete"]').on("click", function() {
		$('.right-side1').removeClass('panels-detail-open');
		$('.right-side1').addClass('panels-detail');
	});
	$('.btn-close-side1').on("click", function() {
		$('.right-side1').addClass('panels-detail-open');
	});
});

$(function() {

	var p = window;
	var c = '.panels-body';
	var divs = [ '.panels-header', '.panels-footer', '#searchForm' ];
	var h;
	h = autoHeight(c, p, divs);

	$(".jqGrid_wrapper").height(h);

	// 自动填充
	var dataGridConfig = initDataGrid();
	var gd = $('#dataGrid').YssDataGrid(dataGridConfig);
	addEvent();

});

function autoHeight(id, container, chield) {
	var container_h = $(container).height();
	var height = 0;
	for (i = 0; i < chield.length; i++) {
		height += $(chield[i]).outerHeight();
	}
	var realHeight = container_h - height - 3;
	$(id).outerHeight(realHeight);
	$(window).resize();
	return realHeight;
}

function initDataGrid() {
	return {
		// 当前页签编号
		shrinkToFit : false,
		tabPageId : 'tabPageId1',
		btnSearch : "#btnSearch",
		// 设置数据表格列
		colModel : [
				{
					header : 'ID',
					name : 'id',
					width : 60
				},
				{
					header : '用户名称',
					name : 'userName',
					width : 100
				},
				{
					header : '用户编码',
					name : 'userCode',
					width : 100
				},
				{
					header : '操作',
					name : 'actions',
					width : 80,
					fixed : true,
					sortable : false,
					resizable : false,
					fixed : true,
					formatter : function(val, obj, row, act) {
						var actions = [];
						actions.push('<a href="user_form.html?id=' + row.id
								+ '" class="btnList" title="查看"><i class="fa fa-pencil"></i></a>&nbsp;');
						return actions.join('');
					}
				} ],
		altRows : true,
		altclass : 'someClass',
		onSelectRow : gridOnSelectRow,
		ondblClickRow : gridOndblClickRow,
		toolbar : [ {
			id : "btnAdd",
			eventMethod : btnAdd,
		}, {
			id : "btnEdit",
			eventMethod : btnEdit,
		}, {
			id : "btnDelete",
			eventMethod : btnDelete,
		}, {
			id : "btnCopy",
			eventMethod : btnCopy,
		}, {
			id : "btnCheck",
			eventMethod : btnCheck,
		}, {
			id : "btnUncheck",
			eventMethod : btnUncheck,
		}, {
			id : "btnExport",
			eventMethod : btnExport,
		}, {
			id : "btnImport",
			eventMethod : btnImport,
		} ]
	};

}

function btnAdd(event) {
	status = "add";
	initForm(getEmptyRowData());
	$('#signupForm').find('select').not(":hidden").each(function() {
		$(this).prop('selectedIndex', 0);
	});
	$("#operate2").val("save");
	// 打开窗口
	var index = YssLayer.createDialogWithToolBar(1, "添加用户", $('#form_id'), $('#toolbar').html(), 800, 670);
	unreadonly();
}

function btnEdit(event) {
	status = "edit";
	var dg = event.data.dataGrid;
	if (!Common.checkSelectOne('#dataGrid')) {
		return;
	}
	var id = dg.jqGrid('getGridParam', 'selrow');
	var data = dg.jqGrid('getRowData', id);
	initForm(data);
	$('#operate2').val('update');
	var index = YssLayer.createDialogWithToolBar(1, "修改用户", $('#form_id'), $('#toolbar').html(), 800, 670);
	unreadonly();
	$('#c_USER_CODE').attr('readonly', true);
}

function btnDelete(event) {
	console.info("delete.....");
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	status = "delete";
	var gd = event.data.dataGrid;
	var id = gd.jqGrid('getGridParam', 'selrow');
	var data = gd.jqGrid('getRowData', id);
	var usercode = data.c_USER_CODE;
	if (usercode == "SYS" || usercode == "chf") {
		YssLayer.messageAlter("系统用户，不允许删除！", 2);
		return;
	}

	var status = data.c_DV_STATE;
	if (status != 'ENAB') {
		YssLayer.messageAlter("审核通过，不允许删除！", 2);
		return;
	}

	var index = YssLayer.showConfirm("确定删除吗？", function() {
		$('#operate2').val('del');
		var parameter = {};
		parameter.data = data;
		parameter.operate = $('#operate2').val();
		$.ajax({
			type : "post", // 访问WebService使用Post方式请求
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			url : contextPath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
			data : {
				"parameter" : JSON.stringify(parameter)
			}, // 这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
			dataType : 'json',
			success : function(result) { // 回调函数，result，返回值
			// retdData = result.data;
				if (result && !result.success) {
					YssLayer.messageAlter("删除用户失败！！！", 2);
					return false;
				} else {
					$('#operate2').val('view');
					$('#dataGrid').trigger("reloadGrid");
					isreadonly();
					YssLayer.messageDialogOnRightDown("删除成功！", 2000);
					YssLayer.closeLayer(index);
				}
			}
		});
	});
}

function btnCopy(event) {
	status = "copy";
	console.info("copy.....");
	var gd = event.data.dataGrid;
	var id = gd.jqGrid('getGridParam', 'selrow');
	var data = gd.jqGrid('getRowData', id);
	initForm(data);
	$('#id').val('');
	$('#c_USER_CODE').val('');
	$('#operate2').val('save');
	var index = YssLayer.createDialogWithToolBar(1, "复制用户", $('#form_id'), $('#toolbar').html(), 800, 670);
	unreadonly();
}

function btnCheck(event) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	layer.tips("审核成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

function btnUncheck(event) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	layer.tips("反审核成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

function btnExport(event) {

}

function btnImport(event) {

}

function btnFullScreen(event) {

}

function btnHelp(event) {

}

function gridOnSelectRow(rowid, status, e) {
	console.info(layerIndex);
	if (layerIndex == 0) {
		return false;
	}
	var opera = $('#operate2').val();
	// alert(opera);
	if (opera != "view") {
		var index = YssLayer.showConfirm("换行之后，正在编辑的内容将不会得到保存，确定继续吗？", function() {
			status = "rowChange";
			lastSel = rowid;
			var tableName = e.currentTarget.id;
			var row = $("#" + tableName).jqGrid('getRowData', rowid);
			initForm(row);
			$('#operate2').val('view');
			isreadonly();
			YssLayer.closeLayer(index);
		});
	} else {
		if (rowid && rowid !== lastSel) {
			status = "rowChange";
			lastSel = rowid;
			var tableName = e.currentTarget.id;
			var row = $("#" + tableName).jqGrid('getRowData', rowid);
			// var row = $("#dataGrid").jqGrid('getRowData', rowid);
			initForm(row);
			$('#operate2').val('view');
			isreadonly();
			// $(".layui-layer-edit").attr({"disabled":"disabled"});
			// $(".layui-layer-edit").css("cursor", "default");
			// $(".layui-layer-edit").attr('href', '#');
		}
	}

}

function gridOndblClickRow(rowid, iRow, iCol, e) {
	status = "doubleClick";
	lastSel = rowid;
	var tableName = e.currentTarget.id;
	var row = $("#" + tableName).jqGrid('getRowData', rowid);
	var index = YssLayer.createDialogWithToolBar(1, "查看用户", $('#form_id'), $('#toolbar').html(), 800, 670);
	initForm(row);
	$('#operate2').val('view');
	isreadonly();
	// alert($('#operate2').val());
	// console.log($('#operate2').val());

	// if (rowid && rowid !== lastSel) {
	// status = "doubleClick";
	// lastSel = rowid;
	// var row = $("#dataGrid").jqGrid('getRowData', rowid);
	// initForm(row);
	// isreadonly();
	// $('#operate2').val('view');
	// YssLayer.createDialogWithToolBar(1, "查看用户", $('#form_id'), $('#toolbar').html());
	// // $(".layui-layer-edit").attr({"disabled":"disabled"});
	// // $(".layui-layer-edit").css("cursor", "default");
	// // $(".layui-layer-edit").attr('href', '#');
	// }
}

function initForm(rowData) {
	$("#id").val(rowData.id);
	$("#c_USER_CODE").val(rowData.c_USER_CODE);
	$("#c_USER_NAME").val(rowData.c_USER_NAME);
	$("#c_USER_PWD").val(rowData.c_USER_PWD);
	$("#re_c_USER_PWD").val(rowData.re_c_USER_PWD);
	$("#c_DV_JOB_TITLE").val(rowData.c_DV_JOB_TITLE);
	$("#c_CORP_ORG_CODE").val(rowData.c_CORP_ORG_CODE);
	$("#c_DV_CARD_TYPE").val(rowData.c_DV_CARD_TYPE);
	// $("#c_DV_JOB_TITLE").find("option[text=rowData.c_DV_JOB_TITLE]").attr("selected",true);
	// $("#c_DV_JOB_TITLE").attr("value", rowData.c_DV_JOB_TITLE);
	// $("#c_CORP_ORG_CODE").attr("value", rowData.c_CORP_ORG_CODE);
	// $("#c_DV_CARD_TYPE").attr("value", rowData.c_DV_CARD_TYPE);
	// $("#c_DV_JOB_TITLE").options[rowData.c_DV_JOB_TITLE].selected = true;
	// $("#c_CORP_ORG_CODE").options[rowData.c_CORP_ORG_CODE].selected = true;
	// $("#c_DV_CARD_TYPE").options[rowData.c_DV_CARD_TYPE].selected = true;
	$("#d_BIRTH").val(rowData.d_BIRTH);
	$("#d_ON_JOB").val(rowData.d_ON_JOB);
	$("#c_IP").val(rowData.c_IP);
	$("#c_MAC").val(rowData.c_MAC);
	$("#c_CARD_NO").val(rowData.c_CARD_NO);
	$("#c_OFFIC_TEL").val(rowData.c_OFFIC_TEL);
	$("#c_MO_TEL").val(rowData.c_MO_TEL);
	$("#c_EMAIL").val(rowData.c_EMAIL);
	$("#c_FAX_NO").val(rowData.c_FAX_NO);
	$("#c_OFFIC_ADDR").val(rowData.c_OFFIC_ADDR);
	$("#c_ZIP_CODE").val(rowData.c_ZIP_CODE);
	// $("#operate2").val(rowData.operate2);
	$("#c_PASS_MARK").val(rowData.c_PASS_MARK);
	$("#c_DV_STATE").val(rowData.c_DV_STATE);
	$("#modifier").val(rowData.modifier);
	$("#modifyDate").val(rowData.modifyDate);

}

function getEmptyRowData() {
	return rowData = {
		"id" : "",
		"c_USER_CODE" : "",
		"c_USER_NAME" : "",
		"c_USER_PWD" : "",
		"re_c_USER_PWD" : "",
		// "c_DV_JOB_TITLE":0,
		// "c_CORP_ORG_CODE":0,
		// "c_DV_CARD_TYPE":0,
		"d_BIRTH" : "",
		"d_ON_JOB" : "",
		"c_IP" : "",
		"c_MAC" : "",
		"c_CARD_NO" : "",
		"c_OFFIC_TEL" : "",
		"c_MO_TEL" : "",
		"c_EMAIL" : "",
		"c_FAX_NO" : "",
		"c_OFFIC_ADDR" : "",
		"c_ZIP_CODE" : "",
		"operate2" : "",
		"c_PASS_MARK" : "E",
		"c_DV_STATE" : "ENAB",
		"modifier" : "",
		"modifyDate" : ""
	};

}

/**
 * 添加事件
 * @returns
 */
function addEvent() {
	$('#btnFullScreen').on('click', btnFullScreen);
	$('#btnHelp').on('click', btnHelp);
	// 更多条件菜单点击事件不传播
	$("ul.dropdown-menu").on("click", "[data-stopPropagation]", function(e) {
		e.stopPropagation();
	});
	$('#btnAddRow').on('click', addrow);
}

function isreadonly() {
	// $('#signupForm').find('input').not(':hidden').attr('readonly',true);
	var values1 = $('#signupForm').find('input').not(':hidden').attr('readonly', true);
	// var values2 = $('#signupForm').find('input').serializeArray();
	// alert(values1.length);
	// alert(values2.length);
	$('#signupForm').find('select').each(function() {
		if ($(this).is(":hidden")) {

		} else {
			$(this).attr("disabled", "disabled");
		}

	});
	$('#signupForm').find('.layer-date').each(function() {
		if ($(this).is(":hidden")) {

		} else {
			$(this).attr("disabled", "disabled");
		}
	});

}

function unreadonly() {
	$('#signupForm').find('input').attr('readonly', false);
	$('#signupForm').find('select').each(function() {
		if ($(this).is(":hidden")) {

		} else {
			$(this).removeAttr("disabled");
		}

	});
	$('#signupForm').find('.layer-date').each(function() {
		if ($(this).is(":hidden")) {

		} else {
			$(this).removeAttr("disabled");
		}
	});
}

var lastSel = null;
var status = null;
var layerIndex = 0;// 窗口是否关闭，0关闭，1打开。
// ---- 弹出框测试事件 start---- //
// 重写的保存事件
function layer_save_event(e) {
	console.info("save.....");
	status = "save";
	// YssLayer.messageDialogOnRightDown("保存成功！！！");
	// console.info(i.data.index);

	var data = Common.getFormData("#signupForm");
	var parameter = {};
	parameter.data = data;
	parameter.operate = data.operate2;
	$.ajax({
		type : "post", // 访问WebService使用Post方式请求
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		// contentType : "application/json", // WebService 会返回Json类型
		url : contextPath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {
			"parameter" : JSON.stringify(parameter)
		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
		dataType : 'json',
		success : function(result) { // 回调函数，result，返回值
			retdData = result.data;
			if (result && !result.success) {
				// layer.alert("操作失败！", {
				// icon : 0,
				// title : '警告'
				// });
				YssLayer.messageAlter("保存失败！！！", 2);
				return false;
			} else {
				// $('#id').val(result.id);
				$('#operate2').val('view');
				$('#dataGrid').trigger("reloadGrid");
				isreadonly();
				// layer.tips("操作成功！", this, {
				// tips : [ 1, "#3595CC" ],
				// time : 2000
				// });
				YssLayer.messageDialogOnRightDown("保存成功！！！", 2000);
			}
		}
	});
}
// 重写的编辑事件
function layer_edit_event(e) {
	status = "edit";
	console.info("edit.....");
	var data = Common.getFormData("#signupForm");
	console.info("data.id:" + data.id);
	// $('#operate2').val('');
	$('#operate2').val('update');
	unreadonly();
	$('#c_USER_CODE').attr('readonly', true);
}
// 重写的新增事件
function layer_add_event(e) {
	status = "add";
	console.info("add.....");
	initForm(getEmptyRowData());
	$('#signupForm').find('select').not(":hidden").each(function() {
		$(this).prop('selectedIndex', 0);
	});
	$('#operate2').val('save');
	unreadonly();
}
// 重写的复制事件
function layer_copy_event(e) {
	status = "copy";
	console.info("copy.....");
	$('#id').val('');
	$('#c_USER_CODE').val('');
	$('#operate2').val('save');
	unreadonly();
}
// 重写的删除事件
function layer_delete_event(e) {
	status = "delete";
	console.info("delete.....");
	$('#operate2').val('del');
	var id = $('#dataGrid').jqGrid('getGridParam', 'selrow');
	var data = $('#dataGrid').jqGrid('getRowData', id);

	var usercode = data.c_USER_CODE;
	if (usercode == "SYS" || usercode == "chf") {
		YssLayer.messageAlter("系统用户，不允许删除！", 2);
		return;
	}

	var statuss = data.c_DV_STATE;
	if (statuss == 'ENAB') {
		YssLayer.messageAlter("审核通过，不允许删除！", 2);
		return;
	}

	var index = YssLayer.showConfirm("确定删除吗？", function() {
		var parameter = {};
		parameter.data = data;
		parameter.operate = $('#operate2').val();
		$.ajax({
			type : "post", // 访问WebService使用Post方式请求
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			// contentType : "application/json", // WebService 会返回Json类型
			url : contextPath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
			data : {
				"parameter" : JSON.stringify(parameter)
			}, // 这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
			dataType : 'json',
			success : function(result) { // 回调函数，result，返回值
				if (result && !result.success) {
					// layer.alert("操作失败！", {
					// icon : 0,
					// title : '警告'
					// });
					YssLayer.messageAlter("删除用户失败！！！", 2);
					return false;
				} else {
					// $('#id').val(result.id);
					$('#operate2').val('view');
					$('#dataGrid').trigger("reloadGrid");
					isreadonly();
					// layer.tips("操作成功！", this, {
					// tips : [ 1, "#3595CC" ],
					// time : 2000
					// });
					YssLayer.messageDialogOnRightDown("删除成功！", 2000);
					YssLayer.closeLayer(index);
				}
			}
		});
	});

	/*
	 * $.ajax({ type : "post", contentType : "application/x-www-form-urlencoded; charset=UTF-8", // url : contextPath +
	 * "/user?operate=del&ids=" + ids, url : contextPath + "/user", data : { "parameter" : JSON.stringify(parameter) }, //
	 * 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到 dataType : "application/json", success : function(result) { //
	 * 回调函数，result，返回值 // retdData = result.data; console.info("success?"); if (result && !result.success) { //
	 * layer.alert("删除用户失败！", { // icon : 0, // title : '警告' // }); console.info("success，no");
	 * YssLayer.messageAlter("删除用户失败！", 2); return false; } else { console.info("success，yes"); isreadonly();
	 * $('#operate2').val('view'); $('#dataGrid').trigger("reloadGrid"); // layer.tips("删除成功！", this, { // tips : [ 1,
	 * "#3595CC" ], // time : 2000 // }); YssLayer.messageDialogOnRightDown("删除成功！", 2000); // subUp(); } } });
	 */
}
// 重写的撤销事件
function layer_undo_event(e) {
	status = "undo";
	console.info("undo.....");
	// initForm(getEmptyRowData());
	// $('#signupForm').find('select').not(":hidden").each(function() {
	// $(this).prop('selectedIndex', 0);
	// });
	$('#operate2').val('view');
	isreadonly();
}
// 重写的上移事件
function layer_up_event(e) {
	status = "up";
	console.info("up.....");
	$('#operate2').val('view');
}
// 重写的下移事件
function layer_down_event(e) {
	status = "down";
	console.info("down.....");
	$('#operate2').val('view');
}
// ---- 弹出框测试事件 end---- //

var confirmDel = function() {
	$('#operate2').val('del');
	var parameter = {};
	parameter.data = data;
	parameter.operate = $('#operate2').val();
	$.ajax({
		type : "post", // 访问WebService使用Post方式请求
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		url : contextPath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {
			"parameter" : JSON.stringify(parameter)
		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
		dataType : 'json',
		success : function(result) { // 回调函数，result，返回值
			retdData = result.data;
			if (result && !result.success) {
				YssLayer.messageAlter("删除用户失败！！！", 2);
				return false;
			} else {
				isreadonly();
				$('#operate2').val('view');
				$('#dataGrid').trigger("reloadGrid");
				YssLayer.messageDialogOnRightDown("删除成功！", 2000);
			}
		}
	});
}

// 新增条件行
var addrow = function addrow() {
	var html = '<li style="margin-top: 5px;" data-stopPropagation="true">';
	html += '<div class="input-group input-group-sm gap">';
	html += '<select class="form-control" name="userType" style="width:80px;">';
	html += '<option value="and">并</option>';
	html += '<option value="or">或</option></select>';
	html += '<input type="text" class="form-control" style="width:100px;" id="username" name="username" placeholder="条件1" />';
	html += '<select class="form-control" name="userType" style="width:80px;">';
	html += '<option value="eq">等于</option>';
	html += '<option value="ne">不等</option>';
	html += '<option value="lt">小于</option>';
	html += '<option value="le">小于等于</option>';
	html += '<option value="gt">大于</option>';
	html += '<option value="ge">大于等于</option></select>';
	html += '<input type="text" class="form-control" style="width:100px;" id="userCode" name="userCode" placeholder="条件2" />';
	html += '<a href="#" onclick="delrow(this)"><i class="fa fa-times-circle" style="margin:10px 10px 10px 10px;"></i></a></div></li>';
	$("ul.dropdown-menu").append(html);
}

// 删除条件行
function delrow(obj) {
	var evt = window.event || arguments.callee.caller.arguments[0]; // 获取event对象
	evt.stopPropagation();
	$(obj).closest('li').remove();
}

$(window).bind('resize', function() {
	// 自动填充
	$('#table_div').height($(document.body).height() - $('#header').height());
});