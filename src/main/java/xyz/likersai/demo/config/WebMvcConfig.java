package xyz.likersai.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @program: awi
 * @description: 配置viewController
 * @author: sun.ye
 * @create: 2019-05-06 22:17
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("ws");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/login").setViewName("html/login");
        registry.addViewController("/requireJsTest").setViewName("requireJsTest");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/chat").setViewName("chat");


    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX +"/static/");
//        super.addResourceHandlers(registry);
//    }

}