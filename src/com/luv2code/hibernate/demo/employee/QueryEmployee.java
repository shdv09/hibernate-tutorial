package com.luv2code.hibernate.demo.employee;

import com.luv2code.hibernate.demo.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List employees = session.createQuery("from Employee e where e.company = 'Tesla Motors'")
                    .list();
            employees.forEach(System.out::println);
        }
    }
}
