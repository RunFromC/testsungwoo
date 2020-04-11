package com.project.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static final String START_MSG = "======================================          START         ======================================";
    private static final String END_MSG = "======================================           END          ======================================";

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        String sessionId = req.getRequestedSessionId();

        if (log.isDebugEnabled()) {
            log.debug("REQ : [" + req.getMethod() + "] " + req.getServletPath() + "\t clientIP : " + getClientIP(req)
                    + "\t sessionID : " + sessionId);
            log.debug(START_MSG);
        }

        return super.preHandle(req, res, handler);
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) {
        if (log.isDebugEnabled()) log.debug(END_MSG);
    }

    private static String getClientIP(HttpServletRequest req) {

        String ip = req.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.length() == 0) {
            ip = req.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = req.getRemoteAddr();
        }

        return ip;
    }

}