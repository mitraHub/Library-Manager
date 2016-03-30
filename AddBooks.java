package com.java.DBproject.main;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Nipun
 */
public class AddBooks extends JFrame {

    private Books book;
    private String URL = "jdbc:mysql://localhost/librarysystem";
    private String USER = "root";
    private String PASS = "";
    private Connection connection = null;
    private boolean availability = true;

    /** Creates new form AddBooks */
    public AddBooks() {
        super("Add Books::");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        initComponents();
        setLocation(170, 20);
        setDefaultCloseOperation(AddBooks.HIDE_ON_CLOSE);
        insertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == insertButton) {
                    int bookID = Integer.valueOf(bookidTextfield.getText().trim());
                    String bookTitle = bookTitleTextfield.getText().trim();
                    String authorName = authorTextfield.getText().trim();
                    String publisherName = publisherTextfield.getText().trim();
                    int copyrightofBook = Integer.valueOf(copyrightTextfield.getText().trim());
                    int editionofBook = Integer.valueOf(editionTextfield.getText().trim());
                    int pagesofBook = Integer.valueOf(pagesTextfield.getText().trim());
                    String isbnofBook = isbnTextfield.getText().trim();
                    int numberofBooks = Integer.valueOf(copiesTextfield.getText().trim());
                    int numberofBorrowedBooks = Integer.valueOf(borrowedbooksTextfield.getText().trim());
                    int availableBooks = Integer.valueOf(availableBooksTextfield.getText().trim());
                    //availability = Boolean.parseBoolean(availabilityTextfield.getText());
                    int selfNumber = Integer.valueOf(selfnoTextfield.getText().trim());

                    book = new Books();
                    //for checking if there is no double information in the database
                    book.connection("SELECT * FROM Books");
                    try {
                        System.out.println("data insert start");
                        String sql = "INSERT INTO Books (BookID,Title,Author,Publisher,Copyright,"
                                + "Edition,Pages,ISBN,NumberOfBooks,NumberOfAvailbleBooks,NumberOfBorrowedBooks,Availble,ShelfNo) VALUES "
                                + " (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = (Connection) DriverManager.getConnection(URL, USER, PASS);
                        System.out.println("connected");
                        java.sql.PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setInt(1, bookID);
                        ps.setString(2, bookTitle);
                        ps.setString(3, authorName);
                        ps.setString(4, publisherName);
                        ps.setInt(5, copyrightofBook);
                        ps.setInt(6, editionofBook);
                        ps.setInt(7, pagesofBook);
                        ps.setString(8, isbnofBook);
                        ps.setInt(9, numberofBooks);//
                        ps.setInt(10, availableBooks);//
                        ps.setInt(11, numberofBorrowedBooks);
                        ps.setBoolean(12, availability);
                        ps.setInt(13, selfNumber);
                        ps.executeUpdate();
                    } catch (Exception ex) {
                        System.out.println("asshole");
                        JOptionPane.showMessageDialog(null, ex.toString());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bookidTextfield = new javax.swing.JTextField();
        bookTitleTextfield = new javax.swing.JTextField();
        authorTextfield = new javax.swing.JTextField();
        publisherTextfield = new javax.swing.JTextField();
        copyrightTextfield = new javax.swing.JTextField();
        editionTextfield = new javax.swing.JTextField();
        pagesTextfield = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        isbnTextfield = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        copiesTextfield = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        availableBooksTextfield = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        borrowedbooksTextfield = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        availabilityTextfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        selfnoTextfield = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(2, 3, 2, 2));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        firstPanel.setBackground(new java.awt.Color(204, 204, 204));
        firstPanel.setForeground(new java.awt.Color(255, 0, 51));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 18));
        jLabel1.setText("Books Information");

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Add a new Book");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Book ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Book Title");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Name of Author");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name of Publisher");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Copiright of Book");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Edition no");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Number of Pages");

        jLabel12.setText("No of Borrowed Books");

        bookidTextfield.setText(" ");

        bookTitleTextfield.setText(" ");

        authorTextfield.setText(" ");

        publisherTextfield.setText(" ");

        copyrightTextfield.setText(" ");

        editionTextfield.setText(" ");

        pagesTextfield.setText(" ");

        insertButton.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        insertButton.setForeground(new java.awt.Color(255, 0, 0));
        insertButton.setText("Insert Info");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("ISBN");

        isbnTextfield.setText(" ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("No of Books");

        copiesTextfield.setText(" ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Available books");

        availableBooksTextfield.setText(" ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Borrowed Books");

        borrowedbooksTextfield.setText(" ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Availablity");

        availabilityTextfield.setText(" ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("SelfNo");

        selfnoTextfield.setText(" ");

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 0, 255));
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                        .addComponent(insertButton)
                        .addGap(8, 8, 8))
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagesTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(editionTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(copyrightTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(publisherTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(bookTitleTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(bookidTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel18)
                            .addComponent(jLabel10))
                        .addGap(19, 19, 19)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selfnoTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(availabilityTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(borrowedbooksTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(copiesTextfield)
                                .addComponent(isbnTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                            .addComponent(availableBooksTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstPanelLayout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(251, 251, 251))
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bookidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(isbnTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bookTitleTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(copiesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(authorTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(availableBooksTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(publisherTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(borrowedbooksTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(copyrightTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(availabilityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(editionTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(selfnoTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(pagesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(insertButton)))
                    .addComponent(cancelButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(firstPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorTextfield;
    private javax.swing.JTextField availabilityTextfield;
    private javax.swing.JTextField availableBooksTextfield;
    private javax.swing.JTextField bookTitleTextfield;
    private javax.swing.JTextField bookidTextfield;
    private javax.swing.JTextField borrowedbooksTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField copiesTextfield;
    private javax.swing.JTextField copyrightTextfield;
    private javax.swing.JTextField editionTextfield;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JTextField isbnTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pagesTextfield;
    private javax.swing.JTextField publisherTextfield;
    private javax.swing.JTextField selfnoTextfield;
    // End of variables declaration//GEN-END:variables
}
