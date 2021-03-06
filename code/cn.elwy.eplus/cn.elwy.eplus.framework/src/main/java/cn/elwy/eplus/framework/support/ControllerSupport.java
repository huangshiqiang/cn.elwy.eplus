package cn.elwy.eplus.framework.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import cn.elwy.common.PropertyConstant;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.eplus.framework.context.AppContext;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class ControllerSupport implements PropertyConstant {

	private ControllerSupport() {
	}

	public ModelAndView getView(String defaultView) {
		return getView(AppContext.getHttpServletRequest(), defaultView);
	}

	public static ModelAndView getView(HttpServletRequest request, String defaultView) {
		String view = request.getParameter(_VIEW);
		if (AssertUtil.isEmpty(view)) {
			view = defaultView;
		}

		ModelAndView mv = getModelAndView(request);
		mv.setViewName(view);

		return mv;
	}

	public static ModelAndView getModelAndView(HttpServletRequest request) {
		return getModelAndView(new ModelAndView(), request);
	}

	public static ModelAndView getModelAndView(ModelAndView mv, HttpServletRequest request) {
		/*-
		String contextPath = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ contextPath + "/";
		
		mv.addObject("contextPath", contextPath);
		mv.addObject("basePath", basePath);
		*/
		return mv;
	}

}
