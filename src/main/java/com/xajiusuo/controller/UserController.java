package com.xajiusuo.controller;

import com.xajiusuo.entity.User;
import com.xajiusuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> page() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<Integer, Object> user_depart = new HashMap<Integer, Object>();
        System.out.println("Hello this is demo page!");
        List<User> list = userService.getAll();
        map.put("list", list);
        for (User u : list) {
            if(u.getDepart()!=null){
                System.out.println(u.getDepart().getName());
                user_depart.put(u.getID(),u.getDepart());
            }
        }
//        map.put("u_depart",user_depart);
        return map;
    }

}
