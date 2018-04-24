package cn.elwy.eplus.framework.dao.druid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class DruidConfig {

	@Value("${spring.datasource.druid.username}")
	private String username;

	@Value("${spring.datasource.druid.password}")
	private String password;

	@Value("${spring.datasource.druid.logSlowSql}")
	private String logSlowSql;

	@Value("${spring.datasource.druid.allow}")
	private String allow;

	@Value("${spring.datasource.druid.deny}")
	private String deny;

	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		reg.addInitParameter("loginUsername", username);
		reg.addInitParameter("loginPassword", password);
		reg.addInitParameter("logSlowSql", logSlowSql);

		// 白名单：
		reg.addInitParameter("allow", allow);
		// IP黑名单(存在共同时，deny优先于allow):如果满足deny的话提示:Sorry, you are not permitted to view
		// this page.
		reg.addInitParameter("deny", deny);
		// 是否能够重置数据.
		reg.addInitParameter("resetEnable", "false");

		return reg;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");
		// 添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("profileEnable", "true");
		return filterRegistrationBean;
	}

}