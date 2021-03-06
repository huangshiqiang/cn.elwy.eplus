package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.DictDao;
import cn.elwy.eplus.core.entity.Dict;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * DictDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("dictDao")
public class DictDaoImpl extends BaseDao<Dict> implements DictDao {

}