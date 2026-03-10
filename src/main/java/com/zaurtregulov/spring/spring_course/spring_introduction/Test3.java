package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    static void main() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


//        Pet pet = context.getBean("myPet", Pet.class);
        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        System.out.println(person.getAge() + " " + person.getSurname());

        context.close();
    }
}
