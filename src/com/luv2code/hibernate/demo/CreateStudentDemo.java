package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            System.out.println("Creating new student object");
            Student student = new Student("Dan", "Balan", "db@gmail.com");

            session.beginTransaction();

            System.out.println("Saving student object");
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
