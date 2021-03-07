package com.qyl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qyl.enums.ResponseEnum;
import com.qyl.utils.ResponseEntity;
import com.qyl.utils.component.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: qyl
 * @Date: 2021/2/8 21:53
 * @Description: 权限拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseEntity<Void> responseEntity;
        // 从请求头中获取token
        String token = request.getHeader("token");
        try {
            TokenUtil.verifyToken(token);
            return true;
        } catch (Exception e) {
            responseEntity = ResponseEntity.fail(ResponseEnum.TOKEN_ERROR.getCode(), ResponseEnum.TOKEN_ERROR.getMsg());
        }
        // 错误响应以json格式写出
        String json = new ObjectMapper().writeValueAsString(responseEntity);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
