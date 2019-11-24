package com.ks.cinema_site.configs;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.reactive.context.ReactiveWebApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = {"com.ks"})
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.addRedirectViewController("/", "/product");
        registry.addRedirectViewController("/swagger", "/swagger-ui.html");
        registry.addRedirectViewController("/login*", "/");
    }

//
//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver() {
//
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }

    //    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        ReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
//        freeMarkerConfigurer.setResourceLoader(applicationContext);
//        return freeMarkerConfigurer;
//    }
//
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/swagger-ui.html",
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/fonts/**",
                "/js/**")
                .addResourceLocations("/swagger-ui.html",
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/fonts/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

}
