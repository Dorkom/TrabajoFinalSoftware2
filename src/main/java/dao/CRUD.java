/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author orope
 */
public interface CRUD<T> {

    T findById(int id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(int id);
}
