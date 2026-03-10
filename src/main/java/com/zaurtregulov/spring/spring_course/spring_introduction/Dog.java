package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dog")
@Scope("singleton")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog created!");
    }

    @Override
    public void say() {
        System.out.println("Woof-woof");
    }
}
