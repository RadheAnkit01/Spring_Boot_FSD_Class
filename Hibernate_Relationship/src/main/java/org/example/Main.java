package org.example;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    static void main() {



        //Connection to database through hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Database Connected...");

        //taking new session
        Session session = sessionFactory.openSession();

        //Preparing Data

        // Insert New department
        Department newDep = new Department(101, "B.TECH CSE");

        // Inserting New Students
        Student newStudent = new Student();
        newStudent.setName("Hasan");

        // Adding in arraylist of student
        newDep.getStudents().add(newStudent);
        newStudent.setDepartment(newDep);



        //Saving to DataBase
        Transaction transaction = session.beginTransaction();
        session.persist(newDep);
        session.persist(newStudent);


        transaction.commit(); // commiting current Transaction
        session.close(); //closing session
        sessionFactory.close(); //closing factory
    }

}
