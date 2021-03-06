package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.HandDetailBiz;
import cn.elwy.eplus.core.entity.HandDetail;
import cn.elwy.eplus.core.service.HandDetailService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * HandDetailService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class HandDetailServiceImpl extends BaseService<HandDetail> implements HandDetailService {

	@Resource
	public void setHandDetailBiz(HandDetailBiz biz) {
		super.setBiz(biz);
	}

}