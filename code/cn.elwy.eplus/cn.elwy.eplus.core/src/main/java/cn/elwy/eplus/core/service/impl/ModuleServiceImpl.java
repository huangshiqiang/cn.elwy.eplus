package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.ModuleBiz;
import cn.elwy.eplus.core.entity.Module;
import cn.elwy.eplus.core.service.ModuleService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * ModuleService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class ModuleServiceImpl extends BaseService<Module> implements ModuleService {

	@Resource
	public void setModuleBiz(ModuleBiz biz) {
		super.setBiz(biz);
	}

}