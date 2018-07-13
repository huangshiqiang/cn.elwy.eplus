package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.GenerateConfigBiz;
import cn.elwy.eplus.core.dao.GenerateConfigDao;
import cn.elwy.eplus.core.entity.GenerateConfig;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * GenerateConfigBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class GenerateConfigBizImpl extends BizImpl<GenerateConfig> implements GenerateConfigBiz {

	@Resource(name = "generateConfigDao")
	public void setGenerateConfigDao(GenerateConfigDao dao) {
		super.setDao(dao);
	}

}