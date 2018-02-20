package cn.elwy.eplus.framework.security.dao;

import java.util.List;

import cn.elwy.eplus.framework.dao.Dao;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface ColumnDao extends Dao<String> {

	List<String> getFilterColumns(String funcCode, String operCode);

}
