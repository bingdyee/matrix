package org.warless.incubator.oauth2.memory.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.warless.incubator.common.ResponseEntity;
import org.warless.incubator.common.exception.SystemErrorException;

import java.util.Objects;

/**
 * ExceptionAdvice
 *
 * @author : yubb
 * @date : 2019-08-06
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static final String UNKNOWN_ERR_MESSAGE = "服务器异常，发生未知错误！";

    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity handle(Exception exception){
        LOGGER.error("Controller API调用失败：" + exception.getMessage(), exception);
        if (exception instanceof SystemErrorException) {
            return ResponseEntity.error(exception.getMessage());
        }
        if (exception instanceof NoHandlerFoundException) {
            return ResponseEntity.result(ResponseEntity.StatusInfo.REQUEST_NOTFOUND);
        }
        if (exception instanceof BindException) {
            BindingResult bindingResult = ((BindException) exception).getBindingResult();
            return ResponseEntity.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        if (exception instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) exception).getBindingResult();
            return ResponseEntity.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        if (exception instanceof AccessDeniedException) {
            return ResponseEntity.result(ResponseEntity.StatusInfo.REQUEST_FORBIDDEN);
        }
        if (exception instanceof HttpRequestMethodNotSupportedException) {
            return ResponseEntity.result(ResponseEntity.StatusInfo.REQUEST_NOT_ALLOWED);
        }
        if (exception instanceof MissingServletRequestParameterException) {
            return ResponseEntity.result(ResponseEntity.StatusInfo.REQUEST_ERROR);
        }
        if (exception instanceof MaxUploadSizeExceededException) {
            return ResponseEntity.error("超过文件最大上传限制！");
        }
        return ResponseEntity.error(UNKNOWN_ERR_MESSAGE);
    }

}
