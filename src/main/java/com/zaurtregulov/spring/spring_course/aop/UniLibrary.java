package com.zaurtregulov.spring.spring_course.aop;


import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(String bookName) {
        System.out.println("Мы берем книгу из UniLibrary: " + bookName);
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
    }

    public String returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "Вернулли";
    }
}
