package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

    @Autowired
    @Qualifier("cat")
    private Pet pet;
    @Value("Burdukov")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person() {
        System.out.println("Person created!");
    }

//    @Autowired
//    public Person(Pet pet) {
//        System.out.println("Person created!");
//        this.pet = pet;
//    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Person: set age");
        this.age = age;
    }

    public void setPet(Pet pet) {
        System.out.println("Class person - pet set");
        this.pet = pet;
    }
}
