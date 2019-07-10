package xyz.likersai.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import xyz.likersai.awi.demo.dto.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: awi
 * @description: 测试demo的controller
 * @author: sun.ye
 * @create: 2019-04-23 01:04
 */
@Controller
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        return resolver;
    }

    @Bean
    public MappingJackson2JsonView jsonView(){
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        return jsonView;
    }

    @RequestMapping(value = "/json",produces = {MediaType.APPLICATION_JSON_VALUE})
    public String json(Model model){
        Person person = new Person("孙也",25);
        model.addAttribute("person",person);
        return "jsonView";
    }


    @RequestMapping("/hello")
    public String hello(Model model) {
        log.info("hello");
        String name = "likersai";
        model.addAttribute("name", name);
        return "demo/hello";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        log.info("index");
        String name = "likersai";
        Person me = new Person("孙也", 25);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("me", me);
        model.addAttribute("people", people);
        model.addAttribute("name", name);
        return "index";
    }

//    @RequestMapping("/ws")
//    public String ws(Model model){
//        return "ws";
//    }



}