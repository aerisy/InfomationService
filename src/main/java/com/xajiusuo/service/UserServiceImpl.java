package com.xajiusuo.service;

import com.xajiusuo.dao.UserDao;
import com.xajiusuo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017-6-13.
 */
//("UserService")
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<Integer, User> implements UserService {

    /*@Autowired
    protected UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }*/

    @Resource
    public void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
    }

   /* @Override
    public User load(Integer id) {
        User u = super.load(id);
        System.out.println("load departname:");
        System.out.println(u.getDepart().getName());
        return u;
    }

    @Override
    public User get(Integer id) {
        User u = super.load(id);
        System.out.println("get departname:");
        System.out.println(u.getDepart().getName());
        return u;
    }*/


    /*@Autowired
    UserDao dao;

    @Override
    public void save(User u) {
        dao.save(u);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User get(int id) {
        return dao.get(id);
    }

    @Override
    public List<User> getList(String key,Object value){
        return dao.getList(key,value);
    }*/
}
