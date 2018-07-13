package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.WidgetsDao;
import cn.elwy.eplus.core.entity.Widgets;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * WidgetsDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("widgetsDao")
public class WidgetsDaoImpl extends BaseDao<Widgets> implements WidgetsDao {

}