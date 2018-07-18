package cn.elwy.eplus.framework.dao.druid;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {

	private String statViewServletEnabled;
	private String loginUsername;
	private String loginPassword;
	private String resetEnable;
	private String[] urlMappings;
	private String[] urlPatterns;
	private String exclusions;
	private String profileEnable;

	private String logSlowSql;
	private String allow;
	private String deny;

	@Bean
	@ConditionalOnProperty(prefix = "spring.datasource.druid", name = "statViewServletEnabled", havingValue = "true")
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean(new StatViewServlet(), urlMappings);
		reg.addInitParameter("loginUsername", loginUsername);
		reg.addInitParameter("loginPassword", loginPassword);
		reg.addInitParameter("logSlowSql", logSlowSql);

		// 白名单：
		reg.addInitParameter("allow", allow);
		// IP黑名单(存在共同时，deny优先于allow):如果满足deny的话提示:Sorry, you are not permitted
		// to view
		// this page.
		reg.addInitParameter("deny", deny);
		// 是否能够重置数据.
		reg.addInitParameter("resetEnable", resetEnable);

		return reg;
	}

	@Bean
	@ConditionalOnProperty(prefix = "spring.datasource.druid", name = "statViewServletEnabled", havingValue = "true")
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns(urlPatterns);
		// 添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", exclusions);
		filterRegistrationBean.addInitParameter("profileEnable", profileEnable);
		return filterRegistrationBean;
	}

	public String getStatViewServletEnabled() {
		return statViewServletEnabled;
	}

	public void setStatViewServletEnabled(String statViewServletEnabled) {
		this.statViewServletEnabled = statViewServletEnabled;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getResetEnable() {
		return resetEnable;
	}

	public void setResetEnable(String resetEnable) {
		this.resetEnable = resetEnable;
	}

	public String[] getUrlMappings() {
		return urlMappings;
	}

	public void setUrlMappings(String[] urlMappings) {
		this.urlMappings = urlMappings;
	}

	public String[] getUrlPatterns() {
		return urlPatterns;
	}

	public void setUrlPatterns(String[] urlPatterns) {
		this.urlPatterns = urlPatterns;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public String getProfileEnable() {
		return profileEnable;
	}

	public void setProfileEnable(String profileEnable) {
		this.profileEnable = profileEnable;
	}

	public String getLogSlowSql() {
		return logSlowSql;
	}

	public void setLogSlowSql(String logSlowSql) {
		this.logSlowSql = logSlowSql;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

}