package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    static void main() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

//        Cat myCat = context.getBean("myPet", Cat.class);
//        myCat.setName("Barsik");
//        Cat yourCat = context.getBean("myPet", Cat.class);
//        yourCat.setName("Vasya");
//
//        System.out.println(myCat.getName());
//        System.out.println(yourCat.getName());

//        System.out.println("Переменные ссылаются на один и тот же объект? " + (myCat == yourCat));
//        System.out.println(myCat);
//        System.out.println(yourCat);

        context.close();

    }
}
