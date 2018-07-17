package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.DictBiz;
import cn.elwy.eplus.core.entity.Dict;
import cn.elwy.eplus.core.service.DictService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * DictService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class DictServiceImpl extends BaseService<Dict> implements DictService {

	@Resource
	public void setDictBiz(DictBiz biz) {
		super.setBiz(biz);
	}

}