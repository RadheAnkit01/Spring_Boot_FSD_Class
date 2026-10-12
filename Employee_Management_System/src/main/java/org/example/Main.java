package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/spring_db",
                    "root",
                    "root"
            );
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
