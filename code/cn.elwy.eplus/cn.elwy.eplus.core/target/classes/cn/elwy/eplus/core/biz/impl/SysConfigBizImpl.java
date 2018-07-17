package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.SysConfigBiz;
import cn.elwy.eplus.core.dao.SysConfigDao;
import cn.elwy.eplus.core.entity.SysConfig;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * SysConfigBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class SysConfigBizImpl extends BizImpl<SysConfig> implements SysConfigBiz {

	@Resource(name = "sysConfigDao")
	public void setSysConfigDao(SysConfigDao dao) {
		super.setDao(dao);
	}

}