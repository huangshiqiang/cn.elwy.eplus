package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Datasource;
import cn.elwy.eplus.core.service.DatasourceService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * DatasourceController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/datasource")
public class DatasourceController extends BaseController<Datasource> {

	public DatasourceController() {
		super("core/datasource");
	}

	@Autowired
	public void setService(DatasourceService service) {
		super.setService(service);
	}

}