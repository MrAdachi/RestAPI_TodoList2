package com.original.RestAPI_TodoList2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.original.RestAPI_TodoList2.dto.TodoItem;
import com.original.RestAPI_TodoList2.repository.TodoListMapper;

@Service
public class TodoListService {
	
	@Autowired
	private TodoListMapper todoListMapper;
	
	public List<TodoItem> retrieve() {
		List<TodoItem> allTodoItems = todoListMapper.selectAll(); 
		return allTodoItems;
	}

	public void register(TodoItem todoItem) {
		todoListMapper.insert(todoItem);
	}

	public TodoItem retrieve(int id) {
		TodoItem getTodoItem = todoListMapper.select(id);
		return getTodoItem;
	}

	public void delete(int id) {
		todoListMapper.delete(id);
	}

	public void update(int id, TodoItem todoItem) {
		todoItem.setId(id);
		todoListMapper.update(todoItem);
	}
}
