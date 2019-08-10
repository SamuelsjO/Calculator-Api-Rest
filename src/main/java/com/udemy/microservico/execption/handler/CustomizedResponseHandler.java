package com.udemy.microservico.execption.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.udemy.microservico.execption.ExceptionResponse;
import com.udemy.microservico.execption.UnsuportedMathOperationExecption;

@ControllerAdvice
@RestController
public class CustomizedResponseHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExecptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsuportedMathOperationExecption.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExecptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
