package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.MenuBiz;
import cn.elwy.eplus.core.entity.Menu;
import cn.elwy.eplus.core.service.MenuService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * MenuService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

	@Resource
	public void setMenuBiz(MenuBiz biz) {
		super.setBiz(biz);
	}

}