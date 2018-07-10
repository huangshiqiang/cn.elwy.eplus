$(function() {
	var dataGridConfig = initTreeGrid();
	var gd = $('#dataGrid').YssDataGrid(dataGridConfig);
	addEvent();
});

function initTreeGrid() {
	return {
		// 当前页签编号
		tabPageId : 'tabPageId1',
		treeGrid : true,
		checkboxColumn : false,
		repeatitems : true,
		treeGridModel : 'adjacency',// nested
		ExpandColumn : 'id',
		ExpandColClick : true,
		// viewrecords : true,
		rownumbers : false,
		multiselect : false,

		// 设置数据表格列
		colModel : [ {
			header : 'ID',
			checkbox : true,
			hidden : false,
			name : 'id',
			index : 'id',
			width : 60
		}, {
			header : '用户名称',
			name : 'name',
			index : 'name',
			checkbox : true,
			width : 100
		}, {
			header : '用户编码',
			name : 'code',
			index : 'code',
			width : 100
		} ],
		height : '500px',
		addEvent : addEvent
	};

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

function _export(_gd) {

}

function _import(_gd) {

}

function fullScreen(_gd) {

}

function _help(_gd) {

}
