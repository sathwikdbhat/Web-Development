package jdbc;


import java.sql.*;

public class JDBCInsertDemo {
    public static void main(String[] args) throws Exception {
        //Load the JDBC
        Class.forName("com.mysql.cj.jdbc.Driver");
        //
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snpsu_ise_jdbc",
                "root","sathwik");
        System.out.println("connection established");
        Statement statement = connection.createStatement();
        String fname = "Vivek";
        String lname = "Moudgalya";
        //SQL injection - we don't write the exact column names in query
        //We qive question mrks for the parameters
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students VALUES (?,?)");
        ps.setString(1,fname);
        ps.setString(2,lname);
        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("Inserted data successfully");
        }else{
            System.out.println("Failed to insert data");
        }
        ps.close();
        connection.close();

    }
}