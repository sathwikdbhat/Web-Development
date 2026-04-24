package BookStore;

import java.sql.*;
import java.util.Scanner;

public class BookStoreCRUD {
    public static final String URL="jdbc:mysql://localhost:3306/ise_bookstore_db";
    public static final String USERNAME="root";
    public static final String PASSWORD="sathwik";
    public static void main(String args[]) throws Exception {
        try(Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Scanner scanner =new Scanner(System.in))
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Main crud application
            while(true){
                //Display some menu option
                System.out.println("\n 1.Create Book | 2.Read Book | 3.Update Book | 4.Delete Book");
                System.out.println("Choice: ");
                int ch=scanner.nextInt();
                scanner.nextLine(); //Consumes the left over spaces goes to next
                if(ch==1){
                    System.out.println("Title:");
                    String title=scanner.nextLine();
                    System.out.println("Author: ");
                    String author=scanner.nextLine();
                    System.out.println("Price:");
                    double price=scanner.nextDouble();
                    //Prepared statement to prevent sql injection
                    String sql="INSERT INTO books (title,author,price) VALUES (?,?,?)";
                    try(PreparedStatement ps=conn.prepareStatement(sql)){
                        ps.setString(1,title);
                        ps.setString(2,author);
                        ps.setDouble(3,price);
                        ps.executeUpdate(); //Executes the INSERT Operation
                        System.out.println("Book: "+title+" added to DB");
                    }
                }
                //-----------Read operation--------------------
                else if(ch==2){
                    String sql="SELECT * FROM books";
                    try(Statement statement=conn.createStatement();
                        ResultSet rs=statement.executeQuery(sql)
                    ) {
                        System.out.println("ID | AUTHOR | PRICE");
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String title = rs.getString("title");
                            String author = rs.getString("author");
                            double price = rs.getDouble("price");
                            System.out.println(id + "\t\t" + title + "\t\t" + author + "\t\t" + price);
                        }
                    }
                }
                else if (ch == 3) {
                    System.out.print("Book ID to Update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("New title: ");
                    String title = scanner.nextLine();
                    System.out.println("New Author: ");
                    String author = scanner.nextLine();
                    System.out.println("New Price: ");
                    double price = scanner.nextDouble();
                    String sql="UPDATE books SET title=?,author=?,price=? WHERE id=?";
                    try(PreparedStatement ps=conn.prepareStatement(sql)){
                        ps.setString(1,title);
                        ps.setString(2,author);
                        ps.setDouble(3,price);
                        ps.setInt(4,id);
                        int rows=ps.executeUpdate();
                        if(rows>0) System.out.println("Updated"); else System.out.println("Not updated ");
                    }
                }
                else if(ch==4){
                    System.out.println("Enter book ID to delete :");
                    int id=scanner.nextInt();
                    String sql="DELETE FROM books WHERE id=?";
                    try(PreparedStatement ps=conn.prepareStatement(sql)){
                        ps.setInt(1,id);
                        int rows=ps.executeUpdate();
                        if(rows>0) System.out.println("Deleted"); else System.out.println("Not Deleted ");
                    }
                }
                // ----------Exit operation-----------------------
                else if(ch==5){
                    System.out.println("Exiting the system...");
                    for(int i=0;i<5;i++){
                        System.out.print(".");
                        Thread.sleep(1000);
                    }
                    break;
                }
                //Handle the invalid cases
                else{
                    System.out.println("Invalid choice");
                    System.out.println("Choices : 1,2,3,4,5");
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("MYSQL JDBC Driver not found . Add Jar to class path");
        } catch (SQLException e){
            System.out.println("Database error:"+e.getMessage());
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}