package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.FuncOper;
import cn.elwy.eplus.core.service.FuncOperService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * FuncOperController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/funcOper")
public class FuncOperController extends BaseController<FuncOper> {

	public FuncOperController() {
		super("core/funcOper");
	}

	@Autowired
	public void setService(FuncOperService service) {
		super.setService(service);
	}

}