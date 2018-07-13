package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.LanguageBiz;
import cn.elwy.eplus.core.entity.Language;
import cn.elwy.eplus.core.service.LanguageService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * LanguageService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class LanguageServiceImpl extends BaseService<Language> implements LanguageService {

	@Resource
	public void setLanguageBiz(LanguageBiz biz) {
		super.setBiz(biz);
	}

}