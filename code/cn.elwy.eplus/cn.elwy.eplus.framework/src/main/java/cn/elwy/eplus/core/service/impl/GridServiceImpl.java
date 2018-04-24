package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.GridBiz;
import cn.elwy.eplus.core.entity.Grid;
import cn.elwy.eplus.core.service.GridService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * GridService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class GridServiceImpl extends BaseService<Grid> implements GridService {

	@Resource
	public void setGridBiz(GridBiz biz) {
		super.setBiz(biz);
	}

}