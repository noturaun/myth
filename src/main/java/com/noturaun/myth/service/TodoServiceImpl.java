package com.noturaun.myth.service;

import com.noturaun.myth.entity.Todo;
import com.noturaun.myth.repository.TodoRepository;

public class TodoServiceImpl implements TodoService{
    private TodoRepository repository;


    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void showTodo() {
        Todo[] todos = repository.getAll();
        for (var todo :
                todos) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @Override
    public void addTodo(String todo) {
        Todo newTodo = new Todo(todo);
        repository.add(newTodo);
    }

    @Override
    public void deleteTodo(Integer idx) {
        boolean success = repository.delete(idx);
        if (success){
            System.out.println("Todo deleted successfully");
        } else {
            System.out.println("Unable to delete Todo");
        }

    }


}
