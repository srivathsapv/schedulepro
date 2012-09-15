/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
        
        usersTable.setModel(new UserTableModel());
        TableColumn col = usersTable.getColumnModel().getColumn(2);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Head of the Department");
        comboBox.addItem("Staff");
        comboBox.addItem("Department Secretary");
        comboBox.addItem("System Administrator");
        
        col.setCellEditor(new DefaultCellEditor(comboBox));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        col.setCellRenderer(renderer);
        
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
        changeRoleMenuItem = new javax.swing.JMenuItem();
        resetPasswordMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        usersLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        changeRoleMenuItem.setText("Change Role");
        changeRoleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeRoleMenuItemActionPerformed(evt);
            }
        });
        userPopupMenu.add(changeRoleMenuItem);

        resetPasswordMenuItem.setText("Reset Password\n");
        resetPasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordMenuItemActionPerformed(evt);
            }
        });
        userPopupMenu.add(resetPasswordMenuItem);

        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        userPopupMenu.add(deleteMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - View Users");
        setResizable(false);

        usersLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(usersLabel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(usersLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
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
                usersTable.setModel(new UserTableModel());
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

    private void changeRoleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeRoleMenuItemActionPerformed
        // TODO add your handling code here:
        ChangeRoleForm.temp=(String) usersTable.getValueAt(selectedRow, 0);
        ChangeRoleForm cf = new ChangeRoleForm();
        Utilfunctions.setIconImage(cf);
        Utilfunctions.setLocation(cf);
        cf.setVisible(true);
    }//GEN-LAST:event_changeRoleMenuItemActionPerformed

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
    private javax.swing.JMenuItem changeRoleMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem resetPasswordMenuItem;
    private javax.swing.JPopupMenu userPopupMenu;
    private javax.swing.JLabel usersLabel;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
    
}

class UserTableModel extends AbstractTableModel {
        private String[] columnNames = {"Login Id","Name","Role","Department"};
        private Object[][] data;
        private final String userRole;
	
        public UserTableModel() throws SQLException{
            userRole = LoginForm.userRole;
            String query;
            if(userRole.equals("sa")){
                query = "SELECT * FROM user ORDER BY name";
            }else{
                query = "SELECT * FROM user WHERE dept = '" + LoginForm.userDept + "' ORDER BY name";
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
                query = "SELECT * FROM login WHERE userCode = '" + rs.getString(1) + "'";
                ResultSet rs2 = Utilfunctions.executeQuery(query);
                rs2.next();
                Object[] values = {rs2.getString(1),rs.getString(2),hm.get(rs2.getString(4)),rs.getString(4)};
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
            if (col < 2) {
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
            data[row][col] = value;
            fireTableCellUpdated(row, col);
            
            HashMap hm = new HashMap();
            hm.put("Head of the Department","hod");
            hm.put("Staff","staff");
            hm.put("Department Secretary","ds");
            hm.put("System Administrator","sa");

            
            String role = value.toString();

            String query = "UPDATE login SET role = '" + hm.get(role) + "' WHERE id = '" + data[row][0] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1)
                JOptionPane.showMessageDialog(null,"Role Changed");
        }
    }

