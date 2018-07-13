package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.GenerateCode;
import cn.elwy.eplus.core.service.GenerateCodeService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * GenerateCodeController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/generateCode")
public class GenerateCodeController extends BaseController<GenerateCode> {

	public GenerateCodeController() {
		super("core/generateCode");
	}

	@Autowired
	public void setService(GenerateCodeService service) {
		super.setService(service);
	}

}