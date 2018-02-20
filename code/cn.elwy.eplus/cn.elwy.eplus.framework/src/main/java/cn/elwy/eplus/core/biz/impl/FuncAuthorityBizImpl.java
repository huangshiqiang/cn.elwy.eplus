package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.FuncAuthorityBiz;
import cn.elwy.eplus.core.dao.FuncAuthorityDao;
import cn.elwy.eplus.core.entity.FuncAuthority;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description FuncAuthorityBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class FuncAuthorityBizImpl extends BizImpl<FuncAuthority> implements FuncAuthorityBiz {

	@Resource(name = "funcAuthorityDao")
	public void setFuncAuthorityDao(FuncAuthorityDao dao) {
		super.setDao(dao);
	}

}