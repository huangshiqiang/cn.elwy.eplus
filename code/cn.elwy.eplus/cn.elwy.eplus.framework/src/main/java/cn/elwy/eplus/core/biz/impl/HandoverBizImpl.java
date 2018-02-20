package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.HandoverBiz;
import cn.elwy.eplus.core.dao.HandoverDao;
import cn.elwy.eplus.core.entity.Handover;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description HandoverBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class HandoverBizImpl extends BizImpl<Handover> implements HandoverBiz {

	@Resource(name = "handoverDao")
	public void setHandoverDao(HandoverDao dao) {
		super.setDao(dao);
	}

}