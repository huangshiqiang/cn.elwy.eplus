package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.FunctionDao;
import cn.elwy.eplus.core.entity.Function;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * FunctionDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDao<Function> implements FunctionDao {

}