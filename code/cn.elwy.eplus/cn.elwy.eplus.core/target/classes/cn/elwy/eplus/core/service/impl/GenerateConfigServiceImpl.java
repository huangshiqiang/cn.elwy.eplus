package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.GenerateConfigBiz;
import cn.elwy.eplus.core.entity.GenerateConfig;
import cn.elwy.eplus.core.service.GenerateConfigService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * GenerateConfigService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class GenerateConfigServiceImpl extends BaseService<GenerateConfig> implements GenerateConfigService {

	@Resource
	public void setGenerateConfigBiz(GenerateConfigBiz biz) {
		super.setBiz(biz);
	}

}