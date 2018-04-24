package cn.elwy.eplus.framework.dao.annotation;

// package cn.elwy.eplus.framework.dao.config;
//
// import javax.sql.DataSource;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// @MapperScan(basePackages = { "titan.mapper" }, sqlSessionFactoryRef =
// "sqlSessionFactory1")
// public class MybatisDbAConfig {
//
// @Autowired
// @Qualifier("masterDataSource")
// private DataSource masterDataSource;
//
// @Bean
// public SqlSessionFactory sqlSessionFactory1() throws Exception {
// SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
// factoryBean.setDataSource(masterDataSource);
//
// return factoryBean.getObject();
//
// }
//
// @Bean
// public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
// SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
// // 使用上面配置的Factory
// return template;
// }
// }