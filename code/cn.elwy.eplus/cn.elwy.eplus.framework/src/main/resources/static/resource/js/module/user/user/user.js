$(function() {
	var dataGridConfig = initDataGrid();
	var gd = new DataGrid(dataGridConfig);
	addEvent(gd);
});

function initDataGrid() {
	return {
		// 当前页签编号
		tabPageId : 'tabPageId1',

		// 设置数据表格列
		columnModel : [
				{
					header : 'ID',
					name : 'id',
					width : 60
				},
				{
					header : '用户名称',
					name : 'c_USER_NAME',
					width : 100
				},
				{
					header : '用户编码',
					name : 'c_USER_CODE',
					width : 100
				},
				{
					header : '描述',
					name : 'ejzb',
					width : 150
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
		addEvent : addEvent
	};

}

/**
 * 添加事件
 * @returns
 */
function addEvent(_gd) {
	$('#btnAdd').on('click', add);
	$('#btnDelete').on('click', del);
	$('#btnEdit').on('click', edit);
	$('#btnQuery').on('click', query);
	$('#btnCheck').on('click', check);
	$('#btnUncheck').on('click', uncheck);
	$('#btnExport').on('click', _export);
	$('#btnImport').on('click', _import);
	$('#btnFullScreen').on('click', fullScreen);
	$('#btnHelp').on('click', _help);
	$('#subAdd').on('click', subAdd);
	$('#subEdit').on('click', subEdit);
	$('#subCopy').on('click', subCopy);
	$('#subDelete').on('click', subDelete);
	$('#subSave').on('click', subSave);
	$('#subUndo').on('click', subUndo);
	$('#subUp').on('click', subUp);
	$('#subDown').on('click', subDown);
	$('#subClose').on('click', subClose);
}

function add(_gd) {
	//openDialog("添加用户", bundlePath + "/user?operate=create", '800px', '500px');
//	$('#myModal').modal('show');
	$('#signupForm')[0].reset();
	YssLayer.openDialog('添加用户',$('#form_id'));
	$("#operate2").val("save");
	$("#id").val("");
}

function del(_gd) {
	if (!Common.checkSelectMulti('#dataGrid')) {
		return;
	}
	var ids = Common.getSelectIds('#dataGrid');
	$.ajax({
		type : "post",
		url : bundlePath + "/user?operate=del&ids=" + ids,
		data : {},
		dataType : "application/json"
	});
	layer.tips("删除成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

function edit(_gd) {
	
	if (!Common.checkSelectOne('#dataGrid')) {
		return;
	}
	var ids = Common.getSelectIds('#dataGrid');
	YssLayer.openDialog('修改用户',$('#form_id'));
	$("#operate2").val("update");
	$("#id").val(ids);
	var parameter = {};
	parameter.id = $("#id").val();
	parameter.operate = $("#operate2").val();
	$.ajax({
		type : "post", // 访问WebService使用Post方式请求
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		//contentType : "application/json", // WebService 会返回Json类型
		url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {
			"parameter" : JSON.stringify(parameter)
		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
		dataType : 'json',
		success : function(result) { // 回调函数，result，返回值

		}
	});
//	openDialog("修改" + '用户', bundlePath + "/user?operate=edit&ids=" + ids, "800px", "500px");
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

function _export(_gd) {

}

function _import(_gd) {

}

function fullScreen(_gd) {

}

function _help(_gd) {

}

function isreadonly(){
	//$('#signupForm').find('input').not(':hidden').attr('readonly',true);
	var values1 = $('#signupForm').find('input').not(':hidden').attr('readonly',true);
	//var values2 = $('#signupForm').find('input').serializeArray();
	//alert(values1.length);
	//alert(values2.length);
	$('#signupForm').find('select').each(function(){
		if($(this).is(":hidden")){
			
		} else {
			$(this).attr("disabled","disabled");
		}
		
	});
	$('#signupForm').find('.layer-date').each(function(){
		if($(this).is(":hidden")){
			
		} else {
			$(this).attr("disabled","disabled");
		}
	});
}

function unreadonly(){
	$('#signupForm').find('input').attr('readonly',false);
	$('#signupForm').find('select').each(function(){
		if($(this).is(":hidden")){
			
		} else {
			$(this).removeAttr("disabled");
		}
		
	});
	$('#signupForm').find('.layer-date').each(function(){
		if($(this).is(":hidden")){
			
		} else {
			$(this).removeAttr("disabled");
		}
	});
}

function clearForm(){
//	var va = $('#signupForm').serializeArray();
//	alert(va.length);
	$('#signupForm').find('input').not(':hidden').val('');
//	var va = $('#signupForm').find('input').not(':hidden').serializeArray();
//	alert(va.length);
/*	$('#signupForm').find('input').each(function(){
		if($(this).is(":hidden")){
			
		} else {
			$(this).attr('value','');
		}
	});*/
//	var va = $('#signupForm').find('select').not(':hidden').serializeArray();
//	alert(va.length);
	$('#signupForm').find('select').each(function(){
//		alert(11);
//		dd = $(this).is(":hidden");
//		alert(dd);
		if($(this).is(":hidden")){
			
		} else {
//			alert(22);
			$(this).prop('selectedIndex', 0);
		}
	});
}

function subAdd(){
	clearForm();
	//$('#operate2').val('');
	unreadonly();
	$('#id').val('');
	$('#operate2').val('save');
	
}

function subEdit(){
	unreadonly();
	//$('#operate2').val('');
	$('#operate2').val('update');
	$('#c_USER_CODE').attr('disable','disable');
	
}

function subCopy(){
	unreadonly();
	$('#id').val('');
	$('#operate2').val('save');
}

function subDelete(){
	var status = $('#c_DV_STATE').val();
	if(status == 'ENAB'){
		layer.alert("审核通过，不允许删除！", {
			icon : 0,
			title : '警告'
		});
 /*       return false; 
		layer.tips("审核通过，不允许删除", this, {
			tips : [ 1, "#3595CC" ],
			time : 2000
		});*/
		return;
	}
//	var id = $('#id').val();
	$('#operate2').val('del');
	var ids = Common.getSelectIds('#dataGrid');
	var data = Common.getFormData("#signupForm");
	var parameter = {};
	parameter.data = data;
	parameter.operate = data.operate2;
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		url : bundlePath + "/user?operate=del&ids=" + ids,
		data : {
			"parameter" : JSON.stringify(parameter)
		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
		dataType : "application/json",
		success : function(result) { // 回调函数，result，返回值
			retdData = result.data;
			if (result && !result.success) {
				layer.alert("删除用户失败！", {
					icon : 0,
					title : '警告'
				});
	            return false; 
			} else {
				$('#dataGrid').trigger("reloadGrid");
				layer.tips("删除成功！", this, {
					tips : [ 1, "#3595CC" ],
					time : 2000
				});
				subUp();
			}
		}
	});
}

function subSave(){
	var data = Common.getFormData("#signupForm");
	var parameter = {};
	parameter.data = data;
	parameter.operate = data.operate2;
	$.ajax({
		type : "post", // 访问WebService使用Post方式请求
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		//contentType : "application/json", // WebService 会返回Json类型
		url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : {
			"parameter" : JSON.stringify(parameter)
		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
		dataType : 'json',
		success : function(result) { // 回调函数，result，返回值
			retdData = result.data;
			if (result && !result.success) {
				layer.alert("操作失败！", {
					icon : 0,
					title : '警告'
				});
	            return false; 
			} else {
				$('#dataGrid').trigger("reloadGrid");
				layer.tips("操作成功！", this, {
					tips : [ 1, "#3595CC" ],
					time : 2000
				});
				isreadonly();
			}
		}
	});
}

function subUndo(){
	clearForm();
}

function subUp(){
	var currentrowid = $('#dataGrid').jqGrid('getGridParam','selrow');
	if(currentrowid <= 1){
		return false;
	} else {
		currentrowid = currentrowid-1;
	}
	alert(currentrowid);
	$("#dataGrid").setSelection(currentrowid,true);
}

function subDown(){
	var currentrowid = $('#dataGrid').jqGrid('getGridParam','selrow');
	var rowListNum = $('#dataGrid').jqGrid('getGridParam', 'records');  
	if(currentrowid >= rowListNum){
		return false;
	} else {
		currentrowid = currentrowid+1;
	}
	alert(currentrowid);
	$("#dataGrid").setSelection(currentrowid,true);
}

function subClose(){
	var index=parent.layer.getFrameIndex(window.name);
	alert(index);
	parent.layer.close(index);
};

/*function isreadonly(formid){
//	var values,index;
//	values = $(formid).find('input').serializeArray();
//	for (index = 0; index < values.length; ++index){
//		values[index]
//	}
//	$("#signupForm").find('input').each(function(){
//		$(this).readonly=true;
//	});
//	$("#signupForm").find('select').each(function(){
//		$(this).disable=true;
//	});
//	$("#signupForm").find('input:layer-date').each(function(){
//		$(this).disable=true;
//	});
	
//	var values,index,eleType;
//	values = $(formid).serializeArray();
//	alert(values.length);
//	values = $(formid).find('input').serializeArray();
//	alert(values.length);
//	for (index = 0; index < values.length; ++index){
//		eleType = values[index].attr('type');
//		alert(eleType);
//	}
	
	$(formid).find('input').attr('readonly',true); //或者使用 prop('readonly',true)
//	$(formid).find('textarea').not(controlId).attr('readonly',true); 
//	$(formid).find('text').not(controlId).attr('readonly',true); 
	$(formid).find('select').attr('disable',true); 	
	$(formid).find(':date').attr('editable',false); 
	var values,index;
	values = $(formid).find('select').serializeArray();
	for (index = 0; index < values.length; ++index){
		values[index].attr('disable','disable');
	}	
	values = $(formid).find(':date').serializeArray();
	for (index = 0; index < values.length; ++index){
		values[index].attr('disable','disable');
	}
//	$(controlId).Attr('disable',false);
//	$(controlId).Attr('editable',true);
//	$(controlId).Attr('readonly',false);
}

function unreadonly(formid){
	$(formid).find('input').attr('readonly',false);
	$(formid).find('select').attr('disable',false); 

	$(formid).find('input:date').attr('editable',true); 
}

function canWrite(formid){
	$(formid).find('input').not(controlId).attr('readonly',false); //或者使用 prop('readonly',true)
	$(formid).find('textarea').not(controlId).attr('readonly',false); 
	$(formid).find('text').not(controlId).attr('readonly',false); 
	$(formid).find('date').not(controlId).attr('editable',true); 
	$(formid).find('select').not(controlId).attr('disable',false); 
}
*/