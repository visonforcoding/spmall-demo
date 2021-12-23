package com.vison.demo.service;

import com.vison.demo.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
//@Scope("prototype")
public class UserService {

    @Autowired
    private HttpServletRequest request;

    public int count(App app) {
        return 1;
    }
}
