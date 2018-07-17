package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.GridDao;
import cn.elwy.eplus.core.entity.Grid;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * GridDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("gridDao")
public class GridDaoImpl extends BaseDao<Grid> implements GridDao {

}