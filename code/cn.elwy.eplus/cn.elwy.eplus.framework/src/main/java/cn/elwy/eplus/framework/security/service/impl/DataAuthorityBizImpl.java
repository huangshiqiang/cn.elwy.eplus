package cn.elwy.eplus.framework.security.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.elwy.common.model.Criteria;
import cn.elwy.eplus.framework.annotation.DataAuth;
import cn.elwy.eplus.framework.annotation.Function;
import cn.elwy.eplus.framework.biz.impl.BizImpl;
import cn.elwy.eplus.framework.dao.Dao;
import cn.elwy.eplus.framework.security.service.DataAuthorityBiz;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Component("dataAuthority")
@Function(code = "dataAuthority")
public class DataAuthorityBizImpl extends BizImpl<Criteria> implements DataAuthorityBiz {

	public DataAuthorityBizImpl() {
		System.out.println("DataAuthorityBizImpl");
	}

	public void setDao(Dao<Criteria> dao) {
		super.setDao(dao);
	}

	@DataAuth(codes = { "", "" })
	public List<Criteria> query(String funcCode, String operCode) {
		return Collections.emptyList();
	}

	public List<Criteria> buildCondition(List<Criteria> criterias) {
		return criterias;
	}
}
