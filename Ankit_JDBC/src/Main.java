import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static  void main(String[]args){
        String url = "JDBC:mysql://localhost:3306/mysql-db";
        String user = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url,user,password)){
            if(connection!=null){
                System.out.println("Connection Established Successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
