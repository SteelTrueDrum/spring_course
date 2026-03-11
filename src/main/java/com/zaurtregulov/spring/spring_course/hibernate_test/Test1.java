package com.zaurtregulov.spring.spring_course.hibernate_test;

import com.zaurtregulov.spring.spring_course.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    static void main() {
        Session session;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            Employee emp = new Employee("Sergey", "Yuriev", "1C_DEV", 58000);

            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
        }
    }
}
