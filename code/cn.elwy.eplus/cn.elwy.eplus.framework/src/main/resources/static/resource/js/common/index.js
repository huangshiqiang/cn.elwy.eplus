// 顶部菜单固定
$('#fixednavbar').click(function() {
	if ($('#fixednavbar').is(':checked')) {
		$(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
		$("body").removeClass('boxed-layout');
		$("body").addClass('fixed-nav');
		$('#boxedlayout').prop('checked', false);

		if (localStorageSupport) {
			localStorage.setItem("boxedlayout", 'off');
		}

		if (localStorageSupport) {
			localStorage.setItem("fixednavbar", 'on');
		}
	} else {
		$(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
		$("body").removeClass('fixed-nav');

		if (localStorageSupport) {
			localStorage.setItem("fixednavbar", 'off');
		}
	}
});

// 收起左侧菜单
$('#collapsemenu').click(function() {
	if ($('#collapsemenu').is(':checked')) {
		$("body").addClass('mini-navbar');
		SmoothlyMenu();

		if (localStorageSupport) {
			localStorage.setItem("collapse_menu", 'on');
		}

	} else {
		$("body").removeClass('mini-navbar');
		SmoothlyMenu();

		if (localStorageSupport) {
			localStorage.setItem("collapse_menu", 'off');
		}
	}
});

// 固定宽度
$('#boxedlayout').click(function() {
	if ($('#boxedlayout').is(':checked')) {
		$("body").addClass('boxed-layout');
		$('#fixednavbar').prop('checked', false);
		$(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
		$("body").removeClass('fixed-nav');
		if (localStorageSupport) {
			localStorage.setItem("fixednavbar", 'off');
		}

		if (localStorageSupport) {
			localStorage.setItem("boxedlayout", 'on');
		}
	} else {
		$("body").removeClass('boxed-layout');

		if (localStorageSupport) {
			localStorage.setItem("boxedlayout", 'off');
		}
	}
});

// 皮肤选择
$('.spin-icon').click(function() {
	$(".theme-config-box").toggleClass("show");
	$(".skin-setttings").toggleClass("show");
});

// 默认主题
$('.s-skin-0').click(function() {

	$("body").removeClass("skin-2");
	$("body").removeClass("skin-3");
	$("body").removeClass("skin-1");
	$.get('/jeeplus/theme/default?url=' + window.top.location.href, function(result) {
	});
});

// 蓝色主题
$('.s-skin-1').click(function() {
	$("body").removeClass("skin-2");
	$("body").removeClass("skin-3");
	$("body").addClass("skin-1");
	$.get('/jeeplus/theme/cerulean?url=' + window.top.location.href, function(result) {
	});
});

// 黄色主题
$('.s-skin-3').click(function() {
	$("body").removeClass("skin-1");
	$("body").removeClass("skin-2");
	$("body").addClass("skin-3");
	$.get('/jeeplus/theme/readable?url=' + window.top.location.href, function(result) {
	});
});

if (localStorageSupport) {
	var collapse = localStorage.getItem("collapse_menu");
	var fixednavbar = localStorage.getItem("fixednavbar");
	var boxedlayout = localStorage.getItem("boxedlayout");

	if (collapse == 'on') {
		$('#collapsemenu').prop('checked', 'checked')
	}
	if (fixednavbar == 'on') {
		$('#fixednavbar').prop('checked', 'checked')
	}
	if (boxedlayout == 'on') {
		$('#boxedlayout').prop('checked', 'checked')
	}
};

$(function() {
	// 退出
	$('#logout').click(function() {
		var index = YssLayer.showConfirm("确定要退出吗？", function() {
			YssLayer.closeLayer(index);
			window.location.href = ctx + '/logout';
		});
	});
});