package cn.elwy.eplus.framework.support;

import java.util.LinkedHashMap;

import cn.elwy.common.model.Pageable;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class DataMap extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public static String SUCCESS = "success";
	public static String MESSAGE = "message";
	public static String DETIAL_MESSAGE = "detialMessage";
	public static String STATE = "state";
	public static String DATA = "data";
	public static String PAGE = "page";

	public DataMap() {
	}

	public Object getData() {
		return this.get(DATA);
	}

	public void setData(Object data) {
		this.put(DATA, data);
	}

	public Boolean isSuccess() {
		return (Boolean) this.get(SUCCESS);
	}

	public void setSuccess(Boolean success) {
		this.put(SUCCESS, success);
	}

	public String getMessage() {
		return (String) this.get(MESSAGE);
	}

	public void setMessage(String message) {
		this.put(MESSAGE, message);
	}

	public String getDetialMessage() {
		return (String) this.get(DETIAL_MESSAGE);
	}

	public void setDetialMessage(String detialMessage) {
		this.put(DETIAL_MESSAGE, detialMessage);
	}

	public Integer getState() {
		return (Integer) this.get(STATE);
	}

	public void setState(Integer state) {
		this.put(STATE, state);
	}

	public Pageable<?> getPage() {
		return (Pageable<?>) this.get(PAGE);
	}

	public void setPage(Object page) {
		this.put(PAGE, page);
	}

}
