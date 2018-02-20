package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.FieldAuthorityBiz;
import cn.elwy.eplus.core.dao.FieldAuthorityDao;
import cn.elwy.eplus.core.entity.FieldAuthority;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * @description FieldAuthorityBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class FieldAuthorityBizImpl extends BizImpl<FieldAuthority> implements FieldAuthorityBiz {

	@Resource(name = "fieldAuthorityDao")
	public void setFieldAuthorityDao(FieldAuthorityDao dao) {
		super.setDao(dao);
	}

}