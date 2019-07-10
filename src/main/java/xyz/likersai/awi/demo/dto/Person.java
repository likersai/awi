package xyz.likersai.awi.demo.dto;

import javax.persistence.*;

/**
 * 演示Demo
 * 使用@Entity表明这是一个和数据库表应试的实体类
 * @author sun.ye
 * @since 2019-04-22 23:59
 */
@Entity
@NamedQuery(name = "Person.findByNameSelf" , query = "select p from Person p where p.name = ?1")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String address;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person(String name, Integer age,String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}