package com.noturaun.myth;

import com.noturaun.myth.repository.TodoRepository;
import com.noturaun.myth.repository.TodoRepositoryImpl;
import com.noturaun.myth.service.TodoService;
import com.noturaun.myth.service.TodoServiceImpl;
import com.noturaun.myth.view.TodoView;



public class MyTh {
    public static void main(String[] args) {
        TodoRepository repository = new TodoRepositoryImpl();
        TodoService service = new TodoServiceImpl(repository);
        TodoView todoView = new TodoView(service);

        todoView.showTodo();
    }
}
