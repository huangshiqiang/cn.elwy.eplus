package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.GroupDao;
import cn.elwy.eplus.core.entity.Group;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * GroupDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("groupDao")
public class GroupDaoImpl extends BaseDao<Group> implements GroupDao {

}