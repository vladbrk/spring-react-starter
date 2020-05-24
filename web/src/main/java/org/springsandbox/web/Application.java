package org.springsandbox.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springsandbox.back.configuration.BackConfiguration;
import org.springsandbox.security.configuration.SecurityConfig;

//@SpringBootApplication(scanBasePackages = {"org.springsandbox.web", "org.springsandbox.core","org.springsandbox.back", "org.springsandbox.security"})
@SpringBootApplication(scanBasePackages = {"org.springsandbox.web"})
@PropertySource(value = "classpath:/application.properties")
@Import({SecurityConfig.class, BackConfiguration.class})
public class Application /*implements WebMvcConfigurer*/ {

    private final static String REACT_ROUTER_FORWARD = "forward:/index.html";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/test")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET")
                .allowedHeaders("*")
                .allowCredentials(false).maxAge(3600);
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://localhost:8080", "*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true).maxAge(3600);
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/**")
                        .addResourceLocations("classpath:/build/").addResourceLocations("classpath:/static/")
                        .resourceChain(true)
                        .addResolver(new PathResourceResolver());


            }

            /**
             * Created for React-Router, in order to except url handling below by Spring Boot
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/app/**").setViewName(REACT_ROUTER_FORWARD);
            }
        };
    }
}