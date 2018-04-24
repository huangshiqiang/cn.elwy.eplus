package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.DataAclBiz;
import cn.elwy.eplus.core.entity.DataAcl;
import cn.elwy.eplus.core.service.DataAclService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * DataAclService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class DataAclServiceImpl extends BaseService<DataAcl> implements DataAclService {

	@Resource
	public void setDataAclBiz(DataAclBiz biz) {
		super.setBiz(biz);
	}

}