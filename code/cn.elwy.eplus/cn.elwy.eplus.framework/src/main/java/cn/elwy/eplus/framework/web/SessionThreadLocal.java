package cn.elwy.eplus.framework.web;

import cn.elwy.eplus.core.entity.User;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class SessionThreadLocal {

	private static ThreadLocal<User> ADMINUSERTHREADLOCAL = new ThreadLocal<User>();

	public static User getThreaduser() {
		return ADMINUSERTHREADLOCAL.get();
	}

	public static void setThreaduser(User user) {
		ADMINUSERTHREADLOCAL.set(user);
	}

}
