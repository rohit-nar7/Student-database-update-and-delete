package com.jap;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class DeleteUpdateStudentData
{

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "admin";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;

    }

    public void deleteStudentData(){
      // call getConnection() method
        try {
            String query = "Delete from school.student where rollNo = 14";
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Deleted ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //execute delete query
    }

    public void updateStudentData(){
        // call getConnection() method
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            String query = "UPDATE  school.student SET totalMarks = 678 where rollNo = 15";
            statement.executeUpdate(query);
            System.out.println("Database values updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //execute update query
    }

    public static void main(String[] args) {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        salesDataDemo.deleteStudentData();
        salesDataDemo.updateStudentData();
    }
}
