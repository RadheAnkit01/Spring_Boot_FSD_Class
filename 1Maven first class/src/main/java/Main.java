import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {

        String url = "jdbc:mysql://localhost:3306/mysql-db";
        String name = "mysql";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url,name,password);
            System.out.println("Connected with my sql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
