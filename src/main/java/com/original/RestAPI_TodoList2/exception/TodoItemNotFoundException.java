package com.original.RestAPI_TodoList2.exception;

public class TodoItemNotFoundException extends RuntimeException {
	
	private Integer id;
	
	public TodoItemNotFoundException(Integer id) {
		super("ToDoItem (id = " + id + ") is not found.");
		this.id = id;
	}
}
