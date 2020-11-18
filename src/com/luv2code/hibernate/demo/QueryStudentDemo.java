package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student s where s.lastName = 'Duck' or s.firstName = 'Dan'", Student.class).getResultList();
            printStudents(students);

            List students2 = session.createQuery("from Student s where s.email like '%@luv2code.com'").list();
            System.out.println("\nStudents with @luv2code mailbox");
            printStudents(students2);


            session.getTransaction().commit();
            System.out.println("Done");
        }
    }

    private static void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }
}
