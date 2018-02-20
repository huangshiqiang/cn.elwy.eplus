package cn.elwy.eplus.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user1")
public class EditorController {

	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "HelloMVC");
		mv.setViewName("users");
		return mv;
	}

}
