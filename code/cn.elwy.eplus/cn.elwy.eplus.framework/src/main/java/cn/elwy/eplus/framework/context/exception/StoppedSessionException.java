package cn.elwy.eplus.framework.context.exception;

/**
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class StoppedSessionException extends InvalidSessionException {

	private static final long serialVersionUID = 1L;

	public StoppedSessionException() {
		super();
	}

	public StoppedSessionException(String message) {
		super(message);
	}

	public StoppedSessionException(Throwable cause) {
		super(cause);
	}

	public StoppedSessionException(String message, Throwable cause) {
		super(message, cause);
	}

}
