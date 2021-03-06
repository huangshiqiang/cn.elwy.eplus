package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.HandoverBiz;
import cn.elwy.eplus.core.entity.Handover;
import cn.elwy.eplus.core.service.HandoverService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * HandoverService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class HandoverServiceImpl extends BaseService<Handover> implements HandoverService {

	@Resource
	public void setHandoverBiz(HandoverBiz biz) {
		super.setBiz(biz);
	}

}