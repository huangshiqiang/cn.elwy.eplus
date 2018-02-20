package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Handover;
import cn.elwy.eplus.core.service.HandoverService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description HandoverController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/handover")
public class HandoverController extends BaseController<Handover> {

	public HandoverController() {
		super("core/handover");
	}

	@Autowired
	public void setService(HandoverService service) {
		super.setService(service);
	}

}