$(function() {
	initWidgets();
	resizeHeight();
	// var dataGridConfig = initTreeGrid();
	// var gd = $('#dataGrid2').YssDataGrid(dataGridConfig);

});

function resizeHeight() {
	var _bodyHeight = $('#mainSplitter').height();
	var _titleHeight = $('#mainSplitter .ibox-title').outerHeight();
	$("#mainSplitter .jqGrid_wrapper").height(_bodyHeight - _titleHeight);
}

function initWidgets() {

	$('#mainSplitter').jqxSplitter({
		width : '100%',
		height : '100%',
		panels : [ {
			size : '20%',
			min : '10%'
		}, {
			size : '80%',
			min : '20%'
		} ]
	});
	// $('#rightSplitter').jqxSplitter({
	// height : '100%',
	// orientation : 'horizontal',
	// panels : [ {
	// size : '60%',
	// collapsible : false
	// }, {
	// size : '40%'
	// } ]
	// });
	//
	// // 自动填充
	// var a = $('#leftSplitter').height();
	// var b = $('#searchForm').height();
	// var c = $('#titleSpan').height();
	// $('#table_div').height(a - b - c);

}

function add(_gd) {
	openDialog("添加用户", "user_form.html", '500px', '360px');
}

function del(_gd) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	layer.tips("删除成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

function edit(_gd) {
	if (!Common.checkSelectOne('#dataGrid')) {
		return;
	}
	openDialog("修改" + '用户', "user_form.html", "500px", "360px");
}

function query(_gd) {

}

function check(_gd) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	layer.tips("审核成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

function uncheck(_gd) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	layer.tips("反审核成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
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
		url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
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
			url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
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
		url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
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
