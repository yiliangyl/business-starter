package com.qyl.config;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.qyl.annotation.TokenRequired;
import com.qyl.enums.ResponseEnum;
import com.qyl.exception.ResponseException;
import com.qyl.mapper.UserMapper;
import com.qyl.pojo.User;
import com.qyl.utils.component.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: qyl
 * @Date: 2021/2/8 21:53
 * @Description: 权限拦截器
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        String token = request.getHeader("token");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有 TokenRequired 注解
        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired tokenRequired = method.getAnnotation(TokenRequired.class);
            if (tokenRequired.required()) {
                // 执行认证
                if (StringUtils.isEmpty(token)) {
                    log.error("token为空，访问路径为：" + request.getRequestURL());
                    throw new ResponseException("token为空", ResponseEnum.TOKEN_EMPTY.getCode(), ResponseEnum.TOKEN_EMPTY.getMsg());
                }
                // 获取 token 中的信息(userId)
                Integer userId = null;
                try {
                    userId = Integer.parseInt(TokenUtil.verifyToken(token));
                } catch (TokenExpiredException e) {
                    log.error("token已过期，访问路径为：" + request.getRequestURL());
                    throw new ResponseException("token已过期", ResponseEnum.TOKEN_EXPIRED.getCode(), ResponseEnum.TOKEN_EXPIRED.getMsg());
                } catch (JWTDecodeException e) {
                    log.error("token解析出错，访问路径为：" + request.getRequestURL());
                    e.printStackTrace();
                }
                User user = userMapper.selectUserById(userId);
                // 用户不存在
                if (user == null) {
                    log.error("用户不存在，访问路径为：" + request.getRequestURL());
                    throw new ResponseException("用户不存在", ResponseEnum.USER_NOT_FOUND.getCode(), ResponseEnum.USER_NOT_FOUND.getMsg());
                } else {
                    return true;
                }
            }
        }
        return true;
    }
}
