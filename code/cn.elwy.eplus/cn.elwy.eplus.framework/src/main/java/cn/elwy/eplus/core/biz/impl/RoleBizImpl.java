package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.RoleBiz;
import cn.elwy.eplus.core.dao.RoleDao;
import cn.elwy.eplus.core.entity.Role;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description RoleBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class RoleBizImpl extends BizImpl<Role> implements RoleBiz {

	@Resource(name = "roleDao")
	public void setRoleDao(RoleDao dao) {
		super.setDao(dao);
	}

}