package com.java.DBproject.main;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Nipun
 */
class ListMembers extends JFrame {

    private Connection connection = null;

    public ListMembers() {
        super("Member's List");
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/librarysystem";
            String userid = "root";
            String password = "";

            try {
                connection = DriverManager.getConnection(url, userid, password);
                System.out.println("Connected.");
                // pull data from the database 
                java.sql.Statement stmts = null;

                String query = "select * from members";
                
                stmts = connection.createStatement();
                ResultSet rs = stmts.executeQuery(query);


                java.sql.ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                //  Get column names
                for (int i = 1; i <= columns; i++) {
                    columnNames.add(md.getColumnName(i));
                }

                //  Get row data
                while (rs.next()) {
                    ArrayList row = new ArrayList(columns);

                    for (int i = 1; i <= columns; i++) {
                        row.add(rs.getObject(i));
                    }

                    data.add(row);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }

        //  Create table with database data    
        final JTable table = new JTable(dataVector, columnNamesVector) {

            @Override
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }
}
