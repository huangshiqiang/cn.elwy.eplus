package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserRoleDao;
import cn.elwy.eplus.core.entity.UserRole;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description UserRoleDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDao<UserRole> implements UserRoleDao {

}