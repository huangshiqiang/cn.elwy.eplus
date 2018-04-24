package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.GridInfoBiz;
import cn.elwy.eplus.core.entity.GridInfo;
import cn.elwy.eplus.core.service.GridInfoService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * GridInfoService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class GridInfoServiceImpl extends BaseService<GridInfo> implements GridInfoService {

	@Resource
	public void setGridInfoBiz(GridInfoBiz biz) {
		super.setBiz(biz);
	}

}