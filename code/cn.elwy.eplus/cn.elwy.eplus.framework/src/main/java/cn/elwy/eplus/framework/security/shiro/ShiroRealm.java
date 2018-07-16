package cn.elwy.eplus.framework.security.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

import cn.elwy.eplus.framework.entity.User;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@Configuration
public class ShiroRealm extends AuthorizingRealm {

	public ShiroRealm() {
		System.out.println("ShiroRealm");
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = String.valueOf(token.getPrincipal());
		// 通过数据库进行验证
		try {
			User user = ShiroFactroy.instance().user(username);
			if (user != null) {
				ByteSource salt = ByteSource.Util.bytes(username);

				return new SimpleAuthenticationInfo(username, // new Principal(user,
						// token.isMobileLogin()),
						user.getPassword(), salt, getName());
			}
			// Parameter parameter = new Parameter();
			// parameter.setId("11");
			// parameter.addParam("FUSER_NAME", username);
			// // parameter.addParam("FPASSWORD", password);
			// UserService userService = SpringContext.getBean(UserService.class);
			// final ResultDto rd = userService.queryByCondition(parameter);//
			// PrimaryKey(parameter.getId());
			// if (rd != null) {
			// User user2 = (User) rd.getDatas().get(0);
			// Session session = SecurityUtils.getSubject().getSession();
			// session.setAttribute("user", user2);
			// // 设置盐值
			// ByteSource salt = ByteSource.Util.bytes(username);
			//
			// // byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
			// return new SimpleAuthenticationInfo(user2, // new Principal(user,
			// // token.isMobileLogin()),
			// password, salt, getName());
			// // return new SimpleAuthenticationInfo(username, password, getName());
			// }
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

}