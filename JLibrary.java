package com.java.DBproject.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Nipun
 */
public class JLibrary extends JFrame {

    private AddBooks addBook;
    private ListBooks listofbooks;
    private AddMembers addMember;
    private ListMembers listofmembers;
    private SearchBooksAndMembers search;
    private BorrowBooks borrowbooks;
    private ReturnBooks returnbooks;

    /** Creates new form JLibrary */
    public JLibrary() {
        super("Library");
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
        setDefaultCloseOperation(JLibrary.HIDE_ON_CLOSE);
        setLocation(500, 270);

        /*Exit Window here**/
        Exit_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Exit_menuitem) {
                    dispose();
                    System.exit(0);
                }
            }
        });

        /*addBooks here**/
        Addbook_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Addbook_menuitem) {
                    addBook = new AddBooks();
                    addBook.setVisible(true);                 
                }
            }
        });
        
       /*List of Books here**/
        Listbooks_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==Listbooks_menuitem) {
                     listofbooks = new ListBooks();
                     listofbooks.setVisible(true);
                     listofbooks.setSize(710, 400);
                     listofbooks.setLocation(450, 120);
                     listofbooks.setDefaultCloseOperation(ListBooks.HIDE_ON_CLOSE);
                 }
            }
        });
        
        /*Addmembers here**/
        Addmember_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Addmember_menuitem) {
                    addMember = new AddMembers();
                    addMember.setVisible(true);
                    addMember.setLocation(320, 120);
                    addMember.setDefaultCloseOperation(AddMembers.HIDE_ON_CLOSE);
                }
             }
        });
        
        /*List of Members here**/
        ListMembers_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==ListMembers_menuitem) {
                    listofmembers = new ListMembers();
                    listofmembers.setVisible(true);
                    listofmembers.setLocation(450, 120);
                    listofmembers.setSize(700, 400);
                    listofmembers.setDefaultCloseOperation(ListMembers.HIDE_ON_CLOSE);
                    
                }
             }
        });
        
        /*search books and members here**/
        Search_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Search_menuitem) {
                    search = new SearchBooksAndMembers();
                    search.setVisible(true);
                    search.setLocation(450, 120);
                    search.setDefaultCloseOperation(SearchBooksAndMembers.HIDE_ON_CLOSE);
                    
                }
             }
        });
        
        /*Borrow some books here**/
        Borrowbook_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(e.getSource()==Borrowbook_menuitem) {
                     borrowbooks = new BorrowBooks();
                     borrowbooks.setVisible(true);
                     borrowbooks.setLocation(450, 120);
                     borrowbooks.setDefaultCloseOperation(BorrowBooks.HIDE_ON_CLOSE);
                     
                 }
            }
        });
        
        /*Return Books here**/
        Returnbook_menuitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Returnbook_menuitem) {
                    returnbooks = new ReturnBooks();
                    returnbooks.setVisible(true);
                    returnbooks.setLocation(450, 120);
                    returnbooks.setDefaultCloseOperation(ReturnBooks.HIDE_ON_CLOSE);
                }
            }
        });
        
        /*Return Books here**/
        aboutMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==aboutMenuItem) {
                    new AboutForm().setVisible(true);
                }
            }
        });
        
        /*Change Password here**/
        changePassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 PasswordChange passwordChange = new PasswordChange();
                 passwordChange.setVisible(true);
                 passwordChange.setLocation(450, 120);
                 passwordChange.setDefaultCloseOperation(PasswordChange.HIDE_ON_CLOSE);
                 
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        File_menu = new javax.swing.JMenu();
        Exit_menuitem = new javax.swing.JMenuItem();
        changePassword = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        Books_menu = new javax.swing.JMenu();
        Addbook_menuitem = new javax.swing.JMenuItem();
        Listbooks_menuitem = new javax.swing.JMenuItem();
        Members_menu = new javax.swing.JMenu();
        Addmember_menuitem = new javax.swing.JMenuItem();
        ListMembers_menuitem = new javax.swing.JMenuItem();
        Search_menu = new javax.swing.JMenu();
        Search_menuitem = new javax.swing.JMenuItem();
        Loan_menu = new javax.swing.JMenu();
        Borrowbook_menuitem = new javax.swing.JMenuItem();
        Returnbook_menuitem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        File_menu.setText("File");
        File_menu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        Exit_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Exit_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Exit_menuitem.setForeground(new java.awt.Color(255, 0, 51));
        Exit_menuitem.setText("Exit");
        File_menu.add(Exit_menuitem);

        changePassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        changePassword.setFont(new java.awt.Font("Segoe UI", 1, 12));
        changePassword.setForeground(new java.awt.Color(255, 0, 51));
        changePassword.setText("Change Password");
        File_menu.add(changePassword);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        aboutMenuItem.setForeground(new java.awt.Color(255, 0, 51));
        aboutMenuItem.setText("About");
        File_menu.add(aboutMenuItem);

        jMenuBar1.add(File_menu);

        Books_menu.setText("Books");
        Books_menu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        Addbook_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Addbook_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Addbook_menuitem.setForeground(new java.awt.Color(204, 0, 51));
        Addbook_menuitem.setText("Add Book");
        Books_menu.add(Addbook_menuitem);

        Listbooks_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        Listbooks_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Listbooks_menuitem.setForeground(new java.awt.Color(255, 0, 51));
        Listbooks_menuitem.setText("List All Books");
        Books_menu.add(Listbooks_menuitem);

        jMenuBar1.add(Books_menu);

        Members_menu.setText("Members");
        Members_menu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        Addmember_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Addmember_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Addmember_menuitem.setForeground(new java.awt.Color(255, 0, 0));
        Addmember_menuitem.setText("Add Member");
        Members_menu.add(Addmember_menuitem);

        ListMembers_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        ListMembers_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        ListMembers_menuitem.setForeground(new java.awt.Color(255, 0, 0));
        ListMembers_menuitem.setText("List All Member");
        Members_menu.add(ListMembers_menuitem);

        jMenuBar1.add(Members_menu);

        Search_menu.setText("Search");
        Search_menu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        Search_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        Search_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Search_menuitem.setForeground(new java.awt.Color(255, 0, 0));
        Search_menuitem.setText("Search");
        Search_menu.add(Search_menuitem);

        jMenuBar1.add(Search_menu);

        Loan_menu.setText("Loan");
        Loan_menu.setFont(new java.awt.Font("Segoe UI", 1, 12));

        Borrowbook_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        Borrowbook_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Borrowbook_menuitem.setForeground(new java.awt.Color(255, 0, 0));
        Borrowbook_menuitem.setText("Borrow A Book");
        Loan_menu.add(Borrowbook_menuitem);

        Returnbook_menuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Returnbook_menuitem.setFont(new java.awt.Font("Segoe UI", 1, 12));
        Returnbook_menuitem.setForeground(new java.awt.Color(255, 0, 0));
        Returnbook_menuitem.setText("Return a Book");
        Loan_menu.add(Returnbook_menuitem);

        jMenuBar1.add(Loan_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Addbook_menuitem;
    private javax.swing.JMenuItem Addmember_menuitem;
    private javax.swing.JMenu Books_menu;
    private javax.swing.JMenuItem Borrowbook_menuitem;
    private javax.swing.JMenuItem Exit_menuitem;
    private javax.swing.JMenu File_menu;
    private javax.swing.JMenuItem ListMembers_menuitem;
    private javax.swing.JMenuItem Listbooks_menuitem;
    private javax.swing.JMenu Loan_menu;
    private javax.swing.JMenu Members_menu;
    private javax.swing.JMenuItem Returnbook_menuitem;
    private javax.swing.JMenu Search_menu;
    private javax.swing.JMenuItem Search_menuitem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem changePassword;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
