package org.example;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Student example = new Student();
        Student secondExample = new Student();

        example.setName("Tosho");
        secondExample.setName("Pesho");

        session.persist(example);
        session.persist(secondExample);

        Student stud1 = session.get(Student.class, 1);
        System.out.println(stud1.getId() + " " + stud1.getName());

        session.getTransaction().commit();
        session.close();
    }
}