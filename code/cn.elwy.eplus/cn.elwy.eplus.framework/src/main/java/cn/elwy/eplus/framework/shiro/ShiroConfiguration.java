package cn.elwy.eplus.framework.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Shiro的配置类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class ShiroConfiguration {

	/**
	 * 安全管理器
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager(ShiroRealm shiroRealm, CookieRememberMeManager rememberMeManager,
			SessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm);
		// securityManager.setCacheManager(cacheShiroManager);
		securityManager.setRememberMeManager(rememberMeManager);
		securityManager.setSessionManager(sessionManager);
		return securityManager;
	}

	/**
	 * spring session管理器（多机环境）
	 */
	@Bean
	// @ConditionalOnProperty(prefix = "guns", name = "spring-session-open",
	// havingValue = "true")
	public ServletContainerSessionManager servletContainerSessionManager() {
		return new ServletContainerSessionManager();
	}

	/**
	 * session管理器(单机环境)
	 */
	@Bean(name = "sessionManager")
	// @ConditionalOnProperty(prefix = "guns", name = "spring-session-open",
	// havingValue = "false")
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

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
	// public CacheManager getCacheShiroManager(EhCacheManagerFactoryBean ehcache) {
	// EhCacheManager ehCacheManager = new EhCacheManager();
	// ehCacheManager.setCacheManager(ehcache.getObject());
	// // cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
	// return ehCacheManager;
	// }

	/**
	 * 项目自定义的Realm
	 */
	/**
	 * ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm， 负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
	 */
	@DependsOn("lifecycleBeanPostProcessor")
	@Bean(name = "shiroRealm")
	public ShiroRealm shiroRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
		ShiroRealm realm = new ShiroRealm();
		realm.setCredentialsMatcher(matcher);
		return realm;
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

	/**
	 * Shiro的过滤器链
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		// 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
		shiroFilter.setLoginUrl("/login");
		shiroFilter.setSuccessUrl("/");
		shiroFilter.setUnauthorizedUrl("/403");
		/**
		 * 配置shiro拦截器链 anon 不需要认证 authc 需要认证 user 验证通过或RememberMe登录的都可以
		 * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的 顺序从上到下,优先级依次降低
		 */
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

		// 注意过滤器配置顺序 不能颠倒
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
		filterChainDefinitionMap.put("/logout", "logout");
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/login", "anon");
		// filterChainDefinitionMap.put("/error", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/resource/**", "anon");
		filterChainDefinitionMap.put("/plugins/**", "anon");
		filterChainDefinitionMap.put("/pages/**", "anon");
		filterChainDefinitionMap.put("/dist/**", "anon");
		filterChainDefinitionMap.put("/bootstrap/**", "anon");
		filterChainDefinitionMap.put("/reg", "anon");
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilter;
	}

	/**
	 * 在方法中 注入 securityManager,进行代理控制
	 */
	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultWebSecurityManager securityManager) {
		MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
		bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		bean.setArguments(new Object[] { securityManager });
		return bean;
	}

	/**
	 * Shiro生命周期处理器: 用于在实现了Initializable接口的Shiro
	 * bean初始化时调用Initializable接口回调(例如:UserRealm) 在实现了Destroyable接口的Shiro bean销毁时调用
	 * Destroyable接口回调(例如:DefaultSecurityManager)
	 */
	/**
	 * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
	 * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
	 * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 启用shrio授权注解拦截方式，AOP式方法级权限检查
	 * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
	 * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
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
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new CustomCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("SHA-256");
		credentialsMatcher.setHashIterations(1024);
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
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

	/**
	 * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}

}