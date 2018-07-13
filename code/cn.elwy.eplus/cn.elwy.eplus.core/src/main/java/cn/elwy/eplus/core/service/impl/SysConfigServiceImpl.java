package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.SysConfigBiz;
import cn.elwy.eplus.core.entity.SysConfig;
import cn.elwy.eplus.core.service.SysConfigService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * SysConfigService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class SysConfigServiceImpl extends BaseService<SysConfig> implements SysConfigService {

	@Resource
	public void setSysConfigBiz(SysConfigBiz biz) {
		super.setBiz(biz);
	}

}