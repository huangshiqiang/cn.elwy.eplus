package cn.elwy.eplus.framework.context.exception;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class SessionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SessionException() {
		super();
	}

	public SessionException(String message) {
		super(message);
	}

	public SessionException(Throwable cause) {
		super(cause);
	}

	public SessionException(String message, Throwable cause) {
		super(message, cause);
	}

}
