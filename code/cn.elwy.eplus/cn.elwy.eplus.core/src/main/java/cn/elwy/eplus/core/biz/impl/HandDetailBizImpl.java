package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.HandDetailBiz;
import cn.elwy.eplus.core.dao.HandDetailDao;
import cn.elwy.eplus.core.entity.HandDetail;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * HandDetailBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class HandDetailBizImpl extends BizImpl<HandDetail> implements HandDetailBiz {

	@Resource(name = "handDetailDao")
	public void setHandDetailDao(HandDetailDao dao) {
		super.setDao(dao);
	}

}