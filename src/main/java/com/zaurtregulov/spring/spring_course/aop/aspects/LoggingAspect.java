package com.zaurtregulov.spring.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public void com.zaurtregulov.spring.spring_course.aop.UniLibrary.getBook())")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

}
