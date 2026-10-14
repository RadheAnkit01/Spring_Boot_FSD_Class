package org.example;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/spring_db",
//                    "root",
//                    "root"
//            );
//            System.out.println("Success");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();

        for (Employee employee : employees){
            System.out.println(employee);
        }

        Employee employee = new Employee("Ankit","avnkasjd@sdfmv.cdk", "SOT", 2000,"987869766");

    }
}
