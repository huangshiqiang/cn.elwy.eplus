package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.OrgBiz;
import cn.elwy.eplus.core.dao.OrgDao;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description OrgBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class OrgBizImpl extends BizImpl<Org> implements OrgBiz {

	@Resource(name = "orgDao")
	public void setOrgDao(OrgDao dao) {
		super.setDao(dao);
	}

}