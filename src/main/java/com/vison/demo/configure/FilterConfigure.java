package com.vison.demo.configure;

import com.vison.demo.aop.LogClientFilter;
import com.vison.demo.aop.LogFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FilterConfigure {

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        FilterRegistrationBean<LogFilter> bean = new FilterRegistrationBean<LogFilter>();
        bean.setFilter(new LogFilter());
        bean.addUrlPatterns("/*");//过滤所有路径
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<LogClientFilter> logClientFilter() {
        FilterRegistrationBean<LogClientFilter> bean = new FilterRegistrationBean<LogClientFilter>();
        bean.setFilter(new LogClientFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(3);
        return bean;
    }

    //    @Bean
    public CustomizedRequestLoggingFilter logInitFilter() {
        log.info("logInitFilter...");
        CustomizedRequestLoggingFilter filter
                = new CustomizedRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(2048);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }


}
