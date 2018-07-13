package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.DictI18n;
import cn.elwy.eplus.core.service.DictI18nService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * DictI18nController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/dictI18n")
public class DictI18nController extends BaseController<DictI18n> {

	public DictI18nController() {
		super("core/dictI18n");
	}

	@Autowired
	public void setService(DictI18nService service) {
		super.setService(service);
	}

}