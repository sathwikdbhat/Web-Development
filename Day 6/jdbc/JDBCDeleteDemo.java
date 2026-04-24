package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCDeleteDemo {
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/snpsu_ise_jdbc","root","sathwik");
        System.out.println("Connection established");
        Statement statement=connection.createStatement();

        String fname="Prashanth";

        //Avoid SQL Injection - we dont write the exacct column names in QUERY
        // We give question marks for the parameters
        PreparedStatement ps=connection.prepareStatement("DELETE FROM students WHERE fname=?");
        ps.setString(1,fname);

        int i=ps.executeUpdate();
        if(i>0){
            System.out.println("Delete data Successfully");

        }else{
            System.out.println("Failed to Delete data");
        }
        ps.close();
        statement.close();
        connection.close();

    }
}