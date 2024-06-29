package com.original.RestAPI_TodoList2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TodoItemNotFoundExceptionControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(TodoItemNotFoundException.class)
	public ResponseEntity<ErrorResponseBody> todoItemNotFoundHandler(TodoItemNotFoundException e) {
		var errorResponseBody = new ErrorResponseBody();
		errorResponseBody.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponseBody.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		errorResponseBody.setMessage(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .body(errorResponseBody);
	}
}
