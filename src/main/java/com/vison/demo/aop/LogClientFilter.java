package com.vison.demo.aop;

import com.vison.demo.configure.MultiReadHttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 记录客户端请求信息
 */

@Log4j2
public class LogClientFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        log.info("client request log init...");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        MultiReadHttpServletRequest wrappedRequest =
                new MultiReadHttpServletRequest(httpServletRequest);
        rootNode.put("uri", httpServletRequest.getRequestURI());
        rootNode.put("clientIp", httpServletRequest.getRemoteAddr());
        String method = httpServletRequest.getMethod();
        rootNode.put("method", method);
        String content = IOUtils.toString(wrappedRequest.getInputStream());
        if (method.equals("GET") || method.equals("DELETE")) {
            rootNode.put("request", httpServletRequest.getQueryString());
        } else {
            rootNode.put("request", content);
        }
        log.info("client request..." + rootNode);
        chain.doFilter(wrappedRequest, response);

    }

}
