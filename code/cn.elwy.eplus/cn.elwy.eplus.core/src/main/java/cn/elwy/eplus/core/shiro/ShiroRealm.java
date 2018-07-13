package cn.elwy.eplus.core.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import cn.elwy.common.model.Parameter;
import cn.elwy.common.model.ResultDto;
import cn.elwy.eplus.core.service.UserService;
import cn.elwy.eplus.core.shiro.factory.ShiroFactroy;
import cn.elwy.eplus.framework.context.SpringContext;
import cn.elwy.eplus.framework.entity.User;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class ShiroRealm extends AuthorizingRealm {
	/**
	 * 项目自定义的Realm
	 */
	/**
	 * ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm， 负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
	 */
	// @Bean(name = "shiroRealm")
	// public AuthorizingRealm shiroRealm(@Qualifier("credentialsMatcher")
	// CredentialsMatcher matcher) {
	// ShiroRealm realm = new ShiroRealm();
	// // 告诉realm,使用credentialsMatcher加密算法类来验证密文
	// realm.setCredentialsMatcher(matcher);
	// // 启用缓存,默认false
	// realm.setCachingEnabled(true);
	// // 启用身份验证缓存，即缓存AuthenticationInfo信息，默认false；
	// realm.setAuthenticationCachingEnabled(true);
	// // 缓存AuthenticationInfo信息的缓存名称,即配置在ehcache.xml中的cache name
	// realm.setAuthenticationCacheName("authenticationCache");
	// // 启用授权缓存，即缓存AuthorizationInfo信息，默认false；
	// realm.setAuthorizationCachingEnabled(true);
	// // 缓存AuthorizationInfo信息的缓存名称；
	// realm.setAuthorizationCacheName("authorizationCache");
	// return realm;
	// }

	/**
	 * 加盐参数
	 */
	public final static String hashAlgorithmName = "MD5";

	/**
	 * 循环次数
	 */
	public final static int hashIterations = 2;

	@Autowired
	private UserService userService;

	public ShiroRealm() {
		System.out.println();
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		String password = new String((char[]) token.getCredentials());
		// 通过数据库进行验证
		try {
			User user = ShiroFactroy.instance().user(username);
			if (user != null) {
				ByteSource salt = ByteSource.Util.bytes(username);

				return new SimpleAuthenticationInfo(username, // new Principal(user,
						// token.isMobileLogin()),
						user.getPassword(), salt, getName());
			}
			Parameter parameter = new Parameter();
			parameter.setId("11");
			parameter.addParam("FUSER_NAME", username);
			// parameter.addParam("FPASSWORD", password);
			UserService userService = SpringContext.getBean(UserService.class);
			final ResultDto rd = userService.queryByCondition(parameter);// PrimaryKey(parameter.getId());
			if (rd != null) {
				User user2 = (User) rd.getDatas().get(0);
				Session session = SecurityUtils.getSubject().getSession();
				session.setAttribute("user", user2);
				// 设置盐值
				ByteSource salt = ByteSource.Util.bytes(username);

				// byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
				return new SimpleAuthenticationInfo(username, // new Principal(user,
																											// token.isMobileLogin()),
						user2.getPassword(), salt, getName());
				// return new SimpleAuthenticationInfo(username, password, getName());
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		// String username = String.valueOf(principal.getPrimaryPrincipal());
		// User user = (User)
		// principal.fromRealm(this.getClass().getName()).iterator().next();//
		// 获取session中的用户

		List<String> roles = new ArrayList<String>();
		roles.add("admin");
		roles.add("test");

		List<String> permissions = new ArrayList<String>();
		permissions.add("count");
		// 给当前用户设置角色
		authorizationInfo.addRoles(roles);
		// 给当前用户设置权限
		authorizationInfo.addStringPermissions(permissions);

		// final User user = userService.selectByUsername(username);
		// final List<Role> roleInfos =
		// roleService.selectRolesByUserId(user.getId());
		// for (Role role : roleInfos) {
		// // 添加角色
		// System.err.println(role);
		// // authorizationInfo.addRole(role.getRoleSign());
		// // final List<Permission> permissions =
		// permissionService.selectPermissionsByRoleId(role.getId());
		// // for (Permission permission : permissions) {
		// // // 添加权限
		// // System.err.println(permission);
		// // authorizationInfo.addStringPermission(permission.getPermissionSign());
		// // }
		// }
		return authorizationInfo;
	}

	// /**
	// * 设置认证加密方式
	// */
	// @Override
	// public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
	// HashedCredentialsMatcher md5CredentialsMatcher = new
	// HashedCredentialsMatcher();
	// md5CredentialsMatcher.setHashAlgorithmName(hashAlgorithmName);
	// md5CredentialsMatcher.setHashIterations(hashIterations);
	// super.setCredentialsMatcher(md5CredentialsMatcher);
	// }

}