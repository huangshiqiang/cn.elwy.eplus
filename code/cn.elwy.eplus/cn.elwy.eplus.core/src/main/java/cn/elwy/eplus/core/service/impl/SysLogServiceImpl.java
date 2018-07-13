package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.SysLogBiz;
import cn.elwy.eplus.core.entity.SysLog;
import cn.elwy.eplus.core.service.SysLogService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * SysLogService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class SysLogServiceImpl extends BaseService<SysLog> implements SysLogService {

	@Resource
	public void setSysLogBiz(SysLogBiz biz) {
		super.setBiz(biz);
	}

}