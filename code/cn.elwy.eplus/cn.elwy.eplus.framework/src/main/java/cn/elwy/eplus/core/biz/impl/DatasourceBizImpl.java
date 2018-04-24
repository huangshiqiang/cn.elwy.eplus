package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.DatasourceBiz;
import cn.elwy.eplus.core.dao.DatasourceDao;
import cn.elwy.eplus.core.entity.Datasource;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * DatasourceBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class DatasourceBizImpl extends BizImpl<Datasource> implements DatasourceBiz {

	@Resource(name = "datasourceDao")
	public void setDatasourceDao(DatasourceDao dao) {
		super.setDao(dao);
	}

}