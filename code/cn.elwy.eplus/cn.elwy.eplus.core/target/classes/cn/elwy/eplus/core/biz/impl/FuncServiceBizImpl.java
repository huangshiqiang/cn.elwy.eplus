package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.FuncServiceBiz;
import cn.elwy.eplus.core.dao.FuncServiceDao;
import cn.elwy.eplus.core.entity.FuncService;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * FuncServiceBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class FuncServiceBizImpl extends BizImpl<FuncService> implements FuncServiceBiz {

	@Resource(name = "funcServiceDao")
	public void setFuncServiceDao(FuncServiceDao dao) {
		super.setDao(dao);
	}

}