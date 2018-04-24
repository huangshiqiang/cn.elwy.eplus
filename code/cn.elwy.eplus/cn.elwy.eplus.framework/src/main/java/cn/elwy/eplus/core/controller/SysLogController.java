package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.SysLog;
import cn.elwy.eplus.core.service.SysLogService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * SysLogController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/sysLog")
public class SysLogController extends BaseController<SysLog> {

	public SysLogController() {
		super("core/sysLog");
	}

	@Autowired
	public void setService(SysLogService service) {
		super.setService(service);
	}

}