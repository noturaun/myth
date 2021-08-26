package repository;

import com.noturaun.myth.entity.Todo;
import com.noturaun.myth.repository.TodoRepository;
import com.noturaun.myth.repository.TodoRepositoryImpl;
import com.noturaun.myth.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

public class TodoRepositoryImplTest {

    HikariDataSource dataSource;

    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoRepository = new TodoRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todo todo = new Todo();
        todo.setTodo("Test Delete (Passed)");

        todoRepository.add(todo);
    }

    @Test
    @Description("Deleted ID will return false. WAD")
    void testDelete() {
        Integer idx = 3;

        Assertions.assertTrue(todoRepository.delete(idx));
    }

    @Test
    void testGetAll() {
        Assertions.assertNotNull(todoRepository.getAll());
        for (var todo :
                todoRepository.getAll()) {
            System.out.println(todo.getId() + " " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
