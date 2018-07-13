package cn.elwy.eplus.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Demo;

/**
 * ApplController
 * @author elwy
 * @version 2017-10-22
 */
@RestController
public class DemoController {

	@RequestMapping("/demo")
	public String demo(Model model) {
		model.addAttribute("demo", new Demo());
		return "/demo";
	}

	@RequestMapping("/demoAdd")
	public String demoAdd(@Valid Demo demo, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("demo", demo);
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
			}

			return "demo";
		}
		return "/demo";
	}

}