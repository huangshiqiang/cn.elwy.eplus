package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.ModuleBiz;
import cn.elwy.eplus.core.dao.ModuleDao;
import cn.elwy.eplus.core.entity.Module;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * ModuleBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class ModuleBizImpl extends BizImpl<Module> implements ModuleBiz {

	@Resource(name = "moduleDao")
	public void setModuleDao(ModuleDao dao) {
		super.setDao(dao);
	}

}