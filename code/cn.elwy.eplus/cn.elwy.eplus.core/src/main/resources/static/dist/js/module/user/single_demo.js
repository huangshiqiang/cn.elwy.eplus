/**
 * Created by huangsq on 2017-07-28.
 */

function changeWidth() {
    var width = $(".tab-pane").width() - 40;
    //alert(width);
    //$(".jqGrid_wrapper").setGridWidth(width);
}

function dele_table_list_1(id, grid_selector) {
    //var grid_selector = "#table_list_1";
    grid_selector = "#" + grid_selector;
    //alert(grid_selector);
    var model = jQuery(grid_selector).jqGrid('getRowData', id);
    alert(model.id);
}
function edit_table_list_1(id, grid_selector) {
    //var grid_selector = "#table_list_1";
    grid_selector = "#" + grid_selector;
    var model = jQuery(grid_selector).jqGrid('getRowData', id);
    alert(model.id);
}
function view_table_list_1(id, grid_selector) {
    //var grid_selector = "#table_list_1";
    grid_selector = "#" + grid_selector;
    var model = jQuery(grid_selector).jqGrid('getRowData', id);
    alert(model.id);
}


$(document).ready(function () {
    $.jgrid.defaults.styleUI = "Bootstrap";

    var mydata = [
        {id: "1", invdate: "2010-05-24", name: "test", note: "note", tax: "10.00", total: "2111.00"},
        {id: "2", invdate: "2010-05-25", name: "test2", note: "note2", tax: "20.00", total: "320.00"},
        {id: "3", invdate: "2007-09-01", name: "test3", note: "note3", tax: "30.00", total: "430.00"},
        {id: "4", invdate: "2007-10-04", name: "test", note: "note", tax: "10.00", total: "210.00"},
        {id: "5", invdate: "2007-10-05", name: "test2", note: "note2", tax: "20.00", total: "320.00"},
        {id: "6", invdate: "2007-09-06", name: "test3", note: "note3", tax: "30.00", total: "430.00"},
        {id: "7", invdate: "2007-10-04", name: "test", note: "note", tax: "10.00", total: "210.00"},
        {
            id: "8",
            invdate: "2007-10-03",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "21.00",
            total: "320.00"
        },
        {
            id: "9",
            invdate: "2007-09-01",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "11",
            invdate: "2007-10-01",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "12",
            invdate: "2007-10-02",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "13",
            invdate: "2007-09-01",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "14",
            invdate: "2007-10-04",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "15",
            invdate: "2007-10-05",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "16",
            invdate: "2007-09-06",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "17",
            invdate: "2007-10-04",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "18",
            invdate: "2007-10-03",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "19",
            invdate: "2007-09-01",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "21",
            invdate: "2007-10-01",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "22",
            invdate: "2007-10-02",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "23",
            invdate: "2007-09-01",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "24",
            invdate: "2007-10-04",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "25",
            invdate: "2007-10-05",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "26",
            invdate: "2007-09-06",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        },
        {
            id: "27",
            invdate: "2007-10-04",
            name: "test",
            note: "note",
            amount: "200.00",
            tax: "10.00",
            total: "210.00"
        },
        {
            id: "28",
            invdate: "2007-10-03",
            name: "test2",
            note: "note2",
            amount: "300.00",
            tax: "20.00",
            total: "320.00"
        },
        {
            id: "29",
            invdate: "2007-09-01",
            name: "test3",
            note: "note3",
            amount: "400.00",
            tax: "30.00",
            total: "430.00"
        }
    ];
    var mydata1 = [
        {id: "1", invdate: "2010-05-24", name: "test", note: "note", tax: "10.00", total: "2111.00"},
        {id: "22", invdate: "2010-05-25", name: "test2", note: "note2", tax: "20.00", total: "320.00"},
        {id: "333", invdate: "2007-09-01", name: "test3", note: "note3", tax: "30.00", total: "430.00"}
    ];

    $("#table_list_1").jqGrid({
        data: mydata,
        datatype: "local",
        height: 490,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["序号", "日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "id", index: "id", width: 60, sorttype: "int"},
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: true},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_1')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_1')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_1')\"></a>";
                }
            }
        ],
        pager: "#pager_list_1",


        subGridRowExpanded: function (subgrid_id, row_id) {
            // we pass two parameters
            // subgrid_id is a id of the div tag created whitin a table data
            // the id of this elemenet is a combination of the "sg_" + id of the row
            // the row_id is the id of the row
            // If we wan to pass additinal parameters to the url we can use
            // a method getRowData(row_id) - which returns associative array in type name-value
            // here we can easy construct the flowing
            alert(subgrid_id);
            alert(row_id);
            var subgrid_table_id, pager_id;
            subgrid_table_id = subgrid_id + "_t";
            pager_id = "p_" + subgrid_table_id;
            $("#" + subgrid_id).html(
                "<table id='" + subgrid_table_id + "' class='scroll'></table><div id='" + pager_id + "' class='scroll'></div>");
            $("#" + subgrid_table_id).jqGrid({
                /* //url : ctx+"/SubGrid?q=2&id=" + row_id,
                 datatype : "local",
                 colNames : [ 'No', 'Item', 'Qty', 'Unit','Line Total' ],
                 colModel : [
                 {name : "num", index : "num",width : 80,key : true},
                 {name : "item",index : "item", width : 130},
                 {name : "qty",index : "qty",width : 70,align : "right"},
                 {name : "unit",index : "unit",width : 70,align : "right"},
                 {name : "total",index : "total",width : 70,align : "right",sortable : false}
                 ],
                 rowNum : 20,
                 pager : pager_id,
                 sortname : 'num',
                 sortorder : "asc",
                 height : '100%'  */


                data: mydata1,
                datatype: "local",
                height: 100,
                //multiselect:true,
                //multiselectWidth:30,
                //subGrid:true,
                //subGridWidth:80,
                rownumbers: true,
                forceFit: true,//手动调整列宽度
                autowidth: true,
                sortable: true,
                shrinkToFit: true,
                rowNum: 20,
                rowList: [10, 20, 30],
                colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
                colModel: [
                    {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
                    {name: "name", index: "name", width: 100},
                    {
                        name: "amount",
                        index: "amount",
                        width: 80,
                        align: "right",
                        sorttype: "float",
                        formatter: "number"
                    },
                    {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
                    {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
                    {name: "note", index: "note", width: 150, sortable: false},
                    {
                        name: "system", index: "system", width: 150, sortable: false,
                        formatter: function (value, grid, rows, state) {
                            /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                             +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                             +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                            return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + "," + subgrid_table_id + ")\"></a>&nbsp;&nbsp;&nbsp;"
                                + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + "," + subgrid_table_id + ")\"></a>&nbsp;&nbsp;&nbsp;"
                                + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + "," + subgrid_table_id + ")\"></a>";
                        }
                    }
                ],
                pager: pager_id,
                viewrecords: true,
                //caption:"jqGrid 示例1",
                hidegrid: false


            });
            jQuery("#" + subgrid_table_id).jqGrid(
                'navGrid',
                "#" + pager_id,
                {edit: false, add: false, del: false, view: false, refresh: false, search: false}
            );
        },

        subGridRowColapsed: function (subgrid_id, row_id) {
            // this function is called before removing the data
            var subgrid_table_id;
            subgrid_table_id = subgrid_id + "_t";
            $("#" + subgrid_table_id).remove();
        },


        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    /* $("#t_table_list_1").append( "<button type='button' class='btn btn-default btn-sm'>添加</button>");
     $("button", "#t_table_list_1").click(function(){
     alert("Hi! I'm added button at this toolbar of top");
     }); */

    $("#table_list_2").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        subGrid: true,
        autowidth: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["序号", "日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "id", index: "id", editable: true, width: 60, sorttype: "int", search: true},
            {name: "invdate", index: "invdate", editable: true, width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", editable: true, width: 100},
            {
                name: "amount",
                index: "amount",
                editable: true,
                width: 80,
                align: "right",
                sorttype: "float",
                formatter: "number"
            },
            {name: "tax", index: "tax", editable: true, width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", editable: true, width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", editable: true, width: 100, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_2')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_2')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_2')\"></a>";
                }
            }
        ],
        pager: "#pager_list_2",
        viewrecords: true,
        //caption:"jqGrid 示例2",
        //add:true,
        //edit:true,
        //addtext:"Add",
        //edittext:"Edit",
        hidegrid: false
    });

    $("#table_list_3").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_3')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_3')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_3')\"></a>";
                }
            }
        ],
        pager: "#pager_list_3",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });
    $("#table_list_4").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        subGrid: true,
        autowidth: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "name", index: "name", editable: true, width: 100},
            {
                name: "amount",
                index: "amount",
                editable: true,
                width: 80,
                align: "right",
                sorttype: "float",
                formatter: "number"
            },
            {name: "tax", index: "tax", editable: true, width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", editable: true, width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", editable: true, width: 100, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_4')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_4')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_4')\"></a>";
                }
            }
        ],
        pager: "#pager_list_4",
        viewrecords: true,
        //caption:"jqGrid 示例2",
        //add:true,
        //edit:true,
        //addtext:"Add",
        //edittext:"Edit",
        hidegrid: false
    });

    $("#table_list_5").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_5')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_5')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_5')\"></a>";
                }
            }
        ],
        pager: "#pager_list_5",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_6").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_6')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_6')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_6')\"></a>";
                }
            }
        ],
        pager: "#pager_list_6",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_7").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_7')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_7')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_7')\"></a>";
                }
            }
        ],
        pager: "#pager_list_7",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_8").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_8')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_8')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_8')\"></a>";
                }
            }
        ],
        pager: "#pager_list_8",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_9").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_9')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_9')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_9')\"></a>";
                }
            }
        ],
        pager: "#pager_list_9",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_10").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_10')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_10')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_10')\"></a>";
                }
            }
        ],
        pager: "#pager_list_10",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_11").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_11')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_11')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_11')\"></a>";
                }
            }
        ],
        pager: "#pager_list_11",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });

    $("#table_list_12").jqGrid({
        data: mydata,
        datatype: "local",
        height: 250,
        multiselect: true,
        //multiselectWidth:30,
        subGrid: true,
        subGridWidth: 80,
        rownumbers: true,
        forceFit: true,//手动调整列宽度
        autowidth: true,
        sortable: true,
        toolbar: [true, "top"],
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["日期", "客户", "金额", "运费", "总额", "备注", "操作"],
        colModel: [
            {name: "invdate", index: "invdate", width: 90, sorttype: "date", formatter: "date"},
            {name: "name", index: "name", width: 100},
            {name: "amount", index: "amount", width: 80, align: "right", sorttype: "float", formatter: "number"},
            {name: "tax", index: "tax", width: 80, align: "right", sorttype: "float"},
            {name: "total", index: "total", width: 80, align: "right", sorttype: "float"},
            {name: "note", index: "note", width: 150, sortable: false},
            {
                name: "system", index: "system", width: 150, sortable: false,
                formatter: function (value, grid, rows, state) {
                    /* return "<button href=\"#\" onclick=\"dele_table_list_1("+rows.id+",'#table_list_1')\">删除</button>"
                     +"<button href=\"#\" onclick=\"edit_table_list_1("+rows.id+",'#table_list_1')\">修改</button>"
                     +"<button href=\"#\" onclick=\"view_table_list_1("+rows.id+",'#table_list_1')\">查看</button>"; */
                    return "<a class=\"glyphicon glyphicon-remove\"  onclick=\"dele_table_list_1(" + rows.id + ",'table_list_12')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-edit\"    onclick=\"edit_table_list_1(" + rows.id + ",'table_list_12')\"></a>&nbsp;&nbsp;&nbsp;"
                        + "<a class=\"glyphicon glyphicon-search\"  onclick=\"view_table_list_1(" + rows.id + ",'table_list_12')\"></a>";
                }
            }
        ],
        pager: "#pager_list_12",
        viewrecords: true,
        //caption:"jqGrid 示例1",
        hidegrid: false
    });


    //$("#table_list_2").setSelection(4,true); //页面加载时选中第四行
    $("#table_list_4").jqGrid(
        "navGrid",
        "#pager_list_4",
        {edit: true, add: true, del: true, search: true, refresh: true, view: true},
        {height: 200, reloadAfterSubmit: true});

    /* $(window).bind("resize",function(){
     var width=$(".tab-pane").width();
     $("#table_list_1").setGridWidth(width);
     $("#table_list_2").setGridWidth(width);
     $("#table_list_3").setGridWidth(width);
     $("#table_list_4").setGridWidth(width);
     }) */
});


function edit() {
    if (! Common.checkSelectOne('#table_list_1')) {
        return ;
    }
    openDialog("修改" + '用户', "user_form.html", "500px", "360px");
}

function _delete() {
    if (! Common.checkSelectMulti('#table_list_1')) {
        return ;
    }
    layer.tips("删除成功！", this, {tips: [1, "#3595CC"], time: 2000});
}


$(document).ready(function () {
    try {
        // 链接去掉虚框
        $("#addButton").on("click", function () {
            openDialog("添加用户", "user_form.html", '500px', '360px');
        });
        $("#editButton").on("click", edit);
        $("#deleteButton").on("click", _delete);
    } catch (e) {
        console.warn(e);
    }
});
