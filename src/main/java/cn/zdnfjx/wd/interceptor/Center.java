package cn.zdnfjx.wd.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Center extends WebMvcConfigurerAdapter{
    public void addInterceptors(InterceptorRegistry registry) {
        //API拦截器
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/api/*");
        super.addInterceptors(registry);
    }
}
