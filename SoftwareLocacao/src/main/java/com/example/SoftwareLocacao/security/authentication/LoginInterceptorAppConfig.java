package com.example.SoftwareLocacao.security.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors (InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/login",
                        "/login?error",
                        "/static/**"
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
    }

}