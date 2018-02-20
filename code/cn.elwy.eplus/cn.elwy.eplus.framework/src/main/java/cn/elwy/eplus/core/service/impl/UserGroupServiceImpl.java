package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserGroupBiz;
import cn.elwy.eplus.core.entity.UserGroup;
import cn.elwy.eplus.core.service.UserGroupService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserGroupService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserGroupServiceImpl extends BaseService<UserGroup> implements UserGroupService {

	@Resource
	public void setUserGroupBiz(UserGroupBiz biz) {
		super.setBiz(biz);
	}

}