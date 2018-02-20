package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserOrg;
import cn.elwy.eplus.core.service.UserOrgService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description UserOrgController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userOrg")
public class UserOrgController extends BaseController<UserOrg> {

	public UserOrgController() {
		super("core/userOrg");
	}

	@Autowired
	public void setService(UserOrgService service) {
		super.setService(service);
	}

}