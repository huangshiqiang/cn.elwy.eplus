package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserGroup;
import cn.elwy.eplus.core.service.UserGroupService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description UserGroupController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userGroup")
public class UserGroupController extends BaseController<UserGroup> {

	public UserGroupController() {
		super("core/userGroup");
	}

	@Autowired
	public void setService(UserGroupService service) {
		super.setService(service);
	}

}