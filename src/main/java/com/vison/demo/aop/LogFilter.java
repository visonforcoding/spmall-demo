package com.vison.demo.aop;

import com.vison.demo.App;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;

@Log4j2
public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        log.info("log filter...");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        App.count.set(0);
        String uuid = UUID.randomUUID().toString();
        MDC.put("trace-id",uuid);
        chain.doFilter(request, response);
    }
}
