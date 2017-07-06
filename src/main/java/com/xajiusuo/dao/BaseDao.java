package com.xajiusuo.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-6-21.
 */
public interface BaseDao<PK extends Serializable, T> {

    public T get(PK id);

    public T load(PK id);

    public void persist(T entity);

    public PK save(T entity);

    public void saveOrUpdate(T entity);

    public void update(T entity);

    public void merge(T entity);

    public boolean exists(PK id);

    public int countAll();

    public int countCri(Criteria cri);

    public void delete(T entity);

    public void delete(PK id);

    public void delete(List<T> list);

    public Criteria createCriteria();

    public List<T> getList(String key, Object value);

    public List<T> getAll();

    public List<T> getList(Map<String, Object> map);

    public List<T> getListLike(String key, Object value);

    public List<T> getListLike(Map<String, Object> map);

    public List<T> getListBetween(String key, Object v1, Object v2);

    public List<T> queryHql(String hql);

    public List<T> queryHql(String hql, Map<String, Object> params);

    public List<T> queryHql(String hql, Object... objects);

    public int executeHql(String hql);

    public int executeHql(String hql, Map<String, Object> params);

    public int executeHql(String hql, Object... objects);

    public List<Map<String, Object>> querySQL(String sql, Object... params);

    public int executeBySql(String sql) throws Exception;

    public List<T> execProc(String hql);

}
