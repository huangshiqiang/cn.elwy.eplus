package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.DataAclBiz;
import cn.elwy.eplus.core.dao.DataAclDao;
import cn.elwy.eplus.core.entity.DataAcl;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * DataAclBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class DataAclBizImpl extends BizImpl<DataAcl> implements DataAclBiz {

	@Resource(name = "dataAclDao")
	public void setDataAclDao(DataAclDao dao) {
		super.setDao(dao);
	}

}