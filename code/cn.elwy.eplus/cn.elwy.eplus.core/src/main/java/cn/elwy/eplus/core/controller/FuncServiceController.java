package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.FuncService;
import cn.elwy.eplus.core.service.FuncServiceService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * FuncServiceController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/funcService")
public class FuncServiceController extends BaseController<FuncService> {

	public FuncServiceController() {
		super("core/funcService");
	}

	@Autowired
	public void setService(FuncServiceService service) {
		super.setService(service);
	}

}