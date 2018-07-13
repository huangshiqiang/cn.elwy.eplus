package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Module;
import cn.elwy.eplus.core.service.ModuleService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * ModuleController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/module")
public class ModuleController extends BaseController<Module> {

	public ModuleController() {
		super("core/module");
	}

	@Autowired
	public void setService(ModuleService service) {
		super.setService(service);
	}

}