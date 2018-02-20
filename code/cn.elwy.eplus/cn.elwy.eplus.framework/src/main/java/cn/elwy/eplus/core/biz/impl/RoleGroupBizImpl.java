package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.RoleGroupBiz;
import cn.elwy.eplus.core.dao.RoleGroupDao;
import cn.elwy.eplus.core.entity.RoleGroup;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description RoleGroupBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class RoleGroupBizImpl extends BizImpl<RoleGroup> implements RoleGroupBiz {

	@Resource(name = "roleGroupDao")
	public void setRoleGroupDao(RoleGroupDao dao) {
		super.setDao(dao);
	}

}