package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.LanguageDao;
import cn.elwy.eplus.core.entity.Language;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * LanguageDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("languageDao")
public class LanguageDaoImpl extends BaseDao<Language> implements LanguageDao {

}