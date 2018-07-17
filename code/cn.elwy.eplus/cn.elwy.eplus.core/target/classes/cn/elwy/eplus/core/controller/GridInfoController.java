package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.GridInfo;
import cn.elwy.eplus.core.service.GridInfoService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * GridInfoController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/gridInfo")
public class GridInfoController extends BaseController<GridInfo> {

	public GridInfoController() {
		super("core/gridInfo");
	}

	@Autowired
	public void setService(GridInfoService service) {
		super.setService(service);
	}

}