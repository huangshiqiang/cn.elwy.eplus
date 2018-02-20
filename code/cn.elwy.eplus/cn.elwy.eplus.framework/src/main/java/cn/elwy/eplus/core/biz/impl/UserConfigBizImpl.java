package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.UserConfigBiz;
import cn.elwy.eplus.core.dao.UserConfigDao;
import cn.elwy.eplus.core.entity.UserConfig;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description UserConfigBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class UserConfigBizImpl extends BizImpl<UserConfig> implements UserConfigBiz {

	@Resource(name = "userConfigDao")
	public void setUserConfigDao(UserConfigDao dao) {
		super.setDao(dao);
	}

}