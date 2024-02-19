package com.mycompany.cuentas;

import java.util.List;

public interface CrudDAO<T> {
    void save(T obj);
    void update(T obj);
    void delete(String primaryKey);
    List<T> getAll();
}
