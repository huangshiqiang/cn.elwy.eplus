function initTablePanel(tablePanels) {
	if (tablePanels != null) {
		var _defaultTablePanel = Common.getContext().defaultTablePanel;
		for ( var i in tablePanels) {
			var tp = tablePanels[i];
			var _id = tp.id;
			var gridConfig = tp.gridConfig;
			if (tp.colModel != null) {
				gridConfig.setColModel(tp.colModel);
			}
			if (gridConfig.onSelectRow == null) {
				gridConfig.onSelectRow = listener.gridOnSelectRow;
			}
			if (gridConfig.ondblClickRow == null) {
				gridConfig.ondblClickRow = listener.gridOndblClickRow;
			}
			var grid = $('#' + _id + 'Grid').YssDataGrid(gridConfig);

			tp.grid = grid;

			Common.getContext().tablePanels[_id] = tp;
			if (_defaultTablePanel == _id) {
				Common.getContext().currentPanel = tp;
			}
		}
		if (Common.getContext().currentPanel == null) {
			Common.getContext().currentPanel = tablePanels[0];
		}
	}

	if (SideToolbar != null) {
		for ( var i in SideToolbar) {
			var _button = SideToolbar[i];
			var _method = function(btn) {
				return function(event) {
					return btn.method(event, btn.names);
				}
			};
			for ( var j in _button.names) {
				$(_button.names[j]).on('click', _method(_button));
				// $(_button.names[j]).on('click', sideToolbarListener);
			}
			for ( var k in _button.hotkeys) {
				$(document).bind(_button.hotkeys[k], _method(_button));
			}
		}
	}
}

function initTabEvent() {
	$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
		Common.resizeGridWrapper($(e.target).attr('href'));
		$(window).resize();
	});
	$("#right-side input,select,textarea").change(function() {
		isModified = true;
	})
}

/**
 * 设置数据到表单控件
 * @param rowData
 * @param _form
 * @returns
 */
function initForm(rowData, _form) {
	$.each(rowData, function(name, value) {
		_form.find(' [name="' + name + '"]').val(value);
		var selectPicker = $("select[name='" + name + "']");
		if (selectPicker.length > 0) {
			selectPicker.selectpicker('refresh');
		}
	});
	isModified = false;
}

/**
 * 获取空数据
 * @param _form
 * @returns
 */
function getEmptyRowData(_form) {
	var rowData = {};
	/*-
	var _currentPanel = Common.getContext().currentPanel;
	var colModel = _currentPanel.gridConfig.colModel;
	$.each(colModel, function(index, item) {
		var name = item.name;
		rowData[name] = getDefaultValue(name);
	});
	 */
	return rowData;
}

// 重新计算页面高度
function resizeRightSideContent() {
	var h = $('#right-side').height() - $('.side-message-bar').height() - $('.nav-tabs').height();
	$('#right-side .tab-content').height(h);
	$('#right-side .tab-content').css('overflow', 'auto');
}

/**
 * 设置表单只读
 * @param _form
 * @param readonly
 * @returns
 */
function setReadonly(_form, readonly) {
	_form.find('input, textarea').not(':hidden').attr('readonly', readonly);
	var _checkbox = _form.find('checkbox').not(':hidden');
	var _select = _form.find('.layer-date, select').not(':hidden');
	if (readonly) {
		_checkbox.attr("disabled", "disabled");
		_select.attr("disabled", "disabled");
	} else {
		_checkbox.removeAttr("disabled");
		_select.removeAttr("disabled");
	}
}

var isModified = false; // 页面是否已经被编辑

/**
 * 显示详细数据
 * @param _context
 * @returns
 */
function showDetail(_context, data) {
	var _currentPanel = _context.currentPanel;
	if (_currentPanel == null) {
		return;
	}
	var _form = $("#" + _currentPanel.name + "Form");

	var row = data;
	if (data == null) {
		row = _currentPanel.grid.jqGrid('getRowData', _currentPanel.lastRow);
	}
	if (_context.isOpenState()) {
		if (editType[_context.currentState]) {
			if (isModified) {
				var index = YssLayer.showConfirm("切换状态正在编辑的内容将丢失，确定继续吗？", function() {
					_context.currentState = _context.operate;
					initForm(row, _form);
					_form.find('#id').val(_currentPanel.lastRow);
					setReadonly(_form, _context.operate == "query");
					YssLayer.closeLayer(index);
				});
				return;
			}
		}
	}
	_context.currentState = _context.operate;
	initForm(row, _form);
	_form.find('#id').val(_currentPanel.lastRow);
	setReadonly(_form, _context.operate == "query");
}

// 装载提示信息
var loadMSG = function(title, detail) {
	clearMSG();
	$('#msg').html(title);
	if (arguments.length > 1) {
		$('#detail').html(detail);
		$('#detailBtn').on('click', open);
		$('#detailBtn').css("cursor", "pointer");
		$('#detailBtn').html("详细信息...");
	}
}

// 清空提示信息
var clearMSG = function() {
	if (!$('#detail').hasClass("hide")) {
		$('#detail').addClass("hide");
	}
	$('#msg').html("");
	$('#detail').html("");
	$('#detailBtn').off('click');
	$('#detailBtn').html("");
}

// 打开右下角详细信息
function open() {
	if ($('#detail').hasClass("hide")) {
		$('#detail').removeClass("hide");
		var h = $('#right-side').height() / 2;
		if ($('#detail').height() > h) {
			$('#detail').height(h - $('#detail').prev().height());
			$('#detail').width($('#detail').prev().width());
			$('#detail').css("overflow-y", "auto");
		}
	} else {
		$('#detail').addClass("hide");
	}
}

/**
 * 右侧边显示隐藏功能
 */
var sideSwitch = function(isOpenState) {
	var _context = Common.getContext();
	if (_context.openState == isOpenState) {
		return;
	}
	_context.openState = isOpenState;
	if (isOpenState) {
		var _currentPanel = _context.currentPanel;
		if (_currentPanel == null) {
			return;
		}

		$('#tab-form form').hide();
		var _form = $("#" + _currentPanel.name + "Form");
		_form.show();

		$('#right-side').removeClass('sidebar-open');
		$('.suspend dt').removeClass('sidebar-open');
	} else {
		$('#right-side').addClass('sidebar-open');
		$('.suspend dt').addClass('sidebar-open');
	}
};

/**
 * 获取当前表格面板
 */
var getCurrentPanel = function(event) {
	var tablePanelId = $(event.currentTarget).attr("tablePanelId");
	var _context = Common.getContext();
	if (tablePanelId != null) {
		_context.currentPanel = _context.tablePanels[tablePanelId];
	}
	return _context.currentPanel;
};

var editType = {
	add : true,
	save : true,
	update : true,
	edit : true,
	copy : true
};

var listener = {

	/**
	 * 单击表格事件
	 * @param rowid
	 * @param status
	 * @param e
	 * @returns
	 */
	gridOnSelectRow : function(rowid, status, e) {
		var _context = Common.getContext();
		_context.operate = "query";

		var _currentPanel = _context.currentPanel;
		var gridId = e.currentTarget.id;
		try {
			var tablePanelId = gridId.substring(0, gridId.indexOf("Grid"));
			if (tablePanelId != null) {
				_currentPanel = _context.tablePanels[tablePanelId];
			}
			if (_currentPanel != null) {
				_context.currentPanel = _currentPanel;
			}
		} catch (e) {
			console.warn(gridId + "表格名称不正确，必须以Grid结尾");
		}

		_currentPanel.lastRow = rowid;
		if (!_context.isOpenState()) {
			return false;
		}
		showDetail(_context);
		resizeRightSideContent();
		clearMSG();
	},

	/**
	 * 双击表格事件
	 * @param rowid
	 * @param iRow
	 * @param iCol
	 * @param e
	 * @returns
	 */
	gridOndblClickRow : function(rowid, iRow, iCol, e) {
		var _context = Common.getContext();
		_context.operate = "query";

		var _currentPanel = _context.currentPanel;
		_currentPanel.lastRow = rowid;

		if (!_context.isOpenState()) {
			sideSwitch(true);
		}
		showDetail(_context);
		resizeRightSideContent();
		clearMSG();
	},
	query : function(_context, event, data) {
		var _currentPanel = _context.currentPanel;
		if (_currentPanel == null) {
			return;
		}

		_currentPanel.grid.reload();
		return false;
	},
	add : function(_context, event, data) {
		var _currentPanel = getCurrentPanel(event);
		if (_currentPanel == null) {
			return;
		}

		var _form = $("#" + _currentPanel.name + "Form");
		var data = getEmptyRowData(_form);
		clearMSG();
		showDetail(_context, data);
		sideSwitch(true);
		setReadonly(_form, false);
		resizeRightSideContent();
		return false;
	},
	edit : function(_context, event, data) {
		var _currentPanel = getCurrentPanel(event);
		if (_currentPanel == null) {
			return;
		}

		if (!Common.checkSelectOne("#" + _currentPanel.id + "Grid")) {
			return;
		}
		var _form = $("#" + _currentPanel.name + "Form");
		clearMSG();
		showDetail(_context);
		sideSwitch(true);
		setReadonly(_form, false);
		resizeRightSideContent();
		return false;
	},
	copy : function(_context, event, data) {
		var _currentPanel = getCurrentPanel(event);
		if (_currentPanel == null) {
			return;
		}

		if (!Common.checkSelectOne("#" + _currentPanel.id + "Grid")) {
			return;
		}
		var rowData = _currentPanel.grid.jqGrid('getRowData', _currentPanel.lastRow);

		var _form = $("#" + _currentPanel.name + "Form");
		clearMSG();
		showDetail(_context, rowData);
		sideSwitch(true);
		setReadonly(_form, false);
		resizeRightSideContent();
		return false;
	},
	save : function(_context, event, data) {
		if (_context.isOpenState()) {
			var _currentPanel = _context.currentPanel;
			if (_currentPanel == null) {
				return;
			}

			var _url = _currentPanel.gridConfig.url;
			var row = _currentPanel.grid.jqGrid('getRowData', _currentPanel.lastRow);
			var _form = $("#" + _currentPanel.name + "Form");

			if ("function" == typeof validateForm) {
				if (!validateForm(_form)) {
					return;
				}
			}
			var data = Common.getFormData("#" + _currentPanel.name + "Form").formData;

			var data = Common.getFormData("#" + _currentPanel.name + "Form");
			var formData = data.formData;
			var dataExtend = data.formExtend;
			var parameter = {};
			parameter.form = formData;
			parameter.formExtend = dataExtend;
			parameter.id = _form.find('#id').val();
			parameter.operate = _context.operate;
			$.ajax({
				type : "post", // 访问WebService使用Post方式请求
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				// contentType : "application/json", // WebService 会返回Json类型
				url : _url, // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
				data : {
					"parameter" : JSON.stringify(parameter)
				}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
				dataType : 'json',
				success : function(result) { // 回调函数，result，返回值
					if (result && !result.success) {
						loadMSG(result.message, result.detailMessage);
						return false;
					} else {
						$('#id').val(result.id);
						setReadonly(_form, true);
						_currentPanel.grid.reload();
						isModified = false;
						loadMSG(result.message);
					}
				},
				complete : function(XMLHttpRequest, status) {
					if (status == 'timeout') {
						loadMSG("获取数据超时，请稍后重试");
					} else if (status == 'error') {
						loadMSG("访问出错，请检查服务器状态");
					}
				}
			});
		}
		return false;

	},
	_delete : function(_context, event, data) {
		var _currentPanel = _context.currentPanel;
		var grid = _currentPanel.grid;
		if (!Common.checkSelectMulti(grid)) {
			return;
		}
		var ids = grid.getSelectRows();
		var rowDatas = [];
		var len = ids.length;
		for (var i = 0; i < len; i++) {
			var singleData = grid.getRowDataById(ids[i]);
			var checkStatus = singleData.n_STATE;
			if (checkStatus != "0") {
				YssLayer.messageAlter("包含审核通过数据，请重新选择！", 2);
				return false;
			}
			rowDatas.push(singleData);
		}
		var index = YssLayer.showConfirm("确定删除吗？", function() {
			var parameter = {};
			parameter.datas = rowDatas;
			parameter.ids = ids;
			parameter.operate = _context.operate;
			parameter.formCode = funcCode;
			$.ajax({
				type : "post", // 访问WebService使用Post方式请求
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				url : _currentPanel.gridConfig.url, // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
				data : {
					"parameter" : JSON.stringify(parameter)
				}, // 这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到
				dataType : 'json',
				success : function(result) { // 回调函数，result，返回值
					if (result && !result.success) {
						YssLayer.messageAlter("删除失败！！！", 2);
						return false;
					} else {
						grid.reload();// .trigger("reloadGrid");
						YssLayer.messageDialogOnRightDown("删除成功！", 2000);
						YssLayer.closeLayer(index);
					}
				}
			});
		});

		return false;
	},
	check : function(_context, event, data) {

		if (typeof checkBtn == 'function') {
			checkBtn();
		}
		console.log("check button");
		return false;
	},
	uncheck : function(_context, event, data) {

		if (typeof uncheckBtn == 'function') {
			uncheckBtn();
		}
		console.log("uncheck button");
		return false;
	},
	_sync : function(_context, event, data) {
		if (typeof _sync == 'function') {
			_sync();
		}
		return false;
	},
	_export : function(_context, event, data) {

		if (typeof exportBtn == 'function') {
			exportBtn();
		}
		console.log("export button");
		return false;
	},
	_import : function(_context, event, data) {

		if (typeof importBtn == 'function') {
			importBtn();
		}
		console.log("import button");
		return false;
	},
	print : function(_context, event, data) {

		if (typeof printBtn == 'function') {
			printBtn();
		}
		console.log("print button");
		return false;
	},
	up : function(_context, event, data) {
		if (Common.getContext().isOpenState()) {
			console.log("up button");
		}
		return false;
	},
	down : function(_context, event, data) {
		if (Common.getContext().isOpenState()) {
			console.log("down button");
		}
		return false;
	},
	undo : function(_context, event, data) {
		if (Common.getContext().isOpenState()) {
			console.log("undo button");
		}
		return false;
	},
	help : function(_context, event, data) {
		console.log("help button");
		return false;
	},
}

var SideToolbar = [ {
	names : [ '.btn-search' ],
	hotkeys : [ 'keydown.Ctrl_q' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "query";

		return listener.query(_context, event, data);
	}
}, {
	names : [ '.btn-add' ],
	hotkeys : [ 'keydown.Ctrl_a' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "save";

		return listener.add(_context, event, data);
	}
}, {
	names : [ '.btn-edit' ],
	hotkeys : [ 'keydown.Ctrl_m' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "update";

		return listener.edit(_context, event, data);
	}
}, {
	names : [ '.btn-copy' ],
	hotkeys : [ 'keydown.Ctrl_c' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "save";

		return listener.copy(_context, event, data);
	}
}, {
	names : [ '.btn-save' ],
	hotkeys : [ 'keydown.Ctrl_s' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.currentState = "query";

		return listener.save(_context, event, data);
	}
}, {
	names : [ '.btn-delete' ],
	hotkeys : [ 'keydown.Ctrl_d' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "del";

		return listener._delete(_context, event, data);
	}
}, {
	names : [ '.btn-check' ],
	// hotkeys : [ 'keydown.Ctrl_c' ],
	hotkeys : [],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "check";

		return listener.check(_context, event, data);
	}
}, {
	names : [ '.btn-uncheck' ],
	// hotkeys : [ 'keydown.Ctrl_Alt_c' ],
	hotkeys : [],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "uncheck";

		return listener.uncheck(_context, event, data);
	}
}, {
	names : [ '.btn-sync' ],
	hotkeys : [],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "sync";

		return listener._sync(_context, event, data);
	}
}, {
	names : [ '.btn-export' ],
	hotkeys : [ 'keydown.Ctrl_e' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "export";

		return listener._export(_context, event, data);
	}
}, {
	names : [ '.btn-import' ],
	hotkeys : [ 'keydown.Ctrl_i' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "import";

		return listener._import(_context, event, data);
	}
}, {
	names : [ 'undo-btn' ],
	hotkeys : [ 'keydown.Ctrl_z' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "undo";

		return listener.undo(_context, event, data);
	}
}, {
	names : [ '.btn-up' ],
	hotkeys : [ 'keydown.Ctrl_up' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "up";

		return listener.up(_context, event, data);
	}
}, {
	names : [ '.btn-down' ],
	hotkeys : [ 'keydown.Ctrl_down' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "up";

		return listener.up(_context, event, data);
	}
}, {
	names : [ '.btn-print' ],
	hotkeys : [ 'keydown.Ctrl_p' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "print";

		return listener.print(_context, event, data);
	}
}, {
	names : [ '.btn-help' ],
	hotkeys : [ 'keydown.Ctrl_h' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "up";

		return listener.help(_context, event, data);
	}
}, {
	names : [ '.tab-manage-list' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "query";

		var tablePanelId = $(event.currentTarget).attr('tablePanelId');
		if (tablePanelId == null) {
			tablePanelId = $(event.currentTarget).attr('name');
		}
		var _tablePanel = _context.tablePanels[tablePanelId];
		var _result = true;
		if (_context.currentPanel != _tablePanel) {
			_context.currentPanel = _tablePanel;

			if (editType[_context.currentState]) {
				_result = false;
				if (isModified) {
					var index = YssLayer.showConfirm("切换状态正在编辑的内容将丢失，确定继续吗？", function() {
						_result = true;
						_context.currentState = _context.operate;
						console.log(_context.currentState + ":" + _context.operate);
						YssLayer.closeLayer(index);
						sideSwitch(false);
					});
				} else {
					_result = true;
				}
			}
			if (_result) {
				sideSwitch(false);
			}
		}
		return _result;
	}
}, {
	names : [ '.btn-close-side', '.btn-side-open' ],
	hotkeys : [ 'keydown.Ctrl_o', 'keydown.Alt_c' ],
	method : function(event, data) {
		var _context = Common.getContext();
		_context.operate = "query";

		if (_context.isOpenState()) {
			var _result = true;
			if (editType[_context.currentState]) {
				_result = false;
				if (isModified) {
					var index = YssLayer.showConfirm("切换状态正在编辑的内容将丢失，确定继续吗？", function() {
						_result = true;
						_context.currentState = _context.operate;
						console.log(_context.currentState + ":" + _context.operate);
						YssLayer.closeLayer(index);
						sideSwitch(false);
					});
				} else {
					_result = true;
				}
			}
			if (_result) {
				sideSwitch(false);
			}
		} else {
			showDetail(_context);
			sideSwitch(!_context.isOpenState());
		}
		return false;
	}
}, {
	names : [ '.btn-fullscreen' ],
	hotkeys : [ 'keydown.Ctrl_f11' ],
	method : function(event, data) {
		console.log("fullscreen button");
		return false;
	}
} ];
