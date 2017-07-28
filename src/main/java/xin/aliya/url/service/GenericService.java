package xin.aliya.url.service;

import xin.aliya.url.util.Pagination;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Serializable, ID extends Number> {

    void create(T t);

    void remove(ID id);

    void remove(String statement, Object parameter);

    void modify(T t);

    void modify(String statement, Object parameter);

    T queryOne(String statement, Object parameter);

    T queryById(ID id);

    List<T> queryList(String statement, Object parameter);

    List<T> queryAll();

    Pagination<T> query(String statement, Object parameter, int currentPage);

    Pagination<T> queryAll(int currentPage);
}
