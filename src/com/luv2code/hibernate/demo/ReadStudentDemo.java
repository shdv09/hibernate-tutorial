package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student tempStudent;

        try (Session session = sessionFactory.getCurrentSession()) {

            System.out.println("Creating new student object");
            tempStudent = new Student("Duffy", "Duck", "duffyDuck@gmail.com");
            System.out.println("New student created: " + tempStudent);

            session.beginTransaction();

            System.out.println("Saving student object");
            session.save(tempStudent);
            System.out.println("Assigned id is: " + tempStudent.getId());

            session.getTransaction().commit();

            System.out.println("Done");
        }

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            //retrieving object from the database
            Student newStudent = session.get(Student.class, tempStudent.getId());

            session.getTransaction().commit();
            System.out.println("Got student from database: " + newStudent);
        }
    }
}
