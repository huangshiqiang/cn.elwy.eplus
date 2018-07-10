$(document).ready(function() {
	$.jgrid.defaults.styleUI = "Bootstrap";
	var mydata = [ {
		id : "1",
		invdate : "2010-05-24",
		name : "test",
		note : "note",
		tax : "10.00",
		total : "2111.00"
	}, {
		id : "2",
		invdate : "2010-05-25",
		name : "test2",
		note : "note2",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "3",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "4",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "5",
		invdate : "2007-10-05",
		name : "test2",
		note : "note2",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "6",
		invdate : "2007-09-06",
		name : "test3",
		note : "note3",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "7",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "8",
		invdate : "2007-10-03",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "21.00",
		total : "320.00"
	}, {
		id : "9",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "11",
		invdate : "2007-10-01",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "12",
		invdate : "2007-10-02",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "13",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "14",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "15",
		invdate : "2007-10-05",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "16",
		invdate : "2007-09-06",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "17",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "18",
		invdate : "2007-10-03",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "19",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "21",
		invdate : "2007-10-01",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "22",
		invdate : "2007-10-02",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "23",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "24",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "25",
		invdate : "2007-10-05",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "26",
		invdate : "2007-09-06",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "27",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "28",
		invdate : "2007-10-03",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "29",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	} ];
	$("#table_appl_list").jqGrid({
		url : ctx + '/user/list.json',
		datatype : "json",
		height : 'auto',
		// height : 500,
		// autoheight : true,
		autowidth : true,
		// shrinkToFit : true,
		pager : "#pager_appl_list",
		viewrecords : true,
		// caption : "<div id='tabTopId111'>11</div>",
		add : true,
		edit : true,
		addtext : "add",
		edittext : "Edit",
		hidegrid : false,

		// //////
		altRows : true,
		// toppager: true,
		multiselect : true,
		// multikey: "ctrlKey",
		// multiboxonly : true,

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
		prmNames : {
			page : "pageNo", // 表示请求页码的参数名称
			rows : "pageSize", // 表示请求行数的参数名称
			sort : "sidx", // 表示用于排序的列名的参数名称
			order : "sord", // 表示采用的排序方式的参数名称
			search : "_search", // 表示是否是搜索请求的参数名称
			nd : "nd", // 表示已经发送请求的次数的参数名称
			id : "id", // 表示当在编辑数据模块中发送数据时，使用的id的名称
			oper : "oper", // operation参数名称（我暂时还没用到）
			editoper : "edit", // 当在edit模式中提交数据时，操作的名称
			addoper : "add", // 当在add模式中提交数据时，操作的名称
			deloper : "delete", // 当在delete模式中提交数据时，操作的名称
			subgridid : "id", // 当点击以载入数据到子表时，传递的数据名称
			npage : null,
			totalrows : "totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
		},
		rowNum : 10,
		rowList : [ 10, 20, 30, 50, 100, 500, 1000 ],
		colNames : [ " ", "名称", "编码", "类型", "真实名称", "生日", "昵称" ],
		colModel : [ {
			name : 'myac',
			index : '',
			width : 80,
			fixed : true,
			sortable : false,
			resize : false,
			formatter : 'actions',
			formatoptions : {
				keys : true
			// delbutton: false,//disable delete button
			// delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
			// editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
			}
		}, {
			name : "name",
			index : "name",
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
		} ]
	});
	// $("#table_appl_list").setSelection(4, true);
	$("#table_appl_list").jqGrid("navGrid", "#pager_appl_list", {
		add : true,
		addicon : 'fa fa-plus-circle purple',
		edit : true,
		editicon : 'fa fa-pencil blue',
		del : true,
		delicon : 'fa fa-trash-o red',
		search : true,
		searchicon : 'fa fa-search orange',
		refresh : true,
		refreshicon : 'fa fa-refresh green',
		view : true,
		viewicon : 'fa fa-search-plus grey',
		alerttext : "请选择需要操作的数据行!"
	// }, {
	// // height : 200,
	// reloadAfterSubmit : true
	});
	// $(window).bind("resize", function() {
	// var width = $(".jqGrid_wrapper").width();
	// $("#table_list_1").setGridWidth(width);
	// $("#table_appl_list").setGridWidth(width)
	// })
});

var grid_data = [ {
	id : "1",
	name : "Desktop Computer",
	note : "note",
	stock : "Yes",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "2",
	name : "Laptop",
	note : "Long text ",
	stock : "Yes",
	ship : "InTime",
	sdate : "2007-12-03"
}, {
	id : "3",
	name : "LCD Monitor",
	note : "note3",
	stock : "Yes",
	ship : "TNT",
	sdate : "2007-12-03"
}, {
	id : "4",
	name : "Speakers",
	note : "note",
	stock : "No",
	ship : "ARAMEX",
	sdate : "2007-12-03"
}, {
	id : "5",
	name : "Laser Printer",
	note : "note2",
	stock : "Yes",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "6",
	name : "Play Station",
	note : "note3",
	stock : "No",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "7",
	name : "Mobile Telephone",
	note : "note",
	stock : "Yes",
	ship : "ARAMEX",
	sdate : "2007-12-03"
}, {
	id : "8",
	name : "Server",
	note : "note2",
	stock : "Yes",
	ship : "TNT",
	sdate : "2007-12-03"
}, {
	id : "9",
	name : "Matrix Printer",
	note : "note3",
	stock : "No",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "10",
	name : "Desktop Computer",
	note : "note",
	stock : "Yes",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "11",
	name : "Laptop",
	note : "Long text ",
	stock : "Yes",
	ship : "InTime",
	sdate : "2007-12-03"
}, {
	id : "12",
	name : "LCD Monitor",
	note : "note3",
	stock : "Yes",
	ship : "TNT",
	sdate : "2007-12-03"
}, {
	id : "13",
	name : "Speakers",
	note : "note",
	stock : "No",
	ship : "ARAMEX",
	sdate : "2007-12-03"
}, {
	id : "14",
	name : "Laser Printer",
	note : "note2",
	stock : "Yes",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "15",
	name : "Play Station",
	note : "note3",
	stock : "No",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "16",
	name : "Mobile Telephone",
	note : "note",
	stock : "Yes",
	ship : "ARAMEX",
	sdate : "2007-12-03"
}, {
	id : "17",
	name : "Server",
	note : "note2",
	stock : "Yes",
	ship : "TNT",
	sdate : "2007-12-03"
}, {
	id : "18",
	name : "Matrix Printer",
	note : "note3",
	stock : "No",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "19",
	name : "Matrix Printer",
	note : "note3",
	stock : "No",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "20",
	name : "Desktop Computer",
	note : "note",
	stock : "Yes",
	ship : "FedEx",
	sdate : "2007-12-03"
}, {
	id : "21",
	name : "Laptop",
	note : "Long text ",
	stock : "Yes",
	ship : "InTime",
	sdate : "2007-12-03"
}, {
	id : "22",
	name : "LCD Monitor",
	note : "note3",
	stock : "Yes",
	ship : "TNT",
	sdate : "2007-12-03"
}, {
	id : "23",
	name : "Speakers",
	note : "note",
	stock : "No",
	ship : "ARAMEX",
	sdate : "2007-12-03"
} ];

// jQuery(function($) {
// var grid_selector = "#table_appl_list";
// var pager_selector = "#pager_appl_list";
//
// var parent_column = $(grid_selector).closest('[class*="col-"]');
// // resize to fit page size
// $(window).on('resize.jqGrid', function() {
// $(grid_selector).jqGrid('setGridWidth', parent_column.width());
// })
//
// // resize on sidebar collapse/expand
// $(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
// if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
// // setTimeout is for webkit only to give time for DOM changes and then redraw!!!
// setTimeout(function() {
// $(grid_selector).jqGrid('setGridWidth', parent_column.width());
// }, 20);
// }
// })
//
// // if your grid is inside another element, for example a tab pane, you should use its parent's width:
// /**
// * $(window).on('resize.jqGrid', function () { var parent_width = $(grid_selector).closest('.tab-pane').width();
// * $(grid_selector).jqGrid( 'setGridWidth', parent_width ); }) //and also set width when tab pane becomes visible
// * $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) { if($(e.target).attr('href') == '#mygrid') { var
// * parent_width = $(grid_selector).closest('.tab-pane').width(); $(grid_selector).jqGrid( 'setGridWidth', parent_width
// ); } })
// */
//
// jQuery(grid_selector).jqGrid({
// // direction: "rtl",
//
// // subgrid options
// subGrid : true,
// // subGridModel: [{ name : ['No','Item Name','Qty'], width : [55,200,80] }],
// // datatype: "xml",
// subGridOptions : {
// plusicon : "fa fa-plus center bigger-110 blue",
// minusicon : "fa fa-minus center bigger-110 blue",
// openicon : "fa fa-chevron-right center orange"
// },
// // for this example we are using local data
// subGridRowExpanded : function(subgridDivId, rowId) {
// var subgridTableId = subgridDivId + "_t";
// $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table>");
// $("#" + subgridTableId).jqGrid({
// datatype : 'local',
// data : subgrid_data,
// colNames : [ 'No', 'Item Name', 'Qty' ],
// colModel : [ {
// name : 'id',
// width : 50
// }, {
// name : 'name',
// width : 150
// }, {
// name : 'qty',
// width : 50
// } ]
// });
// },
//
// data : grid_data,
// datatype : "local",
// height : 250,
// colNames : [ ' ', 'ID', 'Last Sales', 'Name', 'Stock', 'Ship via', 'Notes' ],
// colModel : [ {
// name : 'myac',
// index : '',
// width : 80,
// fixed : true,
// sortable : false,
// resize : false,
// formatter : 'actions',
// formatoptions : {
// keys : true,
// // delbutton: false,//disable delete button
//
// delOptions : {
// recreateForm : true,
// beforeShowForm : beforeDeleteCallback
// },
// // editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
// }
// }, {
// name : 'id',
// index : 'id',
// width : 60,
// sorttype : "int",
// editable : true
// }, {
// name : 'sdate',
// index : 'sdate',
// width : 90,
// editable : true,
// sorttype : "date",
// unformat : pickDate
// }, {
// name : 'name',
// index : 'name',
// width : 150,
// editable : true,
// editoptions : {
// size : "20",
// maxlength : "30"
// }
// }, {
// name : 'stock',
// index : 'stock',
// width : 70,
// editable : true,
// edittype : "checkbox",
// editoptions : {
// value : "Yes:No"
// },
// unformat : aceSwitch
// }, {
// name : 'ship',
// index : 'ship',
// width : 90,
// editable : true,
// edittype : "select",
// editoptions : {
// value : "FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX"
// }
// }, {
// name : 'note',
// index : 'note',
// width : 150,
// sortable : false,
// editable : true,
// edittype : "textarea",
// editoptions : {
// rows : "2",
// cols : "10"
// }
// } ],
//
// viewrecords : true,
// rowNum : 10,
// rowList : [ 10, 20, 30 ],
// pager : pager_selector,
// altRows : true,
// // toppager: true,
//
// multiselect : true,
// // multikey: "ctrlKey",
// multiboxonly : true,
//
// loadComplete : function() {
// var table = this;
// setTimeout(function() {
// styleCheckbox(table);
//
// updateActionIcons(table);
// updatePagerIcons(table);
// enableTooltips(table);
// }, 0);
// },
//
// editurl : "/dummy.html",// nothing is saved
// caption : "Appl"
//
// // ,autowidth: true,
//
// /**
// * , grouping:true, groupingView : { groupField : ['name'], groupDataSorted : true, plusicon : 'fa fa-chevron-down
// * bigger-110', minusicon : 'fa fa-chevron-up bigger-110' }, caption: "Grouping"
// */
//
// });
// $(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
//
// // enable search/filter toolbar
// // jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
// // jQuery(grid_selector).filterToolbar({});
//
// // switch element when editing inline
// function aceSwitch(cellvalue, options, cell) {
// setTimeout(function() {
// $(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
// }, 0);
// }
// // enable datepicker
// function pickDate(cellvalue, options, cell) {
// setTimeout(function() {
// $(cell).find('input[type=text]').datepicker({
// format : 'yyyy-mm-dd',
// autoclose : true
// });
// }, 0);
// }
//
// // navButtons
// jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
// edit : true,
// editicon : 'fa fa-pencil blue',
// add : true,
// addicon : 'fa fa-plus-circle purple',
// del : true,
// delicon : 'fa fa-trash-o red',
// search : true,
// searchicon : 'fa fa-search orange',
// refresh : true,
// refreshicon : 'fa fa-refresh green',
// view : true,
// viewicon : 'fa fa-search-plus grey',
// }, {
// // edit record form
// // closeAfterEdit: true,
// // width: 700,
// recreateForm : true,
// beforeShowForm : function(e) {
// var form = $(e[0]);
// form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
// style_edit_form(form);
// }
// }, {
// // new record form
// // width: 700,
// closeAfterAdd : true,
// recreateForm : true,
// viewPagerButtons : false,
// beforeShowForm : function(e) {
// var form = $(e[0]);
// form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
// style_edit_form(form);
// }
// }, {
// // delete record form
// recreateForm : true,
// beforeShowForm : function(e) {
// var form = $(e[0]);
// if (form.data('styled'))
// return false;
//
// form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
// style_delete_form(form);
//
// form.data('styled', true);
// },
// onClick : function(e) {
// // alert(1);
// }
// }, {
// // search form
// recreateForm : true,
// afterShowSearch : function(e) {
// var form = $(e[0]);
// form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
// style_search_form(form);
// },
// afterRedraw : function() {
// style_search_filters($(this));
// },
// multipleSearch : true,
// /**
// * multipleGroup:true, showQuery: true
// */
// }, {
// // view record form
// recreateForm : true,
// beforeShowForm : function(e) {
// var form = $(e[0]);
// form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
// }
// })
//
// function style_edit_form(form) {
// // enable datepicker on "sdate" field and switches for "stock" field
// form.find('input[name=sdate]').datepicker({
// format : 'yyyy-mm-dd',
// autoclose : true
// })
//
// form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
// // don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
// // .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
//
// // update buttons classes
// var buttons = form.next().find('.EditButton .fm-button');
// buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
// buttons.eq(0).addClass('btn-primary').prepend('<i class="fa fa-check"></i>');
// buttons.eq(1).prepend('<i class="fa fa-times"></i>')
//
// buttons = form.next().find('.navButton a');
// buttons.find('.ui-icon').hide();
// buttons.eq(0).append('<i class="fa fa-chevron-left"></i>');
// buttons.eq(1).append('<i class="fa fa-chevron-right"></i>');
// }
//
// function style_delete_form(form) {
// var buttons = form.next().find('.EditButton .fm-button');
// buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
// buttons.eq(0).addClass('btn-danger').prepend('<i class="fa fa-trash-o"></i>');
// buttons.eq(1).addClass('btn-default').prepend('<i class="fa fa-times"></i>')
// }
//
// function style_search_filters(form) {
// form.find('.delete-rule').val('X');
// form.find('.add-rule').addClass('btn btn-xs btn-primary');
// form.find('.add-group').addClass('btn btn-xs btn-success');
// form.find('.delete-group').addClass('btn btn-xs btn-danger');
// }
// function style_search_form(form) {
// var dialog = form.closest('.ui-jqdialog');
// var buttons = dialog.find('.EditTable')
// buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class',
// 'fa fa-retweet');
// buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class',
// 'fa fa-comment-o');
// buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class',
// 'fa fa-search');
// }
//
// function beforeDeleteCallback(e) {
// var form = $(e[0]);
// if (form.data('styled'))
// return false;
//
// form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
// style_delete_form(form);
//
// form.data('styled', true);
// }
//
// function beforeEditCallback(e) {
// var form = $(e[0]);
// form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
// style_edit_form(form);
// }
//
// // it causes some flicker when reloading or navigating grid
// // it may be possible to have some custom formatter to do this as the grid is being created to prevent this
// // or go back to default browser checkbox styles for the grid
// function styleCheckbox(table) {
// /**
// * $(table).find('input:checkbox').addClass('ace') .wrap('<label />') .after('<span class="lbl align-top" />')
// * $('.ui-jqgrid-labels th[id*="_cb"]:first-child') .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label
// * />').after('<span class="lbl align-top" />');
// */
// }
//
// // unlike navButtons icons, action icons in rows seem to be hard-coded
// // you can change them like this in here if you want
// function updateActionIcons(table) {
// /**
// * var replacement = { 'ui-fa fa-pencil' : 'fa fa-pencil blue', 'ui-fa fa-trash-o' : 'fa fa-trash-o red',
// * 'ui-icon-disk' : 'fa fa-check green', 'ui-icon-cancel' : 'fa fa-times red' }; $(table).find('.ui-pg-div
// * span.ui-icon').each(function(){ var icon = $(this); var $class = $.trim(icon.attr('class').replace('ui-icon',
// * '')); if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]); })
// */
// }
//
// // replace icons with FontAwesome icons like above
// function updatePagerIcons(table) {
// var replacement = {
// 'ui-icon-seek-first' : 'fa fa-angle-double-left bigger-140',
// 'ui-icon-seek-prev' : 'fa fa-angle-left bigger-140',
// 'ui-icon-seek-next' : 'fa fa-angle-right bigger-140',
// 'ui-icon-seek-end' : 'fa fa-angle-double-right bigger-140'
// };
// $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
// var icon = $(this);
// var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
//
// if ($class in replacement)
// icon.attr('class', 'ui-icon ' + replacement[$class]);
// })
// }
//
// function enableTooltips(table) {
// $('.navtable .ui-pg-button').tooltip({
// container : 'body'
// });
// $(table).find('.ui-pg-div').tooltip({
// container : 'body'
// });
// }
//
// // var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
//
// $(document).one('ajaxloadstart.page', function(e) {
// $.jgrid.gridDestroy(grid_selector);
// $('.ui-jqdialog').remove();
// });
// });

function add() {
	$("#inputForm");
	layer.open({
		type : 1,
		title : '应用信息',
		skin : 'layui-layer-rim', // 加上边框
		area : [ '550px', '360px' ],
		// shade : 0,
		// maxmin : true,
		// anim: 2,
		content : $("#inputForm"),
		btn : [ '确定', '关闭' ],
		yes : function() {
			$(that).click(); // 此处只是为了演示，实际使用可以剔除
		},
		btn2 : function() {
			layer.closeAll();
		},
		zIndex : layer.zIndex,
		success : function(layero) {
			layer.setTop(layero); // 重点2
		}
	});

	// openDialog("新增" + '用户', "/jeeplus/a/sys/user/form", "800px", "625px", "officeContent");
}
$(document).ready(function() {
	$('#contentTable thead tr th input.i-checks').on('ifChecked', function(event) { // ifCreated 事件应该在插件初始化之前绑定
		$('#contentTable tbody tr td input.i-checks').iCheck('check');
	});

	$('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event) { // ifCreated 事件应该在插件初始化之前绑定
		$('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
	});

});

function edit() {

	var size = $("#table_appl_list tbody tr td input.i-checks:checked").size();
	if (size == 0) {
		top.layer.alert('请至少选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}

	if (size > 1) {
		top.layer.alert('只能选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return;
	}
	var id = $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");
	openDialog("修改" + '用户', "/jeeplus/a/sys/user/form?id=" + id, "800px", "680px", "officeContent");
}

$(document).ready(function() {
	$('#contentTable thead tr th input.i-checks').on('ifChecked', function(event) { // ifCreated 事件应该在插件初始化之前绑定
		$('#contentTable tbody tr td input.i-checks').iCheck('check');
	});

	$('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event) { // ifCreated 事件应该在插件初始化之前绑定
		$('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
	});

});

function deleteAll() {

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
	$("#btnImport").click(function() {
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

});

$(document).ready(function() {

	$("#btnExport").click(function() {
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
	jQuery("#table_appl_list").jqGrid('searchGrid', {
		sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
	});
});

// $(function() {
// pageInit();
// });
function pageInit() {
	jQuery("#list9").jqGrid({
		url : ctx + '/JSONData?nd=' + new Date().getTime(),
		datatype : "json",
		colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax', 'Total', 'Notes' ],
		colModel : [ {
			name : 'id',
			index : 'id',
			width : 55
		}, {
			name : 'invdate',
			index : 'invdate',
			width : 90
		}, {
			name : 'name',
			index : 'name',
			width : 100
		}, {
			name : 'amount',
			index : 'amount',
			width : 80,
			align : "right"
		}, {
			name : 'tax',
			index : 'tax',
			width : 80,
			align : "right"
		}, {
			name : 'total',
			index : 'total',
			width : 80,
			align : "right"
		}, {
			name : 'note',
			index : 'note',
			width : 150,
			sortable : false
		} ],
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : '#pager9',
		sortname : 'id',
		recordpos : 'left',
		viewrecords : true,
		sortorder : "desc",
		multiselect : true,
		caption : "Multi Select Example"
	});
	jQuery("#list9").jqGrid('navGrid', '#pager9', {
		add : false,
		del : false,
		edit : false,
		position : 'right'
	});
	jQuery("#m1").click(function() {
		var s;
		s = jQuery("#list9").jqGrid('getGridParam', 'selarrrow');
		alert(s);
	});
	jQuery("#m1s").click(function() {
		jQuery("#list9").jqGrid('setSelection', "13");
	});
}