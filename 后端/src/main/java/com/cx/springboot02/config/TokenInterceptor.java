package com.cx.springboot02.config;

import com.alibaba.fastjson.JSONObject;
import com.cx.springboot02.common.ResultCode;
import com.cx.springboot02.common.ResultTool;
import com.cx.springboot02.common.utils.*;
import com.cx.springboot02.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 验证token，是否登录
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    RedisOperator  redisOperator;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IBusinessService iBusinessService;

    @Autowired
    ICustomerServiceService iCustomerServiceService;

    @Autowired
    IManagerService iManagerService;


    /**
     * 忽略拦截的url
     */
    private final List<String> urls = Arrays.asList(
            "/customer/registered",
            "/customer/login",
            "/fastDFS/**"
    );
    @Autowired
    ICustomerService customerService;
    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("进入拦截器");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        //如果不是映射到方发直接通过
        if(!(handler instanceof HandlerMethod))return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //拿到clz对象
        Class clz = method.getClass();


        //不拦截路径（登录路径等等）
        String uri = httpServletRequest.getRequestURI();
        if(urls.contains(uri)) return true;


        //判断是否有放行注解
        Unobstructed unobstructed = method.getAnnotation(Unobstructed.class);
        if(unobstructed!=null) return true;//有就直接放行

        //2.拿到请求头里面的token（如果是第一次登录，那么是没有请求头的）
        String token = httpServletRequest.getHeader("token");
        if(token==null){
            //2.1 拦截请求并返回信息给前台 （前台后置拦截器就是根据这里面返回的json数据，来判读并跳转到登录界面）
            httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.USER_ACCOUNT_TOKEN_NULL)));
            return false;
        }else{
            //根据前端的token取出对应的身份(枚举类)
            AuthorizeType identity = AuthorizeType.StringToAuthorizeType(JwtUtils.getValue(token, "identity"));
            if(identity==null) {
                httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.USER_ACCOUNT_TOKEN_ERROR)));
                return false;
            }
            //根据前端的token取出对应的name,password
            String name = JwtUtils.getValue(token, "name");
            String password = JwtUtils.getValue(token, "password");
            if(password==null || name==null) {
                httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.USER_ACCOUNT_TOKEN_ERROR)));
                return false;
            }
            //判断name和身份去对应的表当中身份,看是否存在此用户
            if(identity.equals(AuthorizeType.CUSTOMER)){
                if(iCustomerService.login(name, password)) return true;
            }else if(identity.equals(AuthorizeType.MANAGE)){
                if(iManagerService.login(name, password)) return true;
            }else if(identity.equals(AuthorizeType.CUSTOMER_SERVICE)){
                if(iCustomerServiceService.login(name, password)) return true;
            }else if(identity.equals(AuthorizeType.BUSINESS)){
                if(iBusinessService.login(name, password)) return true;
            }
            //判断token是否正确或者过时,从redis当中根据name取出对应的token,这里redis以name+":"+"token"为key的方式去取
            String token_redis = redisOperator.get(name+":token");
            //如果token不满足
            if(!(token.equals(token_redis))){
                httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.USER_ACCOUNT_TOKEN_ERROR)));
                return false;
            }
            //判断是否有权限发此请求
            //拿到方法上的注解,为空或者没有权限参数的方法不给访问
            PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);
            PreAuthorize preAuthorizeCLZ = (PreAuthorize) clz.getAnnotation(PreAuthorize.class);
            //当类上没有注解时 并且 方法上也没有注解的时候
            if((preAuthorize==null || preAuthorize.values().length==0)&& (preAuthorizeCLZ==null || preAuthorizeCLZ.values().length==0)){
                httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.NO_PERMISSION)));
                return false;
            }
            //拿到类上的权限列表,判断类上的注解是否符合
            AuthorizeType[] values = preAuthorizeCLZ.values();
            for (AuthorizeType authorizeType : values) {
                if(identity.equals(authorizeType)){
                    return true;
                }
            }
            //拿到方法上面的权限列表
            assert preAuthorize != null;values = preAuthorize.values();
            for (AuthorizeType authorizeType : values) {
                if(identity.equals(authorizeType)){
                    return true;
                }
            }
        }

        httpServletResponse.getWriter().print(JSONObject.toJSON(ResultTool.fail(ResultCode.COMMON_FAIL)));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // System.out.println("处理请求完成后视图渲染之前的处理操作");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // System.out.println("视图渲染之后的操作");
    }
}

