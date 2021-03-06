package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.FieldAuthority;
import cn.elwy.eplus.core.service.FieldAuthorityService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * FieldAuthorityController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/fieldAuthority")
public class FieldAuthorityController extends BaseController<FieldAuthority> {

	public FieldAuthorityController() {
		super("core/fieldAuthority");
	}

	@Autowired
	public void setService(FieldAuthorityService service) {
		super.setService(service);
	}

}