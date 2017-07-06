package com.xajiusuo.controller;

import com.xajiusuo.entity.User;
import com.xajiusuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/i3 0003.
 */

@Controller
@RequestMapping(value = "/hi/")
public class BbyController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "page")
    public String page() {
        System.out.println("Hello this is demo page!");
        return "pageDemo";
//        return "main";
    }


    @RequestMapping(value = "my{page}")
    public String myPage(@PathVariable("page") String page) {
        System.out.println(page);
        System.out.println("Hello this is demo page!");
        return page;
    }

    @RequestMapping(value = "my/{page}")
    public String my_Page(@PathVariable("page") String page) {
        System.out.println("will go to my/" + page);
        return "/" + page;
    }

    @RequestMapping(value = "add{name}", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String addUser(@PathVariable("name") String name) {
        System.out.println("addUser:" + name);
        double ran = Math.random();
        User u = new User();
        u.setName(name);
        u.setAddress("西安市高新区创新大厦" + (ran + "").substring(4, 5) + "栋" + (ran + "").substring(6, 9) + "室");
        u.setIdcard("61" + (int) (ran * 1000000000) + "");
        u.setSex((ran * 10) < 5 ? "male" : "female");
        u.setTelephone(1 + (ran + "").substring(6, 16));
        userService.save(u);
        System.out.println(u.getID());
        System.out.println(u.toString());
        return "Hello this is 消息！" + u.getID();
    }

    @RequestMapping(value = "show{id}", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String showUser(@PathVariable("id") int id) {
        String out = "用户信息:\r\n";
        User u = userService.get(id);
        out += ("用户ID:" + id) + "\r\n";
        out += ("用户名称:" + u.getName()) + "\r\n";
        out += ("用户性别:" + u.getSex()) + "\r\n";
        out += ("用户IDCARD:" + u.getIdcard()) + "\r\n";
        out += ("用户联系方式:" + u.getTelephone()) + "\r\n";
        out += ("用户住址:" + u.getAddress()) + "\r\n";
        if (u.getDepart() != null) {
            out += ("用户机构ID:" + u.getDepart().getID()) + "\r\n";
            out += ("用户机构名称:" + u.getDepart().getName()) + "\r\n";
        }
        return out;
    }

    @RequestMapping(value = "getall", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String getAllUser() {
        System.out.println("get all User.");
        List<User> list = userService.getAll();
        String out = "";
        if (list == null || list.size() == 0) {
            out = "没有用户！";
        } else {
            for (User u : list) {
                out += u.toString() + "\r\n";
            }
        }
        for (Map<String, Object> map : userService.querySQL("select name from basic_user", new Object[]{})) {
            System.out.println(map.get("name"));
        }
        return out;
    }

    @RequestMapping(value = "getuser/{key}/{value}", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String getUser(@PathVariable("key") String key, @PathVariable("value") String value) {
        System.out.println("get all User.");
        List<User> list = userService.getList(key, value);
        String out = "";
        if (list == null || list.size() == 0) {
            out = "没有用户！";
        } else {
            for (User u : list) {
                out += u.toString() + "\r\n";
            }
        }
        return out;
    }


    @RequestMapping(value = "message", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String message() {
        System.out.println("message:");
        return "Hello this is 消息！";
    }

    @RequestMapping(value = "message_fail", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String message_fail() {
        System.out.println("message_fail:");
        return "login failure！";
    }

    public static void main(String[] args) {
        double d = Math.random();
        System.out.println("61" + (int) (d * 1000000000) + "");
        System.out.println((int) (d * 10));
    }
}
