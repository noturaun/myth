package com.noturaun.myth.repository;

import com.noturaun.myth.entity.Todo;

public interface TodoRepository {
    Todo[] getAll();
    void add(Todo todo);
    boolean delete(Integer idx);
}
