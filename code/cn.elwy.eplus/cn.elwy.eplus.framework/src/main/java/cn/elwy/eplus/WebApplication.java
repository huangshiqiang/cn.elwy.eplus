package cn.elwy.eplus;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import cn.elwy.common.AppContext;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.eplus.framework.views.FreeMarkerView;
import cn.elwy.eplus.framework.web.SystemInitListener;

/**
 * SpringBoot启动类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@SpringBootApplication()
@ComponentScan({ "cn.elwy.eplus" })
// @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableCaching // 开启缓存
// @EnableTransactionManagement // 启注解事务管理
// @EnableEncryptableProperties
// @EnableAspectJAutoProxy(proxyTargetClass = true)
//@Import({ DynamicDataSourceRegister.class }) // 注册动态多数据源
// @ServletComponentScan
public class WebApplication extends SpringBootServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		try {
			String path = servletContext.getRealPath("/");
			// AppContext.defaultAppHome(new File(path, Constant.APP_HOME_DIR));
			AppContext.start();
			Logger logger = LoggerFactory.getLogger(getClass());

			logger.info("=================app_home: " + path);

			logger.info("初始化应用系统成功！");
		} catch (Throwable e) {
			logger.info("初始化应用系统失败：", e);
		}
		super.onStartup(servletContext);
	}

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> testListenerRegistration() {
		ServletListenerRegistrationBean<ServletContextListener> registration = new ServletListenerRegistrationBean<ServletContextListener>();
		registration.setListener(new SystemInitListener());
		return registration;
	}

	@Bean
	public CommandLineRunner customFreemarker(final FreeMarkerViewResolver resolver) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				// 增加视图
				resolver.setViewClass(FreeMarkerView.class);
				// 添加自定义解析器
				// Map map = resolver.getAttributesMap();
				// map.put("conver", new MyConver());
			}
		};
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("=================SpringApplicationBuilder");
		return application.sources(this.getClass());
	}

	public static void main(String[] args) {
		AppContext.start();
		SpringApplication.run(WebApplication.class, args);
	}
}
