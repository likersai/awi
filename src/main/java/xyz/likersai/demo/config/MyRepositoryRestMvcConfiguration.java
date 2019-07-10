package xyz.likersai.demo.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Spring Data Rest 配置类
 * Spring Data Rest 的配置是定义在RepositoryRestMvcConfiguration配置类中已经配置好了
 * 我们可以通过继承此类或者直接在配置类上@import此配置类
 * 使用
 * @author MSI PC
 * @since 2019-05-22 23:35
 */
@Configuration
@Import(RepositoryRestMvcConfiguration.class)
public class MyRepositoryRestMvcConfiguration {
}