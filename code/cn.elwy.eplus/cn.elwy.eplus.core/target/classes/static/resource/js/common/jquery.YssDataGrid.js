/**
 * jqGrid 封装类
 * @author huangsq
 * @version 2017-07-29
 */

;
(function($, window, document) {
	$.jgrid.defaults.styleUI = "Bootstrap";
	// 当前Grid对象元素，默认id：dataGrid
	var defaultOptions = {
		mtype : "POST",
		datatype : "json",
		// postData : {
		// parameter : getFormData(searchFormId)
		// },
		jsonReader : { // 自定义表格的JSON读取参数
			id : "id",
			root : "datas",
			page : "pageNo",
			total : "totalPage",
			records : "totalRecord",
			repeatitems : true,
			cell : "cell",
			userdata : "otherData",
			subgrid : {
				root : "datas"
			}
		},
		treeReader : { // 自定义树表格JSON读取参数
			level_field : "level",
			parent_id_field : "parentId",
			expanded_field : "expanded",
			leaf_field : "leaf",
			icon_field : "icon",
			loaded : "loaded",
			userdata : "otherData"
		},
		prmNames : { // 自定义Ajax请求参数
			page : "pageNo",
			rows : "pageSize",
			totalrows : "totalPage",
			sort : "orderBy",
			order : "sord",
			search : "_search",
			nd : "nd",
			id : "id",
			oper : "operate",
			addoper : "create",
			editoper : "edit",
			deloper : "del",
			subgridid : "id",
			npage : null
		},
		rowNum : 15, // 显示行数，-1为显示全部
		rowList : [ 5, 10, 15, 20, 30, 50, 100, 200, 500, 1000 ],
		rownumbers : true,
		loadtext : "数据加载中...",
		emptyrecords : "未查询到相关数据",
		viewrecords : true,
		autowidth : true,
		forceFit : true,
		sortable : true,
		shrinkToFit : true,
		height : "100%",
		rownumWidth : 35, // 序号列宽
		subGrid : false,
		multiselect : true,
		multiboxonly : true, // 单击复选框时在多选
		altRows : true, // 斑马线样式，交替行altclass
		tabPageId : '', // 当前页签编号（作为addTabPage的参数）

		// 设置列模型参数
		colNames : [],
		// colModel : options.columnModel,

		// 数据表格扩展参数
		dataId : 'id', // 指定数据主键
		lazyLoad : false, // 是否懒加载Grid数据（仅对url远程请求数据有效），调用 dataGrid.refresh()时再进行加载
		shrinkToFit : true, // 按百分比自动调整列宽

		// showRownum : true, // 是否显示行号
		showCheckbox : false,// 是否显示复选框
		sortableColumn : true,// 列表是否允许排序

		autoGridHeight : true, // 自动表格高度
		autoGridHeightFix : 0, // 自动表格高度宽度
		autoGridWidth : true, // 自动表格宽度
		autoGridWidthFix : 0, // 自动表格修复宽度

		// 树结构表格参数
		treeGrid : false, // 启用树结构表格
		treeGridModel : 'adjacency', // 启用简单结构模式
		ExpandColClick : true, // 单击列可展开
		// ExpandColumn : options.treeColumn, // 要展开的列
		// defaultExpandLevel : 0, // 默认展开的层次
		// initExpandLevel : options.defaultExpandLevel,// 保存初始化是设置的展开层次

		addEvent : function(dataGrid) {// 数据请求前调用方法
		},
		beforeRequest : function(data) {// 数据请求前调用方法
			// console.debug(data);
		},
		loadComplete : function(data) {// 数据请求完成调用方法
			// 如果有消息，则显示提示消息
			if (data.success === undefined) { // 针对本地数据过滤

			} else if (data && !data.success) {
				layer.alert(data.message, {
					icon : 0,
					title : '查询失败'
				});
			}
			// else {
			// YssLayer.messageDialog("操作成功！！！",'rb',1000);
			// }
		},
		loadError : function(data) {
			console.log(data);
			if (data.responseText && data.responseText != '') {
				/*-
				layer.alert(data.responseText, {
					icon : 0,
					title : '查询失败'
				});
				 */
				YssLayer.messageAlter(data.responseText, 0);
			}
		},
		gridComplete : function() {
			// console.debug("数据加载完成");
		},
		onSelectRow : function(rowid, status) {
			return;
		},
		onCellSelect : function(rowid, iCol, cellcontent, e) {
			return;
		},
		ondblClickRow : function(rowid, iRow, iCol, e) {
			return;
		}
	};

	var _getFormData = function(formId) {
		var parameter = {};
		parameter.param = Common.getFormData(formId).formData;
		if (!parameter.operate) {
			parameter.operate = "query";
		}
		return JSON.stringify(parameter);
	};

	var privateMethods = {
		// 支持首列是checkbox
		_checkboxSupport : function(options) {
			options.colModel = $.merge([ {
				header : '<input type="checkbox" />',
				name : 'id',
				width : 33,
				align : 'center',
				sortable : false,
				formatter : 'checkbox',
				formatoptions : {
					disabled : false
				},
				fixed : true,
				resizable : false,
			} ], options.colModel);
			this.after('<div id="pager"></div>');
		},
		// 支持自定义工具栏
		_navSupport : function(options) {
			if (options.navGridBtns instanceof Array) {
				for ( var i in options.navGridBtns) {
					this.navGrid('#pager', {
						edit : false,
						add : false,
						del : false,
						search : false,
						refresh : false
					}).navButtonAdd('#pager', {
						caption : options.navGridBtns[i].name,
						buttonicon : options.navGridBtns[i].icon,
						onClickButton : options.navGridBtns[i].click,
						position : "last"
					});
				}
			}
		},
		// 支持列头都跟上一个checkbox
		_headWithCheckBox : function(__options) {
			var _id = this.attr('id');
			if (__options.colModel instanceof Array) {
				for ( var i in __options.colModel) {
					var ci = __options.colModel[i];
					var idtemp = this.attr('id') + '_' + __options.colModel[i];
					var checkboxTemp = $("<input id=" + idtemp
							+ "_checkbox type='checkbox' style='display:block;float:left;margin:2px;'/>");
					checkboxTemp.on('click', function() {
						// 默认实现全选
						if ($(this).attr('id').indexOf('colCheckbox') != -1) {
							if ($(this)[0].checked) {
								$('#' + _id).find('td[aria-describedby=' + _id + '_colCheckbox]').children(':checkbox:not(:checked)')
										.prop('checked', true).trigger('change');
							} else {
								$('#' + _id).find('td[aria-describedby=' + _id + '_colCheckbox]').children(':checkbox:checked').prop(
										'checked', false).trigger('change');
							}

						} else {
							__options.events['onHeadCheck']($(this));
						}
					});
					if (ci.checkbox && !ci.hidden) {
						ci.header = checkboxTemp.prop("outerHTML") + ci.header;
					}
					// $('#' + idtemp).prepend(checkboxTemp);
				}
			}
		},
		_selectedRows : {

		},
		_init : function(options) {
			$.proxy(privateMethods._headWithCheckBox, this)(options);
		},
		_checkboxHanler : function() {
			// 为每行的checkbox实现默认选中当前行的功能
			var __this = this;
			this.find('td[aria-describedby=' + this.attr('id') + '_colCheckbox]').children(':checkbox').on(
					'change',
					function() {
						if ($(this).is(":checked")) {
							$(this).parent('td').parent('tr').addClass('success');
							privateMethods._selectedRows[__this.attr('id')].push($.extend(true, {}, __this.jqGrid("getRowData", $(
									this).parent('td').parent('tr').attr('id')), {
								YssTreeGridId : $(this).parent('td').parent('tr').attr('id')
							}));
						} else {
							$(this).parent('td').parent('tr').removeClass('success');
							var trId = $(this).parent('td').parent('tr').attr('id');
							if (!privateMethods._selectedRows[__this.attr('id')]) {
								return;
							} else {
								var cloneArray = $.merge([], privateMethods._selectedRows[__this.attr('id')]);
								$.each(cloneArray, function(index, item) {
									if (item.YssTreeGridId == trId) {
										privateMethods._selectedRows[__this.attr('id')].splice(index, 1);
									}
								});
								delete cloneArray;
							}
						}
					});
		},
		_flash : function(target, total, speed) {
			total--;
			if (total >= 0) {
				target.animate({
					backgroundColor : "#f2dede"
				}, speed, function() {
					target.animate({
						backgroundColor : "white"
					}, speed, function() {
						privateMethods._flash(target, total, speed);
					});
				});
			}
		}
	};

	$.fn.YssDataGrid = function(options) {
		var _this = this;
		// 当前Grid的分页元素，默认id：grid的id+Page为分页元素
		var dataGridId = this.attr('id');
		var dataGridPageId = options.dataGridPageId ? options.dataGridPageId : dataGridId + "Page";
		// 当前Grid的数据来源Form，默认id：searchForm
		var searchForm = options.searchForm ? options.searchForm : $("#searchForm");
		var searchFormId = "#" + searchForm.attr("id");

		var getFormData = options.getFormData ? options.getFormData : _getFormData;
		options.url = options.url ? options.url : searchForm.attr('action');
		options.postData = options.postData ? options.postData : {
			parameter : getFormData(searchFormId)
		};
		options.pager = options.pager ? options.pager : dataGridPageId;

		if (options.gridComplete == null) {
			options.gridComplete = function() {
				var gd = $('#' + dataGridId);
				var ids = gd.jqGrid("getDataIDs");
				for (var i = 0; i < ids.length; i++) {
					var rowData = gd.jqGrid('getRowData', ids[i]);
					if (rowData.n_STATE == "0") {
						gd.find('#' + ids[i]).find("td").addClass("text-warning");
					} else if (rowData.n_STATE == "2") {
						gd.find('#' + ids[i]).find("td").addClass("text-success");
					}
				}
			};
		}

		_options = $.extend({}, defaultOptions, options);

		// 如果是树结构表格
		if (_options.treeGrid) {
			// _options.showRownum = false; // 是否显示行号
			_options.showCheckbox = false; // 是否显示复选框
		}

		// 显示序号
		/*
		 * if (_options.showRownum) { _options.rownumbers = true; // 显示序号 }
		 */

		// 显示多选复选框
		if (_options.showCheckbox) {
			_options.multiselect = true; // 显示多选复选框
		}

		// 如果是本地数据
		if (_options.datatype == 'local' && _options.rowNum == -1) {
			_options.rowNum = 1000; // 设置一个最大行数为1000，否则会显示数据不全
		}

		// 是否懒加载Grid数据（仅对url远程请求数据有效），调用 dataGrid.refresh()时再进行加载
		if (_options.lazyLoad && !_options.treeGrid) {
			_options.datatype_bak = _options.datatype;
			_options.datatype = 'local';
		}

		// 如果设置了多级表头或冻结列
		if (_options.groupHeaders || _options.frozenCols || !_options.shrinkToFit) {
			_options.shrinkToFit = false;// 不按百分比自适应列宽
		} else {
			_options.shrinkToFit = true; // 按百分比自适应列宽
		}

		// 是否显示合计行
		if (_options.showFooter) {
			_options.footerrow = true; // 显示底部合计行
			_options.userDataOnFooter = true; // 使用json数据中的otherData作为合计行数据。
		}

		// 第一列添加checkbox
		if (_options.checkbox) {
			$.proxy(privateMethods._checkboxSupport, this)(_options);
		}
		// 表头添加checkbox
		$.proxy(privateMethods._init, _this)(_options);

		// 获取列标题
		_options.colNames = [];
		for (var i = 0; i < _options.colModel.length; i++) {
			_options.colNames.push(_options.colModel[i].header);
			// 如果是树结构表格
			if (_options.treeGrid || !_options.sortableColumn) {
				_options.colModel[i].sortable = false; // 是否排序列
			}
		}

		// 初始化jqGrid
		var __grid = this.jqGrid(_options);

		// 绑定查询表单提交事件
		// searchForm.submit(function() {
		// reload();
		// return false;
		// });
		// 绑定查询按钮
		if (_options.btnSearch) {
			$(_options.btnSearch).on('click', function() {
				__grid.reload();
				return false;
			});
		}
		// 绑定按钮事件
		if (_options.toolbar) {
			$.each(_options.toolbar, function(index, button) {
				$("#" + button.id).on('click', {
					dataGrid : _this,
					index : index
				}, button.eventMethod);
			});
		}

		// 如果设置了多级表头
		if (_options.groupHeaders && _options.groupHeaders.twoLevel) {
			if (_options.groupHeaders.threeLevel) { // 设置三级表头
				this.jqGrid('setComplexHeaders', {
					complexHeaders : {
						defaultStyle : true,
						twoLevel : _options.groupHeaders.twoLevel,
						threeLevel : _options.groupHeaders.threeLevel
					}
				});
			} else { // 设置二级表头
				this.jqGrid('setGroupHeaders', {
					useColSpanStyle : true,
					groupHeaders : _options.groupHeaders.twoLevel
				});
			}
		}

		// 是否冻结列
		if (_options.frozenCols) {
			_this.jqGrid('setFrozenColumns'); // 冻结列，在colModel指定frozen: true
		}

		// 是否有自定义toolbar
		if (_options.customToolBar) {
			var loc = _options.customToolBarLoc;
			var btns = _options.customToolBarBtns;
			var id = _this.attr('id');
			if (btns instanceof Array) {
				var grid = this.navGrid('#' + _options.pager, {
					edit : false,
					add : false,
					del : false,
					search : false,
					refresh : false
				});
				if ("right" == loc) {
					var id = _this.attr('id');
					$("#gbox_" + id).addClass("navbar-header")
					$("#gbox_" + id).wrap("<div class='flot-chart-content'></div>");
					$("#gbox_" + id).after(
							"<div class='navbar-header' style='width: 25px;padding-left: 5px;'><table id='" + id
									+ "_toolbar'></table></div>");
				}
				for (var i = 0; i < btns.length; i++) {
					if ("bottom" == loc) { // 底部
						this.jqGrid('navButtonAdd', '#' + _options.pager, {
							caption : "",
							title : btns[i].title,
							buttonicon : btns[i].icon,
							id : id + "_il" + btns[i].name,
							onClickButton : btns[i].click != null ? btns[i].click : getFunc(btns[i].name)
						});
					} else if ("right" == loc) { // 右侧
						var html = '<tr><td class="ui-pg-button" style="cursor:pointer;" id="' + id + '_il' + btns[i].name
								+ '" title="' + btns[i].title + '">';
						html += '<div class="ui-pg-div"><span class="glyphicon ' + btns[i].icon + '"></span></div></td></tr>';
						var table = $("#" + id + "_toolbar");
						table.append(html);
						// 绑定事件
						$('#' + id + '_il' + btns[i].name).click(btns[i].click != null ? btns[i].click : getFunc(btns[i].name));
					}
				}
			}
		}

		// 根据名称获得指定函数
		function getFunc(name) {
			var fun = null;
			switch (name) {
			case 'Add':
				fun = rowAddEvent;
				break;
			case 'Delete':
				fun = rowDeleteEvent;
				break;
			case 'Up':
				fun = rowUpEvent;
				break;
			case 'Down':
				fun = rowDownEvent;
				break;
			case 'Save':
				fun = rowSaveEvent;
				break;
			default:
				break;
			}
			return fun;
		}

		// 行排序 上移下移功能函数，待开发
		function sort(type, rowId) {
			// if ("up" == type) {
			// var i = parseInt(rowId)
			// if (i != 0) {
			// var todown = _this.jqGrid('getRowData',i-1);
			// var toup = _this.jqGrid('getRowData',i);
			// _this.jqGrid('getRowData')[i-1] = toup;
			// _this.jqGrid('getRowData')[i] = todown;
			// _this.trigger("reloadGrid");
			// }
			// } else if ("down" == type) {
			//
			// }
		}

		// 行增加事件
		function rowAddEvent() {
            __grid.exAddRow({
                position :"last",
                addRowParams :{
                    keys : true
                }
            });
		}

		// 行删除事件
		function rowDeleteEvent() {
			var rowId = _this.jqGrid('getGridParam', 'selrow');
			if (rowId != null) {
                __grid.exDelRow(rowId);
            } else {
                YssLayer.messageAlter("请选择记录",2);
			}
		}

		// 行上移事件
		function rowUpEvent() {
			var rowId = _this.jqGrid('getGridParam', 'selrow');
			sort('up', rowId);
		}

		// 行下移事件
		function rowDownEvent() {
			var rowId = _this.jqGrid('getGridParam', 'selrow');
			sort('down', rowId);
		}

		// 行保存事件
		function rowSaveEvent() {
			var ids = _this.jqGrid("getDataIDs");
			for (var i = 0; i < ids.length; i++) {
				_this.jqGrid('saveRow', ids[i]);
			}
		}

		/**
		 * 设置选择行
		 */
		function setSelectRow(id, isCancel) {
			if (id == undefined && isCancel == undefined) {
				_this.jqGrid("resetSelection");
			} else if (id != undefined && isCancel) {
				_this.jqGrid("resetSelection", id);
			} else {
				_this.jqGrid("setSelection", id);
			}
			return _this;
		}

		/**
		 * 删除当前行
		 */
		function delRowData(id) {
			_this.jqGrid("delRowData", id);
			return _this;
		}

		// 重置大小
		$(window).bind('resize', function() {
			var id = _this.attr('id');
			var width = $("#gbox_" + id).parent().width();
			_this.setGridWidth(width); // 重置宽度
			// 重置高度
			calculateHeight(id);
			if (__grid.getGridParam('customToolBar')) {
				var width = $("#gbox_" + id).parent().width() - $("#" + id + "_toolbar").parent().outerWidth();
				_this.setGridWidth(width); // 重置宽度
			}
		});

		// 计算高度
		function calculateHeight(id) {
			var height = $("#gbox_" + id).parent().height(); // 最外层高度
			if (height == 0) {

			} else {
                $('#gbox_' + id).height(height-2);
                var ph = $(__grid.getGridParam('pager')).outerHeight(); // 分页高度
                var _h = height - ph;
                $('#gview_' + id).height(_h);
                var hh = $('#gview_' + id + ' .ui-jqgrid-hdiv').height();// 标题高度
                $('#gview_' + id + ' .ui-jqgrid-bdiv').height(_h - hh);
            }
		}

		// 调整表格大小
		function resizeDataGrid() {
			var id = _this.attr('id');
			$('#gview_' + id).css('overflow', 'hidden');
			calculateHeight(id);
			$('#gview_' + id + ' .ui-jqgrid-bdiv').css('overflow', 'auto');
			$(__grid.getGridParam('pager')).css('position', 'absolute');
			$(__grid.getGridParam('pager')).css('bottom', '0px');
			if (__grid.getGridParam('customToolBar')) {
				var width = $("#gbox_" + id).parent().width() - $("#" + id + "_toolbar").parent().outerWidth();
				_this.setGridWidth(width); // 重置宽度
			}
		}
		resizeDataGrid();

		var currentEditId = null; // 当前编辑行id

		// 自定义方法开始
		var publicMethods = {
			/**
			 * 获取参数
			 */
			getParam : function(paramName) {
				return this.jqGrid('getGridParam', paramName);
			},
			/**
			 * 设置参数
			 */
			setParam : function(params) {
				return this.jqGrid("setGridParam", params);
			},
			/**
			 * 获取所有数据ID
			 */
			getDataIDs : function() {
				return this.jqGrid("getDataIDs");
			},
			/**
			 * 获取选择行ID
			 */
			getSelectRow : function() {
				return this.jqGrid('getGridParam', "selrow");
			},
			/**
			 * 获取选择行数组ID
			 */
			getSelectRows : function() {
				return this.jqGrid('getGridParam', "selarrrow");
			},
			/**
			 * 获取指定ID对应的行数据
			 */
			getRowDataById : function(id) {
				return this.jqGrid("getRowData", id);
			},
			/**
			 * 重新加载数据
			 */
			reload : function(params) {
				if (params != null) {
					this.jqGrid("setGridParam", {
						postData : params
					}).trigger("reloadGrid");
				} else {
					this.jqGrid('setGridParam', {
						postData : {
							parameter : getFormData(searchFormId)
						}
					}).trigger('reloadGrid');
				}
			},

			getRowDomById : function(id) {
				return this.getInd(id, true);
			},
			getNotLeafRows : function() {
				var ids = this.jqGrid('getDataIDs');
				var id2return = [];
				var _this = this;
				$.each(ids, function(index, id) {
					if (_this.jqGrid("getRowData", id).isLeaf == 'false') {
						id2return.push(id);
					}
				});
				return id2return;
			},
			addRow : function(rowid, parentid, data) {
				this.jqGrid('addChildNode', rowid, parentid, data);
				// 增加闪烁效果
				var __this = this;
				privateMethods._flash($(__this.getRowDomById(data.id)), 2, 1000);
			},
			delRow : function(rowid) {
				this.jqGrid('delTreeNode', rowid);
			},
			getChildrens : function(rowid, deep, rs) {
				var row = this.jqGrid("getRowData", rowid);
				row._id_ = row.id;
				if (deep === true) {
					if (!rs) {
						rs = [];
					}
					var childrenFirstLevel = this.jqGrid('getNodeChildren', row);
					rs = $.merge(rs, childrenFirstLevel);
					for ( var i in childrenFirstLevel) {
						this.getChildrens(childrenFirstLevel[i].id, deep, rs);
					}
					return rs;
				} else {
					return this.jqGrid('getNodeChildren', row);
				}
			},
			getParent : function(rowid, deep, rs) {
				var row = this.jqGrid("getRowData", rowid);
				row._id_ = row.id;
				if (deep === true) {
					if (!rs) {
						rs = [];
					}
					var parentFirstLevel = this.getParent(rowid, false);
					rs = $.merge(rs, parentFirstLevel);
					for ( var i in parentFirstLevel) {
						if (null != parentFirstLevel[i])
							this.getParent(parentFirstLevel[i].id, deep, rs);
					}
					return rs;
				} else {
					return this.jqGrid('getNodeParent', row) == null ? [] : [ this.jqGrid('getNodeParent', row) ];
				}
			},
			exAddRow : function(p) {
				var flag = true;
				if (currentEditId != null) {
                    flag = __grid.exSaveRow(currentEditId);
				}
				if (flag) {
                    var ids = this.jqGrid('getDataIDs');
                    var newId = parseInt(ids.length) + 1;
                    p = $.extend(true, {
                        rowID : newId,
                        initdata : {},
                        position :"first",
                        useDefValues : true,
                        useFormatter : false,
                        addRowParams : {extraparam:{},afterrestorefunc:function(){currentEditId = null;}}
                    },p  || {});
                    this.jqGrid('addRow', p);
                    currentEditId = newId;
                }
			},
			exDelRow : function(rowid){
                this.jqGrid('delRowData', rowid);
                if (currentEditId == rowid) {
                    currentEditId = null;
				}
			},
			exEditRow : function(rowid, keys, oneditfunc, successfunc, url, extraparam, aftersavefunc, errorfunc, afterrestorefunc){
                var o={}, args = $.makeArray(arguments).slice(1);

                if( $.type(args[0]) === "object" ) {
                    o = args[0];
                } else {
                    if (keys !== undefined) { o.keys = keys; }
                    if ($.isFunction(oneditfunc)) { o.oneditfunc = oneditfunc; }
                    if ($.isFunction(successfunc)) { o.successfunc = successfunc; }
                    if (url !== undefined) { o.url = url; }
                    if (extraparam !== undefined) { o.extraparam = extraparam; }
                    if ($.isFunction(aftersavefunc)) { o.aftersavefunc = aftersavefunc; }
                    if ($.isFunction(errorfunc)) { o.errorfunc = errorfunc; }
                    if ($.isFunction(afterrestorefunc)) {
                    	o.afterrestorefunc = afterrestorefunc;
                    } else {
                        o.afterrestorefunc = function(){
                            currentEditId = null;
						}
					}
                }
				this.jqGrid('editRow', rowid, o);
                currentEditId = rowid;
			},
			exSaveRow : function (rowid, successfunc, url, extraparam, aftersavefunc, errorfunc, afterrestorefunc) {
                var args = $.makeArray(arguments).slice(1), o = {};

                if( $.type(args[0]) === "object" ) {
                    o = args[0];
                } else {
                    if ($.isFunction(successfunc)) { o.successfunc = successfunc; }
                    if (url !== undefined) { o.url = url; }
                    if (extraparam !== undefined) { o.extraparam = extraparam; }
                    if ($.isFunction(aftersavefunc)) { o.aftersavefunc = aftersavefunc; }
                    if ($.isFunction(errorfunc)) { o.errorfunc = errorfunc; }
                    if ($.isFunction(afterrestorefunc)) { o.afterrestorefunc = afterrestorefunc; }
                }
				if (this.jqGrid('saveRow', rowid, o)){
                    currentEditId = null;
                    return true;
                }
                return false;
			},
			getCurrentEditId : function(){
				return currentEditId;
			}
		};

		this.extend(publicMethods);

		return this;
	};
})(jQuery, window, document);
