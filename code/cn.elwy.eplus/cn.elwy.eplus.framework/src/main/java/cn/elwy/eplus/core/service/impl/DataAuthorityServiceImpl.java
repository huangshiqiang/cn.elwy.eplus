package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.DataAuthorityBiz;
import cn.elwy.eplus.core.entity.DataAuthority;
import cn.elwy.eplus.core.service.DataAuthorityService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * DataAuthorityService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class DataAuthorityServiceImpl extends BaseService<DataAuthority> implements DataAuthorityService {

	@Resource
	public void setDataAuthorityBiz(DataAuthorityBiz biz) {
		super.setBiz(biz);
	}

}