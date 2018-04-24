package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.GridBiz;
import cn.elwy.eplus.core.dao.GridDao;
import cn.elwy.eplus.core.entity.Grid;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * GridBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class GridBizImpl extends BizImpl<Grid> implements GridBiz {

	@Resource(name = "gridDao")
	public void setGridDao(GridDao dao) {
		super.setDao(dao);
	}

}