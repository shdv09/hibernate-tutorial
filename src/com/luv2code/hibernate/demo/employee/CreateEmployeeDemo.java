package com.luv2code.hibernate.demo.employee;

import com.luv2code.hibernate.demo.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeeDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Employee employee = new Employee("Musk", "Elon", "Tesla Motors");

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
}
