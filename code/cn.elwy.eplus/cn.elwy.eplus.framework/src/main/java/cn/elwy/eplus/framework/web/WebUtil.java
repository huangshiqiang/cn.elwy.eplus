package cn.elwy.eplus.framework.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.Page;

import cn.elwy.common.PropertyConstant;
import cn.elwy.common.entity.Criteria;
import cn.elwy.common.entity.OrderRule;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.exception.ExceptionSupport;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.common.util.ConvertTypeUtil;
import cn.elwy.common.util.DateUtil;
import cn.elwy.common.util.JsonUtil;
import cn.elwy.common.util.ReflectUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class WebUtil implements PropertyConstant {

	private static Logger logger = LoggerFactory.getLogger(WebUtil.class);
	public static final int RESPONSE_STATUS_ERROR = 500;
	public static final String UTF_8 = "UTF-8";
	public static final String TEXT_JSON_CONTENT_TYPE = "text/json;charset=UTF-8";

	private WebUtil() {
	}

	public static Page<?> getPage(ServletRequest request) {
		Integer pageNo = getInteger(request, PAGE_NO);
		Integer pageSize = getInteger(request, PAGE_SIZE);
		return new Page<Object>(pageNo, pageSize);
	}

	public static Parameter getParameter() {
		Parameter parameter = new Parameter();
		return parameter;
	}

	public static Parameter getParameter(HttpServletRequest request) {
		Parameter parameter = null;
		String parameterText = request.getParameter(PARAMETER);
		if (AssertUtil.isNotEmpty(parameterText)) {
			parameter = JsonUtil.toObject(parameterText, Parameter.class);
		} else {
			parameter = new Parameter();
		}
		parameter.put(CONTEXT_PATH, request.getContextPath());

		Enumeration<?> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			if (!PARAMETER.equals(paraName) && !OPERATE.equals(paraName) && !PAGE_NO.equals(paraName)
					&& !PAGE_SIZE.equals(paraName) && !CRITERIAS.equals(paraName) && !ORDER_RULES.equals(paraName)) {
				parameter.put(paraName, request.getParameter(paraName));
			}
		}
		String operate = WebUtil.getString(request, OPERATE);
		if (AssertUtil.isNotEmpty(operate)) {
			parameter.setOperate(operate);
		}

		String paramText = request.getParameter(PARAM);
		if (AssertUtil.isNotEmpty(paramText)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> param = JsonUtil.toObject(paramText, Map.class);
			parameter.setParam(param);
		}
		Integer pageNo = WebUtil.getInteger(request, PAGE_NO);
		if (AssertUtil.isNotEmpty(pageNo)) {
			parameter.setPageNo(pageNo);
		}
		Integer pageSize = WebUtil.getInteger(request, PAGE_SIZE);
		if (AssertUtil.isNotEmpty(pageSize)) {
			parameter.setPageSize(pageSize);
		}
		String id = WebUtil.getString(request, ID);
		if (AssertUtil.isNotEmpty(id)) {
			parameter.setId(id);
		}
		String[] ids = WebUtil.getStringValues(request, IDS);
		if (AssertUtil.isNotEmpty(ids)) {
			parameter.setIds(ids);
		}

		String criteriaText = request.getParameter(CRITERIAS);
		if (AssertUtil.isNotEmpty(criteriaText)) {
			List<Criteria> criterias = JsonUtil.toList(criteriaText, Criteria.class);
			// for (Criteria criteria : groups) {
			// parameter.and(criteria);
			// }
			parameter.setCriterias(criterias);
		}

		String orderRuleText = request.getParameter(ORDER_RULES);
		if (AssertUtil.isNotEmpty(orderRuleText)) {
			List<OrderRule> orderRules = JsonUtil.toList(orderRuleText, OrderRule.class);
			parameter.setOrderRules(orderRules);
		}

		return parameter;
	}

	public static String getString(ServletRequest request, String key) {
		return getString(request, key, null);
	}

	public static String getString(ServletRequest request, String key, String defaultValue) {
		String string = request.getParameter(key);
		return string != null ? string : defaultValue;
	}

	public static String[] getStringValues(ServletRequest request, String key) {
		return request.getParameterValues(key);
	}

	public static Boolean getBoolean(ServletRequest request, String key, Boolean defaultValue) {
		String parameter = request.getParameter(key);
		return ConvertTypeUtil.toBoolean(parameter, defaultValue);
	}

	public static Boolean[] getBooleanValues(ServletRequest request, String key) {
		String[] parameterValues = request.getParameterValues(key);
		return ConvertTypeUtil.toBooleanArray(parameterValues, false);
	}

	public static Integer getInteger(ServletRequest request, String key) {
		return getInteger(request, key, null);
	}

	public static Integer getInteger(ServletRequest request, String key, Integer defaultValue) {
		String parameter = request.getParameter(key);
		return ConvertTypeUtil.toInteger(parameter, defaultValue);
	}

	public static Long getLong(ServletRequest request, String key) {
		return getLong(request, key, null);
	}

	public static Long getLong(ServletRequest request, String key, Long defaultValue) {
		String parameter = request.getParameter(key);
		return ConvertTypeUtil.toLong(parameter, defaultValue);
	}

	public static Long[] getLongValues(ServletRequest request, String key, Long defaultValue) {
		String[] parameters = request.getParameterValues(key);
		return ConvertTypeUtil.toLongArray(parameters, defaultValue);
	}

	public static Integer[] getIntegerValues(ServletRequest request, String key) {
		String[] parameterValues = request.getParameterValues(key);
		return ConvertTypeUtil.toIntegerArray(parameterValues, 0);
	}

	public static Date getDate(ServletRequest request, String key) {
		return getDate(request, key, null);
	}

	public static Date getDate(ServletRequest request, String key, Date defaultValue) {
		String parameterValues = request.getParameter(key);
		return DateUtil.toDateTime(parameterValues, defaultValue);
	}

	public static void outJson(HttpServletResponse response, String json) {
		PrintWriter writer = null;
		try {
			response.setContentType(TEXT_JSON_CONTENT_TYPE);
			response.setCharacterEncoding(UTF_8);
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
		} catch (Exception e) {
			if (writer != null) {
				writer.println(e.getMessage());
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static void outJson(HttpServletResponse response, Object obj) {
		outJson(response, JsonUtil.toJson(obj));
	}

	public static void failure(HttpServletResponse response, String msg) {
		response.setStatus(RESPONSE_STATUS_ERROR);
		outJson(response, msg);
	}

	/**
	 * 访问失败，将异常信息返回到前台
	 * @param response 响应对象
	 * @param e 异常对象
	 */
	public static void failure(HttpServletResponse response, Throwable e) {
		failure(response, ExceptionSupport.getDetailMessage(e));
	}

	public static void outputStream(HttpServletResponse response, InputStream fis, String fileName) {
		try {
			// 以流的形式下载文件。
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			outputByte(response, fileName, buffer);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			failure(response, e);
		} finally {
			ReflectUtil.close(fis);
		}
	}

	public static void outputByte(HttpServletResponse response, String fileName, byte[] data) {
		OutputStream out = null;
		try {
			// 以流的形式下载文件。
			// 清空response
			response.reset();
			response.setContentType("application/octet-stream;charset=UTF-8");
			// response.setContentType("application/x-download");
			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			// 设置response的Header
			response.addHeader("Content-Length", "" + data.length);

			out = new BufferedOutputStream(response.getOutputStream());
			out.write(data);
			out.flush();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			failure(response, e);
		} finally {
			ReflectUtil.close(out);
		}
	}

}
