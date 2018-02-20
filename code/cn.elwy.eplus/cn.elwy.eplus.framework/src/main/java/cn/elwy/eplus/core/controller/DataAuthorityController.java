package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.DataAuthority;
import cn.elwy.eplus.core.service.DataAuthorityService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * @description DataAuthorityController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/dataAuthority")
public class DataAuthorityController extends BaseController<DataAuthority> {

	public DataAuthorityController() {
		super("core/dataAuthority");
	}

	@Autowired
	public void setService(DataAuthorityService service) {
		super.setService(service);
	}

}