package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            System.out.println("Creating 3 students objects");
            Student student1 = new Student("Dan", "Balan", "db@gmail.com");
            Student student2 = new Student("Mary", "Public", "mary@gmail.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");


            session.beginTransaction();

            System.out.println("Saving 3 students objects");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
