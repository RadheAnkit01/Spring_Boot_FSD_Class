package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    static void main() {
        //---------------------
        //    CURD Operations
        //---------------------
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession(); //taking new session
        Transaction transaction = session.beginTransaction();

        // C - Create
//        Student student1 = new Student("Karan", "SOM");
//        session.persist(student1); //create



        // R - Read
//        Student student =  session.find(Student.class,1); //finding
//        System.out.println(student.getName() + " " + student.getBranch());


        // U -Update
//        Student std =  session.find(Student.class,1); //finding
//        std.setName("Radhe Ankit"); // updating
//        Student student =  session.find(Student.class,1);
//        System.out.println("Updated : " + student.getName() + " " + student.getBranch());


        // D - Delete
//        Student std =  session.find(Student.class,1); // finding
//        session.remove(std); //deleting
// //        Student student =  session.find(Student.class,1); //trying to find again after deleting
// //        System.out.println("Updated : " + student.getName() + " " + student.getBranch());



//    // Example of session.Flush();
//        Student student3 = session.find(Student.class, 3);
//        student3.setName("Hasan 3");
//        session.flush(); // updating in database


        // Example of session.refresh();

//        Student student3 = session.find(Student.class, 3);
//        Student oldStd = session.find(Student.class, 3);
//        System.out.println(oldStd.getId() + "  " + oldStd.getName());
//
//        student3.setName("Hasan 5");
//        session.refresh(student3); // refreshing object of database
//
//        Student newStd = session.find(Student.class, 3);
//        System.out.println(newStd.getId() + "  " + newStd.getName() );



        //BULK SELECT
//        String selectHql = "FROM Student s WHERE s.branch = :branch";
//
//        List<Student> studentList = session.createQuery(selectHql, Student.class)
//                .setParameter("branch", "SOT")
//                .getResultList();
//
//        for (Iterator<Student> it = studentList.iterator(); it.hasNext(); ) {
//            Student s = it.next();
//            System.out.println("Id : " + s.getId() + " Name : " + s.getName() + " Branch : " + s.getBranch() );
//        }


        // BULK UPDATE

//        String updateHql = "UPDATE Student s SET s.branch = :newBranch Where s.branch = :oldBranch";
//
//        int updatedRows = session.createMutationQuery(selectHql)
//                .setParameter("newBranch", "SOT")
//                .setParameter("oldBranch", "SOM")
//                .executeUpdate();





        //BULK DELETE
//        String deleteHql = "DELETE FROM Student s WHERE s.branch = :branch";
//
//        int deletedRows = session.createMutationQuery(deleteHql)
//                .setParameter("branch", "SOT")
//                .executeUpdate();
//
//        System.out.println("Deleted Rows : " + deletedRows);



        //BULK SELECT By Native SQL  --> Print all students
        String selectSqlPrint = "SELECT * FROM student";

        List<Student> allStudentList = session.createNativeQuery(selectSqlPrint, Student.class)
                .getResultList();

        System.out.println("All Students List");

        for(Student s : allStudentList){
            System.out.println("Id : " + s.getId() + " Name : " + s.getName() + " Branch : " + s.getBranch() );
        }




        transaction.commit(); // commiting current Transaction
        session.close(); //closing session
        sessionFactory.close(); //closing factory
    }

}
