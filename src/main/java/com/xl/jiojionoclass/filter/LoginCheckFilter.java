package com.xl.jiojionoclass.filter;

import com.alibaba.fastjson.JSON;
import com.xl.jiojionoclass.common.R;
import com.xl.jiojionoclass.config.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter{
    @Autowired
    private JwtConfig jwtConfig;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求的URI
        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}",requestURI);
        String token = request.getHeader("token");
        if(token==null){
            response.getWriter().write(JSON.toJSONString(R.error("token_fail")));
            return;
        }
        boolean b = jwtConfig.verifierToken(token);
        if (!b){
            response.getWriter().write(JSON.toJSONString(R.error("token_fail")));
            return;
        }
        log.info("已放行请求：{}",requestURI);
        filterChain.doFilter(request,response);
        return;

    }

}
