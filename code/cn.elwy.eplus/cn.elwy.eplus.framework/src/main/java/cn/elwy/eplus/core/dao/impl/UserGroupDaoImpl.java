package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserGroupDao;
import cn.elwy.eplus.core.entity.UserGroup;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description UserGroupDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userGroupDao")
public class UserGroupDaoImpl extends BaseDao<UserGroup> implements UserGroupDao {

}