package com.qaprosoft.stockproject.dao;

import java.util.List;

public interface IDefaultDAO<K, E> {
	
	List<E> getAll();
	
	E getById(K id);
	
    void deleteById(K id);
    
    void createNewEntity(E entity);

}
