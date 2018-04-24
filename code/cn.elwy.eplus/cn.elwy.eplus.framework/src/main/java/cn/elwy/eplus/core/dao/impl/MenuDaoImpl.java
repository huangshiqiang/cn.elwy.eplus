package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.MenuDao;
import cn.elwy.eplus.core.entity.Menu;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * MenuDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("menuDao")
public class MenuDaoImpl extends BaseDao<Menu> implements MenuDao {

}