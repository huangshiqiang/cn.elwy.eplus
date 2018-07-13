package cn.elwy.eplus.framework.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.elwy.eplus.framework.support.ControllerSupport;

@Controller
class IndexController {

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "index");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "home");
		return mv;
	}

	@RequestMapping(value = "/main")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mv = ControllerSupport.getView(request, "main");
		return mv;
	}

}