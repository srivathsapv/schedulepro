/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Sasi Praveen
 */
public class StaffPeriodViewForm extends javax.swing.JFrame {
    
    //private ClassScheduleTableModel model;
    /**
     * Creates new form ClassPeriodViewForm
     */
    public StaffPeriodViewForm() {
        try {
            initComponents();  
            Utilfunctions.populateComboBoxwithQuery(staffComboBox, "SELECT CONCAT(name,'(',userCode,')') FROM `user`");
        } catch (SQLException ex) {
            Logger.getLogger(StaffPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DashboardForm df = new DashboardForm();
                Utilfunctions.setIconImage(df);
                Utilfunctions.setLocation(df);
                e.getWindow().setVisible(false);
                df.setVisible(true);
            }
        });*/
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
        jLabel2 = new javax.swing.JLabel();
        staffComboBox = new javax.swing.JComboBox();
        printButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Class Schedule");

        jLabel1.setText("Choose Faculty:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Staff Schedule");

        staffComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffComboBoxActionPerformed(evt);
            }
        });

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(442, 442, 442)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(403, 403, 403)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(staffComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 462, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(printButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staffComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffComboBoxActionPerformed
        try {
            userCode = Utilfunctions.getWithinBrackets(staffComboBox.getSelectedItem().toString());
            //System.out.println(classCode);
            
            jTable1.setModel(new StaffScheduleTableModel());
            
        } catch (SQLException ex) {
            Logger.getLogger(StaffPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_staffComboBoxActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(StaffPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StaffPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StaffPeriodViewForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox staffComboBox;
    // End of variables declaration//GEN-END:variables
    public static String userCode;
}
class StaffScheduleTableModel extends AbstractTableModel {
        private String[] columnNames = {};
        private Object[][] data;
        private Vector time = new Vector();
        
        public StaffScheduleTableModel() throws SQLException{
            ResultSet columncnt_rs = Utilfunctions.executeQuery("SELECT COUNT(DISTINCT(CONCAT(timeFrom,'-',timeTo))) FROM periodconfig"
                    + " WHERE pconfigId IN(SELECT pconfigId FROM staffperiod WHERE userCode = '"+StaffPeriodViewForm.userCode+"')");
            columncnt_rs.next();
            
            int cols = columncnt_rs.getInt(1);
            columnNames = new String[columncnt_rs.getInt(1)+1];
            
            ResultSet column_rs = Utilfunctions.executeQuery("SELECT DISTINCT(CONCAT(timeFrom,'-',timeTo)) FROM periodconfig"
                    + " WHERE pconfigId IN(SELECT pconfigId FROM staffperiod WHERE userCode = '"+StaffPeriodViewForm.userCode+"') AND pType != 3 order by TIMEFROM(pconfigId)");
            int i=1;
            while(column_rs.next()){
                time.add(column_rs.getString(1));
                columnNames[i++] = column_rs.getString(1).substring(0, 5)+" - "+column_rs.getString(1).substring(9, 14);
            } 
            
            ResultSet daycnt_rs = Utilfunctions.executeQuery("select count(distinct(day)) from periodconfig where "
                    + "pconfigId IN(select pconfigId from staffperiod where userCode = '"+StaffPeriodViewForm.userCode+"')");
            daycnt_rs.next();
            data = new Object[daycnt_rs.getInt(1)][columncnt_rs.getInt(1)+1];
            
            ResultSet day_rs = Utilfunctions.executeQuery("select distinct(day) from periodconfig where "
                    + "pconfigId IN(select pconfigId from staffperiod where userCode = '"+StaffPeriodViewForm.userCode+"')");
            int k=0;
            while(day_rs.next()){
            String[] values = new String[columncnt_rs.getInt(1)+1];
            values[0]="<html><body><b>"+day_rs.getString(1)+"</b></body></html>";
            for(i=0;i<time.size();i++){
                ResultSet result_pf = Utilfunctions.executeQuery("select pconfigId from periodconfig where day = '"+day_rs.getString(1)+"' and CONCAT(timeFrom,'-',timeTo)='"+time.get(i)+"'");
                if(result_pf.next()){
                    ResultSet periodcheck_rs = Utilfunctions.executeQuery("select classCode from staffperiod where pconfigId ="+result_pf.getString(1) + " AND userCode = '" + StaffPeriodViewForm.userCode + "'");
                    if(periodcheck_rs.next())   {
                    ResultSet classname_rs = Utilfunctions.executeQuery("SELECT CONCAT(course,' ',dept,' ',year,' - ',section),roomId FROM class where classCode= "+periodcheck_rs.getString(1));
                    classname_rs.next();
                    ResultSet room_rs = Utilfunctions.executeQuery("select roomNo from classroom where roomId ="+classname_rs.getString(2));
                    room_rs.next();
                    String roomNo = room_rs.getString(1);
                    String classname = classname_rs.getString(1);
                    values[i+1]="<html><body>" + classname + "<br>(" + roomNo + ")</body></html>";
                }else{
                    values[i+1]="-----";
                }
            }
           
        }
            
            data[k++] = values;
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
        Class cl=null;
        try{
          cl = getValueAt(0, c).getClass();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,c);
       }
       return cl;
        }

    
   
    /*
    * Don't need to implement this method unless your table's
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {
        
    }

}  

