package com.java.DBproject.main;

/**
 *
 * @author Nipun
 */
import java.sql.*;

public class Borrow {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int bookID;
    private int memberID;
    private Date dayOfBorrowed;
    private Date dayOfReturn;
    private String URL = "jdbc:mysql://localhost/librarysystem";
    private String USER = "root";
    private String PASS = "";

    public Borrow() {
    }

    public int getBookID() {
        return bookID;
    }

    public int getMemberID() {
        return memberID;
    }

    public Date getDayOfBorrowed() {
        return dayOfBorrowed;
    }

    public Date getDayOfReturn() {
        return dayOfReturn;
    }

    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Borrow.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Borrow.java\n" + e.toString());
        }
        /***************************************************************
         * for making the connection,creating the statement and update *
         * the table in the database. After that,closing the statement *
         * and connection. There is catch block SQLException for error *
         ***************************************************************/
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Borrow");
            while (resultSet.next()) {
                bookID = resultSet.getInt(1);
                memberID = resultSet.getInt(2);
                dayOfBorrowed = resultSet.getDate(3);
                dayOfReturn = resultSet.getDate(4);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            System.out.println("Borrow.java\n" + SQLe.toString());
        }
    }

    public void update(String Query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Borrow.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Borrow.java\n" + e.toString());
        }
        /***************************************************************
         * for making the connection,creating the statement and update *
         * the table in the database. After that,closing the statement *
         * and connection. There is catch block SQLException for error *
         ***************************************************************/
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate(Query);
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            System.out.println("Borrow.java\n" + SQLe.toString());
        }
    }
}

