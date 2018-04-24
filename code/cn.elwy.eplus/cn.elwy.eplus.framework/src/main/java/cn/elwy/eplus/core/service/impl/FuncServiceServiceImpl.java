package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.FuncServiceBiz;
import cn.elwy.eplus.core.entity.FuncService;
import cn.elwy.eplus.core.service.FuncServiceService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * FuncServiceService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class FuncServiceServiceImpl extends BaseService<FuncService> implements FuncServiceService {

	@Resource
	public void setFuncServiceBiz(FuncServiceBiz biz) {
		super.setBiz(biz);
	}

}