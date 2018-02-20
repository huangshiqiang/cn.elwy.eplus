package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Group;
import cn.elwy.eplus.core.service.GroupService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description GroupController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/group")
public class GroupController extends BaseController<Group> {

	public GroupController() {
		super("core/group");
	}

	@Autowired
	public void setService(GroupService service) {
		super.setService(service);
	}

}