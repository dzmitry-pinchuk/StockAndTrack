package com.qaprosoft.stockproject.service;

import java.util.List;

public interface IDefaultService<K, E> {

	List<E> getAll();

	E getById(K id);

	void deleteById(K id);

	void createNewEntity(E entity);

}
