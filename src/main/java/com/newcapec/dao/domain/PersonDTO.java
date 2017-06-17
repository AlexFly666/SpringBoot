package com.newcapec.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Title: 用户实体
 * @ClassName: com.newcapec.dao.domain.Person.java
 * @Description:
 *
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-17 15:08
 * @version V1.0
 */
@Entity
@Table(name = "person")
@ApiModel("Person(用户实体)")
public class PersonDTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @ApiModelProperty("主键id")
    private Long id;

    @Column(name = "name", length = 45)
    @ApiModelProperty("姓名")
    private String name;

    @Column(name = "age")
    @ApiModelProperty("年龄")
    private Integer age;

    @Column(name = "address", length = 45)
    @ApiModelProperty("地址")
    private String address;

    public PersonDTO() {
    }

    public PersonDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public PersonDTO(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public PersonDTO(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDTO person = (PersonDTO) o;

        if (!id.equals(person.id)) return false;
        if (!name.equals(person.name)) return false;
        if (!age.equals(person.age)) return false;
        return address.equals(person.address);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        PersonDTO person = new PersonDTO();
        person.setId(1L);
        person.setAddress("2");
        person.setAge(3);
        person.setName("4");

        PersonDTO person1 = new PersonDTO();
        person1.setId(1L);
        person1.setAddress("2");
        person1.setAge(3);
        person1.setName("4");


        boolean equals = person.equals(person1);
        System.out.println(equals);

    }

}
