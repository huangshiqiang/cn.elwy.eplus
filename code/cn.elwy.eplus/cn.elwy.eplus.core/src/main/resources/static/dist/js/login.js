if (window.top !== window.self) {
	window.top.location = window.location;
}
// 如果在框架或在对话框中，则弹出提示并跳转到首页
/*
 * if (self.frameElement && self.frameElement.tagName == "IFRAME" ||
 * $('#left').length > 0 || $('.jbox').length > 0) {
 * alert('未登录或登录超时。请重新登录，谢谢！'); top.location = ctx; }
 */

$(document).ready(function() {

	function keyLogin() {
		if (event.keyCode == 13) // 回车键的键值为13
			$(".btn-success")[0].click(); // 调用登录按钮的登录事件
	}
	$("body").on("keydown", keyLogin)
	// 重置
	$(".jloginReset").on("click", function() {
		$("#userName").val("");
		$("#password").val("");
	})

	$("#loginForm").submit(function(e) {
		var username = $("#userName").val();
		var password = $("#password").val();
		var rememberMe = $("#rememberMe").val();
		if (username == "") {
			alert("用户名不能为空");
			return false;
		}
		if (password == "") {
			alert("密码不能为空");
			return false;
		}
		// var data = Common.getFormData("#loginForm");
		$.ajax({
			type : "post", // 访问WebService使用Post方式请求
			 contentType : "application/x-www-form-urlencoded; charset=UTF-8",
//			contentType : "application/json", // WebService 会返回Json类型
			url : "./login", // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
			data : {
				"username" : username,
				"password" : password,
				"rememberMe" : rememberMe
			}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
			dataType : 'json',
			success : function(result) { // 回调函数，result，返回值
				retdData = result.data;
				if (result && !result.success) {
					$("#userName").focus();
					return false;
				} else if (result.success) {
					// var customerId = data.attr.customerInfo.id;//将数据中用户信息的ID赋值给变量
					// sessionStorage.customerId =
					// customerId;//将变量存储到本地sessionStorage中，并且value为customerID
					window.location.href = retdData;// 正确登录后页面跳转至
				}

			}
		});
	});
});
