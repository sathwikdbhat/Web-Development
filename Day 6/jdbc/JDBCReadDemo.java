package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCReadDemo {
    static void main(String[] args) throws Exception{
        //Load the JDBC Driver  [jar file]
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Start / Establish the connection
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/snpsu_ise_jdbc",
                "root",
                "sathwik");
        System.out.println("Connection Established!!!");
    }
}