package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.UserConfigDao;
import cn.elwy.eplus.core.entity.UserConfig;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * UserConfigDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("userConfigDao")
public class UserConfigDaoImpl extends BaseDao<UserConfig> implements UserConfigDao {

}