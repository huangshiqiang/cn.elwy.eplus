package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserConfig;
import cn.elwy.eplus.core.service.UserConfigService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description UserConfigController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userConfig")
public class UserConfigController extends BaseController<UserConfig> {

	public UserConfigController() {
		super("core/userConfig");
	}

	@Autowired
	public void setService(UserConfigService service) {
		super.setService(service);
	}

}