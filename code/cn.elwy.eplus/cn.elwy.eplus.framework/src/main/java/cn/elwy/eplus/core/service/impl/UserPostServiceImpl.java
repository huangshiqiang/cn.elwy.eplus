package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserPostBiz;
import cn.elwy.eplus.core.entity.UserPost;
import cn.elwy.eplus.core.service.UserPostService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserPostService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserPostServiceImpl extends BaseService<UserPost> implements UserPostService {

	@Resource
	public void setUserPostBiz(UserPostBiz biz) {
		super.setBiz(biz);
	}

}