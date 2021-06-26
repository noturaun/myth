package service;

import entity.Todo;
import repository.TodoRepository;

public class TodoServiceImpl implements TodoService{
    private TodoRepository repository;


    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void showTodo() {
        Todo[] todos = repository.getAll();

        for( var i = 0; i < todos.length; i++){
            var todo = todos[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
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
