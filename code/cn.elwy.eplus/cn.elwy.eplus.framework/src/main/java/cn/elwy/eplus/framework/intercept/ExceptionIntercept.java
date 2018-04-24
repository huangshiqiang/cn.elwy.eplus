package cn.elwy.eplus.framework.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.elwy.common.exception.CheckedException;
import cn.elwy.common.exception.RunException;
import cn.elwy.common.model.ResultDto;

/**
 * 统一异常处理类
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
@RestControllerAdvice
public class ExceptionIntercept {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 拦截运行期异常
	 * @author huangsq
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = RunException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResultDto errorHandlerOverJson(RunException e) {
		logger.error(e.getMessage(), e);
		ResultDto rd = new ResultDto();
		rd.setSuccess(false);
		rd.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		rd.setMessage(e.getMessage());
		rd.setDetailMesssage(e.getDetailMessage());

		return rd;
	}

	/**
	 * 拦截检查异常
	 * @author huangsq
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = CheckedException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResultDto errorHandlerOverJson1(RunException e) {
		logger.error(e.getMessage(), e);
		ResultDto rd = new ResultDto();
		rd.setSuccess(false);
		rd.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		rd.setMessage(e.getMessage());
		rd.setDetailMesssage(e.getDetailMessage());

		return rd;
	}

}
