package com.felpz.salao.dao;

import com.felpz.salao.exception.DAOException;
import java.util.List;
import org.hibernate.Criteria;

public interface IDaoGeneric<T> {

    T save(T t) throws DAOException;

    T update(T t) throws DAOException;

    T remove(T t) throws DAOException;

    T getById(Long id) throws DAOException;

    List<T> getAll() throws DAOException;

    Criteria getCriteria();

}
