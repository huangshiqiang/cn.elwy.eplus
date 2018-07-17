package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.DictI18nBiz;
import cn.elwy.eplus.core.dao.DictI18nDao;
import cn.elwy.eplus.core.entity.DictI18n;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * DictI18nBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class DictI18nBizImpl extends BizImpl<DictI18n> implements DictI18nBiz {

	@Resource(name = "dictI18nDao")
	public void setDictI18nDao(DictI18nDao dao) {
		super.setDao(dao);
	}

}