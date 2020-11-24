package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) {
            session.beginTransaction();
            int studentId = 9;

            //retrieving object from the database
            System.out.println("Getting student with id = " + studentId);
            Student newStudent = session.get(Student.class, studentId);
            System.out.println("Got student from database: " + newStudent);

            //updating the student
            newStudent.setFirstName("Scooby");

            session.getTransaction().commit();

            //bulk update
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Setting e-mail for all students");
            session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
