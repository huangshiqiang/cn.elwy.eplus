package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.FieldAuthorityBiz;
import cn.elwy.eplus.core.entity.FieldAuthority;
import cn.elwy.eplus.core.service.FieldAuthorityService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description FieldAuthorityService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class FieldAuthorityServiceImpl extends BaseService<FieldAuthority> implements FieldAuthorityService {

	@Resource
	public void setFieldAuthorityBiz(FieldAuthorityBiz biz) {
		super.setBiz(biz);
	}

}