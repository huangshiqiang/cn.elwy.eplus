package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.DatasourceBiz;
import cn.elwy.eplus.core.entity.Datasource;
import cn.elwy.eplus.core.service.DatasourceService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * DatasourceService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class DatasourceServiceImpl extends BaseService<Datasource> implements DatasourceService {

	@Resource
	public void setDatasourceBiz(DatasourceBiz biz) {
		super.setBiz(biz);
	}

}