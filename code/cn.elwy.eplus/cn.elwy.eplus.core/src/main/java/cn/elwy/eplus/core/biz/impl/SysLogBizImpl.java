package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.SysLogBiz;
import cn.elwy.eplus.core.dao.SysLogDao;
import cn.elwy.eplus.core.entity.SysLog;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * SysLogBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class SysLogBizImpl extends BizImpl<SysLog> implements SysLogBiz {

	@Resource(name = "sysLogDao")
	public void setSysLogDao(SysLogDao dao) {
		super.setDao(dao);
	}

}