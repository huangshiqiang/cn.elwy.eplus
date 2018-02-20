package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.HandoverDao;
import cn.elwy.eplus.core.entity.Handover;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * @description HandoverDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("handoverDao")
public class HandoverDaoImpl extends BaseDao<Handover> implements HandoverDao {

}