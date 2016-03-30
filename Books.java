package com.java.DBproject.main;
import java.sql.*;
/**
 *
 * @author Nipun
 */
public class Books {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int bookID;
    //private String subject;
    private String title;
    private String author;
    private String publisher;
    private int copyright;
    private int edition;
    private int pages;
    private String ISBN;
    private int numberOfBooks;
    private int numberOfAvailbleBooks;
    private int numberOfBorrowedBooks;
    private boolean availble;
    private int shelfno;
    private String URL = "jdbc:mysql://localhost/librarysystem";
    private String USER = "root";
    private String PASS = "";

    public Books() {
    }

    public int getBookID() {
        return bookID;
    }

//    public String getSubject() {
//        return subject;
//    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCopyright() {
        return copyright;
    }

    public int getEdition() {
        return edition;
    }

    public int getPages() {
        return pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public int getNumberOfAvailbleBooks() {
        return numberOfAvailbleBooks;
    }

    public int getNumberOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }

    public int getSelfNo() {
        return shelfno;
    }

    public boolean getAvailble() {
        return availble;
    }

    public void connection(String Query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Books.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Books.java\n" + e.toString());
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
                bookID = resultSet.getInt(1);
                title = resultSet.getString(2);
                author = resultSet.getString(3);
                publisher = resultSet.getString(4);
                copyright = resultSet.getInt(5);
                edition = resultSet.getInt(6);
                pages = resultSet.getInt(7);
                ISBN = resultSet.getString(8);
                numberOfBooks = resultSet.getInt(9);
                numberOfAvailbleBooks = resultSet.getInt(10);
                numberOfBorrowedBooks = resultSet.getInt(11);
                availble = resultSet.getBoolean(12);
                shelfno = resultSet.getInt(13);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            System.out.println("Books.java\n" + SQLe.toString());
        }
    }

    public void update(String Query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Books.java\n" + cnfe.toString());
        } catch (Exception e) {
            System.out.println("Books.java\n" + e.toString());
        }
        /***************************************************************
         * for making the connection,creating the statement and update *
         * the table in the database. After that,closing the statmenet *
         * and connection. There is catch block SQLException for error *
         ***************************************************************/
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            statement.executeUpdate(Query);
            statement.close();
            connection.close();
        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
            System.out.println("Books.java\nError:" + SQLe.toString());
        }
    }
}

