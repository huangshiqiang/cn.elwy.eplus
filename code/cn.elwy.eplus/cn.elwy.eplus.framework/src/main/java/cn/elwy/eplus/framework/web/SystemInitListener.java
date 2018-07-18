package cn.elwy.eplus.framework.web;

import java.io.File;
import java.io.Serializable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.elwy.common.AppContext;
import cn.elwy.common.Constant;
import cn.elwy.eplus.framework.service.Service;

/**
 * 系统启动初始化监听类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@WebListener
public class SystemInitListener implements ServletContextListener {

	private static ApplicationContext applicationContext;
	Logger logger = LoggerFactory.getLogger(SystemInitListener.class);

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			String path = event.getServletContext().getRealPath("/");
			AppContext.setDefaultAppHome(new File(path, Constant.APP_HOME_DIR));
			logger.info("=================defaultAppHome: " + path);

			AppContext.start();
			logger.info("初始化应用系统成功！");
		} catch (Throwable e) {
			logger.info("初始化应用系统失败：", e);
		}
		initConvertor();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		// applicationContext.xml配置的Quartz已定时生成索引，此代码是应用服务器每次启动都生成索引。仅供测试，可删除。
		// InformationService informationService = (InformationService)
		// applicationContext.getBean("informationService");
		// informationService.indexingInformation();
	}

	private void initConvertor() {
		ConvertUtils.register(new JavaUtilDateConverter(), java.util.Date.class);
		ConvertUtils.register(new ByteConverter(null), Byte.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
	}

	public static Object getDynamicProperty(String entityName, Serializable key, String propName) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Object cache = request.getAttribute(entityName + "_" + key);
		if (cache != null) {
			try {
				return PropertyUtils.getProperty(cache, propName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String s = entityName.substring(0, 1).toLowerCase() + entityName.substring(1) + "ServiceImpl";
		Service service = (Service) applicationContext.getBean(s);
		Object entity = null;// (WebBaseParameter) service.get(key);
		request.setAttribute(entityName + "_" + key, entity);
		try {
			return PropertyUtils.getProperty(entity, propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
