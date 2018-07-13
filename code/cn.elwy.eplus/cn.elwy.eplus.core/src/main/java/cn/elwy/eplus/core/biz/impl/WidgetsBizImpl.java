package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.WidgetsBiz;
import cn.elwy.eplus.core.dao.WidgetsDao;
import cn.elwy.eplus.core.entity.Widgets;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * WidgetsBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class WidgetsBizImpl extends BizImpl<Widgets> implements WidgetsBiz {

	@Resource(name = "widgetsDao")
	public void setWidgetsDao(WidgetsDao dao) {
		super.setDao(dao);
	}

}