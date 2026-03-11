package com.zaurtregulov.spring.spring_course.hibernate_test;

import com.zaurtregulov.spring.spring_course.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    static void main() {
        Session session;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            Employee emp = new Employee("Anton", "Kulikov", "IS", 55000);

            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();

            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            System.out.println(employee.toString());
            session.getTransaction().commit();

        }
    }
}
