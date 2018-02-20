package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.GroupBiz;
import cn.elwy.eplus.core.dao.GroupDao;
import cn.elwy.eplus.core.entity.Group;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description GroupBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class GroupBizImpl extends BizImpl<Group> implements GroupBiz {

	@Resource(name = "groupDao")
	public void setGroupDao(GroupDao dao) {
		super.setDao(dao);
	}

}