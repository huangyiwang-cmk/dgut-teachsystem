package com.dglg.spring.controller;


import com.dglg.spring.model.User;
import com.dglg.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
//@RequestMapping("/api")
public class IndexController {

    @Autowired
    UserService userService;


    @RequestMapping("/index")
    public String index() {

        System.out.println("Hello Spring MVC ...");

        return "index";
    }

    // http://localhost:8080/zz1  or http://localhost:8080/zz2
    @RequestMapping(value = {"zz1", "zz2"})
    public String index1() {

        System.out.println("Hello Spring MVC ...");

        return "index.html";
    }

    // GET >  http://localhost:8080/index2
    @GetMapping("/index2")      // 查询
    public String index2() {

        System.out.println("GET Spring MVC ...");

        return "index.html";
    }

    // POST >  http://localhost:8080/index2
    @PostMapping("/index2")     // 新增
    public String index3() {

        System.out.println("POST Spring MVC ...");

        return "index.html";
    }

    // PUT >  http://localhost:8080/index2
    @PutMapping("/index2")  //修改
    public String index4() {

        System.out.println("PUT Spring MVC ...");

        return "index.html";
    }

    // DELETE >  http://localhost:8080/index2
    @DeleteMapping("/index2")  // 删除
    public String index5() {

        System.out.println("DELETE Spring MVC ...");

        return "index.html";
    }

    // http://localhost:8080/index6?username=zz&password=123456
    @GetMapping(value = "/index6", params = {"username", "password"})  // 删除
    public String index6(@RequestParam("username") String username, @RequestParam("password") String password) {

        System.out.println("username = " + username + " , password = " + password);

        return "index.html";
    }

    // http://localhost:8080/index7?username=zz&password=123456
    @GetMapping("/index7")  // 删除
    public String index7(String username, String password) {

        System.out.println("username = " + username + " , password = " + password);

        return "index.html";
    }

    // https://blog.csdn.net/aaatomaaa/article/details/124501107
    // http://localhost:8080/index8/9527
    @GetMapping("/index8/{id}")  // 删除
    public String index8(@PathVariable("id") String zz) {

        System.out.println("id = " + zz);

        return "index.html";
    }

    // http://localhost:8080/index9?id=10086
    @GetMapping("/index9")  // 删除
    public String index9(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("id = " + request.getParameter("id"));
        return "index";
    }

    // http://localhost:8080/index10
    @PostMapping("/index10")  // 删除
    public String index10(User user) {
        System.out.println(user);
        return "index";
    }

    // http://localhost:8080/index10
//    @GetMapping("/index11/{id}")
//    public int index11(@PathVariable("id") int id) {
//        System.out.println("id = " + id);
//
//
//        userService.getUser(id);
//
//        return id;
//
//    }

    // http://localhost:8080/index10
    @PostMapping("/index12")
    public User index12(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
