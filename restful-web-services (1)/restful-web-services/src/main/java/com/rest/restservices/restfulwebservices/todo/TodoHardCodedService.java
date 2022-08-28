package com.rest.restservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	private static List<Todo> todos=new ArrayList();
	private static Long idCounter=0L;
	
	static {
		todos.add(new Todo(++idCounter,"jammumeans", "Microservices in 28minutes", new Date(), false));
		todos.add(new Todo(++idCounter,"jammumeans", "Learn to Strive", new Date(), false));
		todos.add(new Todo(++idCounter,"jammumeans", "View English ", new Date(), false));
		todos.add(new Todo(++idCounter,"jammumeans", "Buy the Big Bikes", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo findById(Long id){
		for(Todo todo:todos) {
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}
	
	public Todo deleteById(long id){
		Todo todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo))
			return todo;
		
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
		
	}
	
	

}