package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.FunctionBiz;
import cn.elwy.eplus.core.entity.Function;
import cn.elwy.eplus.core.service.FunctionService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * FunctionService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class FunctionServiceImpl extends BaseService<Function> implements FunctionService {

	@Resource
	public void setFunctionBiz(FunctionBiz biz) {
		super.setBiz(biz);
	}

}