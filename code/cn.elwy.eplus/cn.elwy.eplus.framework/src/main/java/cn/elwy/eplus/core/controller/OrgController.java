package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.core.service.OrgService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description OrgController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/org")
public class OrgController extends BaseController<Org> {

	public OrgController() {
		super("core/org");
	}

	@Autowired
	public void setService(OrgService service) {
		super.setService(service);
	}

}