package com.xajiusuo.controller;

import com.xajiusuo.entity.User;
import com.xajiusuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
//@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/list")
//    @RequestMapping(value = "list", method = RequestMethod.GET)
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
                try {
                user_depart.put(u.getID(),u.getDepart().clone());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        map.put("u_depart",user_depart);
        map.put("data_info","用户列表");
        return map;
    }

}
