package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.exception.RunException;
import cn.elwy.eplus.core.biz.UserBiz;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.core.service.UserService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Resource
	public void setUserBiz(UserBiz biz) {
		super.setBiz(biz);
	}

	@Override
	public ResultDto queryByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setData(((UserBiz) biz).queryByCondition(parameter, 10));
		} catch (RunException e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		} catch (Exception e) {
			rd.setSuccess(false);
			rd.setMessage(e.getMessage());
			rd.setDetailMesssage(e);
		}
		return rd;
	}
}