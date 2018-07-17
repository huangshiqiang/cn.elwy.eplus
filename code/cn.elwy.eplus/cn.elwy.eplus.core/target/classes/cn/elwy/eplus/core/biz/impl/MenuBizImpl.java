package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.MenuBiz;
import cn.elwy.eplus.core.dao.MenuDao;
import cn.elwy.eplus.core.entity.Menu;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * MenuBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class MenuBizImpl extends BizImpl<Menu> implements MenuBiz {

	@Resource(name = "menuDao")
	public void setMenuDao(MenuDao dao) {
		super.setDao(dao);
	}

}