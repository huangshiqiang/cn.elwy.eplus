package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.FuncAuthorityBiz;
import cn.elwy.eplus.core.entity.FuncAuthority;
import cn.elwy.eplus.core.service.FuncAuthorityService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description FuncAuthorityService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class FuncAuthorityServiceImpl extends BaseService<FuncAuthority> implements FuncAuthorityService {

	@Resource
	public void setFuncAuthorityBiz(FuncAuthorityBiz biz) {
		super.setBiz(biz);
	}

}