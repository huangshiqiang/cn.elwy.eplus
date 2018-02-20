package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserOrgBiz;
import cn.elwy.eplus.core.entity.UserOrg;
import cn.elwy.eplus.core.service.UserOrgService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserOrgService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserOrgServiceImpl extends BaseService<UserOrg> implements UserOrgService {

	@Resource
	public void setUserOrgBiz(UserOrgBiz biz) {
		super.setBiz(biz);
	}

}