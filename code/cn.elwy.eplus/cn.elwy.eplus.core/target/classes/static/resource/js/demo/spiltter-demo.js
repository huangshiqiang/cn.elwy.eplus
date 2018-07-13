$(function () {
	initWidgets();
});

$(window).bind('resize', function () {
    // 自动填充
	var a = $('#A_Area').height();
	var b = $('#searchForm').height();
	var c = $('#titleSpan').height();
	$('#table_div').height(a-b-c);
});

function initWidgets() {
	$('.input-group-btn').width($('#btn_search').width());
	
    $('#mainSplitter').jqxSplitter({ 
    	width: '100%', 
    	height: '100%', 
    	panels: [{ size: '20%',min : 200}, { size: '80%'}] 
    });
    $('#rightSplitter').jqxSplitter({ 
    	height: '100%', 
    	orientation: 'horizontal', 
    	panels: [{ size: '60%', collapsible: false }, { size: '40%'}] 
    });
    
	//自动填充
	var a = $('#A_Area').height();
	var b = $('#searchForm').height();
	var c = $('#titleSpan').height();
	$('#table_div').height(a-b-c);
	
    var dataGridConfig1 = initDataGrid("pager_list_1");
    var dataGridConfig2 = initDataGrid("pager_list_2");
    var dataGridConfig3 = initDataGrid("pager_list_3");
	var gd1 = $('#dataGrid1').YssDataGrid(dataGridConfig1);
	var gd2 = $('#dataGrid2').YssDataGrid(dataGridConfig2);
	var gd3 = $('#dataGrid3').YssDataGrid(dataGridConfig3);
}

function initDataGrid(pageId){
	var mydata = [
	              {
	                  id: "1",
	                  invdate: "2010-05-24",
	                  name: "test",
	                  note: "note",
	                  tax: "10.00",
	                  total: "2111.00"
	              },
	              {
	                  id: "2",
	                  invdate: "2010-05-25",
	                  name: "test2",
	                  note: "note2",
	                  tax: "20.00",
	                  total: "320.00"
	              },
	              {
	                  id: "3",
	                  invdate: "2007-09-01",
	                  name: "test3",
	                  note: "note3",
	                  tax: "30.00",
	                  total: "430.00"
	              },
	              {
	                  id: "4",
	                  invdate: "2007-10-04",
	                  name: "test",
	                  note: "note",
	                  tax: "10.00",
	                  total: "210.00"
	              },
	              {
	                  id: "5",
	                  invdate: "2007-10-05",
	                  name: "test2",
	                  note: "note2",
	                  tax: "20.00",
	                  total: "320.00"
	              },
	              {
	                  id: "6",
	                  invdate: "2007-09-06",
	                  name: "test3",
	                  note: "note3",
	                  tax: "30.00",
	                  total: "430.00"
	              },
	              {
	                  id: "7",
	                  invdate: "2007-10-04",
	                  name: "test",
	                  note: "note",
	                  tax: "10.00",
	                  total: "210.00"
	              },
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
	return {
		data: mydata,
        datatype: "local",
        shrinkToFit : false,
        colModel: [
                   {
                	   header : '序号',
                       name: 'id',
                       index: 'id',
                       width: 60,
                       sorttype: "int"
                   },
                   {
                	   header : '日期',
                	   name: 'invdate',
                       index: 'invdate',
                       width: 90,
                       sorttype: "date",
                       formatter: "date"
                   },
                   {
                	   header : '客户',
                	   name: 'name',
                       index: 'name',
                       width: 100
                   },
                   {
                	   header : '金额',
                	   name: 'amount',
                       index: 'amount',
                       width: 80,
                       align: "right",
                       sorttype: "float",
                       formatter: "number"
                   },
                   {
                	   header : '运费',
                	   name: 'tax',
                       index: 'tax',
                       width: 80,
                       align: "right",
                       sorttype: "float"
                   },
                   {
                	   header : '总额',
                	   name: 'total',
                       index: 'total',
                       width: 80,
                       align: "right",
                       sorttype: "float"
                   },
                   {
                	   header : '备注',
                	   name: 'note',
                       index: 'note',
                       width: 150,
                       sortable: false
                   }
               ],
               pager: pageId
	}
}