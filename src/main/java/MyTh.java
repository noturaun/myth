import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoView;



public class MyTh {
    public static void main(String[] args) {
        TodoRepository repository = new TodoRepositoryImpl();
        TodoService service = new TodoServiceImpl(repository);
        TodoView todoView = new TodoView(service);

        todoView.showTodo();
    }
}
