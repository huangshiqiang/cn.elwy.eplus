package cn.elwy.eplus.framework.security.service;

import java.util.List;

import cn.elwy.common.model.Criteria;
import cn.elwy.eplus.framework.biz.Biz;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface DataAuthorityBiz extends Biz<Criteria> {

	public List<Criteria> query(String funcCode, String operCode);

	public List<Criteria> buildCondition(List<Criteria> criterias);
}
