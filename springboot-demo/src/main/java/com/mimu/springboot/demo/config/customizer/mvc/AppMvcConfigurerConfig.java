package com.mimu.springboot.demo.config.customizer.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration(proxyBeanMethods = false)
public class AppMvcConfigurerConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(AppMvcConfigurerConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("AppMvcConfigurerCustomer preHandle {}", handler.getClass().getCanonicalName());
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                super.postHandle(request, response, handler, modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                super.afterCompletion(request, response, handler, ex);
            }

            @Override
            public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                super.afterConcurrentHandlingStarted(request, response, handler);
            }
        });
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new HandlerMethodArgumentResolver() {
            @Override
            public boolean supportsParameter(MethodParameter parameter) {
                boolean paraFlag = false;
                //paraFlag = parameter.hasMethodAnnotation(aAnnotation.class);
                //paraFlag = parameter.getParameterType().isAnnotationPresent(aAnnotation.class);
                return paraFlag;
            }

            @Override
            public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
                return null;
            }
        });
    }
}
