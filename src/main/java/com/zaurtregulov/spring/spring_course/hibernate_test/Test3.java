package com.zaurtregulov.spring.spring_course.hibernate_test;

import com.zaurtregulov.spring.spring_course.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    static void main() {
        Session session;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {

            session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> emps = session.createQuery("FROM Employee").getResultList();
            List<Employee> emps = session.createQuery("FROM Employee " + "WHERE name = 'Anton'" + " AND salary > 45000").getResultList();

            for (Employee emp : emps) {
                System.out.println(emp);
            }




            session.getTransaction().commit();

        }
    }
}
