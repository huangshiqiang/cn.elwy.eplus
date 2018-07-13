package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.FuncOperBiz;
import cn.elwy.eplus.core.entity.FuncOper;
import cn.elwy.eplus.core.service.FuncOperService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * FuncOperService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class FuncOperServiceImpl extends BaseService<FuncOper> implements FuncOperService {

	@Resource
	public void setFuncOperBiz(FuncOperBiz biz) {
		super.setBiz(biz);
	}

}