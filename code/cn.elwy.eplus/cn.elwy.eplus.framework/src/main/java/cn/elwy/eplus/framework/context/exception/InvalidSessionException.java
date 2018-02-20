package cn.elwy.eplus.framework.context.exception;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class InvalidSessionException extends SessionException {

	private static final long serialVersionUID = 1L;

	public InvalidSessionException() {
		super();
	}

	public InvalidSessionException(String message) {
		super(message);
	}

	public InvalidSessionException(Throwable cause) {
		super(cause);
	}

	public InvalidSessionException(String message, Throwable cause) {
		super(message, cause);
	}

}
