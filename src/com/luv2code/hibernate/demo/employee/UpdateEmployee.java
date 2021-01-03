package com.luv2code.hibernate.demo.employee;

import com.luv2code.hibernate.demo.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        int employeeId = 1;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            employee.setCompany("PayPal");
            session.getTransaction().commit();
        }
    }
}
