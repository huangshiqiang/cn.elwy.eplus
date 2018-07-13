$(document).ready(function() {

});
$(window).bind("resize", function() {
	var width = $(".jqGrid_wrapper").width();
	$("#table_dbObject_list").setGridWidth(width);
});
