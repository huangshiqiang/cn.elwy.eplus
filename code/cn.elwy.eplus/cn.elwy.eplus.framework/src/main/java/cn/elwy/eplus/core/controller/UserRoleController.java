package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserRole;
import cn.elwy.eplus.core.service.UserRoleService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description UserRoleController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userRole")
public class UserRoleController extends BaseController<UserRole> {

	public UserRoleController() {
		super("core/userRole");
	}

	@Autowired
	public void setService(UserRoleService service) {
		super.setService(service);
	}

}