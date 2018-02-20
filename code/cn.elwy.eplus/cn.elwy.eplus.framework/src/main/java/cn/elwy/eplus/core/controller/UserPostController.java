package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.UserPost;
import cn.elwy.eplus.core.service.UserPostService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description UserPostController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/userPost")
public class UserPostController extends BaseController<UserPost> {

	public UserPostController() {
		super("core/userPost");
	}

	@Autowired
	public void setService(UserPostService service) {
		super.setService(service);
	}

}