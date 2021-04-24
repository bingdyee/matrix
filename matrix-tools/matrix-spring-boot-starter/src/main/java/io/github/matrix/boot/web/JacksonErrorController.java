package io.github.matrix.boot.web;


import io.github.matrix.commons.model.ApiResponse;
import io.github.matrix.commons.model.status.StatusCode;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Bing D. Yee
 * @since 2021/04/09
 */
@RestController
@RequestMapping("${server.error.path:/error}")
public class JacksonErrorController extends AbstractErrorController {

    public JacksonErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @GetMapping
    public ApiResponse<String> error() {
        return ApiResponse.of(StatusCode.INVALID_REQUEST);
    }

    @Override
    public String getErrorPath() {
        return null;
    }

}