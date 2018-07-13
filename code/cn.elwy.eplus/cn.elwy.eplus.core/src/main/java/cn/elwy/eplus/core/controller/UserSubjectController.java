package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserSubject;
import cn.elwy.eplus.core.service.UserSubjectService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * UserSubjectController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userSubject")
public class UserSubjectController extends BaseController<UserSubject> {

	public UserSubjectController() {
		super("core/userSubject");
	}

	@Autowired
	public void setService(UserSubjectService service) {
		super.setService(service);
	}

}