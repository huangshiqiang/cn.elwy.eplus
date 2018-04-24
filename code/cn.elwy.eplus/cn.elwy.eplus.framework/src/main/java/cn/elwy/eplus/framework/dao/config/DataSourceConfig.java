package cn.elwy.eplus.framework.dao.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 多数据源配置
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class DataSourceConfig {

	/**
	 * 用于解决@Transactional 注解无效，发生异常不回滚
	 * @author huangsq
	 * @param dynamicDataSource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
		return new DataSourceTransactionManager(dynamicDataSource);
	}

}