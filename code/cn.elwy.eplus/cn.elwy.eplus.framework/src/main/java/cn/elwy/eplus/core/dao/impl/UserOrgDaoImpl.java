package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserOrgDao;
import cn.elwy.eplus.core.entity.UserOrg;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description UserOrgDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userOrgDao")
public class UserOrgDaoImpl extends BaseDao<UserOrg> implements UserOrgDao {

}