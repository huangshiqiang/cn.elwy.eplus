/**
 * 通用公共方法
 * @author huangsq
 * @version 1.0.0
 */
var Common = {}

/**
 * 上下文对象，用于存储页面的全局元素
 */
Common.context = {
	openState : false,
	currentPanel : null,
	currentState : 'query',
	operate : 'query',
	tablePanels : {},

	isOpenState : function() {
		return this.openState;
	}
// setOpenState : function(value) {
// this.openState = value;
// },
// getCurrentPanel : function() {
// return this.currentPanel;
// },
// setCurrentPanel : function(value) {
// this.currentPanel = value;
// },
// getCurrentState : function() {
// return this.currentState;
// },
// setCurrentState : function(value) {
// this.currentState = value;
// },
// getTablePanels : function() {
// return this.tablePanels;
// },
// setTablePanels : function(value) {
// this.tablePanels = value;
// }
};

function TablePanel(id, gridConfig) {
	this.id = id;
	this.name = id;
	this.gridConfig = gridConfig;
	this.url = null;
	this.grid = null;
	this.lastRow = null;
}
//
// TablePanel.prototype.getId = function() {
// return this.id;
// };
// TablePanel.prototype.setId = function(value) {
// this.id = value;
// };
// TablePanel.prototype.getGridConfig = function() {
// return this.gridConfig;
// };
// TablePanel.prototype.setGridConfig = function(value) {
// this.gridConfig = value;
// };
// TablePanel.prototype.getUrl = function() {
// return this.url;
// };
// TablePanel.prototype.setUrl = function(value) {
// this.url = value;
// };
// TablePanel.prototype.getGrid = function() {
// return this.grid;
// };
// TablePanel.prototype.setGrid = function(value) {
// this.grid = value;
// };
// TablePanel.prototype.getLastRow = function() {
// return this.lastRow;
// };
// TablePanel.prototype.setLastRow = function(value) {
// this.lastRow = value;
// };

Common.getContext = function() {
	return Common.context;
};

/**
 * 检测是否选中一条记录
 */
Common.checkSelectOne = function(tableId) {
	var ids = Common.getSelectIds(tableId);
	var size = ids.length;
	if (size != 1) {
		layer.alert('请选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return false;
	}
	return true;
}

/**
 * 检测是否选中一条或多条记录
 */
Common.checkSelectMulti = function(tableId) {
	var ids = Common.getSelectIds(tableId);
	var size = ids.length;
	if (size < 1) {
		layer.alert('请至少选择一条数据!', {
			icon : 0,
			title : '警告'
		});
		return false;
	}
	return true;
}

/**
 * 获取选中的ID
 */
Common.getSelectIds = function(tableId) {
	return $(tableId).jqGrid('getGridParam', 'selarrrow');
}

/**
 * 获取表单所有非空的数据
 */
Common.getFormData = function(formId) {
	var _formData = {};
	var _extendData = {};
	var _form = {};
	var _thisForm = $(formId);
	if (_thisForm) {
		// 处理placeholder
		var emptyValuePlaceholderNames = new Array();
		_thisForm.find(".placeholder").each(function() {
			if ($(this).attr("placeholder") != "" && ($(this).val() == "" || $(this).val() == $(this).attr("placeholder"))) {
				emptyValuePlaceholderNames.push($(this).attr("name"));
			}
		});
		// 读取表单里面的字段
		var _formArr = _thisForm.serializeArray();
		for (var i = 0; i < _formArr.length; i++) {
			if (_formArr[i].value == "") {
				continue; // 过滤空值字段
			}
			if ($.inArray(_formArr[i].name, emptyValuePlaceholderNames) > -1) {
				continue; // 处理placeholder
			}

			if (_thisForm.find("[name='" + _formArr[i].name + "']").hasClass("formExtend")) {
				if (_extendData[_formArr[i].name] !== undefined) {
					_extendData[_formArr[i].name] = _extendData[_formArr[i].name] + "," + _formArr[i].value;
				} else {
					_extendData[_formArr[i].name] = _formArr[i].value;
				}
			} else {
				if (_formData[_formArr[i].name] !== undefined) {
					_formData[_formArr[i].name] = _formData[_formArr[i].name] + "," + _formArr[i].value;
				} else {
					_formData[_formArr[i].name] = _formArr[i].value;
				}
			}
		}
		_form.formData = _formData;
		_form.formExtend = _extendData;
		try {
			_formData["queryType"] = $("#queryType").val();
		} catch (e) {
			console.warn("不存在queryType属性");
		}
	}
	return _form;
}

// 将表单数据转换成json
Common.form2Json = function(fromId) {
	// 处理placeholder
	var emptyValuePlaceholderNames = new Array();
	var formObj = $("#" + fromId);
	formObj.find(".placeholder").each(function() {
		if ($(this).attr("placeholder") != "" && ($(this).val() == "" || $(this).val() == $(this).attr("placeholder"))) {
			emptyValuePlaceholderNames.push($(this).attr("name"));
		}
	});
	// 读取表单里面的字段
	var arr = $("#" + fromId).serializeArray();
	var json = {};
	for (var i = 0; i < arr.length; i++) {
		if (arr[i].value == "")
			continue; // 过滤空值字段
		if ($.inArray(arr[i].name, emptyValuePlaceholderNames) > -1)
			continue; // 处理placeholder
		json[arr[i].name] = arr[i].value;
	}

	return json;
}

// 判断一个变量是否为空
Common.isEmpty = function(obj) {
	if (obj == null || obj == undefined) {
		return true;
	}
	if (typeof obj == "string" && obj.length == 0) {
		return true;
	}
	return false;
}

// 重置GridWrapper的高度
// id 为最接近table的div的id
Common.resizeGridWrapper = function(id) {
    var target = id.startsWith("#")?id:"#"+id;
    var container_h = $(".main-container").innerHeight() == null ? 0 : $(".main-container").innerHeight(); // main-container的高度
    var header_h = $(".header").innerHeight() == null ? 0 : $(".header").innerHeight(); // header高度
    var footer_h = $(".footer").innerHeight() == null ? 0 : $(".footer").innerHeight(); // footer高度
    var tab_nav_h = $(".nav-tabs").innerHeight() == null ? 0 : $(".nav-tabs").innerHeight(); // tab导航高度
    var tab_search_h = $(".tab-search").innerHeight() == null ? 0 : $(".tab-search").innerHeight(); // tab的search栏高度
    var tab_header_h = $(target+" .tab-header").innerHeight() == null ? 0 : $(target+" .tab-header").innerHeight(); // tab内header高度
    var tab_footer_h = $(target+" .tab-footer").innerHeight() == null ? 0 : $(target+" .tab-footer").innerHeight(); // tab内footer高度
    var tab_panel_p = 0 ; // panel-body的padding
    if ($(target+" .panel-body").length > 0) {
        tab_panel_p = $(target+" .panel-body").innerHeight()-$(target+" .panel-body").height();
    }
    var height = container_h - header_h - footer_h - tab_nav_h - tab_search_h - tab_header_h - tab_footer_h - tab_panel_p - 10;
    $(target+" .jqGrid_wrapper").height(height);
    console.info("重置后表格外层高度是："+$(target+" .jqGrid_wrapper").height());
}