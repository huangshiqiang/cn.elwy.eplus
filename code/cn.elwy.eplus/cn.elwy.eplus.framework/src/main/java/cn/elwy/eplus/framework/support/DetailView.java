package cn.elwy.eplus.framework.support;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class DetailView<E> {

	protected E data;
	protected String message;
	protected boolean success;

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
