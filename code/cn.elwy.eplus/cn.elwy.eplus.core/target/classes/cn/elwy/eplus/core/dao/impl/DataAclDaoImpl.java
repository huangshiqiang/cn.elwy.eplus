package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.DataAclDao;
import cn.elwy.eplus.core.entity.DataAcl;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * DataAclDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("dataAclDao")
public class DataAclDaoImpl extends BaseDao<DataAcl> implements DataAclDao {

}