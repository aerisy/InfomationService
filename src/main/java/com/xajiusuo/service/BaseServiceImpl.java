package com.xajiusuo.service;

import com.xajiusuo.dao.BaseDao;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-6-21.
 */
public class BaseServiceImpl<PK extends Serializable, T> implements BaseService<PK, T> {


    protected BaseDao<PK, T> baseDao;

    public BaseDao<PK, T> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<PK, T> baseDao) {
        this.baseDao = baseDao;
    }

    public T get(PK id) {
        return baseDao.get(id);
    }

    public T load(PK id) {
        return baseDao.load(id);
    }

    public void persist(T entity) {
        baseDao.persist(entity);
    }

    public PK save(T entity) {
        return baseDao.save(entity);
    }

    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void merge(T entity) {
        baseDao.merge(entity);
    }

    public boolean exists(PK id) {
        return baseDao.exists(id);
    }

    public int countAll() {
        return baseDao.countAll();
    }

    public int countCri(Criteria cri) {
        return baseDao.countCri(cri);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void delete(PK id) {
        baseDao.delete(id);
    }

    public void delete(List<T> list) {
        baseDao.delete(list);
    }

    public Criteria createCriteria() {
        return baseDao.createCriteria();
    }

    public List<T> getList(String key, Object value) {
        return baseDao.getList(key, value);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    public List<T> getList(Map<String, Object> map) {
        return baseDao.getList(map);
    }

    public List<T> getListLike(String key, Object value) {
        return baseDao.getListLike(key, value);
    }

    public List<T> getListLike(Map<String, Object> map) {
        return baseDao.getListLike(map);
    }

    public List<T> getListBetween(String key, Object v1, Object v2) {
        return baseDao.getListBetween(key, v1, v2);
    }

    public List<T> queryHql(String hql) {
        return baseDao.queryHql(hql);
    }

    public List<T> queryHql(String hql, Map<String, Object> params) {
        return baseDao.queryHql(hql, params);
    }

    public List<T> queryHql(String hql, Object... objects) {
        return baseDao.queryHql(hql, objects);
    }

    public int executeHql(String hql) {
        return baseDao.executeHql(hql);
    }

    public int executeHql(String hql, Map<String, Object> params) {
        return baseDao.executeHql(hql, params);
    }

    public int executeHql(String hql, Object... objects) {
        return baseDao.executeHql(hql, objects);
    }

    public List<Map<String, Object>> querySQL(String sql, Object... params) {
        return baseDao.querySQL(sql, params);
    }

    public int executeBySql(String sql) throws Exception {
        return baseDao.executeBySql(sql);
    }

    public List<T> execProc(String hql) {
        return execProc(hql);
    }


}
