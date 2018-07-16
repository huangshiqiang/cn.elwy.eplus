package cn.elwy.eplus.framework.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class FreeMarkerView extends org.springframework.web.servlet.view.freemarker.FreeMarkerView {

	protected static final String CONTEXT_PATH = "ctx";

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest req) throws Exception {
		String ctx = req.getContextPath();
		model.put(CONTEXT_PATH, ctx);
		model.put("_page_author", "");
		model.put("_page_keywords", "");
		model.put("_page_keywords", "");
		model.put("_page_description", "");
		model.put("_page_title", "");
		model.put("_v", "1.0.0");

		// String basePath = req.getScheme() + "://" + req.getServerName() + ":" +
		// req.getServerPort() + ctx + "/";
		// model.put(BASE_PATH, basePath);
		super.exposeHelpers(model, req);
	}

}