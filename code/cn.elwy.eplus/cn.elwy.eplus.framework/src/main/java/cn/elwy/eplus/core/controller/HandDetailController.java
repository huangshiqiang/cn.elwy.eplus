package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.HandDetail;
import cn.elwy.eplus.core.service.HandDetailService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * HandDetailController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/handDetail")
public class HandDetailController extends BaseController<HandDetail> {

	public HandDetailController() {
		super("core/handDetail");
	}

	@Autowired
	public void setService(HandDetailService service) {
		super.setService(service);
	}

}