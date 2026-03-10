package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    static void main() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("person", Person.class);
        person.callYourPet();

        context.close();
    }
}
