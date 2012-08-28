/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Home
 */
public class SubjectsHandledViewForm extends javax.swing.JFrame {

    private int selectedRow;
    private int selectedColumn;

    /**
     * Creates new form SubjectsHandledViewForm
     */
    public SubjectsHandledViewForm() throws SQLException {
        initComponents();
        subjectsHandledTable.setModel(new SubjectsHandledTableModel());
        subjectsHandledTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        subjectsHandledTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        subjectsHandledTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        subjectsHandledTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        subjectsHandledTable.getColumnModel().getColumn(3).setPreferredWidth(105);
        subjectsHandledTable.getColumnModel().getColumn(4).setPreferredWidth(500);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DashboardForm df = new DashboardForm();
                Utilfunctions.setIconImage(df);
                Utilfunctions.setLocation(df);
                e.getWindow().setVisible(false);
                df.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectsHandledTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Subjects Handled");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Subjects Handled");

        subjectsHandledTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        subjectsHandledTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subjectsHandledTable.setInheritsPopupMenu(true);
        subjectsHandledTable.setShowHorizontalLines(false);
        subjectsHandledTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(subjectsHandledTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SubjectsHandledViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable subjectsHandledTable;
    // End of variables declaration//GEN-END:variables
}

class SubjectsHandledTableModel extends AbstractTableModel {

    private String[] columnNames = {"Course","Year", "Section", "Subject Code", "Subject Name"};
    private Vector<String[]> data;

    public SubjectsHandledTableModel() {
        ResultSet rs_cnt = Utilfunctions.executeQuery("SELECT COUNT(*) FROM `subclass` WHERE `userCode`='" + LoginForm.userCode + "'");
        int cnt = 0;
        ResultSet result;
        ResultSet result1;
        ResultSet result2;
        String query;
        try {
            rs_cnt.next();
            cnt = rs_cnt.getInt(1);
            data = new Vector<String[]>();
            if (cnt > 0) {
                query = "SELECT subCode, classCode FROM subclass WHERE userCode='" + LoginForm.userCode + "'";
                result = Utilfunctions.executeQuery(query);
                while (result.next()) {
                    result1 = Utilfunctions.executeQuery("SELECT `subName` FROM `subject` WHERE `subcode`='" + result.getString(1) + "'");
                    result1.next();
                    result2 = Utilfunctions.executeQuery("SELECT `year`, `section`, course FROM `class` WHERE `classCode`=" + result.getString(2));
                    result2.next();
                    String[] values = {result2.getString(3),result2.getString(1), result2.getString(2), result.getString(1), result1.getString(1)};
                    data.add(values);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectsHandledViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setColumnValue(int col, String[] values) {
        for (int i = 0; i < values.length; i++) {
            JOptionPane.showMessageDialog(null, values[i]);
            this.setValueAt(values[i], i, col);
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        String values[] = data.get(row);
        values[column] = value.toString();
        data.setElementAt(values, row);
    }

    public void removeRow(int row) {
        data.remove(row);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        this.fireTableDataChanged();
    }
}
