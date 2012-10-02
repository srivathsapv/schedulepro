/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;



/**
 *
 * @author srivathsa
 */
public class EquipmentViewForm extends javax.swing.JFrame {
    private final String userRole;

    /**
     * Creates new form EquipmentView
     */
    public EquipmentViewForm() throws SQLException {
        initComponents();
        jMenuItem4.setVisible(false);
        userRole = LoginForm.userRole;
        if (userRole.equals("sa") || userRole.equals("ds") || userRole.equals("hod")) {
            jMenuItem4.setVisible(true);
        }
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
        jTable1.setModel(new EquipmentTableModel());
        TableColumn col = jTable1.getColumnModel().getColumn(1);
        col.setCellRenderer(new ToolTipRenderer());
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
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItem5.setText("Book");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem6.setText("View Booking Details");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        jMenuItem4.setText("Delete");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("View Equipments - SchedulePro");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipments");

        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setRowHeight(25);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt)) {
            JTable source = (JTable)evt.getSource();
            selectedRow = source.rowAtPoint( evt.getPoint() );
            selectedColumn = source.columnAtPoint( evt.getPoint() );
            
            if (! source.isRowSelected(selectedRow))
                source.changeSelection(selectedRow, selectedColumn, false, false);
            
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this equipment?","Delete Equipment",JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){
            Utilfunctions.executeUpdate("DELETE FROM equipment WHERE equipId = '" + jTable1.getValueAt(selectedRow,0) + "'");
            Utilfunctions.executeUpdate("DELETE FROM `equipmentissue` WHERE `equipId`='" + jTable1.getValueAt(selectedRow,0) + "'");
            EquipmentTableModel model = (EquipmentTableModel)jTable1.getModel();
            try {
                jTable1.setModel(new EquipmentTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(EquipmentViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        EquipmentIssueForm.chosenEquipId=Integer.parseInt(jTable1.getValueAt(selectedRow,0).toString());
        EquipmentIssueForm eif = new EquipmentIssueForm();
        Utilfunctions.setIconImage(eif);
        Utilfunctions.setLocation(eif);
        
        EquipmentTableModel emodel = (EquipmentTableModel)jTable1.getModel();
        //EquipmentIssueForm.chosenEquipId = emodel.getEquipId(selectedRow);
        
        eif.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        equipmentId=Integer.parseInt(jTable1.getValueAt(selectedRow,0).toString());
        ViewBookingDetailsForm vb = null;
        try {
            vb = new ViewBookingDetailsForm();
            Utilfunctions.setIconImage(vb);
            Utilfunctions.setLocation(vb);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        vb.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EquipmentViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new EquipmentViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EquipmentViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private int selectedRow;
    private int selectedColumn;
    public static int equipmentId;
}
class EquipmentTableModel extends AbstractTableModel {
        private String[] columnNames = {"Equipment ID","SMS ID","Equipment Name","Department"};
        private Object[][] data;
        private final String userRole;

        public EquipmentTableModel() throws SQLException{
            userRole = LoginForm.userRole;
            String query;
            if(userRole.equals("sa")){
                query = "SELECT equipId,equipName,dept,SMSid FROM equipment";
            }else{
                query = "SELECT equipId,equipName,dept,SMSid FROM equipment WHERE dept = '" + LoginForm.userDept + "'";
            }
            ResultSet rs = Utilfunctions.executeQuery(query);
            int cnt = 0;
            while(rs.next())
                cnt++;

            data = new Object[cnt][4];
            rs=Utilfunctions.executeQuery(query);
            int i=0;
            while(rs.next()){
                String values[] = {rs.getString(1),rs.getString(4),rs.getString(2),rs.getString(3)};
                data[i++]=values;
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
        if (col == 1) {
            if(!LoginForm.userRole.equals("sa")||!LoginForm.userRole.equals("ds")||!LoginForm.userRole.equals("hod")){
                return false;
            }
            else {
                return true;
            }
        } 
        else {
            return false;
        }
    }

    /*
    * Don't need to implement this method unless your table's
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {
        
        String cValue = (data[row][col]).toString();
        if(cValue.equals(value)) return;
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        
        String query = "UPDATE equipment SET equipName = '" + value.toString() + "' WHERE equipId = '" + data[row][0] + "'";
        int n = Utilfunctions.executeUpdate(query);
        if(n >= 1)
            JOptionPane.showMessageDialog(null,"Equipment name edited");
    }
}

class ToolTipRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected,
                                            hasFocus, row, column);
        setToolTipText("Double click to edit");
        return this;
    }
}