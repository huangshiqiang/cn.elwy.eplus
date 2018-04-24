package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Operation;
import cn.elwy.eplus.core.service.OperationService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * OperationController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/operation")
public class OperationController extends BaseController<Operation> {

	public OperationController() {
		super("core/operation");
	}

	@Autowired
	public void setService(OperationService service) {
		super.setService(service);
	}

}