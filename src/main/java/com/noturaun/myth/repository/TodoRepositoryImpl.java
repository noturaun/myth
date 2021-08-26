package com.noturaun.myth.repository;

import com.noturaun.myth.entity.Todo;
import com.zaxxer.hikari.HikariDataSource;

public class TodoRepositoryImpl implements TodoRepository{

    private HikariDataSource dataSource;
    public Todo[] todos = new Todo[10];

    public TodoRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todo[] getAll() {
        return todos;
    }

    @Override
    public void add(Todo todo) {
//        resizeIfFull();
//        // add todo to todos
//        for (var i = 0; i < todos.length; i++){
//            if (todos[i] == null){
//                todos[i] = todo;
//                break;
//            }
//        }

    }

    @Override
    public boolean delete(Integer idx) {
        if ((idx -1) > todos.length){
            return false;
        } else if ((todos[idx - 1] == null)){
            return false;
        } else {
            for (int i = (idx -1); i < todos.length; i++) {
                if (i == (todos.length) -1){
                    todos[i] = null;
                } else {
                    todos[i] = todos[i + 1];
                }
            }
            return true;
        }
    }
    public boolean isFull(){
// Check if todos is full
        boolean isFull = true;
        for (Todo todo : todos) {
            if (todo == null) {
                // todos still have enough capacity
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
        if (isFull()){
            var temp = todos;
            todos = new Todo[todos.length * 2];

            System.arraycopy(temp, 0, todos, 0, temp.length);
        }
    }
}
