package cn.elwy.eplus.framework.context;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.elwy.eplus.core.entity.User;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public abstract class AppContext implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = AppContext.class.getName();

	public static final String APP_SESSION_KEY = CLASS_NAME + "_APP_SESSION_KEY";

	public static AppSession getAppSession() {
		AppSession appSession = ThreadContext.getAppSession();
		if (appSession == null) {
			appSession = new AppSession();
			ThreadContext.bind(appSession);
		}
		return appSession;
	}

	public static User getUser() {
		AppSession appSession = getAppSession();
		return appSession.getUser();
	}

	public static String getUserId() {
		AppSession appSession = getAppSession();
		User user = appSession.getUser();
		if (user != null) {
			return user.getId();
		}
		return "1";
	}

	public static String getApplId() {
		// AppSession appSession = getAppSession();
		// Appl appl = appSession.getAppl();
		// if (appl != null) {
		// return appl.getId();
		// }
		return null;
	}

	public static String getApplCode() {
		// AppSession appSession = getAppSession();
		// Appl appl = appSession.getAppl();
		// if (appl != null) {
		// return appl.getCode();
		// }
		return null;
	}

	public static void setAppSession(AppSession appSession) {
		ThreadContext.bind(appSession);
	}

	public static <T> T getThreadContext(String key) {
		return ThreadContext.get(key);
	}

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public HttpSession getHttpSession() {
		HttpServletRequest request = getHttpServletRequest();
		return request.getSession();
	}

}
