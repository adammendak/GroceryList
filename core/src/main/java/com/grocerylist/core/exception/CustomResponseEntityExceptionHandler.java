package com.grocerylist.core.exception;

import com.grocerylist.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2020-01-15
 *
 * This class contains method to handle with exceptions
 * @extends ResponseEntityExceptionHandler
 */
@Component
@RestController
@ControllerAdvice
@Slf4j
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(Exception ex, WebRequest request) {

        log.info("####Controller Advice");
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(LocalDateTime.now(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest request) {

        log.info("####Controller Advice");
        ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(LocalDateTime.now(),
                "Resource Not Found !");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler({UserExistException.class, UserNotExistException.class})
    public ResponseEntity<Object> handleUserExistOrNotException(Exception ex, WebRequest request) {

        log.info("####Controller Advice");
        ExceptionResponseDto userExistExceptionResponse = new ExceptionResponseDto(LocalDateTime.now(),
                "You given wrong data - bad request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userExistExceptionResponse);

    }

}
