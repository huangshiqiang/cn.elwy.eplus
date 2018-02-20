package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.ApplFuncBiz;
import cn.elwy.eplus.core.entity.ApplFunc;
import cn.elwy.eplus.core.service.ApplFuncService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description ApplFuncService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class ApplFuncServiceImpl extends BaseService<ApplFunc> implements ApplFuncService {

	@Resource
	public void setApplFuncBiz(ApplFuncBiz biz) {
		super.setBiz(biz);
	}

}