package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.LanguageBiz;
import cn.elwy.eplus.core.dao.LanguageDao;
import cn.elwy.eplus.core.entity.Language;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * LanguageBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class LanguageBizImpl extends BizImpl<Language> implements LanguageBiz {

	@Resource(name = "languageDao")
	public void setLanguageDao(LanguageDao dao) {
		super.setDao(dao);
	}

}