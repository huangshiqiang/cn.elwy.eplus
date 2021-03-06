package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.OrgBiz;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.core.service.OrgService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * OrgService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class OrgServiceImpl extends BaseService<Org> implements OrgService {

	@Resource
	public void setOrgBiz(OrgBiz biz) {
		super.setBiz(biz);
	}

}