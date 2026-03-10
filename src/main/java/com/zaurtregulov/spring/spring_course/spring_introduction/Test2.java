package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    static void main() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        context.close();
    }
}
