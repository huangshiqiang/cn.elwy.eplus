package cn.elwy.eplus.framework.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.elwy.common.AppContext;
import cn.elwy.common.log.Logger;
import cn.elwy.common.log.LoggerFactory;
import cn.elwy.common.util.PathUtil;

/**
 * 系统启动初始化监听类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@WebListener
public class WebAppListener implements ServletContextListener {

	Logger logger = LoggerFactory.getLogger(WebAppListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			String path = sce.getServletContext().getRealPath("/");
			PathUtil.setInstallHome(new File(path));
			AppContext.start();
			logger.info("appHome:" + PathUtil.getAppHomePath());
			logger.info("初始化应用系统成功！");
		} catch (Throwable e) {
			logger.info("初始化应用系统失败：", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}