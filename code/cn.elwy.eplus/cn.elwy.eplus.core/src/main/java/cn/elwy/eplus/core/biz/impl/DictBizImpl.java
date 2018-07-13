package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.DictBiz;
import cn.elwy.eplus.core.dao.DictDao;
import cn.elwy.eplus.core.entity.Dict;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * DictBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class DictBizImpl extends BizImpl<Dict> implements DictBiz {

	@Resource(name = "dictDao")
	public void setDictDao(DictDao dao) {
		super.setDao(dao);
	}

}