package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Function;
import cn.elwy.eplus.core.service.FunctionService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * FunctionController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/function")
public class FunctionController extends BaseController<Function> {

	public FunctionController() {
		super("core/function");
	}

	@Autowired
	public void setService(FunctionService service) {
		super.setService(service);
	}

}