/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sasi Praveen
 */
public class UserViewForm extends javax.swing.JFrame {

    private int selectedRow;
    private int selectedColumn;

    /**
     * Creates new form UserViewForm
     */
    public UserViewForm() throws SQLException {
        initComponents();
        
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
        
        usersTable.setModel(new UserTableModel(""));
        TableColumn col = usersTable.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Head of the Department");
        comboBox.addItem("Staff");
        comboBox.addItem("Department Secretary");
        comboBox.addItem("System Administrator");
        
        col.setCellEditor(new DefaultCellEditor(comboBox));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        col.setCellRenderer(renderer);
        
        col = usersTable.getColumnModel().getColumn(3);
        JComboBox deptCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(deptCombo,"SELECT dept FROM dept ORDER BY dept");
        col.setCellEditor(new DefaultCellEditor(deptCombo));
        
    }

    public JTextField getEditTextBox() {
        JTextField editField = new JTextField();
        return editField;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPopupMenu = new javax.swing.JPopupMenu();
        resetPasswordMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        usersLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        resetPasswordMenuItem.setText("Reset Password\n");
        resetPasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordMenuItemActionPerformed(evt);
            }
        });
        userPopupMenu.add(resetPasswordMenuItem);

        jMenuItem1.setText("View subjects Handled");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        userPopupMenu.add(jMenuItem1);

        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        userPopupMenu.add(deleteMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Users - SchedulePro");
        setResizable(false);

        usersLabel.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        usersLabel.setText("Users");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        usersTable.setCellSelectionEnabled(true);
        usersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersTable.setInheritsPopupMenu(true);
        usersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        usersTable.setShowHorizontalLines(false);
        usersTable.setShowVerticalLines(false);
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usersTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);

        jTextField1.setToolTipText("Search");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(usersLabel)))
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseReleased
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            JTable source = (JTable) evt.getSource();
            selectedRow = source.rowAtPoint(evt.getPoint());
            selectedColumn = source.columnAtPoint(evt.getPoint());

            if (!source.isRowSelected(selectedRow)) {
                source.changeSelection(selectedRow, selectedColumn, false, false);
            }

            userPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_usersTableMouseReleased

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        ResultSet result,r;
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this User?", "Delete User", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            result = Utilfunctions.executeQuery("SELECT `userCode` FROM `login` WHERE `id`='" + usersTable.getValueAt(selectedRow, 0) + "'");
            try {
                result.next();
                Utilfunctions.executeUpdate("DELETE FROM `login` WHERE `userCode`='" + result.getString(1) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `user` WHERE `userCode`='" + result.getString(1) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `staffconstraint` WHERE `userCode`='" + result.getString(1) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `staffperiodexception` WHERE `userCode`='" + result.getString(1) + "'");
                r = Utilfunctions.executeQuery("SELECT `workHourConfigId` FROM `userworkid` WHERE `userCode`='" + result.getString(1) + "'");
                while(r.next()){
                    Utilfunctions.executeUpdate("DELETE FROM `staffworkhour` WHERE `workHourConfigId`='" + r.getString(1) + "'");
                }
                Utilfunctions.executeUpdate("DELETE FROM `userworkid` WHERE `userCode`='" + result.getString(1) + "'");
                Utilfunctions.executeUpdate("UPDATE `examinvigilation` SET `userCode`= '' WHERE `userCode`='" + result.getString(1) + "'");
                Utilfunctions.executeUpdate("DELETE FROM `equipmentissue` WHERE `userCode`='" + result.getString(1) + "'");
            } catch (SQLException ex) {
                Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                usersTable.setModel(new UserTableModel(""));
            } catch (SQLException ex) {
                Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void resetPasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordMenuItemActionPerformed
        // TODO add your handling code here:
        ResultSet result;
        int n=0;
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Reset the Password?", "Reset Password", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            String newPassword = Utilfunctions.randomStringGenerator(8);
            try {
                n=Utilfunctions.executeUpdate("UPDATE `login` SET `password`='"+Utilfunctions.MD5(newPassword).toString(16)+"' WHERE `id`='" + usersTable.getValueAt(selectedRow, 0) + "'");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(n==1)
                JOptionPane.showMessageDialog(null, "Password reset to '"+newPassword+"'");
            else
                JOptionPane.showMessageDialog(null, "Error in reseting Password");
        }
    }//GEN-LAST:event_resetPasswordMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        UserTableModel model = (UserTableModel)usersTable.getModel();
        SubjectsTakenForm.userCode = model.getValueAt(selectedRow,0).toString();
        try {
            SubjectsTakenForm stf = new SubjectsTakenForm();
            Utilfunctions.setIconImage(stf);
            Utilfunctions.setLocation(stf);
            stf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {
            usersTable.setModel(new UserTableModel(jTextField1.getText()));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(UserViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UserViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem resetPasswordMenuItem;
    private javax.swing.JPopupMenu userPopupMenu;
    private javax.swing.JLabel usersLabel;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
    
}

class UserTableModel extends AbstractTableModel {
        private String[] columnNames = {"User Code","Name","Role","Department"};
        private Object[][] data;
        private final String userRole;
	
        public UserTableModel(String pattern) throws SQLException{
            userRole = LoginForm.userRole;
            String query;
            if(userRole.equals("sa")){
                query = "SELECT * FROM user WHERE NAME LIKE '" + pattern + "%' ORDER BY name";
            }else{
                query = "SELECT * FROM user WHERE dept = '" + LoginForm.userDept + "' AND name LIKE '" + pattern + "%' ORDER BY name";
            }
            ResultSet rs = Utilfunctions.executeQuery(query);
            
            int cnt = 0;
            while(rs.next())
                cnt++;
            HashMap hm = new HashMap();
            hm.put("hod","Head of the Department");
            hm.put("staff","Staff");
            hm.put("ds","Department Secretary");
            hm.put("sa","System Administrator");
            
            data = new Object[cnt][4];
            
            rs = Utilfunctions.executeQuery(query);
            int i=0;
            while(rs.next()){
                query = "SELECT * FROM login WHERE userCode = '" + rs.getString(1) + "' AND userCode IN(SELECT userCode FROM user WHERE name LIKE '" + pattern + "%')";
                ResultSet rs2 = Utilfunctions.executeQuery(query);
                rs2.next();
                Object[] values = {rs2.getString(2),rs.getString(2),hm.get(rs2.getString(4)),rs.getString(4)};
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
            if (col == 0) {
            return false;
        } else if (!LoginForm.userRole.equals("sa") && col == 3) {
            return false;
        } else {
            return true;
        }
        }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
        public void setValueAt(Object value, int row, int col) {
            if(value.toString().equals(data[row][col].toString())) return;
            if(col == 1){
                if(!Validation.isStringWithSpace(value.toString())){
                    JOptionPane.showMessageDialog(null,"Invalid Name");
                    return;
                }
                String query = "UPDATE user SET name = '" + value.toString() + "' WHERE userCode = '" + data[row][0] + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1)
                    JOptionPane.showMessageDialog(null,"Name Changed");
            }
            else if(col == 2){
                HashMap hm = new HashMap();
                hm.put("Head of the Department","hod");
                hm.put("Staff","staff");
                hm.put("Department Secretary","ds");
                hm.put("System Administrator","sa");

                String role = value.toString();

                String query = "UPDATE login SET role = '" + hm.get(role) + "' WHERE userCode = '" + data[row][0] + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1)
                    JOptionPane.showMessageDialog(null,"Role Changed");
            }
            else if(col == 3){
                String query = "UPDATE user SET dept = '" + value.toString() + "' WHERE userCode = '" + data[row][0] + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1)
                    JOptionPane.showMessageDialog(null,"Department Changed");
            }
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }

