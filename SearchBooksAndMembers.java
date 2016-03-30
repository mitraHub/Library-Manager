package com.java.DBproject.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Nipun
 */
public class SearchBooksAndMembers extends JFrame {

    private String[] booksTypes = {"SelecT","BookID"};
    private String[] membersTypes = {"SelecT","MemberID"};
    
    public SearchBooksAndMembers() {
        super("Search Book and Member");
        initComponents();
        booksearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == booksearchButton) {
                    String type = bookCombobox.getSelectedItem().toString();
                    int data = Integer.parseInt(bookKeywordField.getText().trim());
                    ListSearchBooks listSearchBooks = new ListSearchBooks(data);
                    listSearchBooks.setVisible(true);
                    listSearchBooks.setSize(600, 500);
                    listSearchBooks.setLocation(400, 120);
                    listSearchBooks.setDefaultCloseOperation(ListSearchBooks.HIDE_ON_CLOSE);
                }
                bookKeywordField.setText("");
                bookCombobox.setSelectedItem(booksTypes[0]);
            }
           
        });

        membersearchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == membersearchButton) {
                    String type = memberCombobox.getSelectedItem().toString();
                    int value = Integer.parseInt(memberKeywordField.getText().trim());

                    ListSearchMembers listSearchMembers = new ListSearchMembers(value);
                    listSearchMembers.setVisible(true);
                    listSearchMembers.setSize(600, 500);
                    listSearchMembers.setLocation(450, 120);
                    listSearchMembers.setDefaultCloseOperation(ListSearchMembers.HIDE_ON_CLOSE);
                }
                memberCombobox.setSelectedItem(membersTypes[0]);
                memberKeywordField.setText("");
            }
        });
        setVisible(true);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frontPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bookCombobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        memberCombobox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        bookKeywordField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        memberKeywordField = new javax.swing.JTextField();
        booksearchButton = new javax.swing.JButton();
        membersearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("Search for Books and Members");

        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Search for a Book");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Search By");

        bookCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SelecT","BookID"}));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Search for a Member");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Search By");

        memberCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"SelecT","MemberID"}));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Keyword");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Keyword");

        booksearchButton.setFont(new java.awt.Font("Bodoni MT Black", 1, 14));
        booksearchButton.setText("Search");

        membersearchButton.setFont(new java.awt.Font("Bodoni MT Black", 1, 14));
        membersearchButton.setText("Search");

        javax.swing.GroupLayout frontPanelLayout = new javax.swing.GroupLayout(frontPanel);
        frontPanel.setLayout(frontPanelLayout);
        frontPanelLayout.setHorizontalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPanelLayout.createSequentialGroup()
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frontPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frontPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(157, 157, 157)
                                .addComponent(jLabel4))
                            .addGroup(frontPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(48, 48, 48)
                                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bookKeywordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(bookCombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(booksearchButton))
                                .addGap(47, 47, 47)
                                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(40, 40, 40)
                                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(membersearchButton)
                                    .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(memberKeywordField)
                                        .addComponent(memberCombobox, 0, 125, Short.MAX_VALUE)))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        frontPanelLayout.setVerticalGroup(
            frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bookCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(memberCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bookKeywordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(memberKeywordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(frontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(booksearchButton)
                    .addComponent(membersearchButton))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(frontPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bookCombobox;
    private javax.swing.JTextField bookKeywordField;
    private javax.swing.JButton booksearchButton;
    private javax.swing.JPanel frontPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox memberCombobox;
    private javax.swing.JTextField memberKeywordField;
    private javax.swing.JButton membersearchButton;
    // End of variables declaration//GEN-END:variables
}
