package cn.elwy.eplus.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.common.exception.RunException;
import cn.elwy.common.model.Pageable;
import cn.elwy.common.model.Parameter;
import cn.elwy.common.model.ResultDto;
import cn.elwy.eplus.core.biz.OrgBiz;
import cn.elwy.eplus.core.biz.UserBiz;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.core.service.UserService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * UserService
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

	@Autowired
	OrgBiz orgBiz;

	@Override
	public ResultDto queryByCondition(Parameter parameter) {
		ResultDto rd = new ResultDto();
		try {
			rd.setDatas(((UserBiz) biz).queryByCondition(parameter, 10));
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

	/**
	 * 根据条件查询实体对象
	 * @param parameter 查询条件
	 * @param page 分页查询条件
	 * @return 实体对象列表
	 */
	public ResultDto queryByCondition(Parameter parameter, Pageable<User> page) {
		ResultDto queryByCondition = super.queryByCondition(parameter, page);
		try {
			List<Org> queryAll = orgBiz.queryAll();
			System.out.println(queryAll);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return queryByCondition;
	}

}