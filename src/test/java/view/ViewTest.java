package view;

import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;

public class ViewTest {
    public static void main(String[] args) {
     testDeleteTodoView();
    }
    public static void testShowTodoView(){
        TodoRepository repository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(repository);
        TodoView todoView = new TodoView(todoService);

        todoService.addTodo("Another shit");
        todoService.addTodo("Another shit");
        todoService.addTodo("Yet, another shit");
        todoView.showTodo();
    }

    public static void  testAddTodoView(){
        TodoRepository repository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(repository);
        TodoView todoView = new TodoView(todoService);
        todoView.addTodo();
        todoView.showTodo();
    }

    public static void testDeleteTodoView(){
        TodoRepository repository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(repository);
        TodoView todoView = new TodoView(todoService);

        todoService.addTodo("Another shit");
        todoService.addTodo("Another shit");
        todoService.addTodo("Yet, another shit");
        todoView.deleteTodo();
        todoView.showTodo();

    }
}
