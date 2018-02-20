package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.ApplBiz;
import cn.elwy.eplus.core.dao.ApplDao;
import cn.elwy.eplus.core.entity.Appl;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description ApplBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class ApplBizImpl extends BizImpl<Appl> implements ApplBiz {

	@Resource(name = "applDao")
	public void setApplDao(ApplDao dao) {
		super.setDao(dao);
	}

}