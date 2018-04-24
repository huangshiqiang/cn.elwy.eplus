package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.PostDao;
import cn.elwy.eplus.core.entity.Post;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * PostDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("postDao")
public class PostDaoImpl extends BaseDao<Post> implements PostDao {

}