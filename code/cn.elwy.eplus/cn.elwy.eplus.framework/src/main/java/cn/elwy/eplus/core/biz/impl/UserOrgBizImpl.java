package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserOrgBiz;
import cn.elwy.eplus.core.dao.UserOrgDao;
import cn.elwy.eplus.core.entity.UserOrg;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserOrgBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserOrgBizImpl extends BizImpl<UserOrg> implements UserOrgBiz {

	@Resource(name = "userOrgDao")
	public void setUserOrgDao(UserOrgDao dao) {
		super.setDao(dao);
	}

}