package cn.elwy.eplus.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.elwy.common.dao.SqlBuilder;
import cn.elwy.common.entity.Criteria;
import cn.elwy.common.entity.Pageable;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.entity.Criteria.OP;
import cn.elwy.common.exception.RunException;
import cn.elwy.eplus.core.biz.OrgBiz;
import cn.elwy.eplus.core.biz.UserBiz;
import cn.elwy.eplus.core.entity.Org;
import cn.elwy.eplus.framework.context.SpringContext;
import cn.elwy.eplus.framework.entity.User;
import cn.elwy.eplus.framework.service.BaseService;
import cn.elwy.eplus.framework.service.UserService;

/**
 * UserService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service()
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Resource
	public void setUserBiz(UserBiz biz) {
		super.setBiz(biz);
	}

	@Autowired
	OrgBiz orgBiz;

	@Override
	@Cacheable(cacheNames="CONSTANT", unless="#result==null")
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
//	@Cacheable(cacheNames="CONSTANT", unless="#result==null")
	public ResultDto queryByCondition(Parameter parameter, Pageable<User> page) {
		ResultDto queryByCondition = super.queryByCondition(parameter, page);
		try {
			Criteria c = new Criteria();
//			c.orAllLike("FUSER_NAME", "fa");
//			c.andStartLike("FUSER_CODE", "fa");
//			c.orEqualTo("FEDIT_STATE", 1);
			
			Criteria c1 = new Criteria();
			// c.setGop(gop);
			c1.orAllLike("FUSER_NAME", "fa");
			c1.orStartLike("FUSER_CODE", "fa");
			c.orCriteria(c1);
			
			Criteria c2 = new Criteria();
			// c.setGop(gop);
			c2.orAllLike("FUSER_NAME", "fa");
			c2.orStartLike("FUSER_CODE", "fa");
			c.orCriteria(c2);
			
//			c.setOp(OP.OR);
			parameter.getCriterias().add(c);

			UserBiz bean = SpringContext.getBean(UserBiz.class);
			List<User> queryAll = bean.queryByCondition(parameter);
			List<User> queryAll1 = bean.queryAll();
			
				SqlBuilder instance = SqlBuilder.getInstance(c);
				String ql = instance.buildQl();
				System.out.println(ql);
//				List<Object> valueList = instance.getValueList();

			
			
			
//			Org org = new Org();
//			org.setId("111");
//			org.setOrgType("tttt");
//			org.setOrgName("test");
//			org.setOrgCode("1111");
//			org.setLvalue(1);
//			org.setRvalue(2);
//			org.setCreateTime(new Date());
//			org.setCreatorId("11");
//			org.setEditState(0);
//			orgBiz.insert(org);
//			
//			org.setId("111");
//			org.setOrgType(null);
//			org.setOrgName("test");
//			org.setOrgCode("1111");
//			org.setLvalue(1);
//			org.setRvalue(2);
//			org.setCreateTime(new Date());
//			org.setCreatorId("11");
//			org.setEditState(0);
//			orgBiz.insert(org);
//			
//			
//			User entity = new User();
//			entity.setId("fdsa");
//			super.insert(entity );
//			System.out.println(queryAll);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return queryByCondition;
	}

}