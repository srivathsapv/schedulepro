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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author srivathsa
 */
public class ViewAssignedFacultyForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewAssignedFacultyForm
     */
    public ViewAssignedFacultyForm() throws SQLException {
        initComponents();
        
        String query = "SELECT * FROM class WHERE classCode = '" + classCode + "'";
        ResultSet classResult = Utilfunctions.executeQuery(query);
        classResult.next();
        jLabel1.setText(classResult.getString(4) + " - " + classResult.getString(2) + " " + classResult.getString(3) + " " + classResult.getString(5) + " - Assigned Faculty" );
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setModel(new FacultyTableModel());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(280);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        
        JComboBox subcombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(subcombo, "SELECT CONCAT(subName,'(',subcode,')') FROM subject ORDER BY subName");
        
        TableColumn col = jTable1.getColumnModel().getColumn(0);
        col.setCellEditor(new DefaultCellEditor(subcombo));
        
        JComboBox usercombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(usercombo, "SELECT CONCAT(salutation,name,'- ',dept,' (',userCode,')') FROM user ORDER BY name");
        
        col = jTable1.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(usercombo));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ClassViewForm cf;
                try {
                    cf = new ClassViewForm();
                    Utilfunctions.setIconImage(cf);
                    Utilfunctions.setLocation(cf);
                    e.getWindow().setVisible(false);
                    cf.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Assigned Faculty Form");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Class Details");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new ViewAssignedFacultyForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewAssignedFacultyForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    public static int classCode;
}

class FacultyTableModel extends AbstractTableModel {
    private String[] columnNames = {"Subject Name","Faculty Name"};
    private Object[][] data;
    private String[] subcodes;
    private String[] usercodes;
    private int[] subclassIds;
        
    public FacultyTableModel() throws SQLException{
        int classCode = ViewAssignedFacultyForm.classCode;
        String query = "SELECT COUNT(*) FROM subclass WHERE classCode = '" + classCode + "'";
        ResultSet cnt_rs = Utilfunctions.executeQuery(query);
        cnt_rs.next();
        
        data = new Object[cnt_rs.getInt(1)][2];
        subcodes = new String[cnt_rs.getInt(1)];
        usercodes = new String[cnt_rs.getInt(1)];
        subclassIds = new int[cnt_rs.getInt(1)];
        
        if(cnt_rs.getInt(1) >= 1){
            query = "SELECT * FROM subclass WHERE classCode = '" + classCode + "'";
            ResultSet rs = Utilfunctions.executeQuery(query);
            int i=0;
            while(rs.next()){
                subclassIds[i] = rs.getInt(1);
                
                subcodes[i]=rs.getString(3);
                query = "SELECT subName FROM subject WHERE subcode = '" + rs.getString(3) + "'";
                ResultSet subrs = Utilfunctions.executeQuery(query);
                subrs.next();
                
                usercodes[i] = rs.getString(4);
                query = "SELECT * FROM user WHERE userCode = '" + rs.getString(4) + "'";
                ResultSet userrs = Utilfunctions.executeQuery(query);
                userrs.next();
                
                String[] values = {subrs.getString(1) + "(" + rs.getString(3) + ")",userrs.getString(3) + userrs.getString(2) + " - " + userrs.getString(4) + " (" + userrs.getString(1) + ")"};
                data[i++] = values;
            }
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
        return true;
    }
    
    /*
    * Don't need to implement this method unless your table's
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {        
        if(value.toString().equals(data[row][col].toString())) return;
        
        String query = "";
        String v = value.toString();
        int bIndex = v.indexOf("(");
        int beIndex = v.indexOf(")");
        if(col == 0){    
            String subcode = v.substring(bIndex+1,beIndex);
            
            query = "UPDATE subclass SET subCode = '" + subcode + "' WHERE subClassId = " + subclassIds[row];
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Updated");
        }
        else {
            String usercode = v.substring(bIndex+1,beIndex);
            query = "UPDATE subclass SET userCode = '" + usercode + "' WHERE subClassId = " + subclassIds[row];
            int n = Utilfunctions.executeUpdate(query);
            if(n >= 1) JOptionPane.showMessageDialog(null,"Updated");
        }
        
        data[row][col] = value;
        fireTableCellUpdated(row,col);
    }
}