package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserPostBiz;
import cn.elwy.eplus.core.dao.UserPostDao;
import cn.elwy.eplus.core.entity.UserPost;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserPostBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserPostBizImpl extends BizImpl<UserPost> implements UserPostBiz {

	@Resource(name = "userPostDao")
	public void setUserPostDao(UserPostDao dao) {
		super.setDao(dao);
	}

}