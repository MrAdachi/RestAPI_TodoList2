package com.original.RestAPI_TodoList2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class TodoItem {
	
	private int id;
	private String title;
	private String status;
	private String details;
	private Timestamp createdDateTime;
	private Timestamp updatedDateTime;
}
