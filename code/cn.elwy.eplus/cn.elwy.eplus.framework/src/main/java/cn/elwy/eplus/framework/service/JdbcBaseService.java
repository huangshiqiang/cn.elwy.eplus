package cn.elwy.eplus.framework.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import cn.elwy.eplus.framework.dao.springjdbc.JdbcDao;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Transactional
public class JdbcBaseService {

	@Resource
	protected JdbcDao<?> jdbcDao;

}
