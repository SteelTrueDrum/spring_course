package com.zaurtregulov.spring.spring_course.hibernate_test;

import com.zaurtregulov.spring.spring_course.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    static void main() {
        Session session;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 8);
//            System.out.println(employee);
//            session.remove(employee);

            session.createQuery("DELETE FROM Employee WHERE id > 8").executeUpdate();

            session.getTransaction().commit();

        }
    }
}
