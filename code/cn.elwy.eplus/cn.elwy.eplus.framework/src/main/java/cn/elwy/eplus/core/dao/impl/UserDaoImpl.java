package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserDao;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description UserDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

}