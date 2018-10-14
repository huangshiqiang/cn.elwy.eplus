package cn.elwy.eplus.framework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import cn.elwy.common.entity.BaseEntity;
import cn.elwy.common.entity.Identity;
import cn.elwy.common.entity.Page;
import cn.elwy.common.entity.Parameter;
import cn.elwy.common.entity.ResultDto;
import cn.elwy.common.i18n.Msg;
import cn.elwy.common.util.AssertUtil;
import cn.elwy.common.util.ClassUtil;
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

	protected String detailView;
	protected String listView;
	protected String formView;

	protected Service<E> service;

	public BaseController() {
		this("base");
	}

	public BaseController(String modelView) {
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
	public ModelAndView create(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = ControllerSupport.getView(req, formView);
		mv.addObject(MSG, getMsg(OPERATE_CREATE, req));
		mv.addObject(OPERATE, OPERATE_CREATE);
		return mv;
	}

	@Operation(code = "edit")
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = ControllerSupport.getView(req, formView);
		mv.addObject(MSG, getMsg(OPERATE_CREATE, req));
		mv.addObject(OPERATE, OPERATE_CREATE);
		return mv;
	}

	@Operation(code = "list")
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = ControllerSupport.getView(req, listView);
		mv.addAllObjects(getViewInfo(OPERATE_LIST, req));
		mv.addObject(OPERATE, OPERATE_LIST);
		return mv;
	}

	@Operation(code = "detail")
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") String id) {
		ModelAndView mv = ControllerSupport.getView(req, detailView);
		mv.addObject(OPERATE, OPERATE_DETAIL);
		ResultDto rd = service.queryByPrimaryKey(id);
		mv.addAllObjects(rd);
		return mv;
	}

	@Operation(code = "copy")
	@RequestMapping(value = "/copy/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto copy(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") String id) {
		ResultDto resultDto = service.queryByPrimaryKey(id);
		BaseEntity record = (BaseEntity) resultDto.getData();
		record.setId(null);
		return resultDto;
	}

	@Operation(code = "delete")
	@RequestMapping(value = "/delete/{ids}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
	public ResultDto delete(HttpServletRequest req, HttpServletResponse respons, @PathVariable("ids") String[] ids) {
		if (AssertUtil.isNotEmpty(ids)) {
			Class<E> clazz = ClassUtil.getGenericClass(this.getClass());
			List<E> recordList = new ArrayList<E>();
			for (String id : ids) {
				E record = ClassUtil.newInstance(clazz);
				((Identity) record).setId(id);
				recordList.add(record);
			}
			return service.deleteByPrimaryKeys(recordList);
		} else {
			return new ResultDto("ID不能为空");
		}
	}

	@Operation(code = "recycle")
	@RequestMapping(value = "/recycle/{ids}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto recycle(HttpServletRequest req, HttpServletResponse res, @PathVariable("ids") String[] ids) {
		if (AssertUtil.isNotEmpty(ids)) {
			Class<E> clazz = ClassUtil.getGenericClass(this.getClass());
			List<E> recordList = new ArrayList<E>();
			for (String id : ids) {
				E record = ClassUtil.newInstance(clazz);
				((Identity) record).setId(id);
				recordList.add(record);
			}
			return service.logicallyDeleteByPrimaryKeys(recordList);
		} else {
			return new ResultDto("ID不能为空");
		}
	}

	@Operation(code = "recover")
	@RequestMapping(value = "/recover/{ids}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto recover(HttpServletRequest req, HttpServletResponse respons, @PathVariable("ids") String[] ids) {

		if (AssertUtil.isNotEmpty(ids)) {
			Class<E> clazz = ClassUtil.getGenericClass(this.getClass());
			List<E> recordList = new ArrayList<E>();
			for (String id : ids) {
				E record = ClassUtil.newInstance(clazz);
				((Identity) record).setId(id);
				recordList.add(record);
			}
			return service.recoverByPrimaryKeys(recordList);
		} else {
			return new ResultDto("ID不能为空");
		}
	}

	@Operation(code = "get")
	@RequestMapping(value = "/get/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto get(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") String id) {
		return service.queryByPrimaryKey(id);
	}

	@Operation(code = "audit")
	@RequestMapping(value = "/audit/{ids}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public ResultDto audit(HttpServletRequest req, HttpServletResponse res, @PathVariable("ids") String[] ids) {
		Class<E> clazz = ClassUtil.getGenericClass(this.getClass());
		List<E> recordList = new ArrayList<E>();
		for (String id : ids) {
			E record = ClassUtil.newInstance(clazz);
			((Identity) record).setId(id);
			recordList.add(record);
		}
		return service.audit(recordList);
	}

	@Operation(code = "unaudit")
	@RequestMapping(value = "/unaudit/{ids}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public ResultDto unaudit(HttpServletRequest req, HttpServletResponse res, @PathVariable("ids") String[] ids) {
		Class<E> clazz = ClassUtil.getGenericClass(this.getClass());
		List<E> recordList = new ArrayList<E>();
		for (String id : ids) {
			E record = ClassUtil.newInstance(clazz);
			((Identity) record).setId(id);
			recordList.add(record);
		}
		return service.unaudit(recordList);
	}

	@Operation(code = "save")
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ResultDto save(HttpServletRequest req, HttpServletResponse res, E record) {
		ResultDto rd = null;
		String operate = WebUtil.getString(req, OPERATE);
		if (AssertUtil.isNotEmpty(operate) && operate.equals(OPERATE_EDIT)) {
			rd = service.updateByPrimaryKeySelective(record);
		} else {
			rd = service.insert(record);
		}
		return rd;
	}

	@Operation(code = "update")
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public ResultDto update(HttpServletRequest req, HttpServletResponse res, E record) {
		ResultDto rd = service.updateByPrimaryKeySelective(record);
		return rd;
	}

	@Operation(code = "updates")
	@RequestMapping(value = "/updates", method = { RequestMethod.POST })
	public ResultDto updates(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);

		return service.updateByConditionSelective(parameter);
	}

	@Operation(code = "find")
	@RequestMapping(value = "/find", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto find(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		return service.queryByCondition(parameter);
	}

	@Operation(code = "query")
	@RequestMapping(value = "/query", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto query(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		return rd;
	}

	@Operation(code = "queryAll")
	@RequestMapping(value = "/queryAll", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto queryAll(HttpServletRequest req, HttpServletResponse res) {
		return service.queryAll();
	}

	@RequestMapping(value = "/validation", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto validation(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		return service.queryByCondition(parameter);
	}

	@Operation(code = "setting")
	@RequestMapping(value = "/setting", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto setting(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);

		ResultDto rd = service.updateByConditionSelective(parameter);
		return rd;
	}

	@Operation(code = "export")
	@RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto export(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		return rd;
	}

	@Operation(code = "import")
	@RequestMapping(value = "/import", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto _import(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
		return rd;
	}

	@Operation(code = "print")
	@RequestMapping(value = "/print", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDto print(HttpServletRequest req, HttpServletResponse res) {
		Parameter parameter = WebUtil.getParameter(req);
		Integer pageNo = parameter.getPageNo();
		Integer pageSize = parameter.getPageSize();
		ResultDto rd = null;
		if (AssertUtil.isNotNull(pageNo) && AssertUtil.isNotNull(pageSize)) {
			rd = service.queryByCondition(parameter, new Page<E>(pageNo, pageSize));
		} else {
			rd = service.queryByCondition(parameter);
		}
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

	protected Map<String, String> getMsg(String operate, HttpServletRequest req) {
		HashMap<String, String> msg = new HashMap<String, String>();
		msg.putAll(getI18n(formView));
		msg.putAll(getViewInfo(operate, req));
		return msg;
	}

	protected Map<String, String> getViewInfo(String operate, HttpServletRequest req) {
		return new HashMap<String, String>();
	}

}
