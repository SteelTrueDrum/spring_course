package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    static void main() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Cat myCat = context.getBean("myPet", Cat.class);
        Cat yourCat = context.getBean("myPet", Cat.class);
        myCat.say();


        context.close();
    }
}
