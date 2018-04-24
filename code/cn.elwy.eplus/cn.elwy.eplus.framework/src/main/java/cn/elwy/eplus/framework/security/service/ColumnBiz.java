package cn.elwy.eplus.framework.security.service;

import java.util.List;

import cn.elwy.eplus.framework.biz.Biz;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface ColumnBiz extends Biz<String> {

	List<String> getFilterColumns(String funcCode, String operCode);

}
