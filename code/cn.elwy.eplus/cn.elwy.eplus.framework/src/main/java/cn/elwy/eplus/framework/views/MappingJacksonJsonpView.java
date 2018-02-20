package cn.elwy.eplus.framework.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class MappingJacksonJsonpView extends MappingJackson2JsonView {

	public static final String DEFAULT_CONTENT_TYPE = "application/javascript";
	// private Logger log = Logger.getLogger(MappingJacksonJsonpView.class);

	@Override
	public String getContentType() {
		return DEFAULT_CONTENT_TYPE;
	}

	/**
	 * Prepares the view given the specified model, merging it with static
	 * attributes and a RequestContext attribute, if necessary. Delegates to
	 * renderMergedOutputModel for the actual rendering.
	 * @see #renderMergedOutputModel
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if ("GET".equals(request.getMethod().toUpperCase())) {
			Map<String, String[]> params = request.getParameterMap();
			try {
				if (params.containsKey("callback")) {
					response.getOutputStream().write(new String(params.get("callback")[0] + "(").getBytes());
					super.render(model, request, response);
					response.getOutputStream().write(new String(");").getBytes());
					response.setContentType("application/javascript");
				} else {
					super.render(model, request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			super.render(model, request, response);
		}
	}
}
