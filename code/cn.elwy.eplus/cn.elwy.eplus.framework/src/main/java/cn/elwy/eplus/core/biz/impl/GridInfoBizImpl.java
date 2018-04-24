package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.GridInfoBiz;
import cn.elwy.eplus.core.dao.GridInfoDao;
import cn.elwy.eplus.core.entity.GridInfo;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * GridInfoBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class GridInfoBizImpl extends BizImpl<GridInfo> implements GridInfoBiz {

	@Resource(name = "gridInfoDao")
	public void setGridInfoDao(GridInfoDao dao) {
		super.setDao(dao);
	}

}