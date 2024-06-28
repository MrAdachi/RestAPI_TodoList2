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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.original.RestAPI_TodoList2.dto.EnumStatus.Status;
import com.original.RestAPI_TodoList2.dto.TodoItem;
import com.original.RestAPI_TodoList2.service.TodoListService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/todos")
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	
	@GetMapping
	public List<TodoItem> getAllTodoItems(@RequestParam(required = false) String status, @RequestParam(required = false) String title) {
		
		if(statusJudge(status) && StringUtils.isNotBlank(title)) {
			return todoListService.retrieveNarrowDownStatusAndTitle(status, title);
		} else if(statusJudge(status)) {
			return todoListService.retrieveNarrowDownStatus(status);
		} else if (StringUtils.isNotBlank(title)) {
			return todoListService.retrieveNarrowDownTitle(title);
		} else if (status == null && title == null) {
			return todoListService.retrieve();
		} else {
			return null;
		}
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
	
	// ----------------------------------------- extra(start) -----------------------------------------
	@GetMapping("/sort/{sortName}")
	public List<TodoItem> getAllTodoItemsSort(@PathVariable("sortName") String sortName) {
		
		if(sortName.equals("id")) {
			return todoListService.retrieveSortId();
		} else if (sortName.equals("status")) {
			return todoListService.retrieveSortStatus();
		} else {
			return todoListService.retrieve();
		}
	}
	
	// ----------------------------------------- extra(end)   -----------------------------------------
	
	// statusのqueryparameterの判定
	private static boolean statusJudge(String status) {
		
		// statusの入力値がnullや空文字でないか判定する
		if(StringUtils.isNotBlank(status)) {
			
			// statusの入力値がenumで定義されている値であるか判定する
			for(Status enumStatus : Status.values()) {
				
				if(status.equals(enumStatus.getStatusJapanese())) {
					return true;
				}
			}
		}
		
		return false;
	}
}
