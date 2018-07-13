$(function() {
	$("#signupForm").submit(function(e){
		// var data = $("#signupForm").serializeArray(); // 自动将form表单封装成json
		var data = Common.getFormData("#signupForm");
		var parameter = {};
		parameter.data = data;
		parameter.operate = data.operate2;
		$.ajax({
			type : "post", // 访问WebService使用Post方式请求
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			//contentType : "application/json", // WebService 会返回Json类型
			url : bundlePath + "/user", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
			data : {
				"parameter" : JSON.stringify(parameter)
			}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
			dataType : 'json',
			success : function(result) { // 回调函数，result，返回值
				retdData = result.data;
				if (result && !result.success) {
					layer.alert("添加用户失败！", {
						icon : 0,
						title : '警告'
					});
		            return false; 
				} else {
//					alert(1);
//					datagrid = window.opener.document.getElementById("dataGrid");
//					datagrid = window.parent.document.getElementById("reportRadio");
//					alert(datagrid);
//					datagrid.trigger("reloadGrid");	
//					window.parent.location.reload();
					$('#dataGrid').trigger("reloadGrid");
					layer.alert("添加成功！", {
						icon : 0,
						title : '提醒'
					});
				}
			}
		});
	});
});

$.validator.setDefaults({
	highlight : function(e) {
		$(e).closest(".toExamine").removeClass("has-success").addClass(
				"has-error")
	},
	success : function(e) {
		e.closest(".toExamine").removeClass("has-error").addClass(
				"has-success")
	},
	errorElement : "span",
	errorPlacement : function(e, r) {
		e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent()
				.parent() : r.parent())
	},
	errorClass : "help-block m-b-none",
	validClass : "help-block m-b-none"
}), 
$().ready(function() {
	$("#commentForm").validate();
	var e = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			c_USER_CODE : "required",
			c_USER_NAME : "required",
			c_USER_PWD : "required",
			c_CORP_ORG_CODE : "required",
			re_c_USER_PWD : "required",
			re_c_USER_PWD : {
				required : !0,
				equalTo : "#c_USER_PWD"
			},
		},
		messages : {
			c_USER_CODE : e + "请输入用户id",
			c_USER_NAME : {
				required : e + "请输入您的用户名"
			},
			c_USER_PWD : {
				required : e + "请输入您的密码"
			},
			re_c_USER_PWD : {
				required : e + "请再次输入密码",
				/*minlength : e + "密码必须5个字符以上",*/
				equalTo : e + "两次输入的密码不一致"
			}
		}
	})
});

$('.input-mask-date').ready(function(){
	$.mask.definitions['f']='[0-9.]';  //自定义格式
	$(".input-mask-num").mask("ffffffffffffff",{placeholder:"",});
	$(".input-mask-phone").mask("199-9999-9999",{placeholder:" ",});
	$("#c_IP").mask("ffffffffffffff",{placeholder:"",});
	$("#c_MAC").mask("ffffffffffffff",{placeholder:"",});
	$("#c_MO_TEL").mask("199-9999-9999",{placeholder:"",});
	$("#c_ZIP_CODE").mask("999999",{placeholder:"",});
	$("#c_OFFIC_TEL").mask("999999999999",{placeholder:"",});
	$("#c_FAX_NO").mask("99999999999",{placeholder:"",})
	/*$("#test").mask("?1ff");*/
   });
	//日期控制
	var start = {
		   elem: '#d_BIRTH',
		   format: 'YYYY-MM-DD',
		   min: laydate.now(), //设定最小日期为当前日期
		   max: '2099-06-16', //最大日期
		   istime: true,
		   istoday: false,
		   choose: function(datas){
		      end.min = datas; //开始日选好后，重置结束日的最小日期
		      end.start = datas //将结束日的初始值设定为开始日
		   }
		 };
		 var end = {
		   elem: '#d_ON_JOB',
		   format: 'YYYY-MM-DD',
		   min: laydate.now(),
		   max: '2099-06-16',
		   istime: true,
		   istoday: false,
		   choose: function(datas){
		     start.max = datas; //结束日选好后，重置开始日的最大日期
		   }
		 };
		 laydate(start);
		 laydate(end);
/*jQuery(document).ready(function($) {  
    // Stuff to do as soon as the DOM is ready;  
    var phone=$('#num');  
    $(phone).on('click',function(){  
        phone.val('');  
    })  
    $(phone).on('keyup',function(evt){  
        var phoneVal=phone.val();  
        phoneVal=phoneVal.replace('/[^\d]+/g', ''); //替换非数字字符为空格  
        phoneVal=parseInt(phoneVal,10);  
        if(isNaN(phoneVal)){  
            phoneVal = '';  
        }  
        this.value=phoneVal;  
    })  
});  */



/*function inputkeypress(inputobj){
	   if(!inputobj.value.match(/^\d*?\.?\d*?$/))
	    inputobj.value=inputobj.t_value;
	   else
	    inputobj.t_value=inputobj.value;
	   if(inputobj.value.match(/^(?:\d+(?:\.\d+)?)?$/))
	    inputobj.o_value=inputobj.value
	   if(/\.\d\d$/.test(inputobj.value))event.returnValue=false
	}
	function inputkeyup(inputobj){
	   if(!inputobj.value.match(/^\d*?\.?\d*?$/))
	    inputobj.value=inputobj.t_value;
	   else
	    inputobj.t_value=inputobj.value;
	   if(inputobj.value.match(/^(?:\d+(?:\.\d+)?)?$/))
	    inputobj.o_value=inputobj.value
	}
	function inputblur(inputobj){
	   if(!inputobj.value.match(/^(?:\d+(?:\.\d+)?|\.\d*?)?$/))
	    inputobj.value=inputobj.o_value;
	    else{
	     if(inputobj.value.match(/^\.\d+$/))
	      inputobj.value=0+inputobj.value;
	     if(inputobj.value.match(/^\.$/))
	      inputobj.value=0;
	     inputobj.o_value=inputobj.value
	    }
	}*/

	/*$("#num").on('keyup', function (event) {
	    var $amountInput = $(this);
	    //响应鼠标事件，允许左右方向键移动 
	    event = window.event || event;
	    if (event.keyCode == 37 | event.keyCode == 39) {
	        return;
	    }
	    //先把非数字的都替换掉，除了数字和. 
	    $amountInput.val($amountInput.val().replace(/[^\d.]/g, "").
	        //只允许一个小数点              
	        replace(/^\./g, "").replace(/\.{2,}/g, ".").
	        //只能输入小数点后两位
	        replace(".", "$#$").replace(/\./g, "").replace("$#$", ".").replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'));
	            });
	$("#num").on('blur', function () {
	    var $amountInput = $(this);
	    //最后一位是小数点的话，移除
	    $amountInput.val(($amountInput.val().replace(/\.$/g, "")));
	});*/
	
	/*$(document).on('keypress', '.num', function (e) {
	    // 在 keypress 事件中拦截错误输入

	    var sCharCode = String.fromCharCode(e.charCode);
	    var sValue = this.value;

	    if (/[^0-9.]/g.test(sCharCode) || __getRegex(sCharCode).test(sValue)) {
	        return false;
	    }

	    *//**
	     * 根据用户输入的字符获取相关的正则表达式
	     * @param  {string} sCharCode 用户输入的字符，如 'a'，'1'，'.' 等等
	     * @return {regexp} patt 正则表达式
	     *//*
	    function __getRegex (sCharCode) {
	        var patt;
	        if (/[0]/g.test(sCharCode)) {
	            // 判断是否为空
	            patt = /^$/g;
	        } else if (/[.]/g.test(sCharCode)) {
	            // 判断是否已经包含 . 字符或者为空
	            patt = /((\.)|(^$))/g;
	        } else if (/[1-9]/g.test(sCharCode)) {
	            // 判断是否已经到达小数点后两位
	            patt = /\.\d{2}$/g;
	        }
	        return patt;
	    }
	}).on('keyup paste', '.num', function () {
	    // 在 keyup paste 事件中进行完整字符串检测

	    var patt = /^((?!0)\d+(\.\d{1,2})?)$/g;

	    if (!patt.test(this.value)) {
	        // 错误提示相关代码，边框变红、气泡提示什么的
	        console.log('输入格式不正确！');                
	    }
	});
*/

