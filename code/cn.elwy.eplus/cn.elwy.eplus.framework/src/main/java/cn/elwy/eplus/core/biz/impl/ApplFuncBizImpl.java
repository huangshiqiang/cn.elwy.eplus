package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.ApplFuncBiz;
import cn.elwy.eplus.core.dao.ApplFuncDao;
import cn.elwy.eplus.core.entity.ApplFunc;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description ApplFuncBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class ApplFuncBizImpl extends BizImpl<ApplFunc> implements ApplFuncBiz {

	@Resource(name = "applFuncDao")
	public void setApplFuncDao(ApplFuncDao dao) {
		super.setDao(dao);
	}

}