package xyz.likersai.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.likersai.awi.demo.dto.Person;

import xyz.likersai.awi.demo.dto.repository.PersonRepository;




/**
 * JPA数据控制器
 *
 * @author MSI PC
 * @since 2019-05-22 00:03
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person person = personRepository.save(new Person(name,age,address));
        return person;
    }

}