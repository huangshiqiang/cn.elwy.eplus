package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.FunctionBiz;
import cn.elwy.eplus.core.dao.FunctionDao;
import cn.elwy.eplus.core.entity.Function;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * FunctionBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class FunctionBizImpl extends BizImpl<Function> implements FunctionBiz {

	@Resource(name = "functionDao")
	public void setFunctionDao(FunctionDao dao) {
		super.setDao(dao);
	}

}