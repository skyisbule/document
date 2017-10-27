package cn.zdnfjx.wd.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class Center extends WebMvcConfigurerAdapter{

    @Bean
    AuthInterceptor Auth(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //API拦截器
        registry.addInterceptor(Auth()).addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //静态资源拦截器
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
