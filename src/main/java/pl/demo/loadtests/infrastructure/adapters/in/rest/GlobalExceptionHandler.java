package pl.demo.loadtests.infrastructure.adapters.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.demo.loadtests.infrastructure.adapters.in.rest.model.ErrorRsp;

@RestControllerAdvice("pl.demo.loadtests.infrastructure.adapters.in.rest")
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    protected ResponseEntity<ErrorRsp> handle() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ErrorRsp.builder()
                        .code("code")
                        .message("message")
                        .details("details")
                        .build()
        );
    }
}
