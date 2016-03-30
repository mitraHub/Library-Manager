package com.java.DBproject.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nipun
 */
public class ReturnBooks extends JFrame {

    private Books book;
    private Members member;
    private Borrow borrow;
    private String URL = "jdbc:mysql://localhost/librarysystem";
    private String USER = "root";
    private String PASS = "";

    /** Creates new form ReturnBooks */
    public ReturnBooks() {
        super("Return Book");
        initComponents();
        totalfineTextfield.setEditable(false);

        returnButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {
                    book = new Books();
                    member = new Members();
                    borrow = new Borrow();
                    book.connection("SELECT * FROM books");
                    member.connection("SELECT * FROM members");
                    java.sql.Date da = null;
                    int numberOfAvailbleBooks = book.getNumberOfAvailbleBooks();//
                    int numberOfBorrowedBooks = book.getNumberOfBorrowedBooks();
                    int numberOfBooks = member.getNumberOfBooks();//

                    //for checking if there is no same information in the database
                    System.out.println("numberOfAvailbleBooks" + numberOfAvailbleBooks);
                    System.out.println("numberOfBorrowedBooks" + numberOfBorrowedBooks);
                    System.out.println("numberOfBooks" + numberOfBooks);
                    try {
                        System.out.println("keylistener");
                        int fineamt = Integer.parseInt(fineTextfield.getText().trim());
                        Class.forName("com.mysql.jdbc.Driver");
                        java.sql.Connection con = DriverManager.getConnection(URL, USER, PASS);
                        java.sql.Statement st = con.createStatement();
                        System.out.println("connected");
                        int bookid = Integer.parseInt(bookidTextfield.getText().trim());
                        int memid = Integer.parseInt(memberidTextfield.getText().trim());
                        try {
                            String sql = "SELECT DayOfReturn from borrow where MemberID=" + memid + " and BookID=" + bookid;
                            ResultSet rs = st.executeQuery(sql);
                            System.out.println("executed");
                            if (rs.next()) {

                                da = rs.getDate(1);
                                java.util.Date today = new java.util.Date();
                                /*java.util.Date retdate=new java.util.Date(da.getYear(),da.getMonth(),da.getDate());
                                JOptionPane.showMessageDialog(null, "today=" + today + "\nRet date=" + retdate);*/

                                System.out.println(today.after(da));

                                if (today.after(da)) {
                                    long finedays = today.getTime() - da.getTime();
                                    int days = (int) (finedays / (1000 * 60 * 60 * 24));
                                    System.out.println(days);
                                    totalfineTextfield.setText(String.valueOf(fineamt * days));
                                } else {
                                    totalfineTextfield.setText("0");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Member ID entered not found on databse");
                            }

                        } catch (Exception ex1) {
                            JOptionPane.showMessageDialog(null, "Error, Cannot retrieve date value from table" + ex1.toString());
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error, cannot connect to database" + ex.toString());
                    }
                    if (numberOfAvailbleBooks == 0 && numberOfBooks > 0) {
                        numberOfAvailbleBooks += 1;
                        numberOfBooks -= 1;
                        System.out.println("procceed");
                        book.update("UPDATE books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks
                                + ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + ",Availble = true WHERE BookID =" + bookidTextfield.getText().trim());
                        member.update("UPDATE members SET NumberOfBooks =" + numberOfBooks + " WHERE MemberID =" + memberidTextfield.getText().trim());
                        borrow.update("DELETE FROM borrow WHERE BookID =" + bookidTextfield.getText().trim() + " AND MemberID =" + memberidTextfield.getText().trim());
                        //for setting the array of JTextField to null
                        JOptionPane.showMessageDialog(null, "The book is Successfully returned", "Success", JOptionPane.INFORMATION_MESSAGE);
                        //clearTextField();
                    } else if (numberOfAvailbleBooks > 0 && numberOfBooks > 0) {
                        numberOfAvailbleBooks += 1;
                        numberOfBooks -= 1;
                        System.out.println("Look AT THAT");
                        book.update("UPDATE books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks
                                + ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + " WHERE BookID =" + bookidTextfield.getText().trim());
                        member.update("UPDATE members SET NumberOfBooks =" + numberOfBooks + " WHERE MemberID =" + memberidTextfield.getText().trim());
                        borrow.update("DELETE FROM borrow WHERE BookID =" + bookidTextfield.getText().trim() + " AND MemberID =" + memberidTextfield.getText().trim());
                        //for setting the array of JTextField to null
                        JOptionPane.showMessageDialog(null, "The book is Successfully Returned", "Success", JOptionPane.INFORMATION_MESSAGE);
                        //clearTextField();
                    } else {
                        JOptionPane.showMessageDialog(null, "The book is not borrowed", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                bookidTextfield.setText("");
                memberidTextfield.setText("");
                
            }
        });
        
        /*Cancel Button here***/
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cancelButton) {
                    setDefaultCloseOperation(ReturnBooks.HIDE_ON_CLOSE);
                    new JLibrary().setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bookidTextfield = new javax.swing.JTextField();
        memberidTextfield = new javax.swing.JTextField();
        fineTextfield = new javax.swing.JTextField();
        totalfineTextfield = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Book Information");

        jToolBar1.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Return a Book");
        jToolBar1.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        jLabel3.setText("Write the BookID");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 10));
        jLabel4.setText("Write The MemberID");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Fine/Day");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Total Fine Amount");

        returnButton.setFont(new java.awt.Font("Traditional Arabic", 1, 14));
        returnButton.setForeground(new java.awt.Color(255, 0, 51));
        returnButton.setText("Return");

        cancelButton.setFont(new java.awt.Font("Traditional Arabic", 1, 14));
        cancelButton.setText("Cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(101, Short.MAX_VALUE)
                                .addComponent(returnButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalfineTextfield)
                                    .addComponent(fineTextfield)
                                    .addComponent(memberidTextfield)
                                    .addComponent(bookidTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(cancelButton)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bookidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(memberidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalfineTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fineTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton)
                    .addComponent(cancelButton))
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookidTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField fineTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField memberidTextfield;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField totalfineTextfield;
    // End of variables declaration//GEN-END:variables
}
