package com.example.SoftwareLocacao.security.authentication;

import com.example.SoftwareLocacao.security.authentication.cookie.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{


        if (CookieService.getCookie(request,"administradorId") != null){
            return true;
        }

        response.sendRedirect("/login");
        return false;
        //       return true; //permitir todo acesso para trablhar as pags


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{
    }




}