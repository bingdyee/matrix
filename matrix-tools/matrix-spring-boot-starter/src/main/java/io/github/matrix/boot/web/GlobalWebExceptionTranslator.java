package io.github.matrix.boot.web;


import com.google.common.base.Joiner;
import io.github.matrix.commons.exception.AbstractWebException;
import io.github.matrix.commons.model.ApiResponse;
import io.github.matrix.commons.model.status.StatusCode;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Bing D. Yee
 * @since 2021/04/09
 */
@RestControllerAdvice
public class GlobalWebExceptionTranslator {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ApiResponse<String> handleError(NoHandlerFoundException e) {
        return ApiResponse.of(StatusCode.NOT_FOUND);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class
    })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleInvalidArgumentException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
            Set<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toSet());
            return ApiResponse.of(StatusCode.INVALID_REQUEST.getCode(), Joiner.on(", ").join(errors));
        }
        return ApiResponse.of(StatusCode.INVALID_REQUEST);
    }

    @ExceptionHandler(AbstractWebException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<String> handleException(AbstractWebException e) {
        return ApiResponse.of(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<String> handleException(Exception e) {
        return ApiResponse.of(StatusCode.INTERNAL_SERVER_ERROR);
    }

}
