package cn.elwy.eplus.framework.context.exception;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class ExpiredSessionException extends StoppedSessionException {

	private static final long serialVersionUID = 1L;

	public ExpiredSessionException() {
		super();
	}

	public ExpiredSessionException(String message) {
		super(message);
	}

	public ExpiredSessionException(Throwable cause) {
		super(cause);
	}

	public ExpiredSessionException(String message, Throwable cause) {
		super(message, cause);
	}
}
