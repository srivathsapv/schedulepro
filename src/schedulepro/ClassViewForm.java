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
 * @author srivathsa
 */
public class ClassViewForm extends javax.swing.JFrame {
    private String userRole;

    /**
     * Creates new form ClassViewForm
     */
    public ClassViewForm() throws SQLException {
        initComponents();
        jTable1.setModel(new ClassTableModel());
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
        
        JComboBox sectionCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(sectionCombo, "SELECT DISTINCT(section) FROM class ORDER BY section");
        
        JComboBox yearCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(yearCombo, "SELECT DISTINCT(year) FROM class ORDER BY year");
        
        JComboBox courseCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(courseCombo, "SELECT DISTINCT(course) FROM class");
        
        JComboBox deptCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(deptCombo, "SELECT DISTINCT(dept) FROM class");
        
        TableColumn col = jTable1.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(courseCombo));
        
        col = jTable1.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(deptCombo));
        
        col = jTable1.getColumnModel().getColumn(3);
        col.setCellEditor(new DefaultCellEditor(yearCombo));
        
        col = jTable1.getColumnModel().getColumn(4);
        col.setCellEditor(new DefaultCellEditor(sectionCombo));
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItem2.setText("View Assigned Faculty");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Class Schedule Details");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem1.setText("Delete");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Class View");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
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
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ResultSet result;
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this class?", "SchedulePro - Class View", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION){
            ClassTableModel model = (ClassTableModel)jTable1.getModel();
            int classCode = model.getClassCode(selectedRow);
            String query = "DELETE FROM class WHERE classCode = " + classCode;
            n = Utilfunctions.executeUpdate(query);
            Utilfunctions.executeQuery("DELETE FROM subclass WHERE classCode = " + classCode);
            Utilfunctions.executeQuery("DELETE FROM `equipmentissue` WHERE classCode = " + classCode);
            result = Utilfunctions.executeQuery("SELECT `examCode` FROM `exam` WHERE `classCode`= " + classCode);
            try {
                if(result.next()){
                    Utilfunctions.executeUpdate("DELETE FROM `examinvigilation` WHERE `examCode`=" + result.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            Utilfunctions.executeQuery("DELETE FROM `exam` WHERE classCode = " + classCode);
            if(n >= 1) {
                JOptionPane.showMessageDialog(null,"Class Deleted");
                try {
                    jTable1.setModel(new ClassTableModel());
                } catch (SQLException ex) {
                    Logger.getLogger(ClassViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        userRole = LoginForm.userRole;
        if (userRole.equals("sa") || userRole.equals("ds") || userRole.equals("hod")) {
            if (SwingUtilities.isRightMouseButton(evt)) {
                JTable source = (JTable) evt.getSource();
                selectedRow = source.rowAtPoint(evt.getPoint());
                selectedColumn = source.columnAtPoint(evt.getPoint());
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            ClassTableModel model = (ClassTableModel)jTable1.getModel();
            ViewAssignedFacultyForm.classCode = model.getClassCode(selectedRow);
            ViewAssignedFacultyForm aff;
            aff = new ViewAssignedFacultyForm();
            Utilfunctions.setIconImage(aff);
            Utilfunctions.setLocation(aff);
            this.setVisible(false);
            aff.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ClassViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        ClassTableModel model = (ClassTableModel)jTable1.getModel();
        ClassScheduleDetailsForm.classCode = model.getClassCode(selectedRow);
        ClassScheduleDetailsForm csdf = new ClassScheduleDetailsForm();
        Utilfunctions.setIconImage(csdf);
        Utilfunctions.setLocation(csdf);
        
        csdf.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(ClassViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new ClassViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ClassViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    int selectedRow;
    int selectedColumn;
}
class ClassTableModel extends AbstractTableModel {
        private String[] columnNames = {"Room Number","Course","Department","Year","Section","Strength"};
        private Object[][] data;
        private int classCodes[];
        private final String userRole;
        public ClassTableModel() throws SQLException{
            ResultSet r;
            String query;
            userRole = LoginForm.userRole;
            if(userRole.equals("sa")){
                query = "SELECT * FROM class ORDER BY year,section";
            }else{
                query = "SELECT * FROM class WHERE dept = '" + LoginForm.userDept + "' ORDER BY year,section";
            }
            ResultSet rs = Utilfunctions.executeQuery(query);
            int cnt = 0;
            while(rs.next())
                cnt++;

            data = new Object[cnt][5];
            classCodes = new int[cnt];
            rs=Utilfunctions.executeQuery(query);
            int i=0;
            while(rs.next()){
                r = Utilfunctions.executeQuery("Select roomNo from classroom where roomId="+rs.getString(6));
                r.next();
                String values[] = {r.getString(1),rs.getString(4),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(7)};
                data[i]=values;
                classCodes[i++] = rs.getInt(1);
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
        if(!LoginForm.userRole.equals("sa") && col == 2){
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public int getClassCode(int row){
        return classCodes[row];
    }
    /*
    * Don't need to implement this method unless your table's
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {
        String query;
        String userDept;
        if(LoginForm.userRole.equals("sa")){
            userDept = (data[row][2]).toString();
        }else{
            userDept = LoginForm.userDept;
        }
        if(value.toString().equals(data[row][col].toString())) return;
        if(col == 0){
            query = "SELECT COUNT(*) FROM classroom WHERE roomNo = '" + value.toString() + "'";
            ResultSet r1 = Utilfunctions.executeQuery(query);
            try {
                r1.next();
                int roomId=0;
                if(r1.getInt(1) >= 1) {
                    r1 = Utilfunctions.executeQuery("SELECT roomId FROM classroom WHERE roomNo = '" + value.toString() + "'");
                    r1.next();
                    query = "SELECT COUNT(*) FROM class WHERE roomId = " + r1.getInt(1) + " AND classCode != '" + classCodes[row] + "'";
                    ResultSet rs = Utilfunctions.executeQuery(query);
                    rs.next();
                    if(rs.getInt(1) >= 1) {
                        JOptionPane.showMessageDialog(null,"Room number cannot be duplicate");
                        return;
                    }
                    roomId = r1.getInt(1);
                }
                else {
                    query = "INSERT INTO classroom(roomNo) VALUES('" + value.toString() + "')";
                    JOptionPane.showMessageDialog(null,query);
                    
                    roomId = Utilfunctions.insertWithGeneratedKey(query);
                }
                query = "UPDATE class SET roomId = '" + roomId + "' WHERE classCode = '" + classCodes[row] + "'";
                int n = Utilfunctions.executeUpdate(query);
                if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
            } catch (SQLException ex) {
                Logger.getLogger(ClassTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(col == 5) {
            if(!Validation.isNumber(value.toString())) {
                JOptionPane.showMessageDialog(null,"Invalid Value for Class Strength");
                return;
            }
            query = "UPDATE class SET strength = '" + value.toString() + "' WHERE classCode = '" + classCodes[row] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
        }
        else if(col == 1) {
            query = "SELECT COUNT(*) FROM class WHERE course = '" + value.toString() + 
                    "' AND year = '" + (data[row][3]).toString() + "' AND section = '" + 
                    (data[row][4]).toString() + "' AND classCode != '" + classCodes[row] + "' AND dept = '" + userDept + "'";
            ResultSet rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Duplicate Class");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "UPDATE class SET course = '" + value.toString() + "' WHERE classCode = '" + classCodes[row] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
            
        }
        else if(col == 3){
            query = "SELECT COUNT(*) FROM class WHERE course = '" + (data[row][1]).toString() + 
                    "' AND year = '" + value.toString() + "' AND section = '" + 
                    (data[row][4]).toString() + "' AND classCode != '" + classCodes[row] + "' AND dept = '" + userDept + "'";
            ResultSet rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Duplicate Class");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "UPDATE class SET year = '" + value.toString() + "' WHERE classCode = '" + classCodes[row] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
        }
        else if(col == 4){
            query = "SELECT COUNT(*) FROM class WHERE course = '" + (data[row][1]).toString() + 
                    "' AND year = '" + (data[row][3]).toString() + "' AND section = '" + 
                    value.toString() + "' AND classCode != '" + classCodes[row] + "' AND dept = '" + userDept + "'";
            ResultSet rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Duplicate Class");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "UPDATE class SET section = '" + value.toString() + "' WHERE classCode = '" + classCodes[row] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
        }else if(col == 2){
            query = "SELECT COUNT(*) FROM class WHERE course = '" + (data[row][1]).toString() + 
                    "' AND year = '" + (data[row][3]).toString() + "' AND section = '" + 
                    (data[row][4]).toString() + "' AND classCode != '" + classCodes[row] + "' AND dept = '" + value.toString() + "'";
            ResultSet rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Duplicate Class");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "UPDATE class SET dept = '" + value.toString() + "' WHERE classCode = '" + classCodes[row] + "'";
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Value updated successfuly");
        }
        data[row][col] = value;
        fireTableCellUpdated(row,col);
    }
}
