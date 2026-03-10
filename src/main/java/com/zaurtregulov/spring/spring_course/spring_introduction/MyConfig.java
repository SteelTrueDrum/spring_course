package com.zaurtregulov.spring.spring_course.spring_introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.zaurtregulov.spring.spring_course.spring_introduction")
@PropertySource("classpath:myApp.properties")
public class MyConfig {

}
