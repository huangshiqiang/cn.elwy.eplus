package cn.elwy.eplus.framework.security.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.elwy.eplus.framework.biz.impl.BizImpl;
import cn.elwy.eplus.framework.dao.Dao;
import cn.elwy.eplus.framework.security.service.ColumnBiz;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Component("columnBiz")
public class ColumnBizImpl extends BizImpl<String> implements ColumnBiz {

	private Map<String, List<String>> columnMap = new HashMap<String, List<String>>();

	@Resource(name = "columnDao")
	public void setColumnDao(Dao<String> dao) {
		super.setDao(dao);
	}

	@Override
	public List<String> getFilterColumns(String funcCode, String operCode) {
		String key = getKey(funcCode, operCode);
		List<String> list = columnMap.get(key);
		if (list == null) {
			list = getDao().selectByCondition(null);
			if (list == null) {
				list = Collections.emptyList();
			}
			columnMap.put(key, list);
		}
		return list;
	}

	public String getKey(String funcCode, String operCode) {
		return funcCode + operCode;
	}
}
