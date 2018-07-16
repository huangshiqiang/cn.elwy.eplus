package cn.elwy.eplus.framework.dao.config;

/**
 * 多数据源配置
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
//@Configuration
//public class DataSourceConfig {
//
//	/**
//	 * 用于解决@Transactional 注解无效，发生异常不回滚
//	 * @author huangsq
//	 * @param dynamicDataSource
//	 * @return
//	 */
//	@Bean
//	public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
//		return new DataSourceTransactionManager(dynamicDataSource);
//	}
//
//}