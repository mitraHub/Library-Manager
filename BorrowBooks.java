package com.java.DBproject.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nipun
 */
public class BorrowBooks extends JFrame {

    private Borrow borrow;
    private Books book;
    private Members member;
    private Date borrowDate;
    private Date returnDate;
    private String borrowdate1;
    private String returndate1;

    /** Creates new form BorrowBooks */
    public BorrowBooks() {
        super("Borrow Book");
        initComponents();
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == borrowButton) {

                    int bookID = Integer.valueOf(bookIDTextfield.getText().trim());
                    int memberID = Integer.valueOf(memberidTextfield.getText().trim());


                    /*JXdatepeaker here***/
                    SimpleDateFormat formatter;
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    borrowDate = datepeakerCurrentdate.getDate();
                    returnDate = datepeakerReturndate.getDate();
                    borrowdate1 = formatter.format(borrowDate);
                    returndate1 = formatter.format(returnDate);
                    System.out.println("date: " + borrowdate1 + returndate1);
                    
                    book = new Books();
                    member = new Members();
                    borrow = new Borrow();
                    book.connection("SELECT * FROM Books");
                    member.connection("SELECT * FROM Members");

                    int numberOfAvailbleBooks = book.getNumberOfAvailbleBooks();
                    int numberOfBorrowedBooks = 1 + book.getNumberOfBorrowedBooks();
                    int numberOfBooks = 1 + member.getNumberOfBooks();
                    //for checking if there is no same information in the database
                    if (numberOfAvailbleBooks == 1) {
                        numberOfAvailbleBooks -= 1;
                        book.update("UPDATE Books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks
                                + ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + ",Availble = false WHERE BookID =" + bookID);
                        member.update("UPDATE Members SET NumberOfBooks = " + numberOfBooks + " WHERE MemberID = " + memberID);
                        borrow.update("INSERT INTO Borrow (BookID, MemberID, DayOfBorrowed, DayOfReturn) VALUES ("
                                + bookID + "," + memberID + ",'" + borrowdate1 + "','" + returndate1 + "')");
                        //for setting the array of JTextField to null
                        clearTextField();
                    } else if (numberOfAvailbleBooks > 1) {
                        numberOfAvailbleBooks -= 1;
                        book.update("UPDATE Books SET NumberOfAvailbleBooks =" + numberOfAvailbleBooks
                                + ",NumberOfBorrowedBooks =" + numberOfBorrowedBooks + " WHERE BookID =" + bookID);
                        member.update("UPDATE Members SET NumberOfBooks =" + numberOfBooks + " WHERE MemberID =" + memberID);
                        borrow.update("INSERT INTO Borrow (BookID, MemberID, DayOfBorrowed, DayOfReturn) VALUES ("
                                + bookID + "," + memberID + ",'" + borrowdate1 + "','" + returndate1 + "')");
                        //for setting the array of JTextField to null
                        JOptionPane.showMessageDialog(null, "The book is Successfully borrowed", "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearTextField();
                    } else {
                        JOptionPane.showMessageDialog(null, "The book is Not Available", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                datepeakerCurrentdate.setDate(null);
                datepeakerReturndate.setDate(null);
                bookIDTextfield.setText("");
                memberidTextfield.setText("");
            }

            private void clearTextField() {
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frontPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        bookIDTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        memberidTextfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datepeakerCurrentdate = new org.jdesktop.swingx.JXDatePicker();
        datepeakerReturndate = new org.jdesktop.swingx.JXDatePicker();
        borrowButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Siyam Rupali", 1, 18));
        jLabel1.setText("Borrow Book");

        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Write the BookID");

        bookIDTextfield.setText(" ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Write the MemberID");

        memberidTextfield.setText(" ");

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        jLabel4.setText("Borrow Date");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Return Date");

        borrowButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        borrowButton.setForeground(new java.awt.Color(0, 51, 255));
        borrowButton.setText("Borrow");

        javax.swing.GroupLayout frontPanelLayout = new javax.swing.GroupLayout(frontPanel);
        frontPanel.setLayout(frontPanelLayout);
        frontPanelLayout.setHorizontalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPanelLayout.createSequentialGroup()
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(memberidTextfield)
                                .addComponent(bookIDTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                            .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(datepeakerCurrentdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datepeakerReturndate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frontPanelLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(borrowButton)
                .addGap(143, 143, 143))
        );
        frontPanelLayout.setVerticalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bookIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(memberidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(datepeakerCurrentdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(datepeakerReturndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(borrowButton)
                .addContainerGap())
        );

        getContentPane().add(frontPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookIDTextfield;
    private javax.swing.JButton borrowButton;
    private org.jdesktop.swingx.JXDatePicker datepeakerCurrentdate;
    private org.jdesktop.swingx.JXDatePicker datepeakerReturndate;
    private javax.swing.JPanel frontPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField memberidTextfield;
    // End of variables declaration//GEN-END:variables
}
