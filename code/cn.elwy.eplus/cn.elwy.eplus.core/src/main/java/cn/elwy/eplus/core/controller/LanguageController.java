package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Language;
import cn.elwy.eplus.core.service.LanguageService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * LanguageController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/language")
public class LanguageController extends BaseController<Language> {

	public LanguageController() {
		super("core/language");
	}

	@Autowired
	public void setService(LanguageService service) {
		super.setService(service);
	}

}