package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.OperationBiz;
import cn.elwy.eplus.core.entity.Operation;
import cn.elwy.eplus.core.service.OperationService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * OperationService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class OperationServiceImpl extends BaseService<Operation> implements OperationService {

	@Resource
	public void setOperationBiz(OperationBiz biz) {
		super.setBiz(biz);
	}

}