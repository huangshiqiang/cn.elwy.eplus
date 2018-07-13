package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Grid;
import cn.elwy.eplus.core.service.GridService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * GridController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/grid")
public class GridController extends BaseController<Grid> {

	public GridController() {
		super("core/grid");
	}

	@Autowired
	public void setService(GridService service) {
		super.setService(service);
	}

}