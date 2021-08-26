package com.noturaun.myth.repository;

import com.noturaun.myth.entity.Todo;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImpl implements TodoRepository{

    private HikariDataSource dataSource;
    public Todo[] todos = new Todo[10];

    public TodoRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todo[] getAll() {
        String sql = "select * from todos";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            List<Todo> list = new ArrayList<>();
            while (result.next()){
                Todo todo = new Todo();
                todo.setId(result.getInt("id"));
                todo.setTodo(result.getString("todo"));
                list.add(todo);
                }
            return  list.toArray(new Todo[]{});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Todo todo) {
        String sql = "insert into todos(todo) values(?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, todo.getTodo());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private boolean isExist(Integer idx){
        String sql = "select id from todos where id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idx);
            try(ResultSet result = statement.executeQuery()) {
                if (result.next()){
                    return true;
                } else return false;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer idx) {
        if(isExist((idx))){
            String sql = "delete from todos where id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idx);
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else return false;

    }

}
