package cn.elwy.eplus.core.dao.impl;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.core.dao.OrgDao;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.framework.annotation.DS.DsId;
import cn.elwy.eplus.framework.dao.BaseDao;

/**
 * OrgDao实现类
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Repository("orgDao")
public class OrgDaoImpl extends BaseDao<Org> implements OrgDao {

	@Override
	public String getDsId() {
		return DsId.cluster.name();
	}
}