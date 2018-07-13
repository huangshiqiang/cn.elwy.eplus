package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.OperationBiz;
import cn.elwy.eplus.core.dao.OperationDao;
import cn.elwy.eplus.core.entity.Operation;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * OperationBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class OperationBizImpl extends BizImpl<Operation> implements OperationBiz {

	@Resource(name = "operationDao")
	public void setOperationDao(OperationDao dao) {
		super.setDao(dao);
	}

}