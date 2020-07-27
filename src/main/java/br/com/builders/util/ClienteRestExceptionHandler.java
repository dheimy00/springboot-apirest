package br.com.builders.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClienteRestExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ClienteErrorResponse> handleException(ClienteNotFoundException exc) {
		
		ClienteErrorResponse error = new ClienteErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ClienteErrorResponse> handleException(Exception exc) {
		
		ClienteErrorResponse error = new ClienteErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
