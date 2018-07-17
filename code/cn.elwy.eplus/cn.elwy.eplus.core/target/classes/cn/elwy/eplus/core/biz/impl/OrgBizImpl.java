package cn.elwy.eplus.core.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.OrgBiz;
import cn.elwy.eplus.core.dao.OrgDao;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.framework.annotation.DS;
import cn.elwy.eplus.framework.annotation.DS.DsId;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * OrgBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class OrgBizImpl extends BizImpl<Org> implements OrgBiz {

	@Resource(name = "orgDao")
	public void setOrgDao(OrgDao dao) {
		super.setDao(dao);
	}

	@Override
	@DS(DsId.cluster)
	public List<Org> queryAll() {
		return super.queryAll();
	}
}