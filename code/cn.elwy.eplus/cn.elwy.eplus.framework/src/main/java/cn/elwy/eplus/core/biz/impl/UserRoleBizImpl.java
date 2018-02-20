package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserRoleBiz;
import cn.elwy.eplus.core.dao.UserRoleDao;
import cn.elwy.eplus.core.entity.UserRole;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserRoleBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserRoleBizImpl extends BizImpl<UserRole> implements UserRoleBiz {

	@Resource(name = "userRoleDao")
	public void setUserRoleDao(UserRoleDao dao) {
		super.setDao(dao);
	}

}