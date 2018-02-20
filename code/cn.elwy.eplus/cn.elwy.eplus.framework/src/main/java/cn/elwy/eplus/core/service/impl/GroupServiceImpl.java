package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.GroupBiz;
import cn.elwy.eplus.core.entity.Group;
import cn.elwy.eplus.core.service.GroupService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description GroupService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class GroupServiceImpl extends BaseService<Group> implements GroupService {

	@Resource
	public void setGroupBiz(GroupBiz biz) {
		super.setBiz(biz);
	}

}