function getMydata() {
	return [ {
		id : "1",
		invdate : "2010-05-24",
		c_PORT_NAME : "test",
		note : "note",
		tax : "10.00",
		total : "2111.00"
	}, {
		id : "2",
		invdate : "2010-05-25",
		c_PORT_NAME : "test2",
		note : "note2",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "3",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "4",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "5",
		invdate : "2007-10-05",
		c_PORT_NAME : "test2",
		note : "note2",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "6",
		invdate : "2007-09-06",
		c_PORT_NAME : "test3",
		note : "note3",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "7",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "8",
		invdate : "2007-10-03",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "21.00",
		total : "320.00"
	}, {
		id : "9",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "11",
		invdate : "2007-10-01",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "12",
		invdate : "2007-10-02",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "13",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "14",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "15",
		invdate : "2007-10-05",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "16",
		invdate : "2007-09-06",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "17",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "18",
		invdate : "2007-10-03",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "19",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "21",
		invdate : "2007-10-01",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "22",
		invdate : "2007-10-02",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "23",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "24",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "25",
		invdate : "2007-10-05",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "26",
		invdate : "2007-09-06",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "27",
		invdate : "2007-10-04",
		c_PORT_NAME : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "28",
		invdate : "2007-10-03",
		c_PORT_NAME : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "29",
		invdate : "2007-09-01",
		c_PORT_NAME : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	} ];
}
function initDataGrid() {

	return {
		data : getMydata(),
		datatype : "local",
		shrinkToFit : false,
		colModel : [ {
			header : 'init',
			name : 'id',
			index : 'id',
			width : 60,
			sorttype : "int"
		}, {
			header : '日期',
			name : 'invdate',
			index : 'invdate',
			width : 90,
			sorttype : "date",
			formatter : "date"
		}, {
			header : '产品名称',
			name : 'c_PORT_NAME',
			index : 'c_PORT_NAME',
			width : 100
		}, {
			header : '金额',
			name : 'amount',
			index : 'amount',
			width : 80,
			align : "right",
			sorttype : "float",
			formatter : "number"
		}, {
			header : '运费',
			name : 'tax',
			index : 'tax',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '总额',
			name : 'total',
			index : 'total',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '备注',
			name : 'note',
			index : 'note',
			width : 150,
			sortable : false
		} ]
	}
}
function getPanelSettingGrid() {

	return {
		data : getMydata(),
		datatype : "local",
		shrinkToFit : false,
		colModel : [ {
			header : 'getPanelSettingGrid',
			name : 'id',
			index : 'id',
			width : 60,
			sorttype : "int"
		}, {
			header : '日期1',
			name : 'invdate',
			index : 'invdate',
			width : 90,
			sorttype : "date",
			formatter : "date"
		}, {
			header : '客户1',
			name : 'name',
			index : 'name',
			width : 100
		}, {
			header : '金额',
			name : 'amount',
			index : 'amount',
			width : 80,
			align : "right",
			sorttype : "float",
			formatter : "number"
		}, {
			header : '运费',
			name : 'tax',
			index : 'tax',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '总额',
			name : 'total',
			index : 'total',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '备注',
			name : 'note',
			index : 'note',
			width : 150,
			sortable : false
		} ]
	}
}


function initGridSettingGrid() {
	return {
		// 当前页签编号
		shrinkToFit : false,
		// 设置数据表格列
		colModel : [
				{
					header : 'ID',
					name : 'id',
					width : 60
				},
				{
					header : '列名称',
					name : 'columnName',
					width : 100
				},
				{
					header : '列编码',
					name : 'columnCode',
					width : 100
				},
				{
					header : '是否隐藏',
					name : 'isShow',
					width : 35
				},
				{
					header : '列宽',
					name : 'width',
					width : 150
				},
				{
					header : '列格式',
					name : 'formatter',
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
		altRows : true,
		altclass : 'someClass',
		// onSelectRow : gridOnSelectRow,
		// ondblClickRow : gridOndblClickRow,
		toolbar : [
		// {
		// id : "btnAdd",
		// eventMethod : btnAdd,
		// }, {
		// id : "btnEdit",
		// eventMethod : btnEdit,
		// }, {
		// id : "btnDelete",
		// eventMethod : btnDelete,
		// }, {
		// id : "btnCopy",
		// eventMethod : btnCopy,
		// }, {
		// id : "btnCheck",
		// eventMethod : btnCheck,
		// }, {
		// id : "btnUncheck",
		// eventMethod : btnUncheck,
		// }, {
		// id : "btnExport",
		// eventMethod : btnExport,
		// }, {
		// id : "btnImport",
		// eventMethod : btnImport,
		//
		// }
		]
	};

}

function getGridConfig() {

	return {
		data : getMydata(),
		datatype : "local",
		shrinkToFit : false,
		height: '400px',
		colModel : [ {
			header : 'getGridConfig',
			name : 'id',
			index : 'id',
			width : 60,
			sorttype : "int"
		}, {
			header : '日期',
			name : 'invdate',
			index : 'invdate',
			width : 90,
			sorttype : "date",
			formatter : "date"
		}, {
			header : '客户',
			name : 'name',
			index : 'name',
			width : 100
		}, {
			header : '金额',
			name : 'amount',
			index : 'amount',
			width : 80,
			align : "right",
			sorttype : "float",
			formatter : "number"
		}, {
			header : '运费',
			name : 'tax',
			index : 'tax',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '总额',
			name : 'total',
			index : 'total',
			width : 80,
			align : "right",
			sorttype : "float"
		}, {
			header : '备注',
			name : 'note',
			index : 'note',
			width : 150,
			sortable : false
		} ]
	}
}



var tablePanels = [];

$(function() {
	var t1 = new TablePanel("stock", initDataGrid(), "", null);
	var t2 = new TablePanel("bond", getGridConfig(), "", null);
	var t3 = new TablePanel("tablePanel", getPanelSettingGrid(), "", null)
	tablePanels.push(t1);
	tablePanels.push(t2);
	tablePanels.push(t3);
	
	Common.getContext().defaultTablePanel = 'stock';
	Common.resizeGridWrapper("tab-stock");
	initTablePanel(tablePanels);
	initTabEvent();
});

