package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.UserConfigBiz;
import cn.elwy.eplus.core.entity.UserConfig;
import cn.elwy.eplus.core.service.UserConfigService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * @description UserConfigService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class UserConfigServiceImpl extends BaseService<UserConfig> implements UserConfigService {

	@Resource
	public void setUserConfigBiz(UserConfigBiz biz) {
		super.setBiz(biz);
	}

}