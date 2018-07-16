package cn.elwy.eplus.framework.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.elwy.common.PropertyConstant;
import cn.elwy.common.i18n.Msg;
import cn.elwy.common.model.BaseEntity;
import cn.elwy.common.model.Page;
import cn.elwy.common.model.Parameter;
import cn.elwy.common.model.ResultDto;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.eplus.framework.Constant;
import cn.elwy.eplus.framework.annotation.Operation;
import cn.elwy.eplus.framework.service.Service;
import cn.elwy.eplus.framework.support.ControllerSupport;
import cn.elwy.eplus.framework.web.CustomDateEditor;
import cn.elwy.eplus.framework.web.WebUtil;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public abstract class BaseController<E> implements PropertyConstant, Constant {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected String modelView;
	protected String detailView;
	protected String listView;
	protected String formView;

	protected Service<E> service;

	public BaseController() {
		this("base");
	}

	public BaseController(String modelView) {
		this.modelView = modelView;
		this.detailView = modelView + "_detail";
		this.formView = modelView + "_form";
		this.listView = modelView;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor());
	}

	@Operation(code = "create")
	@RequestMapping(value = "/create", method = { RequestMethod.GET })
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = ControllerSupport.getView(request, formView);
		mv.addObject(MSG, getMsg(OPERATE_CREATE, request));
		mv.addObject(OPERATE, OPERATE_CREATE);
		return mv;
	}

	@Operation(code = "detail")
	@RequestMapping(value = "/detail", method = { RequestMethod.GET })
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = ControllerSupport.getView(request, detailView);
		mv.addAllObjects(getViewInfo(OPERATE_LIST, request));
		mv.addObject(OPERATE, OPERATE_DETAIL);
		mv.addObject(OPERATE, OPERATE_DETAIL);
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.queryByPrimaryKey(parameter.getId());
		mv.addAllObjects(rd);
		return mv;
	}

	@Operation(code = "detail")
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		ModelAndView mv = ControllerSupport.getView(request, detailView);
		mv.addObject(OPERATE, OPERATE_DETAIL);
		ResultDto rd = service.queryByPrimaryKey(id);
		mv.addAllObjects(rd);
		return mv;
	}

	@Operation(code = "edit")
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = ControllerSupport.getView(request, formView);
		mv.addObject(MSG, getMsg(OPERATE_CREATE, request));
		mv.addObject(OPERATE, OPERATE_CREATE);
		return mv;
	}

	@Operation(code = "edit")
	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET })
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		ModelAndView mv = ControllerSupport.getView(request, formView);
		mv.addObject(OPERATE, OPERATE_DETAIL);
		ResultDto rd = service.queryByPrimaryKey(id);
		mv.addAllObjects(rd);
		return mv;
	}

	@Operation(code = "list")
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = ControllerSupport.getView(request, listView);
		mv.addAllObjects(getViewInfo(OPERATE_LIST, request));
		mv.addObject(OPERATE, OPERATE_LIST);
		return mv;
	}

	@Operation(code = "copy")
	@RequestMapping(value = "/copy", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto copy(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto resultDto = service.queryByPrimaryKey(parameter.getId());
		BaseEntity record = (BaseEntity) resultDto.getData();
		record.setId(null);
		return resultDto;
	}

	@Operation(code = "copy")
	@RequestMapping(value = "/copy/{id}", method = { RequestMethod.GET })
	public ResultDto copy(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		ResultDto resultDto = service.queryByPrimaryKey(id);
		BaseEntity record = (BaseEntity) resultDto.getData();
		record.setId(null);
		return resultDto;
	}

	@Operation(code = "delete")
	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE })
	public ResultDto delete(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = null;
		if (AssertUtil.isNotEmpty(parameter.getIds())) {
			rd = service.deleteByPrimaryKeys(parameter.getIds());
		} else {
			rd = service.deleteByCondition(parameter);
		}
		return rd;
	}

	@Operation(code = "deleteByPrimaryKeys")
	@RequestMapping(value = "/delete/{ids}", method = { RequestMethod.DELETE })
	public ResultDto delete(HttpServletRequest request, HttpServletResponse respons, @PathVariable String id) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = null;
		if (AssertUtil.isNotEmpty(id)) {
			String[] ids = id.split(",");
			rd = service.deleteByPrimaryKeys(ids);
		} else {
			rd = service.deleteByCondition(parameter);
		}
		return rd;
	}

	@Operation(code = "get")
	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	public ResultDto get(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.queryByPrimaryKey(parameter.getId());
		return rd;
	}

	@Operation(code = "get")
	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET })
	public ResultDto get(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
		ResultDto rd = service.queryByPrimaryKey(id);
		return rd;
	}

	@Operation(code = "audit")
	@RequestMapping(value = "/audit", method = { RequestMethod.PUT })
	public ResultDto audit(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.audit(parameter.getIds());
		return rd;
	}

	@Operation(code = "audit")
	@RequestMapping(value = "/audit/{ids}", method = { RequestMethod.PUT })
	public ResultDto audit(HttpServletRequest request, HttpServletResponse response, @PathVariable String[] ids) {
		ResultDto rd = service.audit(ids);
		return rd;
	}

	@Operation(code = "unaudit")
	@RequestMapping(value = "/unaudit", method = { RequestMethod.PUT })
	public ResultDto unaudit(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.unaudit(parameter.getIds());
		return rd;
	}

	@Operation(code = "unaudit")
	@RequestMapping(value = "/unaudit/{ids}", method = { RequestMethod.PUT })
	public ResultDto unaudit(HttpServletRequest request, HttpServletResponse response, @PathVariable String[] ids) {
		ResultDto rd = service.unaudit(ids);
		return rd;
	}

	@Operation(code = "query")
	@RequestMapping(value = "/query", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto query(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@Operation(code = "queryAll")
	@RequestMapping(value = "/queryAll", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto queryAll(HttpServletRequest request, HttpServletResponse response) {
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		rd = service.queryAll();
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@Operation(code = "save")
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ResultDto save(HttpServletRequest request, HttpServletResponse response, E record) {
		ResultDto rd = null;
		String id = WebUtil.getString(request, "id");
		String operate = WebUtil.getString(request, OPERATE);
		if (AssertUtil.isNotEmpty(id) && AssertUtil.isNotEmpty(operate) && operate.equals(OPERATE_EDIT)) {
			rd = service.updateByPrimaryKey(record);
		} else {
			rd = service.insert(record);
		}
		return rd;
	}

	@Operation(code = "update")
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public ResultDto update(HttpServletRequest request, HttpServletResponse response, E record) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.updateByCondition(record, parameter);
		return rd;
	}

	@RequestMapping(value = "/validation", method = { RequestMethod.GET })
	public ResultDto validation(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		ResultDto rd = service.queryByCondition(parameter);
		BaseEntity record = (BaseEntity) rd.getData();
		record.setId(null);
		return rd;
	}

	@Operation(code = "setting")
	@RequestMapping(value = "/setting", method = { RequestMethod.POST })
	public ResultDto setting(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@Operation(code = "export")
	@RequestMapping(value = "/export", method = { RequestMethod.GET })
	public ResultDto export(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@Operation(code = "import")
	@RequestMapping(value = "/import", method = { RequestMethod.POST })
	public ResultDto _import(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	@Operation(code = "print")
	@RequestMapping(value = "/print", method = { RequestMethod.GET })
	public ResultDto print(HttpServletRequest request, HttpServletResponse response) {
		Parameter parameter = WebUtil.getParameter(request);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		long start = System.currentTimeMillis();
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		System.out.println("用时：" + (System.currentTimeMillis() - start));
		return rd;
	}

	public Service<E> getService() {
		return service;
	}

	public void setService(Service<E> service) {
		this.service = service;
	}

	public String getDetailView() {
		return detailView;
	}

	public void setDetailView(String detailView) {
		this.detailView = detailView;
	}

	public String getListView() {
		return listView;
	}

	public void setListView(String listView) {
		this.listView = listView;
	}

	public String getFormView() {
		return formView;
	}

	public void setFormView(String formView) {
		this.formView = formView;
	}

	protected Map<String, String> getI18n(String view) {
		return Msg.getMsgMap(Msg.class);
	}

	protected Map<String, String> getMsg(String operate, HttpServletRequest request) {
		HashMap<String, String> msg = new HashMap<String, String>();
		msg.putAll(getI18n(formView));
		msg.putAll(getViewInfo(operate, request));
		return msg;
	}

	protected Map<String, String> getViewInfo(String operate, HttpServletRequest request) {
		return new HashMap<String, String>();
	}

}
