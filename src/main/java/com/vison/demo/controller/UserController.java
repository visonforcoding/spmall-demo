package com.vison.demo.controller;

import com.vison.demo.App;
import com.vison.demo.Response;
import com.vison.demo.ResponseCode;
import com.vison.demo.dao.UserRepository;
import com.vison.demo.entity.Goods;
import com.vison.demo.entity.GoodsCat;
import com.vison.demo.entity.User;
import com.vison.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(name = "用户添加", path = "/user/add")
    public Response add(@Valid @RequestBody User user) {
        Optional<User> user1 = userRepository.findByName(user.getName());
        userRepository.save(user);
        return new Response(0, "获取成功", user);
    }

    @GetMapping(name = "统计", path = "/user/count")
    public Response count(HttpServletRequest request) {
        Map<String, Integer> data = new HashMap<>();
        userRepository.count();
        userRepository.findByName("曹");
        userRepository.findById(1L);
        log.info(String.format("something wrong count is %d",App.count.get()));
        return new Response(0, "获取成功", data);
    }

    @GetMapping(name = "用户详情",path = "/user/{id}")
    public Response detail(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new Response(ResponseCode.success, "获取成功", user.get());
        }
        return new Response(ResponseCode.noDataFound, "获取失败");
    }

}
