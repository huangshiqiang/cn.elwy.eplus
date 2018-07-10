layer.config({
	anim: 1, //默认动画风格
	skin: 'layui-layer-lan' //默认皮肤
	//btnAlign : 'c'
});

//top.layer.config({
//	anim: 1, //默认动画风格
//	skin: 'layui-layer-lan', //默认皮肤
//	btnAlign: 'c'
//});

function YssLayer(){
	var event = {};
	event['save'] = function a(i){
		layer_save_event(i);
	};
	event['edit'] = function b(i){
		layer_edit_event(i);
	}
	event['add'] = function c(i){
		layer_add_event(i);
	}
	event['copy'] = function d(i){
		layer_copy_event(i);
	}
	event['delete'] = function e(i){
		layer_delete_event(i);
	}
	event['undo'] = function f(i){
		layer_undo_event(i);
	}
	event['up'] = function g(i){
		layer_up_event(i);
	}
	event['down'] = function h(i){
		layer_down_event(i);
	};
	this.event = event;
};

/**
 * 基于layer封装一系列的表单，提示框，tip，加载层， loading层等
 * author huangjunxiong 2017-07-29
 */
YssLayer.prototype = {
	colseTime : 3000, // 默认关闭时间
    width : "800px", // 默认窗口的宽度
    height : "600px", // 默认窗口的高度
    px : "px", // 基本像素单位
	event : null, // toolbar事件
	showConfirm : function(message, fun) {  
		var index = null;
		if (fun != null) {			
			index = layer.confirm(message,{
				btn : ['确认','取消'],
			},fun);
		} else {
			index = layer.confirm(message,{
				btn : ['确认','取消'],
			});
		}
		return index;
	},
	closeLayer : function(index){
		layer.close(index);
	},
	closeTopLayer : function(index){
		top.layer.close(index);
	},
	closeAllLayer : function(){
		layer.closeAll();
	},
	// title:窗口标题, content: iframe或id, width:宽度, height:高度, callback:关闭窗口后回调函数
	openDialogNoBtn : function(title, content, width, height, callback){
		var length = arguments.length ;   //  实际传入参数的长度
		if (length == 2) { // 默认宽高
			return this.openDialogNoCallBack(title, content, this.width, this.height)
		} else if (length == 3) { // 只传入宽度参数
			width += this.px;
			return this.openDialogNoCallBack(title, content, width, this.height)
		} else if (length == 4) { // 传入宽度和高度
			width += this.px;
			height += this.px;
			return this.openDialogNoCallBack(title, content, width, height)
		} else if (length == 5) { // 带回调函数
			width += this.px;
			height += this.px;
			return this.openDialogWithCallBack(title, content, width, height, callback);
		}
	},
	openYesTopDialog : function(type, title, content, callback, toolbar, event, width, height){
		var length = arguments.length ;   //  实际传入参数的长度
		var index = null;
		if (length == 6) { // 默认宽高
			index = this.createTopDialog(type, title, content, callback, toolbar, event, this.width, this.height)
		} else if (length == 7) { // 只传入宽度参数
			width += this.px;
			index = this.createTopDialog(type, title, content, callback, toolbar, event, width, this.height)
		} else if (length == 8) { // 传入宽度和高度
			width += this.px;
			height += this.px;
			index = this.createTopDialog(type, title, content, callback, toolbar, event, width, height)
		} 
		return index;
	},
	openYesTopDialogNoBtn : function(type, title, content, width, height){
		var length = arguments.length ;   //  实际传入参数的长度
		var index = null;
		if (length == 3) { // 默认宽高
			index = this.createTopDialogNoBtn(type, title, content, this.width, this.height)
		} else if (length == 4) { // 只传入宽度参数
			width += this.px;
			index = this.createTopDialogNoBtn(type, title, content, width, this.height)
		} else if (length == 5) { // 传入宽度和高度
			width += this.px;
			height += this.px;
			index = this.createTopDialogNoBtn(type, title, content, width, height)
		} 
		return index;
	},
	createTopDialogNoBtn : function(type, title, content, width, height){
		return top.layer.open({
			type : type,
			title : title,
			content : content,
			moveType: 1,
			shade: 0,
			area : [ width, height ]
		});
	},
	createTopDialog : function(type, title, content, callback, toolbar, event, width, height){
		return top.layer.open({
			type : type,
			title : title,
			content : content,
			moveType: 1,
			shade: 0,
			area : [ width, height ],
			yes : callback ,
			success: function (layero, index) {
			      var bar = layero.find('.layui-layer-setwin');
			      bar.empty();
			      bar.append(toolbar);
			      $.each(event, function(key,values){     
			    	    var o = layero.find('.layui-layer-'+key).on('click',{index : index},values);
			      }); 
			  }
		});
	},
	openYesDialog : function(title, content, callback, width, height){
		var length = arguments.length ;   //  实际传入参数的长度
		var index = null;
		if (length == 3) { // 默认宽高
			index = this.createDialog(title, content, callback, this.width, this.height)
		} else if (length == 4) { // 只传入宽度参数
			width += this.px;
			index = this.createDialog(title, content, callback, width, this.height)
		} else if (length == 5) { // 传入宽度和高度
			width += this.px;
			height += this.px;
			index = this.createDialog(title, content, callback, width, height)
		} 
		return index;
	},
	createDialog : function(title, content, callback, width, height){
		if ((typeof content == 'string') && content.constructor == String) {		
			return layer.open({
				type : 2,
				title : title,
				content : content,
				btn : ['确认','取消'],
				moveType: 1,
				shade: 0,
				area : [ width, height ],
				yes : callback,
				success: function (layero) {
				      var btn = layero.find('.layui-layer-btn');
				      btn.css('text-align', 'center');
				  }
			});
		} else {			
			return layer.open({
				type : 1,
				title : title,
				content : content,
				btn : ['确认','取消'],
				moveType: 1,
				shade: 0,
				area : [ width, height ],
				yes : callback,
				success: function (layero) {
				      var btn = layero.find('.layui-layer-btn');
				      btn.css('text-align', 'center');
				  }
			});
		}
	},
	openDialogNoCallBack : function(title, content, width, height){
		if ((typeof content == 'string') && content.constructor == String) {		
			return layer.open({
				type : 2,
				title : title,
				content : content,
				moveType: 1,
				area : [ width, height ]
			});
		} else {			
			return layer.open({
				type : 1,
				title : title,
				content : content,
				moveType: 1,
				area : [ width, height ]
			});
		}
	},
	openDialogWithCallBack : function(title, content, width, height, callback){
		if ((typeof content == 'string') && content.constructor == String) {			
			return layer.open({
				type : 2,
				title : title ,
				content : content ,
				area: [width, height],
				end  : callback
			});
		} else {			
			return layer.open({
				type : 1,
				title : title ,
				content : content ,
				area: [width, height],
				end  : callback
			});
		}
	},
	showLoading : function(content){	    	
 		var index =  layer.open({
 		      content: content,
 		      icon: 16,
 		      shade: [0.5,'#fff'],
 		      skin: 'layui-layer-msg',
 		      title: false,
 		      closeBtn: false,
 		      btn: false,
 		      resize: false
 		      });
	    return index;
	},
	tip:function(message, dom){
		layer.tips(message, dom);
	},
	messageDialog : function(message, offset/*, timeout*/){
		var time = this.colseTime;
		if (arguments[2] != null ) {
			time = arguments[2];
		}
        var index = layer.open({
            type: 1,
            offset: offset, //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            content:'<div style="padding: 20px 20px 20px 100px;text-align: left;">'+ message +'</div>',
            shade: 0, //不显示遮罩
            anim: 1,
            time : time,
            area: ['250px', '110px'],
            title : '操作提示'
        });
		return index;
	},
	messageDialogOnRightDown : function(message/*, timeout*/){
		var time = this.colseTime;
		if (arguments[2] != null ) {
			time = arguments[2];
		}
		var index = layer.open({
	        type: 1,
	        offset: 'rb', //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
	        content:'<div style="padding: 20px 20px 20px 100px;text-align: left;">'+ message +'</div>',
	        shade: 0, //不显示遮罩
            anim: 1,
	        time : time,
            area: ['250px', '110px'],
	        title : '操作提示'
	      });
		return index;
	},
	messageAlter : function(message,type) {		
		var index = layer.open({  
			content:message,  
			icon:type,  
			title : '操作提示',
			success:function (layero, index) {
				 var btn = layero.find('.layui-layer-btn0');
			     btn.css('background','#4476A7');
			  }
		}); 
		return index;
	},
	createModal : function(id, title, content, callback) {
		$('#'+id).empty();
		var html = "<div class='modal inmodal' id='myModal' tabindex='-1' role='dialog' aria-hidden='true' data-backdrop='static' data-keyboard='false'>";
		html += "<div class='modal-dialog modal-lg'>";
		html +=	"<div class='modal-content animated bounceInRight'>";
		html += "<div class='modal-header' style='padding-bottom: 5px;padding-top:5px;padding-right: 0px;' > "; 
		html += "<button type='button' class='close' data-dismiss='modal'><span aria-hidden='true'>&times;</span><span class='sr-only'>关闭</span></button>";
		html += "<h5 class='modal-title'>";
		html += title;
		html += "</h5></div>";
		html += "<div class='modal-body' style='padding:0px; max-height:450px; overflow-y:auto;'>";
		html += content;
		html += "</div>";
		html += "<div class='modal-footer' style='text-align:center'>";
		html += "<button id='modal-save' type='button' class='btn btn-primary'>保存</button>";
		html += "<button type='button' class='btn btn-white' data-dismiss='modal'>关闭</button>";
		html += "</div>"
		html += "</div></div></div>";
		$('#'+id).append(html);
		// 绑定事件
		$('#modal-save').on('click', callback);
		$("#myModal").modal("show");
	},
	createDialogWithToolBar : function (type, title, content, toolbar, status, width, height) {
		var length = arguments.length ;   //  实际传入参数的长度
		var index = null;
		if (length == 4) { // 默认宽高
			index = this.createDialogWithToolBarHandler(type, title, content, toolbar,status, this.width, this.height)
		} else if (length == 5) { // 只传入宽度参数
			var bodyWidth = $(document.body).width();
			if (width > bodyWidth) {
				width = bodyWidth;
			}
			width += this.px;
			index = this.createDialogWithToolBarHandler(type, title, content, toolbar,status, width, this.height)
		} else if (length == 6) { // 传入宽度和高度
			var bodyWidth = $(document.body).width();
			if (width > bodyWidth) {
				width = bodyWidth;
			}
			var bodyHeight = $(document.body).height();
			if (height > bodyHeight) {
				height = bodyHeight;
			}
			width += this.px;
			height += this.px;
			index = this.createDialogWithToolBarHandler(type, title, content, toolbar,status, width, height)
		} else if (length == 7) { // 传入宽度和高度
			var bodyWidth = $(document.body).width();
			if (width > bodyWidth) {
				width = bodyWidth;
			}
			var bodyHeight = $(document.body).height();
			if (height > bodyHeight) {
				height = bodyHeight;
			}
			width += this.px;
			height += this.px;
			index = this.createDialogWithToolBarHandler(type, title, content, toolbar,status, width, height)
		} 
		return index;
	},
	createDialogWithToolBarHandler : function(type, title, content, toolbar ,status, width, height){
		var event = this.event;
		return index = layer.open({
			type : type,
			title : title,
			content : content,
			btn : ['确认'],
			moveType: 1,
			shade: 0,
			area : [ width, height ],
			cancel: function(){
				layerIndex=layerIndex-1;
				layer.close(index);
			},
			success: function (layero, index) {
				if(layerIndex==0){
					layerIndex = layerIndex+1;
				}
			      var bar = layero.find('.layui-layer-setwin');
			      bar.empty();
			      bar.append(toolbar);
			      
			      var bar1 = layero.find('.layui-layer-btn');
			      bar1.empty();
//			      bar1.append("新增Add");
			      
			      $.each(event, function(key,values){   
			    	    var o = layero.find('.layui-layer-'+key).on('click',{index : index},values);
			      }); 
			  }
		});
	}
}

var YssLayer = new YssLayer();
// 可重写
// toolbar保存事件
function layer_save_event(i){
	return;
}
//toolbar编辑事件
function layer_edit_event(i){
	return;
}
//toolbar新增事件
function layer_add_event(i){
	return;
}
//toolbar复制事件
function layer_copy_event(i){
	return;
}
//toolbar删除事件
function layer_delete_event(i){
	return;
}
//toolbar撤销事件
function layer_undo_event(i){
	return;
}
//toolbar上移事件
function layer_up_event(i){
	return;
}
//toolbar下移事件
function layer_down_event(i){
	return;
}