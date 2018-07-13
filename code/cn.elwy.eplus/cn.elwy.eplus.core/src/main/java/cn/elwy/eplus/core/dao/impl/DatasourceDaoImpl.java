package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.DatasourceDao;
import cn.elwy.eplus.core.entity.Datasource;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * DatasourceDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("datasourceDao")
public class DatasourceDaoImpl extends BaseDao<Datasource> implements DatasourceDao {

}