package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Role;
import cn.elwy.eplus.core.service.RoleService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * RoleController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController<Role> {

	public RoleController() {
		super("core/role");
	}

	@Autowired
	public void setService(RoleService service) {
		super.setService(service);
	}

}