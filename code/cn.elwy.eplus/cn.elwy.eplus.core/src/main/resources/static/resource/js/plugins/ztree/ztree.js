var setting = {
		check: {
			enable: true,
			chkboxType: {"Y":"", "N":""}
		},
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: beforeClick,
			onCheck: onCheck
		}
	};

	var zNodes =[
		{id:1, pId:0, name:"北京"},
		{id:2, pId:0, name:"天津"},
		{id:3, pId:0, name:"上海"},
		{id:6, pId:0, name:"重庆"},
		{id:4, pId:0, name:"河北省", open:true, nocheck:true},
		{id:41, pId:4, name:"石家庄"},
		{id:42, pId:4, name:"保定"},
		{id:43, pId:4, name:"邯郸"},
		{id:44, pId:4, name:"承德"},
		{id:5, pId:0, name:"广东省", open:true, nocheck:true},
		{id:51, pId:5, name:"广州"},
		{id:52, pId:5, name:"深圳"},
		{id:53, pId:5, name:"东莞"},
		{id:54, pId:5, name:"佛山"},
		{id:6, pId:0, name:"福建省", open:true, nocheck:true},
		{id:61, pId:6, name:"福州"},
		{id:62, pId:6, name:"厦门"},
		{id:63, pId:6, name:"泉州"},
		{id:64, pId:6, name:"三明"}
	 ];

	function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}
	
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
	}

	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	
	var test = ['are you kedding me','what are you'];
	for(var i=0;i<test.length;i++){
	$("#lunchBegins").append("<option value='Value'>"+test[i]+"</option>");
	}

	  $(document).ready(function () {
	    var mySelect = $('#first-disabled2');

	    $('#special').on('click', function () {
	      mySelect.find('option:selected').prop('disabled', true);
	      mySelect.selectpicker('refresh');
	    });

	    $('#special2').on('click', function () {
	      mySelect.find('option:disabled').prop('disabled', false);
	      mySelect.selectpicker('refresh');
	    });

	    $('#basic2').selectpicker({
	      liveSearch: true,
	      maxOptions: 1
	    });
	  });
	  
	  
	/*  function AutoMatch(txtObj) {
		    if (txtObj.value.length > 0) {
		        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		        var nodeList = treeObj.getNodesByParamFuzzy("name", txtObj.value,null);
		        //将找到的nodelist节点更新至Ztree内
		        $.fn.zTree.init($("#treeDemo"), setting, nodeList);
		    } else {
		        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		    }
		}*/
