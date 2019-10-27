package pers.lrf.weixinserver.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务调用的拦截器
 * @author lirufeng
 * @date 2019/10/12 18:38
 **/
@Slf4j
public class ServerCallInterceptor implements HandlerInterceptor, InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
//        do nothing
    }

    /**
     * 该方法在controller服务调用之前调用
     * @param request
     * @param response
     * @param o
     * @return boolean
     * @throws Exception e
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("用户名: "+request.getRemoteUser()+
                ", IP: "+request.getRemoteAddr()+
                ", 端口: "+request.getRemotePort());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
//        do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
//        do nothing
    }
}
