package com.vison.demo.controller;

import com.vison.demo.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(path = "/hello", method = {RequestMethod.GET,RequestMethod.POST}, name = "欢迎")
    public String hello() {
        return "hello,world";
    }

    @RequestMapping(path = "/response", method = {RequestMethod.GET}, name = "对象返回")
    public Response response() {
        logger.debug("对象返回接口被调用");
        return new Response(0, "获取成功");
    }
}
