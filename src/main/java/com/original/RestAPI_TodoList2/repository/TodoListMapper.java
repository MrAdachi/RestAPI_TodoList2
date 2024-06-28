package com.original.RestAPI_TodoList2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.original.RestAPI_TodoList2.dto.TodoItem;

@Mapper
public interface TodoListMapper {
	
	// selectAll(全取得)
	List<TodoItem> selectAll();
	
	// insert(挿入)
	void insert(TodoItem todoitem);
	
	// select(1データ取得)
	TodoItem select(int id);
	
	// delete(1データ削除)
	void delete(int id);

}
