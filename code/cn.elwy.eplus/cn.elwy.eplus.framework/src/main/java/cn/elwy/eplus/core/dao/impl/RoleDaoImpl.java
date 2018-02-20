package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.RoleDao;
import cn.elwy.eplus.core.entity.Role;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description RoleDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<Role> implements RoleDao {

}