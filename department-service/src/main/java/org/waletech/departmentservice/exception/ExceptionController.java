package org.waletech.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.waletech.departmentservice.dto.response.ErrorResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DepartmentException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentException(DepartmentException exception, WebRequest request){

        ErrorResponse response = ErrorResponse.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .path(request.getDescription(false))
                .build();

        return ResponseEntity.ok(response);

    }

}
