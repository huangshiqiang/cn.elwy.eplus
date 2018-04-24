package cn.elwy.eplus.framework;

import org.springframework.context.ApplicationContext;

/**
 * 系统常量
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public interface Constant {

	/** SQL名称 */
	public static final String SQL_NAME = "sqlName";
	/** 去重 */
	public static final String DISTINCT = "distinct";

	public static final String VIEW_INDEX = "index";
	public static final String VIEW_SUCCESS = "success";
	public static final String VIEW_FAILURE = "failure";

	public static final String DS_FREAMEWORK = "dataSource";
	public static final String LOGIN_USER = "username";
	public static final String LOGIN_PASSWORD = "password";
	public static final String LOGIN_REMEMBER_ME = "rememberMe";

	public static final String SESSION_SECURITY_CODE = "sessionSecurityCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String AUTH_CODE = "AUTH_CODE";

	public static final String SESSION_menuList = "menuList"; // 当前菜单
	public static final String SESSION_allmenuList = "allmenuList"; // 全部菜单

	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";

	public static final String SESSION_USERROL = "USERROL"; // 用户对象
	public static final String SESSION_USERNAME = "USERNAME"; // 用户名

	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login.ctrl"; // 登录地址

	public static final String SYSNAME = "admin/config/SYSNAME.txt"; // 系统名称路径
	// public static final String PAGE = "admin/config/PAGE.txt"; // 分页条数配置路径
	public static final String EMAIL = "admin/config/EMAIL.txt"; // 邮箱服务器配置路径
	public static final String SMS1 = "admin/config/SMS1.txt"; // 短信账户配置路径1
	public static final String SMS2 = "admin/config/SMS2.txt"; // 短信账户配置路径2

	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/"; // 图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/"; // 文件上传路径

	public static ApplicationContext WEB_APP_CONTEXT = null; // 该值会在web容器启动时由WebAppContextListener初始化

	public static String REDIRECT = "redirect:";
	public static String FORWARD = "forward:";

}
