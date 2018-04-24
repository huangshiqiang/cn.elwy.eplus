package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.OperationDao;
import cn.elwy.eplus.core.entity.Operation;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * OperationDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("operationDao")
public class OperationDaoImpl extends BaseDao<Operation> implements OperationDao {

}