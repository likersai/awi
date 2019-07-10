package xyz.likersai.demo.config;

import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

/**
 * @program: awi
 * @description: Jpa的配置类
 * @author: MSI PC
 * @create: 2019-05-20 14:07
 */
//@Configuration
//@EnableJpaRepositories("xyz.likersai.awi.demo.dto.repository")
public class JpaConfiguration {
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return null;
    }
//    还需要配置DataSource，PlatformTransactionManager等相关bean
}