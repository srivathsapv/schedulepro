/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sasi Praveen
 */
public class ViewSubjectDetailsForm extends javax.swing.JFrame {

    private int selectedRow;
    private int selectedColumn;

    /**
     * Creates new form ViewSubjectDetailsForm
     */
    public ViewSubjectDetailsForm() throws SQLException {
        initComponents();
        SubjectDetailsTable.setModel(new SubjectTableModel());
        SubjectDetailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        SubjectDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(85);
        SubjectDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        
        TableColumn col = SubjectDetailsTable.getColumnModel().getColumn(3);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        
        col.setCellEditor(new DefaultCellEditor(comboBox));
        
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        SubjectDetailsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("Delete");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - View Subjects");
        setResizable(false);

        SubjectDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        SubjectDetailsTable.setColumnSelectionAllowed(true);
        SubjectDetailsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubjectDetailsTable.setInheritsPopupMenu(true);
        SubjectDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SubjectDetailsTable.setShowHorizontalLines(false);
        SubjectDetailsTable.setShowVerticalLines(false);
        SubjectDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SubjectDetailsTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(SubjectDetailsTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Subjects");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(240, 240, 240))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ResultSet result;
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this subject?", "Delete Subject", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            
            try {
                
                Utilfunctions.executeUpdate("DELETE FROM `subject` WHERE `subcode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `subclass` WHERE `subCode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `subjectconstraint` WHERE `subCode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `subperiodexception` WHERE `subCode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
                result = Utilfunctions.executeQuery("SELECT `examCode` FROM `exam` WHERE `subCode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
                if(result.next()){
                    Utilfunctions.executeUpdate("DELETE FROM `examinvigilation` WHERE `examCode`=" + result.getString(1));
                }
                Utilfunctions.executeUpdate("DELETE FROM `exam` WHERE `subCode`='" + SubjectDetailsTable.getValueAt(selectedRow,0) + "'");
            } catch (Exception ex) {
                Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                SubjectDetailsTable.setModel(new SubjectTableModel());
                SubjectDetailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                SubjectDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(85);
                SubjectDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(500);
            } catch (SQLException ex) {
                Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void SubjectDetailsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubjectDetailsTableMouseReleased
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            JTable source = (JTable) evt.getSource();
            selectedRow = source.rowAtPoint(evt.getPoint());
            selectedColumn = source.columnAtPoint(evt.getPoint());

            if (!source.isRowSelected(selectedRow)) {
                source.changeSelection(selectedRow, selectedColumn, false, false);
            }

            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_SubjectDetailsTableMouseReleased

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
            java.util.logging.Logger.getLogger(ViewSubjectDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSubjectDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSubjectDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSubjectDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewSubjectDetailsForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewSubjectDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SubjectDetailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

class SubjectTableModel extends AbstractTableModel {
        private String[] columnNames = {"Subject Code", "Subject Name","Short Name", "Credits"};
        private Object[][] data;
	
        public SubjectTableModel() throws SQLException{
            //Remove it later
            LoginForm.userDept = "CSE";
            //Remove it later
            
            ResultSet rs_cnt = Utilfunctions.executeQuery("SELECT COUNT(*) FROM `subject` WHERE dept = '" + LoginForm.userDept + "'");
            rs_cnt.next();
            int cnt = rs_cnt.getInt(1);

            data = new Object[cnt][4];

            String query = "SELECT `subcode`, `subName`,`subShortName`, `credits` FROM `subject` where `dept` = '" + LoginForm.userDept + "' order by `subName` asc";
            ResultSet result = Utilfunctions.executeQuery(query);
            int i =0;
            while (result.next()) {
                String[] values = {result.getString(1), result.getString(2), result.getString(3),result.getString(4)};
                data[i++] = values;
            }
            
        }
        
    @Override
        public int getColumnCount() {
            return columnNames.length;
        }

    @Override
        public int getRowCount() {
            return data.length;
        }

    @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

    @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
    @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
    @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if(col == 0)
                return false;
            else 
                return true;
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
    @Override
        public void setValueAt(Object value, int row, int col) {
            String subcode = (data[row][0]).toString();
            if(value.toString().equals((data[row][col]).toString())) {
                return;
            }
            String dept = LoginForm.userDept;
            if(col == 1){
                ResultSet rs_cnt = Utilfunctions.executeQuery("SELECT COUNT(*) FROM "
                                                              + "subject WHERE subName = '" 
                                                              + value.toString() + "' "
                                                              + "AND dept = '" + dept + "'");
                if(!Validation.isalphanumeric(value.toString())){
                    JOptionPane.showMessageDialog(null,"Invalid Subject Code");
                    return;
                }
                try {
                    rs_cnt.next();
                    if(rs_cnt.getInt(1) >= 1){
                        JOptionPane.showMessageDialog(null,"Duplicate Subject Name");
                        return;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                String query = "UPDATE subject SET subName = '" 
                                + value.toString() + "' WHERE subcode = '" 
                                + subcode + "' AND dept = '" + dept + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1) JOptionPane.showMessageDialog(null,"Subject Name Updated");
            }
            else if(col == 2){
                ResultSet rs_cnt = Utilfunctions.executeQuery("SELECT COUNT(*) FROM "
                                                             + "subject WHERE subShortName = "
                                                             + "'" + value.toString()  + "' AND dept = '" 
                                                             + dept + "'");
                if(!Validation.isalphanumeric(value.toString())){
                    JOptionPane.showMessageDialog(null,"Invalid Subject Short Name");
                    return;
                }
                try {
                    rs_cnt.next();
                    if(rs_cnt.getInt(1) >= 1){
                        JOptionPane.showMessageDialog(null,"Duplicate Subject Short Name");
                        return;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String query = "UPDATE subject SET subShortName = '" 
                               + value.toString() + "' WHERE subcode = '" 
                               + subcode + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1) JOptionPane.showMessageDialog(null,"Subject Short Name Updated");
            }
            else if(col == 3) {
                String query = "UPDATE subject SET credits = " + value.toString() 
                                + " WHERE subcode = '" + subcode + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1) JOptionPane.showMessageDialog(null,"Credits updated");
            }
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }