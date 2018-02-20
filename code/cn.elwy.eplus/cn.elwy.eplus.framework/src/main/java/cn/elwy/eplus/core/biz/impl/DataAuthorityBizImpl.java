package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.DataAuthorityBiz;
import cn.elwy.eplus.core.dao.DataAuthorityDao;
import cn.elwy.eplus.core.entity.DataAuthority;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description DataAuthorityBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class DataAuthorityBizImpl extends BizImpl<DataAuthority> implements DataAuthorityBiz {

	@Resource(name = "dataAuthorityDao")
	public void setDataAuthorityDao(DataAuthorityDao dao) {
		super.setDao(dao);
	}

}