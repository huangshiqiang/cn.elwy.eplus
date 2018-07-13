package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.SysConfig;
import cn.elwy.eplus.core.service.SysConfigService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * SysConfigController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/sysConfig")
public class SysConfigController extends BaseController<SysConfig> {

	public SysConfigController() {
		super("core/sysConfig");
	}

	@Autowired
	public void setService(SysConfigService service) {
		super.setService(service);
	}

}