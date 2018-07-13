/**
 * Created by huangsq on 2017-07-28.
 */
function changeWidth() {
	var width = $(".tab-pane").width() - 40;
	// alert(width);
	// $(".jqGrid_wrapper").setGridWidth(width);
}

function dele_table_list_1(id, grid_selector) {
	// var grid_selector = "#table_list_1";
	grid_selector = "#" + grid_selector;
	// alert(grid_selector);
	var model = jQuery(grid_selector).jqGrid('getRowData', id);
	alert(model.id);
}
function edit_table_list_1(id, grid_selector) {
	// var grid_selector = "#table_list_1";
	grid_selector = "#" + grid_selector;
	var model = jQuery(grid_selector).jqGrid('getRowData', id);
	alert(model.id);
}
function view_table_list_1(id, grid_selector) {
	// var grid_selector = "#table_list_1";
	grid_selector = "#" + grid_selector;
	var model = jQuery(grid_selector).jqGrid('getRowData', id);
	alert(model.id);
}

function edit() {
	if (!Common.checkSelectOne('#table_list_1')) {
		return;
	}
	openDialog("修改" + '用户', "user_form.html", "500px", "360px");
}

function _delete() {
	if (!Common.checkSelectMulti('#table_list_1')) {
		return;
	}
	layer.tips("删除成功！", this, {
		tips : [ 1, "#3595CC" ],
		time : 2000
	});
}

