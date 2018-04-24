package cn.elwy.eplus.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.core.biz.GenerateCodeBiz;
import cn.elwy.eplus.core.entity.GenerateCode;
import cn.elwy.eplus.core.service.GenerateCodeService;
import cn.elwy.eplus.framework.service.BaseService;

/**
 * GenerateCodeService
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Service
@Transactional(readOnly = true)
public class GenerateCodeServiceImpl extends BaseService<GenerateCode> implements GenerateCodeService {

	@Resource
	public void setGenerateCodeBiz(GenerateCodeBiz biz) {
		super.setBiz(biz);
	}

}