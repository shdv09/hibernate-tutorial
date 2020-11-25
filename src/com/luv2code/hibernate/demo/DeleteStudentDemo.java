package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) {
            /*session.beginTransaction();
            int studentId = 9;

            //retrieving object from the database
            System.out.println("Getting student with id = " + studentId);
            Student theStudent = session.get(Student.class, studentId);
            System.out.println("Got student from database: " + theStudent);

            //deleting the student
            session.delete(theStudent);

            session.getTransaction().commit();*/

            session.beginTransaction();

            System.out.println("Deleting student with id = 10");
            session.createQuery("delete from Student where id = 10").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");


        }
    }
}
