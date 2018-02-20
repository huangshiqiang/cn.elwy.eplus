package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.ApplFunc;
import cn.elwy.eplus.core.service.ApplFuncService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description ApplFuncController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/applFunc")
public class ApplFuncController extends BaseController<ApplFunc> {

	public ApplFuncController() {
		super("core/applFunc");
	}

	@Autowired
	public void setService(ApplFuncService service) {
		super.setService(service);
	}

}