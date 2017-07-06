package com.xajiusuo.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-6-21.
 */
public abstract class BaseDaoImpl<PK extends Serializable, T> implements BaseDao<PK,T>{
//public abstract class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 根据主键获取对象
     *
     * @param id 对象ID
     */
    @SuppressWarnings("unchecked")
    public T get(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    /**
     * 加载
     *
     * @param id 对象ID
     */
    @SuppressWarnings("unchecked")
    public T load(PK id) {
        return (T) getSession().load(persistentClass, id);
    }

    /**
     * 保存对象，事物内同save，事物外persist不会执行insert语句；
     * 使用persist时更安全，规范，需要注意1.添加事物2.主键自增时不要赋值给主键
     *
     * @param entity 保存对象
     */
    public void persist(T entity) {
        getSession().persist(entity);
    }

    @SuppressWarnings("unchecked")
    public PK save(T entity) {
        return (PK) getSession().save(entity);
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void merge(T entity) {
        getSession().merge(entity);
    }

    public boolean exists(PK id) {
        return get(id) != null;
    }

    public int countAll() {
        Criteria cri = createCriteria();
        return countCri(cri);
    }

    public int countCri(Criteria cri) {
        return Integer.valueOf(cri.setProjection(Projections.rowCount()).uniqueResult().toString());
    }

    /**
     * 删除对象
     *
     * @param entity 对象实体
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void delete(PK id) {
        getSession().delete(this.get(id));
    }

    public void delete(List<T> list) {
        if (list != null && list.size() > 0) {
            for (T entity : list) {
                getSession().delete(entity);
            }
        }
    }

    public Criteria createCriteria() {
        return getSession().createCriteria(persistentClass);
    }

    /**
     * 获取全部对象
     *
     * @return 返回结果集合
     */
    public List<T> getAll() {
        Criteria c = createCriteria().addOrder(Order.desc("name"));
        System.out.println("go");
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<T> list = c.list();
        System.out.println(c);
        return list;/*
        Criteria cri = createCriteria();
//        Criteria cri = getSession().createCriteria(persistentClass);
        cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return cri.list();*/
    }

    /**
     * 通过条件获取集合，匹配方式为=
     *
     * @param key   字段
     * @param value 值
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> getList(String key, Object value) {
        Criteria cri = getSession().createCriteria(persistentClass);
        cri.add(Restrictions.eq(key, value));
        return cri.list();
    }


    /**
     * 通过条件获取集合，匹配方式为=，多个条件
     *
     * @param map 条件集合，key字段，value值
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> getList(Map<String, Object> map) {
        if (map != null && map.keySet().size() > 0) {
            Criteria cri = getSession().createCriteria(persistentClass);
            for (String key : map.keySet()) {
                cri.add(Restrictions.eq(key, map.get(key)));
            }
            return cri.list();
        } else {
            return null;
        }
    }

    /**
     * 通过条件获取集合，匹配方式为like
     *
     * @param key   字段
     * @param value 值
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> getListLike(String key, Object value) {
        Criteria cri = getSession().createCriteria(persistentClass);
        cri.add(Restrictions.like(key, value));
        return cri.list();
    }

    /**
     * 通过条件获取集合，匹配方式为like，多个条件
     *
     * @param map 条件集合，key字段，value值
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> getListLike(Map<String, Object> map) {
        if (map != null && map.keySet().size() > 0) {
            Criteria cri = getSession().createCriteria(persistentClass);
            for (String key : map.keySet()) {
                cri.add(Restrictions.like(key, map.get(key)));
            }
            return cri.list();
        } else {
            return null;
        }
    }

    /**
     * 通过条件获取集合，匹配方式为between
     *
     * @param key 字段
     * @param v1  左区间
     * @param v2  右区间
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> getListBetween(String key, Object v1, Object v2) {
        Criteria cri = getSession().createCriteria(persistentClass);
        cri.add(Restrictions.between(key, v1, v2));
        return cri.list();
    }

    /******************************
     * ******** HQL相关查询 ********
     ******************************/

    /**
     * 通过HQL查询集合
     *
     * @param hql 查询HQL
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> queryHql(String hql) {
        Query q = getSession().createQuery(hql);
        return q.list();
    }

    /**
     * 通过HQL查询集合，带参数
     *
     * @param hql    查询语句
     * @param params 参数
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> queryHql(String hql, Map<String, Object> params) {
        Query q = getSession().createQuery(hql);
        this.setParameterToQuery(q, params);
        return q.list();
    }

    /**
     * 通过HQL查询集合，带参数
     *
     * @param hql     查询语句
     * @param objects 参数
     * @return 返回结果集合
     */
    @SuppressWarnings("unchecked")
    public List<T> queryHql(String hql, Object... objects) {
        Query q = getSession().createQuery(hql);
        this.setParameterToQuery(q, objects);
        return q.list();
    }

    /**
     * 执行HQL语句
     *
     * @param hql 执行HQL
     * @return 返回执行条数
     */
    public int executeHql(String hql) {
        Query q = getSession().createQuery(hql);
        return q.executeUpdate();
    }

    /**
     * 执行HQL语句，参数为
     *
     * @param hql    执行HQL
     * @param params 参数
     * @return 返回执行条数
     */
    public int executeHql(String hql, Map<String, Object> params) {
        Query q = getSession().createQuery(hql);
        this.setParameterToQuery(q, params);
        return q.executeUpdate();
    }

    public int executeHql(String hql, Object... objects) {
        Query q = getSession().createQuery(hql);
        this.setParameterToQuery(q, objects);
        return q.executeUpdate();
    }

    /**
     * @param q      Query
     * @param params 当前支持普通对象,不支持集合与数组
     */
    protected void setParameterToQuery(Query q, Object... params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                Object object = params[i];
                q.setParameter(i, object);
            }
        }
    }

    /**
     * @param q      Query
     * @param params 当前支持普通对象,数组,集合三种类型的参数
     */
    protected void setParameterToQuery(Query q, Map<String, Object> params) {
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                if (params.get(key) instanceof Object[]) {
                    Object[] objs = (Object[]) params.get(key);
                    q.setParameterList(key, objs);
                } else if (params.get(key) instanceof Collection<?>) {
                    Collection<?> collection = (Collection<?>) params.get(key);
                    q.setParameterList(key, collection);
                } else {
                    q.setParameter(key, params.get(key));
                }
            }
        }
    }

    /******************************
     ********* SQL相关查询 ********
     ******************************/

    /**
     * 通过sql查询，结果集直接返回
     *
     * @param sql    查询语句
     * @param params 查询参数
     * @return List d
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> querySQL(String sql, Object... params) {
        Query query = getSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        this.setParameterToQuery(query, params);
        return query.list();
    }


    /**
     * 执行原生态的sql语句，添加、删除、修改语句
     *
     * @param sql 执行SQL
     * @throws Exception
     */
    public int executeBySql(String sql) throws Exception {
        try {
            return getSession().createSQLQuery(sql).executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //********************************************

    /**
     * 调用存储过程
     *
     * @param hql 执行HQL
     */
    @SuppressWarnings("unchecked")
    public List<T> execProc(String hql) {
        Query q = getSession().getNamedQuery(hql);
        return q.list();
    }

    //@TODO 实现page分页相关方法
}
