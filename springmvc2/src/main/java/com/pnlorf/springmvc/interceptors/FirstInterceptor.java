package com.pnlorf.springmvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:第一个拦截器
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/1/25.
 */
public class FirstInterceptor implements HandlerInterceptor {
    /**
     * 该方法在目标方法之前被调用
     * 若返回值为true，则继续调用后续的拦截器和目标方法。
     * 若返回值为false，则不会再调用后续的拦截器和目标方法。
     * <p>
     * 可以考虑做权限，日志，事务等
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        System.out.println("[FirstInterceptor] preHandle");
        return true;
    }

    /**
     * 调用目标方法之后，渲染视图之前被调用
     * <p>
     * 可以对请求域中的属性或视图做出修改
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        System.out.println("[FirstInterceptor] postHandle");
    }

    /**
     * 渲染视图之后被调用
     * <p>
     * 释放资源
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        System.out.println("[FirstInterceptor] afterCompletion");
    }
}
