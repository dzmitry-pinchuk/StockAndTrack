package com.qaprosoft.stockproject.service;

import java.util.List;

public interface IDefaultService<T> {

    void add(T entity);

    T getById(Long id);

    void update(T entity);

    void delete(Long id);

    List<T> getAll();

}
