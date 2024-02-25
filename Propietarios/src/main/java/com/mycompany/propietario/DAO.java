package com.mycompany.propietario;


import java.util.List;

public interface DAO<T, K> {
    T findById(K id);
    List<T> findAll();
    void insert(T obj);
    void update(T obj);
    void delete(T obj);
}

