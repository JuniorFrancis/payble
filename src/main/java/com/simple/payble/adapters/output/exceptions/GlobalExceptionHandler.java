package com.simple.payble.adapters.output.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.simple.payble.adapters.output.exceptions.enums.MessageErrors.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(DataIntegrityViolationException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(DUPLICATED_ACCOUNT.getDescription());
    }

    @ExceptionHandler({NonExistentAccountException.class})
    public ResponseEntity<Object> handleNonExistentAccountException(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ACCOUNT_NOT_FOUND.getDescription());
    }

    @ExceptionHandler({InvalidIdentifierNumberException.class})
    public ResponseEntity<Object> handlerInvalidIdentifierNumber(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(INVALID_ACCOUNT_IDENTIFIER.getDescription());
    }

    @ExceptionHandler({InvalidAmountInWalletException.class})
    public ResponseEntity<Object> handleInvalidAmountInWalletException(InvalidAmountInWalletException e){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(e.getMessage());
    }
}
