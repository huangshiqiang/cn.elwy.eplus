package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserRoleBiz;
import cn.elwy.eplus.core.entity.UserRole;
import cn.elwy.eplus.core.service.UserRoleService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserRoleService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

	@Resource
	public void setUserRoleBiz(UserRoleBiz biz) {
		super.setBiz(biz);
	}

}