package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.DictI18nBiz;
import cn.elwy.eplus.core.entity.DictI18n;
import cn.elwy.eplus.core.service.DictI18nService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * DictI18nService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class DictI18nServiceImpl extends BaseService<DictI18n> implements DictI18nService {

	@Resource
	public void setDictI18nBiz(DictI18nBiz biz) {
		super.setBiz(biz);
	}

}