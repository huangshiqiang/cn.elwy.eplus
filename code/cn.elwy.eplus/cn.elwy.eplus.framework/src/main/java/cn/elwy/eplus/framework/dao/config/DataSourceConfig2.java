// package cn.elwy.eplus.framework.dao.config;
//
// import java.util.HashMap;
// import java.util.Map;
//
// import javax.sql.DataSource;
//
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.transaction.PlatformTransactionManager;
//
// import cn.elwy.eplus.framework.annotation.DS.DsId;
//
/// **
// * 多数据源配置
// * @author huangsq
// * @version 1.0, 2018-02-19
// */
// @Configuration
// public class DataSourceConfig {
//
// @Bean(name = "master")
// @Primary
// @ConfigurationProperties(prefix = "spring.datasource.druid.master")
// public DataSource masterDataSource() {
// return DataSourceBuilder.create().build();
// }
//
// @Bean(name = "cluster")
// @ConfigurationProperties(prefix = "spring.datasource.druid.cluster")
// public DataSource clusterDataSource() {
// return DataSourceBuilder.create().build();
// }
//
// @Bean("dynamicDataSource")
// public DataSource dynamicDataSource(@Qualifier("master") DataSource master,
// @Qualifier("cluster") DataSource cluster) {
// DynamicDataSource dynamicRoutingDataSource = new DynamicDataSource();
// Map<Object, Object> dataSourceMap = new HashMap<Object, Object>(2);
// dataSourceMap.put(DsId.master, master);
// dataSourceMap.put(DsId.cluster, cluster);
//
// // 将 master 数据源作为默认指定的数据源
// dynamicRoutingDataSource.setDefaultTargetDataSource(master);
// // 将 master 和 slave 数据源作为指定的数据源
// dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
//
// DataSourceContextHolder.setDsId(DsId.master);
// // // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
// //
// DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
//
// // // 将 Slave 数据源的 key 放在集合中，用于轮循
// //
// DynamicDataSourceContextHolder.slaveDataSourceKeys.addAll(dataSourceMap.keySet());
// // DynamicDataSourceContextHolder.slaveDataSourceKeys.remove(DsId.master);
// return dynamicRoutingDataSource;
// }
//
// /**
// * 配置 SqlSessionFactoryBean，在这里是为了将 MyBatis 的 mapper 位置和持久层接口的别名设置到 Bean 的属性中，
// * 如果没有使用 *.xml 则可以不用该配置，否则将会产生 invalid bond statement异常
// * @author huangsq
// * @return SqlSessionFactoryBean
// */
// @Bean
// @ConfigurationProperties(prefix = "mybatis")
// public SqlSessionFactoryBean
// sqlSessionFactoryBean(@Qualifier("dynamicDataSource") DataSource
// dynamicDataSource) {
// SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
// // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource 作为数据源则不能实现切换
// sqlSessionFactoryBean.setDataSource(dynamicDataSource);
// return sqlSessionFactoryBean;
// }
//
// /**
// * 用于解决@Transactional 注解无效，发生异常不回滚
// * @author huangsq
// * @param dynamicDataSource
// * @return
// */
// @Bean
// public PlatformTransactionManager
// transactionManager(@Qualifier("dynamicDataSource") DataSource
// dynamicDataSource) {
// return new DataSourceTransactionManager(dynamicDataSource);
// }
//
// }