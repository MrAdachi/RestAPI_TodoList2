package com.original.RestAPI_TodoList2.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.original.RestAPI_TodoList2.dto.TodoItem;

@Mapper
public interface TodoListMapper {
	
	// selectAll(全取得)
	List<TodoItem> selectAll();
	
	// selectNarrowDownStatusAndTitle(タイトルと状態で絞り込んだデータを取得)
	List<TodoItem> selectNarrowDownStatusAndTitle(String status, String title);
	
	// selectNarrowDownStatus(状態で絞り込んだデータを取得)
	List<TodoItem> selectNarrowDownStatus(String status);
	
	// selectNarrowDownTitle(タイトルで絞り込んだデータを取得)
	List<TodoItem> selectNarrowDownTitle(String title);
	
	// insert(挿入)
	void insert(TodoItem todoItem);
	
	// select(1データ取得)
	Optional<TodoItem> select(int id);
	
	// delete(1データ削除)
	void delete(int id);
	
	// update(更新)
	void update(TodoItem todoItem);
	
	// selectAllSortId(IDでSortしたデータを全取得)
	List<TodoItem> selectAllSortId();
}
