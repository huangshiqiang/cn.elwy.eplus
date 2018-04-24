package cn.elwy.eplus.framework.security.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.elwy.eplus.framework.dao.BaseDao;
import cn.elwy.eplus.framework.security.dao.ColumnDao;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Repository("columnDao")
public class ColumnDaoImpl extends BaseDao<String> implements ColumnDao {

	public ColumnDaoImpl() {
	}

	@Override
	public List<String> getFilterColumns(String funcCode, String operCode) {
		return Collections.emptyList();
	}

}
