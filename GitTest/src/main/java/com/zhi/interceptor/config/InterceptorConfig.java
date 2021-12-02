package com.zhi.interceptor.config;

import com.zhi.interceptor.interceptors.FirstInterceptor;
import com.zhi.interceptor.interceptors.SecondInterceptor;
import com.zhi.interceptor.interceptors.ThirdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(secondInterceptor()).addPathPatterns("/user/get");
        registry.addInterceptor(thirdInterceptor()).addPathPatterns("/**");
    }
}
