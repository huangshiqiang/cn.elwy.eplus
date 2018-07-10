if (window.top !== window.self) {
	window.top.location = window.location;
}
// 如果在框架或在对话框中，则弹出提示并跳转到首页
if (self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0) {
	alert('未登录或登录超时。请重新登录，谢谢！');
	top.location = ctx;
}

$(document).ready(function() {

	$("#loginForm").submit(function(e){
		var username = $("#userName").val();
		var password = $("#passWord").val();
		if(username == "" || password == ""){
			YssLayer.tip("用户名密码不能为空", this);
			return false;
		}
		var arr = $("#combo_post").val();
		var post = "";
		for (var i = 0 ;i<arr.length;i++) {
	    	if (arr[i] != ''){	    		
	    		post += arr[i]+",";
	    	}
	    }
		if (post == "" || post == ",") {
			YssLayer.tip("岗位不能为空", this);
			return false;
		}
		//var data = Common.getFormData("#loginForm");
		var data = {
			"USERNAME":username,
			"PASSWORD":password,
			"POST":post
		};
		var parameter = {};
		parameter.data = data;
		parameter.operate = "validate";
		$.ajax({
			type : "post", // 访问WebService使用Post方式请求
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			//contentType : "application/json", // WebService 会返回Json类型
			url : bundlePath + "/login", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
			data : {
				"parameter" : JSON.stringify(parameter)
			}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
			dataType : 'json',
			success : function(result) { // 回调函数，result，返回值
				retdData = result.data;
				if (result && !result.success) {
					layer.alert("用户名密码错误", {
						icon : 0,
						title : '警告'
					});
					$("#userName").val(""); 
					$("#passWord").val("");
					$("#combo_post").empty();
					$("#combo_post").append("<option value='' selected='true'>请选择</option>");    
					//更新内容刷新到相应的位置
					$('#combo_post').selectpicker('render');
					$('#combo_post').selectpicker('refresh');
		            return false; 
				} else if(result.success || retdData){
					 //var customerId = data.attr.customerInfo.id;//将数据中用户信息的ID赋值给变量 
			         //sessionStorage.customerId = customerId;//将变量存储到本地sessionStorage中，并且value为customerID 
			         window.location.href=ctx + "/fast-plm/index";//正确登录后页面跳转至 
				}
				
			}
		});
	});
	
	//用户名失去焦点事件
	$("#userName").blur(function(){
		var tempAjax = "";
		var userCode = $("#userName").val();
		if (userCode == "") {
			tempAjax += "<option value='' selected='true'>请选择</option>";
			$("#combo_post").empty();
			$("#combo_post").append(tempAjax);    
			//更新内容刷新到相应的位置
			$('#combo_post').selectpicker('render');
			$('#combo_post').selectpicker('refresh');
		} else {			
			$.post(ctx+'/webplus/webPost',{
				operate:'getPostByUser',
				userCode:userCode
			},function(data){
				tempAjax += "<option value='' selected='true'>请选择</option>";
				$.each(data.datas,function(i,n){
					tempAjax += "<option value='"+n.c_POST_CODE+"'>"+n.c_POST_NAME+"</option>";
				});
				$("#combo_post").empty();
				$("#combo_post").append(tempAjax);    
				//更新内容刷新到相应的位置
				$('#combo_post').selectpicker('render');
				$('#combo_post').selectpicker('refresh');
			});
		}
	});
	
//	function confirm(){ 
//		  var tel=$tel.val();//获取页面中登录名和密码 
//		  var pwd=$pwd.val(); 
//		  if(tel==""|| pwd==""){//判断两个均不为空（其他判断规则在其输入时已经判断） 
//		    alert("手机号密码均不能为空！") 
//		    return false; 
//		  }else{//以上均符合要求，则调用登录esb接口 
//		     $.ajax({ 
//		       url:config.baseServerUrl + '/account/login',//相对应的esb接口地址
//		       type:'post',  
//		       data:{mobile:tel,password:pwd},//向服务器（接口）传递的参数
//		       success:function(data){//服务器（接口）返回来的数据
//		         if(data.success){//如果返回来的信息说明提交的信息为正确的 
//		           var customerId = data.attr.customerInfo.id;//将数据中用户信息的ID赋值给变量 
//		           sessionStorage.customerId = customerId;//将变量存储到本地sessionStorage中，并且value为customerID 
//		           window.location.href='http://localhost/index.html';//正确登录后页面跳转至 
//		         } 
//		         else{//如果返回来的信息说明提供的信息为错误的 
//		           if(tel != data.tel){//判断是用户名还是密码错误，提示相应信息 
//		             alert(data.message); 
//		             $tel.val(""); 
//		             $pwd.val(""); 
//		             return false; 
//		            } 
//		            if(pwd != data.pwd){ 
//		             alert(data.message); 
//		             $pwd.val(""); 
//		             return false; 
//		            } 
//		         } 
//		       } 
//		    }) 
//		  } 
//		}
	
//	$("#loginForm").validate({
//		rules : {
//			validateCode : {
//				remote : ctx + "/servlet/validateCodeServlet"
//			}
//		},
//		messages : {
//			username : {
//				required : "请填写用户名."
//			},
//			password : {
//				required : "请填写密码."
//			},
//			validateCode : {
//				remote : "验证码不正确.",
//				required : "请填写验证码."
//			}
//		},
//		errorLabelContainer : "#messageBox",
//		errorPlacement : function(error, element) {
//			error.appendTo($("#loginError").parent());
//		}
//	});
	

});
