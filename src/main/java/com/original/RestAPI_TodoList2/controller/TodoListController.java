package com.original.RestAPI_TodoList2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.original.RestAPI_TodoList2.dto.TodoItem;
import com.original.RestAPI_TodoList2.service.TodoListService;

@RestController
@RequestMapping("/todos")
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	
	@GetMapping
	public List<TodoItem> getAllTodoItems() {
		return todoListService.retrieve();
	}
	
	@PostMapping
	public void addTodoItem(@RequestBody TodoItem todoItem) {
		
		String inputStatus = todoItem.getStatus();
		
		// statusの入力値がenumで定義されている値であるか判定する
		for(Status enumStatus : Status.values()) {
			
			if(inputStatus.equals(enumStatus.getStatusJapanese())) {
				todoListService.register(todoItem);
			}
		}
	}
	
	@GetMapping("{id}")
	public TodoItem getTodoItem(@PathVariable("id") int id) {
		return todoListService.retrieve(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteTodoItem(@PathVariable("id") int id) {
		todoListService.delete(id);
	}
	
	@PutMapping("{id}")
	public void updateTodoItem(@PathVariable("id") int id, @RequestBody TodoItem todoItem) {
		
		String inputStatus = todoItem.getStatus();
		
		// statusの入力値がenumで定義されている値であるか判定する
		for(Status enumStatus : Status.values()) {
			
			if(inputStatus.equals(enumStatus.getStatusJapanese())) {
				todoListService.update(id, todoItem);
			}
		}
	}
	
	// statusのenum定義
	public enum Status {
		
		NotStarted("未着手"),
		OnGoing("進行中"),
		Completed("完了");
		
		private String statusJapanese;
		
		private Status(String statusJapanese) {
			this.statusJapanese = statusJapanese;
		}
		
		public String getStatusJapanese() {
			return this.statusJapanese;
		}
	}
}
