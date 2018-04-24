package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.FuncOperBiz;
import cn.elwy.eplus.core.dao.FuncOperDao;
import cn.elwy.eplus.core.entity.FuncOper;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * FuncOperBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class FuncOperBizImpl extends BizImpl<FuncOper> implements FuncOperBiz {

	@Resource(name = "funcOperDao")
	public void setFuncOperDao(FuncOperDao dao) {
		super.setDao(dao);
	}

}