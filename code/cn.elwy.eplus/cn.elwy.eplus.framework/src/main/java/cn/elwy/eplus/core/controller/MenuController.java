package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Menu;
import cn.elwy.eplus.core.service.MenuService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * MenuController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController<Menu> {

	public MenuController() {
		super("core/menu");
	}

	@Autowired
	public void setService(MenuService service) {
		super.setService(service);
	}

}