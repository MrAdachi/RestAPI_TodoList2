package com.original.RestAPI_TodoList2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void addTodoItem(@RequestBody TodoItem todoitem) {
		
		String inputStatus = todoitem.getStatus();
		
		// statusの入力値がenumで定義されている値であるか判定する
		for(Status enumStatus : Status.values()) {
			
			if(inputStatus.equals(enumStatus.getStatusJapanese())) {
				todoListService.register(todoitem);
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
