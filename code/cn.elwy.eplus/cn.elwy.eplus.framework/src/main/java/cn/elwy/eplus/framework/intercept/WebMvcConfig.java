package cn.elwy.eplus.framework.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 向MVC中添加自定义组件
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	// @Resource
	// private BaseInterceptor baseInterceptor;
	//
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(baseInterceptor);
	// }

	/**
	 * 添加静态资源文件，外部可以直接访问地址
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/upload/**").addResourceLocations("file:" +
		// TaleUtils.getUplodFilePath() + "upload/");
		super.addResourceHandlers(registry);
	}
}
