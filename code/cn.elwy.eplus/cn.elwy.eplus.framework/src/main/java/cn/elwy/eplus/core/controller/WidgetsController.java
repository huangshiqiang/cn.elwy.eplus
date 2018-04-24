package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Widgets;
import cn.elwy.eplus.core.service.WidgetsService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * WidgetsController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/widgets")
public class WidgetsController extends BaseController<Widgets> {

	public WidgetsController() {
		super("core/widgets");
	}

	@Autowired
	public void setService(WidgetsService service) {
		super.setService(service);
	}

}