package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.ModuleDao;
import cn.elwy.eplus.core.entity.Module;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * ModuleDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("moduleDao")
public class ModuleDaoImpl extends BaseDao<Module> implements ModuleDao {

}