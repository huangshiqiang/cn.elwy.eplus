package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.RoleGroup;
import cn.elwy.eplus.core.service.RoleGroupService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description RoleGroupController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/roleGroup")
public class RoleGroupController extends BaseController<RoleGroup> {

	public RoleGroupController() {
		super("core/roleGroup");
	}

	@Autowired
	public void setService(RoleGroupService service) {
		super.setService(service);
	}

}