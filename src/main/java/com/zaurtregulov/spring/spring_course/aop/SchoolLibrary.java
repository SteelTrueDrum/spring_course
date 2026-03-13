package com.zaurtregulov.spring.spring_course.aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }
}
