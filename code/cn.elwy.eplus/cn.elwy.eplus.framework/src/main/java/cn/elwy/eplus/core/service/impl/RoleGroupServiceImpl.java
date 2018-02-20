package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.RoleGroupBiz;
import cn.elwy.eplus.core.entity.RoleGroup;
import cn.elwy.eplus.core.service.RoleGroupService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description RoleGroupService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class RoleGroupServiceImpl extends BaseService<RoleGroup> implements RoleGroupService {

	@Resource
	public void setRoleGroupBiz(RoleGroupBiz biz) {
		super.setBiz(biz);
	}

}