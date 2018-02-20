package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.ApplBiz;
import cn.elwy.eplus.core.entity.Appl;
import cn.elwy.eplus.core.service.ApplService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description ApplService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class ApplServiceImpl extends BaseService<Appl> implements ApplService {

	@Resource
	public void setApplBiz(ApplBiz biz) {
		super.setBiz(biz);
	}

}