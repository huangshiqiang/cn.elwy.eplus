package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.RoleBiz;
import cn.elwy.eplus.core.entity.Role;
import cn.elwy.eplus.core.service.RoleService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description RoleService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

	@Resource
	public void setRoleBiz(RoleBiz biz) {
		super.setBiz(biz);
	}

}