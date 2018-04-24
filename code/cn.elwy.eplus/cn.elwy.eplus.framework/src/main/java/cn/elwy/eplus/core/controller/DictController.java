package cn.elwy.eplus.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.elwy.eplus.core.entity.Dict;
import cn.elwy.eplus.core.service.DictService;
import cn.elwy.eplus.framework.controller.BaseController;

/**
 * DictController
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@RestController
@RequestMapping(value = "/dict")
public class DictController extends BaseController<Dict> {

	public DictController() {
		super("core/dict");
	}

	@Autowired
	public void setService(DictService service) {
		super.setService(service);
	}

}