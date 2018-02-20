package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserPostDao;
import cn.elwy.eplus.core.entity.UserPost;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description UserPostDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userPostDao")
public class UserPostDaoImpl extends BaseDao<UserPost> implements UserPostDao {

}