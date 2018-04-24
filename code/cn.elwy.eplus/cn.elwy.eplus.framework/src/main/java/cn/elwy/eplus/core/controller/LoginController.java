package cn.elwy.eplus.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.elwy.common.model.ResultDto;
import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.framework.security.SessionUtil;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = SessionUtil.getCurrentUser();

		// // 默认页签模式
		// String tabmode = CookieUtils.getCookie(request, "tabmode");
		// if (tabmode == null){
		// CookieUtils.setCookie(response, "tabmode", "1");
		// }

		// 如果已登录，再次访问主页，则退出原账号。
		// if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
		// CookieUtils.setCookie(response, "LOGINED", "false");
		// }

		// 如果已经登录，则跳转到管理首页
		if (user != null) {
			return "redirect:/";
		}
		// if(user != null && !user.isMobileLogin()){
		// return "redirect:" + adminPath;
		// }
		// String view;
		// view = "/WEB-INF/views/modules/sys/sysLogin.jsp";
		// view = "classpath:";
		// view +=
		// "jar:file:/D:/GitHub/jeesite/src/main/webapp/WEB-INF/lib/jeesite.jar!";
		// view += "/"+getClass().getName().replaceAll("\\.",
		// "/").replace(getClass().getSimpleName(), "")+"view/sysLogin";
		// view += ".jsp";
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto login1(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe) {
		ResultDto result = new ResultDto();

		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(rememberMe);
			subject.login(token);
			result.setData("index.html");
			result.setMessage("登录成功！");
		} catch (UnknownAccountException ex) {
			result.setMessage("用户不存在或者密码错误！");
			result.setSuccess(false);
		} catch (IncorrectCredentialsException ex) {
			result.setMessage("用户不存在或者密码错误！");
			result.setSuccess(false);
		} catch (AuthenticationException ex) {
			result.setMessage(ex.getMessage());
			result.setSuccess(false);
		} catch (Exception ex) {
			result.setMessage("用户不存在或者密码错误！");
			result.setSuccess(false);
		}
		return result;
	}

	// public ResultDto validate(IBaseService service, Parameter parameter) {
	// ResultDto result = new ResultDto();
	// LoginServiceImpl loginService = (LoginServiceImpl) getService();
	// Boolean data = false;
	// try {
	// data = loginService.validate(parameter);
	// if (data) {
	// String msg = "用户登录" + Msg.M_SUCCESS;
	// result.setMessage(msg);
	// } else {
	// result.setSuccess(false);
	// String msg = "用户登录" + Msg.M_FAILING;
	// result.setMessage(msg);
	// }
	// } catch (Exception e) {
	// result.setSuccess(false);
	// String msg = "用户登录" + Msg.M_FAILING;
	// result.setMessage(msg);
	// result.setDetailMesssage(e);
	// }
	//
	// // 如果session保存有上次访问页面，则跳转到上次访问的页面
	// Session session = SessionUtil.getCurrentSession();
	// String lastUrl = (String) session.getAttribute(Constant.SESSION_LAST_URL);
	// if (!StringUtils.isEmpty(lastUrl)) {
	// session.removeAttribute(Constant.SESSION_LAST_URL); // 跳转到上次访问页面，同时清理session
	// } else {
	// lastUrl = "/fast-plus/index"; // 默认跳转到首页
	// }
	//
	// result.setData(lastUrl);
	//
	// return result;
	//
	// }

}
