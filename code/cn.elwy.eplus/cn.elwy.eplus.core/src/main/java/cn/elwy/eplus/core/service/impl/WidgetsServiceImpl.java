package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.WidgetsBiz;
import cn.elwy.eplus.core.entity.Widgets;
import cn.elwy.eplus.core.service.WidgetsService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * WidgetsService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class WidgetsServiceImpl extends BaseService<Widgets> implements WidgetsService {

	@Resource
	public void setWidgetsBiz(WidgetsBiz biz) {
		super.setBiz(biz);
	}

}