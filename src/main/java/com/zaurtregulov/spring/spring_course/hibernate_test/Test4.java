package com.zaurtregulov.spring.spring_course.hibernate_test;

import com.zaurtregulov.spring.spring_course.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4 {
    static void main() {
        Session session;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(42500);

            session.createQuery("UPDATE Employee set salary = 45000 WHERE name = 'Anton'")
                    .executeUpdate();


            session.getTransaction().commit();

        }
    }
}
