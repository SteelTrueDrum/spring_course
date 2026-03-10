package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class ScopeTest {
    static void main() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");

        String[] dog = context.getBeanNamesForType(Dog.class);
        System.out.println(Arrays.toString(dog));

    }
}
