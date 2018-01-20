package com.tangzhihe.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    /**
     * 拦截器
     * @param registry
     * addPathPatterns 用于添加拦截规则
     * excludePathPatterns 用户排除拦截
     */
}

