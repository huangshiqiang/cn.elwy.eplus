package cn.elwy.eplus.core.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.core.biz.GenerateCodeBiz;
import cn.elwy.eplus.core.dao.GenerateCodeDao;
import cn.elwy.eplus.core.entity.GenerateCode;
import cn.elwy.eplus.framework.biz.impl.BizImpl;

/**
 * GenerateCodeBiz
 * @author elwy
 * @version 1.0, 2018-02-19
 */
@Component
public class GenerateCodeBizImpl extends BizImpl<GenerateCode> implements GenerateCodeBiz {

	@Resource(name = "generateCodeDao")
	public void setGenerateCodeDao(GenerateCodeDao dao) {
		super.setDao(dao);
	}

}