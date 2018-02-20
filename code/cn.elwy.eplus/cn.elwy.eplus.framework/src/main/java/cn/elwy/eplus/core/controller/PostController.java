package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Post;
import cn.elwy.eplus.core.service.PostService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description PostController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/post")
public class PostController extends BaseController<Post> {

	public PostController() {
		super("core/post");
	}

	@Autowired
	public void setService(PostService service) {
		super.setService(service);
	}

}