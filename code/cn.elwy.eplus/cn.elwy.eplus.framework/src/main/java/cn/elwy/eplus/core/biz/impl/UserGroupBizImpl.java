package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserGroupBiz;
import cn.elwy.eplus.core.dao.UserGroupDao;
import cn.elwy.eplus.core.entity.UserGroup;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserGroupBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserGroupBizImpl extends BizImpl<UserGroup> implements UserGroupBiz {

	@Resource(name = "userGroupDao")
	public void setUserGroupDao(UserGroupDao dao) {
		super.setDao(dao);
	}

}