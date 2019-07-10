package xyz.likersai.awi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"xyz.likersai.demo.controller", "xyz.likersai.demo.config", "xyz.likersai.demo.dto"})
@ComponentScan(basePackages = {"xyz.likersai.awi.demo.dto", "xyz.likersai.demo.config","xyz.likersai.demo.controller"})
//@EnableJpaRepositories("xyz.likersai.awi.demo.dto.repository")
public class AwiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwiApplication.class, args);
    }

}

