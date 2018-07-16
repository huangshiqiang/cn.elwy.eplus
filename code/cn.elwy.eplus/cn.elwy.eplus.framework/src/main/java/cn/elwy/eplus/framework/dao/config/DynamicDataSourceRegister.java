package cn.elwy.eplus.framework.dao.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;

import cn.elwy.common.util.AssertUtil;

/**
 * 启动动态数据源请在启动类中（如SpringBootSampleApplication）添加 @Import(DynamicDataSourceRegister.class)
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

	private static final String SPRING_DATASOURCE2 = "spring.datasource";
	private static final String SPRING_DATASOURCE = "spring.datasource.";
	private static final String TYPE = "type";
	private static final String DRIVER_CLASS_NAME = "driverClassName";
	private static final String URL = "url";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

	private ConversionService conversionService = new DefaultConversionService();
	private PropertyValues dataSourcePropertyValues;

	// 如配置文件中未指定数据源类型，使用该默认值
	private String DEFAULT_DATASOURCE_TYPE = "com.alibaba.druid.pool.DruidDataSource";

	private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();
	// 数据源
	private DataSource defaultDataSource;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		// 将主数据源添加到更多数据源中
		targetDataSources.put("dataSource", defaultDataSource);
		DynamicDataSourceContextHolder.addDataSource("dataSource");

		// SqlSessionFactory sqlSessionFactory =
		// clusterSqlSessionFactory(defaultDataSource);
		// targetSqlSessionFactorys.put("dataSource", sqlSessionFactory);

		// 添加更多数据源
		targetDataSources.putAll(customDataSources);
		for (String key : customDataSources.keySet()) {
			DynamicDataSourceContextHolder.addDataSource(key);
			// SqlSessionFactory sqlSessionFactoryBean1 =
			// clusterSqlSessionFactory(customDataSources.get(key));
			// targetSqlSessionFactorys.put(key, sqlSessionFactoryBean1);
		}
		// DynamicSqlSessionDaoSupport.setTargetSqlSessionFactorys(targetSqlSessionFactorys);
		// 创建DynamicDataSource
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(DynamicDataSource.class);
		beanDefinition.setSynthetic(true);
		MutablePropertyValues mpv = beanDefinition.getPropertyValues();
		mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
		mpv.addPropertyValue("targetDataSources", targetDataSources);
		registry.registerBeanDefinition("dynamicDataSource", beanDefinition);

		logger.info("Dynamic DataSource Registry");
	}

	public SqlSessionFactory clusterSqlSessionFactory(DataSource clusterDataSource, Environment env) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(clusterDataSource);

		String typeAliasesPackage = env.getProperty("mybatis.typeAliasesPackage");
		if (AssertUtil.isNotEmpty(typeAliasesPackage)) {
			sessionFactory.setTypeAliasesPackage(typeAliasesPackage);// 指定基包
		}
		String mapperLocations = env.getProperty("mybatis.mapperLocations");
		if (AssertUtil.isNotEmpty(mapperLocations)) {
			sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		}

		return sessionFactory.getObject();
	}

	@Override
	public void setEnvironment(Environment env) {
		initDefaultDataSource(env);
		initCustomDataSources(env);

		try {
			Map<Object, SqlSessionFactory> targetSqlSessionFactorys = new HashMap<Object, SqlSessionFactory>();
			SqlSessionFactory sqlSessionFactory = clusterSqlSessionFactory(defaultDataSource, env);
			targetSqlSessionFactorys.put("dataSource", sqlSessionFactory);

			for (String key : customDataSources.keySet()) {
				DynamicDataSourceContextHolder.addDataSource(key);
				SqlSessionFactory sqlSessionFactoryBean1 = clusterSqlSessionFactory(customDataSources.get(key), env);
				targetSqlSessionFactorys.put(key, sqlSessionFactoryBean1);
			}
			DynamicSqlSessionDaoSupport.setTargetSqlSessionFactorys(targetSqlSessionFactorys);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化主数据源
	 * @author SHANHY
	 * @create 2016年1月24日
	 */
	private void initDefaultDataSource(Environment env) {
		// 读取主数据源
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, SPRING_DATASOURCE);
		Map<String, Object> dsMap = new HashMap<String, Object>();
		dsMap.put(TYPE, propertyResolver.getProperty(TYPE));
		dsMap.put(DRIVER_CLASS_NAME, propertyResolver.getProperty(DRIVER_CLASS_NAME));
		dsMap.put(URL, propertyResolver.getProperty(URL));
		dsMap.put(USERNAME, propertyResolver.getProperty(USERNAME));
		dsMap.put(PASSWORD, propertyResolver.getProperty(PASSWORD));

		defaultDataSource = buildDataSource(dsMap);

		dataBinder(defaultDataSource, env);
	}

	/**
	 * 初始化更多数据源
	 * @author SHANHY
	 * @create 2016年1月24日
	 */
	private void initCustomDataSources(Environment env) {
		// 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, SPRING_DATASOURCE);
		String dsPrefixs = propertyResolver.getProperty("names");
		for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
			Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
			DataSource ds = buildDataSource(dsMap);
			customDataSources.put(dsPrefix, ds);
			dataBinder(ds, env);
		}
	}

	@SuppressWarnings("unchecked")
	public DataSource buildDataSource(Map<String, ?> dsMap) {
		try {
			Object type = dsMap.get(TYPE);
			if (type == null) {
				type = DEFAULT_DATASOURCE_TYPE;// 默认DataSource
			}
			Class<? extends DataSource> dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

			String driverClassName = dsMap.get(DRIVER_CLASS_NAME).toString();
			String url = dsMap.get(URL).toString();
			String username = dsMap.get(USERNAME).toString();
			String password = dsMap.get(PASSWORD).toString();

			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
					.username(username).password(password).type(dataSourceType);

			return factory.build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 为DataSource绑定更多数据
	 * @param dataSource
	 * @param env
	 * @author SHANHY
	 * @create 2016年1月25日
	 */
	private void dataBinder(DataSource dataSource, Environment env) {
		RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
		// dataBinder.setValidator(new
		// LocalValidatorFactory().run(this.applicationContext));
		dataBinder.setConversionService(conversionService);
		dataBinder.setIgnoreNestedProperties(false);
		dataBinder.setIgnoreInvalidFields(false);
		dataBinder.setIgnoreUnknownFields(true);
		if (dataSourcePropertyValues == null) {
			Map<String, Object> rpr = new RelaxedPropertyResolver(env, SPRING_DATASOURCE2).getSubProperties(".");
			Map<String, Object> values = new HashMap<String, Object>(rpr);
			// 排除已经设置的属性
			values.remove(TYPE);
			values.remove(DRIVER_CLASS_NAME);
			values.remove(URL);
			values.remove(USERNAME);
			values.remove(PASSWORD);
			dataSourcePropertyValues = new MutablePropertyValues(values);
		}
		dataBinder.bind(dataSourcePropertyValues);
	}

}