package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserSubjectBiz;
import cn.elwy.eplus.core.entity.UserSubject;
import cn.elwy.eplus.core.service.UserSubjectService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * UserSubjectService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserSubjectServiceImpl extends BaseService<UserSubject> implements UserSubjectService {

	@Resource
	public void setUserSubjectBiz(UserSubjectBiz biz) {
		super.setBiz(biz);
	}

}