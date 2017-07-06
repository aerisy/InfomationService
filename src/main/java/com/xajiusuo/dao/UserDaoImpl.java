package com.xajiusuo.dao;

import com.xajiusuo.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-6-13.
 */
@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<Integer, User> implements UserDao {
    /*@Override
    public List<User> getAll() {
        Criteria c = createCriteria().addOrder(Order.desc("name"));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<User> list = c.list();
        return list;
    }

    @Override
    public List<User> getBy(String key, String value) {
        //@TODO 通过字段获取对象集合 -- 未测试
        Criteria c = createCriteria().addOrder(Order.desc("name"));
        c.add(Restrictions.eq(key, value));
        List<User> list = c.list();
        return list;
    }

    @Override
    public User get(int id) {
        System.out.println("get - " + id);
        return super.get(id);
    }

    @Override
    public void save(User u) {
        System.out.println("save - " + u.getName());
        System.out.println("save - " + u.getID());
        System.out.println("save - " + u.getAddress());
        persist(u);
    }

    @Override
    public void delete(int id) {
        System.out.println("delete");
        User u = getByKey(id);
        delete(u);
    }*/

}
