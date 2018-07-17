package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserSubjectBiz;
import cn.elwy.eplus.core.dao.UserSubjectDao;
import cn.elwy.eplus.core.entity.UserSubject;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * UserSubjectBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserSubjectBizImpl extends BizImpl<UserSubject> implements UserSubjectBiz {

	@Resource(name = "userSubjectDao")
	public void setUserSubjectDao(UserSubjectDao dao) {
		super.setDao(dao);
	}

}