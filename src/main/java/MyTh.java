import java.util.Scanner;

public class MyTh {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodo();
    }

    /**
     * Show all todo to list
     */
    static void showTodo(){
        for( var i = 0; i < todos.length; i++){
            var todo = todos[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }
    static void testShowTodo(){
//        todos[0] = "Belajar java";
//        todos[1] = "Belajar semua hal";
        showTodo();
    }

    /**
     * add todo to list
     */
    static void addTodo(String todo){
    // Check if todos is full
        boolean isFull = true;
        for (String s : todos) {
            if (s == null) {
                // todos still have enough capacity
                isFull = false;
                break;
            }
        }
        if (isFull){
            var temp = todos;
            todos = new String[todos.length * 2];

            System.arraycopy(temp, 0, todos, 0, temp.length);
        }
    // add todo to todos
        for (var i = 0; i < todos.length; i++){
            if (todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }

    /**
     * Test add todo
     */
    static void testAddTodo(){
        for (int i = 0; i < 25; i++) {
            addTodo("todo " + i);
        }
    }
    /**
     * delete todo to list
     */
    static boolean deleteTodo(Integer num){
        if ((num -1) > todos.length){
            return false;
        } else if ((todos[num - 1] == null)){
            return false;
        } else {
            for (int i = (num -1); i < todos.length; i++) {
                if (i == (todos.length) -1){
                    todos[i] = null;
                } else {
                    todos[i] = todos[i + 1];
                }
            }
            return true;
        }
    }
    static void testDeleteTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");

        var result = deleteTodo(20);
        System.out.println(result);

        result = deleteTodo(4);
        System.out.println(result);

        result = deleteTodo(2);
        System.out.println(result);

        showTodo();
    }

    /**
     * receive input
     */
    public static String input(String info){
        System.out.print(info +" : ");
        return scanner.nextLine();
    }
    static void testNewTodo(){
        var data = input("nama");
        System.out.println(data);
    }
    /**
     * show the menu on show todo
     */
    static void viewShowTodo(){
        label:
        while (true){
            System.out.println("----------------------------------");
            System.out.println("----- MyTh - Your Simple Todo ----");
            System.out.println("----------------------------------");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");
            System.out.println("----------------------------------");


            showTodo();
            var input = input("Pilih menu");

            switch (input) {
                case "1":
                    viewAddTodo();
                    break;
                case "2":
                    viewDeleteTodo();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    static void testViewShowTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        viewShowTodo();
    }

    /**
     * show the menu on add todo
     */
    static void viewAddTodo(){
        System.out.println("----------------------------------");
        System.out.println("-         Add New Todo           -");
        System.out.println("----------------------------------");

        var todo = input("Add new Todo (x to cancel)");
        if (todo.equals("x")){
            //cancel
            viewShowTodo();
        } else {
            addTodo(todo);
        }
    }
    static void testViewAddTodo(){
        addTodo("1");
        addTodo("2");
        addTodo("3");
        addTodo("4");
        viewShowTodo();
    }

    /**
     * show the menu on delete todo
     */
    static void viewDeleteTodo(){
        System.out.println("----------------------------------");
        System.out.println("-         Delete Todo            -");
        System.out.println("----------------------------------");
        var index = input("Index: (x to cancel)");

        if (index.equals("x")){
            testViewShowTodo();
        } else {
            boolean success = deleteTodo(Integer.valueOf(index));
            if (!success){
                System.out.println("Can't Remove choosen index.");
            }
        }

    }
    static void testViewDeleteTodo(){
        addTodo("1");
        addTodo("2");
        addTodo("3");
        addTodo("4");
        showTodo();
        viewDeleteTodo();
        showTodo();
    }
}
