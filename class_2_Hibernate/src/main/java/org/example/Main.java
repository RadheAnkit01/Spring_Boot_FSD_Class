package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    static void main() {
        //---------------------
        //    CURD Operations
        //---------------------
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        // C - Create
        Session session = sessionFactory.openSession(); //taking new session
        Transaction transaction = session.beginTransaction();
        Student student1 = new Student("Karan", "SOM");
        session.persist(student1); //create
        transaction.commit();
        session.close(); //closing session
        sessionFactory.close(); //closing factory


        // R - Read
//        Session session = sessionFactory.openSession(); //taking new session
//        Transaction transaction = session.beginTransaction();
//        Student student =  session.find(Student.class,1); //finding
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
//        System.out.println(student.getName() + " " + student.getBranch());


        // U -Update
//        Session session = sessionFactory.openSession(); //taking new session
//        Transaction transaction = session.beginTransaction();
//        Student std =  session.find(Student.class,1); //finding
//        std.setName("Radhe Ankit"); // updating
//        Student student =  session.find(Student.class,1);
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
//        System.out.println("Updated : " + student.getName() + " " + student.getBranch());


        // D - Delete
//        Session session = sessionFactory.openSession(); //taking new session
//        Transaction transaction = session.beginTransaction();
//        Student std =  session.find(Student.class,1); // finding
//        session.remove(std); //deleting
// //        Student student =  session.find(Student.class,1); //trying to finding again after deleting
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
// //        System.out.println("Updated : " + student.getName() + " " + student.getBranch());
    }

}
