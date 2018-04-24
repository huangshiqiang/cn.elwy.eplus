package cn.elwy.eplus.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexController {

	@RequestMapping("/")
	public String index() {
		return "forward:/index.html";
	}
}