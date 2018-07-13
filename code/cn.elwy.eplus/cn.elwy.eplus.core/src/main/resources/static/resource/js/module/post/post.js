$(function() {
	initWidgets();
	initEvent();
});

var lastSel;
// 初始化面板UI
function initWidgets() {
	$('#mainSplitter').jqxSplitter({
		width : '100%',
		height : '100%',
		panels : [{ size: '20%',min : 200 },{ size: '100%' }]
	});
	var dataGridConfig = {
		colModel : [ {
			header : '岗位名称',
			name : 'c_POST_NAME',
			index:'c_POST_NAME',
			width : '50%'
		}, {
			header : '岗位代码',
			name : 'c_POST_CODE',
			index:'c_POST_CODE',
			width : '50%'
		} ],
		multiselect : false,
		rownumbers : false,
		loadonce : true,
		onSelectRow : gridOnSelectRow
	}
	$('#dataGrid').YssDataGrid(dataGridConfig);
	// 隐藏列头
	$('#gbox_dataGrid .ui-jqgrid-hdiv').hide();
	$('#dataGrid').closest(".ui-jqgrid-bdiv").css('overflow-x','hidden');
	// 默认选中第一行
	// resize
}

// 表格行选中事件
function gridOnSelectRow(rowid) {
	if (rowid && rowid !== lastSel) {
		lastSel = rowid;
		var row = $("#dataGrid").jqGrid('getRowData', rowid);
		//initForm(row);
		console.info(row);
		$('#post_right_div').html("点击了岗位名称为："+row.c_POST_NAME+"，岗位代码为："+row.c_POST_CODE);
	}
}

function initEvent(){
	$('#btn_search').on('click', function(){
		var key = $('#txt_search').val();
		if (key == "") { // 空白就重置
			var sdata = {};
			sdata['filters'] = ""
			sdata['searchField'] = "";
			sdata['searchOper'] = "";
			sdata['searchString'] = "";
			sdata['sidx'] = "";
			var table = $("#dataGrid").jqGrid('setGridParam',{
				postData:sdata,
            	search: false,
            	resetsearch: true,
        	});
			serachTable(table);
		} else { // 有值就查询
			var sdata = {};
			sdata['filters'] = "{'groupOp':'AND','rules':[{'field':'c_POST_CODE','op':'eq','data':'"+key+"'}]}"
			sdata['searchField'] = "";
			sdata['searchOper'] = "";
			sdata['searchString'] = "";
			sdata['sidx'] = "c_POST_CODE";
			var table = $("#dataGrid").jqGrid('setGridParam',{
            	postData:sdata,
            	search: true
        	});
			serachTable(table);
		}
	});
}

// 搜索表，本地
function serachTable(table){
	mustReload = table.triggerHandler("jqGridFilterSearch");
	if( mustReload === undefined) {
		mustReload = true;
	}
	if (mustReload !== false) {
		table.trigger("reloadGrid");
		$('#dataGrid').closest(".ui-jqgrid-bdiv").css('overflow-x','hidden');
	}
}
