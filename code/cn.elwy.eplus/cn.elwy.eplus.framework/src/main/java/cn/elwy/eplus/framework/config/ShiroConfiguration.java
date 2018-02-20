package cn.elwy.eplus.framework.config;

import org.springframework.context.annotation.Configuration;

/**
 * @description shiro的配置类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class ShiroConfiguration {
	// @Bean(name = "shiroFilter")
	// public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")
	// SecurityManager manager) {
	// ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
	// bean.setSecurityManager(manager);
	// // 配置登录的url和登录成功的url
	// bean.setLoginUrl("/login");
	// bean.setSuccessUrl("/home");
	// // 配置访问权限
	// LinkedHashMap<String, String> filterChainDefinitionMap = new
	// LinkedHashMap<>();
	// filterChainDefinitionMap.put("/jsp/login.jsp*", "anon"); // 表示可以匿名访问
	// filterChainDefinitionMap.put("/loginUser", "anon");
	// filterChainDefinitionMap.put("/logout*", "anon");
	// filterChainDefinitionMap.put("/jsp/error.jsp*", "anon");
	// filterChainDefinitionMap.put("/jsp/index.jsp*", "authc");
	// filterChainDefinitionMap.put("/*", "authc");// 表示需要认证才可以访问
	// filterChainDefinitionMap.put("/**", "authc");// 表示需要认证才可以访问
	// filterChainDefinitionMap.put("/*.*", "authc");
	// bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	// return bean;
	// }
	//
	// // 配置核心安全事务管理器
	// @Bean(name = "securityManager")
	// public SecurityManager securityManager(@Qualifier("authRealm") ShiroDbRealm
	// authRealm) {
	// System.err.println("--------------shiro已经加载----------------");
	// DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
	// manager.setRealm(authRealm);
	// return manager;
	// }
	//
	// // 配置自定义的权限登录器
	// @Bean(name = "authRealm")
	// public ShiroDbRealm authRealm(@Qualifier("credentialsMatcher")
	// CredentialsMatcher matcher) {
	// ShiroDbRealm authRealm = new ShiroDbRealm();
	// authRealm.setCredentialsMatcher(matcher);
	// return authRealm;
	// }
	//
	// // 配置自定义的密码比较器
	// @Bean(name = "credentialsMatcher")
	// public CredentialsMatcher credentialsMatcher() {
	// return new CredentialsMatcher();
	// }
	//
	// @Bean
	// public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	// return new LifecycleBeanPostProcessor();
	// }
	//
	// @Bean
	// public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	// DefaultAdvisorAutoProxyCreator creator = new
	// DefaultAdvisorAutoProxyCreator();
	// creator.setProxyTargetClass(true);
	// return creator;
	// }
	//
	// @Bean
	// public AuthorizationAttributeSourceAdvisor
	// authorizationAttributeSourceAdvisor(
	// @Qualifier("securityManager") SecurityManager manager) {
	// AuthorizationAttributeSourceAdvisor advisor = new
	// AuthorizationAttributeSourceAdvisor();
	// advisor.setSecurityManager(manager);
	// return advisor;
	// }
	// @Bean
	// public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
	// System.out.println("ShiroConfiguration.shirFilter()");
	// ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
	// shiroFilterFactoryBean.setSecurityManager(securityManager);
	// //拦截器.
	// Map<String,String> filterChainDefinitionMap = new
	// LinkedHashMap<String,String>();
	// // 配置不会被拦截的链接 顺序判断
	// filterChainDefinitionMap.put("/static/**", "anon");
	// //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
	// filterChainDefinitionMap.put("/logout", "logout");
	// //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
	// //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
	// filterChainDefinitionMap.put("/**", "authc");
	// // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
	// shiroFilterFactoryBean.setLoginUrl("/login");
	// // 登录成功后要跳转的链接
	// shiroFilterFactoryBean.setSuccessUrl("/index");
	//
	// //未授权界面;
	// shiroFilterFactoryBean.setUnauthorizedUrl("/403");
	// shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	// return shiroFilterFactoryBean;
	// }
	//
	// @Bean
	// public MyShiroRealm myShiroRealm(){
	// MyShiroRealm myShiroRealm = new MyShiroRealm();
	// return myShiroRealm;
	// }
	//
	//
	// @Bean
	// public SecurityManager securityManager(){
	// DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	// securityManager.setRealm(myShiroRealm());
	// return securityManager;
	// }
}