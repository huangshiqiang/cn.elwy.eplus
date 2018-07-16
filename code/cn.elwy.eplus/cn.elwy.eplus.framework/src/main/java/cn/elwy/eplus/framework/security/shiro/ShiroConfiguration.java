package cn.elwy.eplus.framework.security.shiro;

import java.util.LinkedHashMap;
import java.util.Map;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Shiro的配置类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfiguration {

	private String loginUrl;
	private String successUrl;
	private String unauthorizedUrl;
	private String cacheConfig;
	private String hashAlgorithm = "SHA-256";
	private int hashIterations = 1024;
	private boolean storedCredentialsHexEncoded = true;

	private Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	/**
	 * 安全管理器
	 */
	@Bean(name = "securityManager")
	@DependsOn("cacheManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(AuthorizingRealm shiroRealm,CacheManager cacheManager,
			CookieRememberMeManager rememberMeManager, SessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm);
		 securityManager.setCacheManager(cacheManager);
		securityManager.setRememberMeManager(rememberMeManager);
		securityManager.setSessionManager(sessionManager);
		return securityManager;
	}

	/**
	 * spring session管理器（多机环境）
	 */
	@Bean
	@ConditionalOnProperty(prefix = "eplus", name = "spring-session-open", havingValue = "true")
	public ServletContainerSessionManager servletContainerSessionManager() {
		return new ServletContainerSessionManager();
	}

	/**
	 * session管理器(单机环境)
	 */
	@Bean(name = "sessionManager")
	@ConditionalOnProperty(prefix = "eplus", name = "spring-session-open", havingValue = "false")
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new MySessionManager();

		// // 用户信息必须是序列化格式，要不创建用户信息创建不过去，此坑很大，
		// sessionManager.setSessionDAO(redisSessionDAO());// 如不想使用REDIS可注释此行
		// Collection<SessionListener> sessionListeners = new ArrayList<>();
		// sessionListeners.add(customSessionListener());
		// sessionManager.setSessionListeners(sessionListeners);

		// sessionManager.setCacheManager(cacheShiroManager);
		// 单位为毫秒（1秒=1000毫秒） 3600000毫秒为1个小时
		sessionManager.setSessionValidationInterval(3600000 * 12);
		// 3600000 milliseconds = 1 hour
		sessionManager.setGlobalSessionTimeout(3600000 * 12);
		// 是否删除无效的，默认也是开启
		sessionManager.setDeleteInvalidSessions(true);
		// 是否开启 检测，默认开启
		sessionManager.setSessionValidationSchedulerEnabled(true);
		// 创建会话Cookie
		Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
		cookie.setName("shiroCookie");
		// cookie.setName("WEBID");
		cookie.setHttpOnly(true);

		sessionManager.setSessionIdCookie(cookie);
		return sessionManager;
	}

	// /**
	// * 缓存管理器 使用Ehcache实现
	// */
	// @Bean(name = "ehCacheManager")
	// public CacheManager getCacheShiroManager(EhCacheManagerFactoryBean ehcache)
	// {
	// EhCacheManager ehCacheManager = new EhCacheManager();
	// ehCacheManager.setCacheManager(ehcache.getObject());
	// // cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
	// return ehCacheManager;
	// }

	/**
	 * 项目自定义的Realm
	 */
	@Bean(name = "shiroRealm")
	public AuthorizingRealm getShiroRealm() {
		AuthorizingRealm shiroRealm = new ShiroRealm();
		shiroRealm.setCredentialsMatcher(getCredentialsMatcher());
		return shiroRealm;
	}

	// @Bean(name = "shiroEhcacheManager")
	// public EhCacheManager getEhCacheManager() {
	// EhCacheManager em = new EhCacheManager();
	// em.setCacheManagerConfigFile(cacheConfig);
	// return em;
	// }

	/**
	 * Shiro的过滤器链
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl(loginUrl);
		shiroFilterFactoryBean.setSuccessUrl(successUrl);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/*-*
	 * 在方法中 注入 securityManager,进行代理控制
	
	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultWebSecurityManager securityManager) {
		MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
		bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		bean.setArguments(new Object[] { securityManager });
		return bean;
	}
	*/
	/**
	 * Shiro生命周期处理器: 用于在实现了Initializable接口的Shiro
	 * bean初始化时调用Initializable接口会调(例如:UserRealm) 在实现了Destroyable接口的Shiro bean销毁时调用
	 * Destroyable接口回调(例如:DefaultSecurityManager)
	 */
	/**
	 * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
	 * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
	 * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daapc = new DefaultAdvisorAutoProxyCreator();
		daapc.setProxyTargetClass(true);
		return daapc;
	}

	/**
	 * 启用shrio授权注解拦截方式，AOP式方法级权限检查
	 * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
	 * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * HashedCredentialsMatcher，这个类是为了对密码进行编码的， 防止密码在数据库里明码保存，当然在登陆认证的时候，
	 * 这个类也负责对form里输入的密码进行编码。
	 */
	@Bean(name = "credentialsMatcher")
	public HashedCredentialsMatcher getCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new CustomCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName(hashAlgorithm);
		credentialsMatcher.setHashIterations(hashIterations);
		credentialsMatcher.setStoredCredentialsHexEncoded(storedCredentialsHexEncoded);
		return credentialsMatcher;
	}

	/**
	 * rememberMe管理器, cipherKey生成见{@code Base64Test.java}
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
		CookieRememberMeManager manager = new CookieRememberMeManager();
		manager.setCipherKey(Base64.decode("Z3VucwAAAAAAAAAAAAAAAA=="));
		manager.setCookie(rememberMeCookie);
		return manager;
	}

	/**
	 * 记住密码Cookie
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		simpleCookie.setHttpOnly(true);
		simpleCookie.setMaxAge(7 * 24 * 60 * 60);// 7天
		return simpleCookie;
	}

	// /**
	// * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
	// * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
	// */
	// @Bean(name = "ehCacheManager")
	// @DependsOn("lifecycleBeanPostProcessor")
	// public EhCacheManager ehCacheManager() {
	// return new EhCacheManager();
	// }

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

	public String getCacheConfig() {
		return cacheConfig;
	}

	public void setCacheConfig(String cacheConfig) {
		this.cacheConfig = cacheConfig;
	}

	public String getHashAlgorithm() {
		return hashAlgorithm;
	}

	public void setHashAlgorithm(String hashAlgorithm) {
		this.hashAlgorithm = hashAlgorithm;
	}

	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public boolean isStoredCredentialsHexEncoded() {
		return storedCredentialsHexEncoded;
	}

	public void setStoredCredentialsHexEncoded(boolean storedCredentialsHexEncoded) {
		this.storedCredentialsHexEncoded = storedCredentialsHexEncoded;
	}

	public Map<String, String> getFilterChainDefinitionMap() {
		return filterChainDefinitionMap;
	}

	public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
		this.filterChainDefinitionMap = filterChainDefinitionMap;
	}

}