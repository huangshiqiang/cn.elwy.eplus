package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.DataAcl;
import cn.elwy.eplus.core.service.DataAclService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * DataAclController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/dataAcl")
public class DataAclController extends BaseController<DataAcl> {

	public DataAclController() {
		super("core/dataAcl");
	}

	@Autowired
	public void setService(DataAclService service) {
		super.setService(service);
	}

}