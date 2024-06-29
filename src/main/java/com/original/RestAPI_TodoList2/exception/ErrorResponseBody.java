package com.original.RestAPI_TodoList2.exception;

import lombok.Data;

// NotFoundException発生時のレスポンス内容
@Data
public class ErrorResponseBody {
	
	private int statusCode;
	private String error;
	private String message;
	
}
