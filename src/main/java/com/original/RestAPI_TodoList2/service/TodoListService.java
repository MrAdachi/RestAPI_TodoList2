package com.original.RestAPI_TodoList2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.original.RestAPI_TodoList2.dto.EnumStatus.Status;
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
	
	public List<TodoItem> retrieveNarrowDownStatusAndTitle(String status, String title) {
		List<TodoItem> TodoItemsNarrowDownStatusAndTitle = todoListMapper.selectNarrowDownStatusAndTitle(status, title); 
		return TodoItemsNarrowDownStatusAndTitle;
	}
	
	public List<TodoItem> retrieveNarrowDownStatus(String status) {
		List<TodoItem> TodoItemsNarrowDownStatus = todoListMapper.selectNarrowDownStatus(status); 
		return TodoItemsNarrowDownStatus;
	}
	
	public List<TodoItem> retrieveNarrowDownTitle(String title) {
		List<TodoItem> TodoItemsNarrowDownTitle = todoListMapper.selectNarrowDownTitle(title); 
		return TodoItemsNarrowDownTitle;
	}

	public void register(TodoItem todoItem) {
		todoListMapper.insert(todoItem);
	}

	public Optional<TodoItem> retrieve(int id) {
		Optional<TodoItem> getTodoItem = todoListMapper.select(id);
		return getTodoItem;
	}

	public void delete(int id) {
		todoListMapper.delete(id);
	}

	public void update(int id, TodoItem todoItem) {
		todoItem.setId(id);
		todoListMapper.update(todoItem);
	}

	public List<TodoItem> retrieveSortId() {
		List<TodoItem> allTodoItemsSortId = todoListMapper.selectAllSortId();
		return allTodoItemsSortId;
	}

	public List<TodoItem> retrieveSortStatus() {
		List<TodoItem> allTodoItemsSortStatus = new ArrayList<>();
		
		for(Status enumStatus : Status.values()) {
			for(TodoItem todoItem : todoListMapper.selectAll()) {
				if((todoItem.getStatus()).equals(enumStatus.getStatusJapanese())) {
					allTodoItemsSortStatus.add(todoItem);
				}
			}
		}
		
		return allTodoItemsSortStatus;
	}
}
