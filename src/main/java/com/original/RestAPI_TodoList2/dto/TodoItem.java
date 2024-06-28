package com.original.RestAPI_TodoList2.dto;

import lombok.Data;

@Data
public class TodoItem {
	
	private int id;
	private String title;
	private String status;
	private String details;
}
