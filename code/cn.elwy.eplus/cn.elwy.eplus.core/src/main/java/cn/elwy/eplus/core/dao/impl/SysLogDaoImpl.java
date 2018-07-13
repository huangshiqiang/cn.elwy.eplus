package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.SysLogDao;
import cn.elwy.eplus.core.entity.SysLog;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * SysLogDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("sysLogDao")
public class SysLogDaoImpl extends BaseDao<SysLog> implements SysLogDao {

}