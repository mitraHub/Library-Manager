package com.java.DBproject.main;

/**
 *
 * @author Nipun
 */
import java.sql.*;

public class Members {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int memberID;
    //private int ID;
    private String password;
    private String name;
    private String email;
    private String major;
    private int numberOfBooks;
    private int mony;
    private Date expired;
    private String URL = "jdbc:mysql://localhost/librarysystem";
    private String USER = "root";
    private String PASS = "";

    public Members() {
    }
 
    public void connection(String Query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Members.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Members.java\n" + e.toString());
        }
        /***************************************************************
         * for making the connection,creating the statement and update *
         * the table in the database. After that,closing the statement *
         * and connection. There is catch block SQLException for error *
         ***************************************************************/
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                memberID = resultSet.getInt(1);
                password = resultSet.getString(2);
                name = resultSet.getString(3);
                email = resultSet.getString(4);
                major = resultSet.getString(5);
                expired = resultSet.getDate(6);
                numberOfBooks = resultSet.getInt(7);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            System.out.println("Members.java\n" + SQLe.toString());
        }
    }

    public int getMemberID() {
        return memberID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public int getMony() {
        return mony;
    }
    
    public Date getExpired() {
        return expired;
    }

    public void update(String Query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Members.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Members.java\n" + e.toString());
        }
        /***************************************************************
         * for making the connection,creating the statement and update *
         * the table in the database. After that,closing the statmenet *
         * and connection. There is catch block SQLException for error *
         ***************************************************************/
        try {
            System.out.println(Query);
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate(Query);
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            System.out.println("Members.java\n" + SQLe.toString());
        }
    }
}