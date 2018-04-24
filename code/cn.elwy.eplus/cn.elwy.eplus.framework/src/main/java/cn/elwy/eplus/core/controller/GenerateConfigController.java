package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.GenerateConfig;
import cn.elwy.eplus.core.service.GenerateConfigService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * GenerateConfigController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/generateConfig")
public class GenerateConfigController extends BaseController<GenerateConfig> {

	public GenerateConfigController() {
		super("core/generateConfig");
	}

	@Autowired
	public void setService(GenerateConfigService service) {
		super.setService(service);
	}

}