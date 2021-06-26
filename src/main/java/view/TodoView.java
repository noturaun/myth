package view;


import service.TodoService;
import utils.InputUtil;

public class TodoView {

    private TodoService todoService;

    public TodoView(TodoService todoService) {
        this.todoService = todoService;
    }

    public void showTodo(){
        label:
        while (true){
            System.out.println("----------------------------------");
            System.out.println("----- MyTh - Your Simple Todo ----");
            System.out.println("----------------------------------");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");
            System.out.println("----------------------------------");

            todoService.showTodo();
            var input = InputUtil.input("Pilih menu");

            switch (input) {
                case "1":
                    addTodo();
                    break;
                case "2":
                    deleteTodo();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    public void addTodo(){
        System.out.println("----------------------------------");
        System.out.println("-         Add New Todo           -");
        System.out.println("----------------------------------");

        var todo = InputUtil.input("Add new Todo (x to cancel)");
        if (todo.equals("x")){
            //cancel
            todoService.showTodo();
        } else {
            todoService.addTodo(todo);
        }
    }
    public void deleteTodo(){
        System.out.println("----------------------------------");
        System.out.println("-         Delete Todo            -");
        System.out.println("----------------------------------");
        var index = InputUtil.input("Index: (x to cancel)");

        if (index.equals("x")){
            todoService.showTodo();
        } else {
            todoService.deleteTodo(Integer.valueOf(index));
        }
    }
}
