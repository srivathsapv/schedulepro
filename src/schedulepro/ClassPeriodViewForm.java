/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasi Praveen
 */
public class ClassPeriodViewForm extends javax.swing.JFrame {
    
    //private ClassScheduleTableModel model;
    /**
     * Creates new form ClassPeriodViewForm
     */
    public ClassPeriodViewForm() {
        try {
            initComponents();
            
            Utilfunctions.populateComboBoxwithQuery(classComboBox, "SELECT CONCAT(course,' ',dept,' ',year,' - ',section) FROM class");
        } catch (SQLException ex) {
            Logger.getLogger(ClassPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
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
        classComboBox = new javax.swing.JComboBox();
        printButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Class Schedule");

        jLabel1.setText("Choose class:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Class Schedule");

        classComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBoxActionPerformed(evt);
            }
        });

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Schedule for Class:");

        jLabel4.setText("w");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(printButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboBoxActionPerformed
        try {
            jLabel4.setText(classComboBox.getSelectedItem().toString());
            classCode = Utilfunctions.getClassCode(classComboBox.getSelectedItem().toString());
            if(classCode == 4){
            jTable1.setModel(new ClassScheduleTableModel());
            jTable2.setModel(new ClassScheduleDetailsTableModel());
            jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_classComboBoxActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            // TODO add your handling code here:
            MessageFormat header = new MessageFormat("Schedule for: "+classComboBox.getSelectedItem().toString());
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (PrinterException ex) {
            Logger.getLogger(ClassPeriodViewForm.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ClassPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassPeriodViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClassPeriodViewForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
    public static int classCode;
}

class ClassScheduleTableModel extends AbstractTableModel {
        private String[] columnNames = {};
        private Object[][] data;
        
        public ClassScheduleTableModel() throws SQLException{
            ResultSet columncnt_rs = Utilfunctions.executeQuery("SELECT COUNT(DISTINCT(CONCAT(timeFrom,'-',timeTo))) FROM periodconfig"
                    + " WHERE pconfigId IN(SELECT pconfigId FROM classperiod WHERE classcode = "+ClassPeriodViewForm.classCode+") AND pType != 3");
            columncnt_rs.next();
            
            int cols = columncnt_rs.getInt(1);
            columnNames = new String[columncnt_rs.getInt(1)+1];
            
            ResultSet column_rs = Utilfunctions.executeQuery("SELECT DISTINCT(CONCAT(timeFrom,'-',timeTo)) FROM periodconfig"
                    + " WHERE pconfigId IN(SELECT pconfigId FROM classperiod WHERE classcode = "+ClassPeriodViewForm.classCode+") AND pType != 3");
            int i=1;
            while(column_rs.next()){
                columnNames[i++] = column_rs.getString(1).substring(0, 5)+" - "+column_rs.getString(1).substring(9, 14);
            } 
            
            ResultSet daycnt_rs = Utilfunctions.executeQuery("select count(distinct(day)) from periodconfig where "
                    + "pconfigId IN(select pconfigId from classperiod where classCode = "+ClassPeriodViewForm.classCode+") and pType != 3");
            daycnt_rs.next();
            
            int rows = daycnt_rs.getInt(1);
            
            data = new Object[rows][cols+1];
            
            ResultSet day_rs = Utilfunctions.executeQuery("select distinct(day) from periodconfig where "
                    + "pconfigId IN(select pconfigId from classperiod where classCode = "+ClassPeriodViewForm.classCode+") and pType != 3");
            i=0;
            
            ResultSet shortname_rs;
            while(day_rs.next()){
                ResultSet table_rs = Utilfunctions.executeQuery("select subCode from classPeriod where classCode = "+ClassPeriodViewForm.classCode+" and pconfigId IN(SELECT `pconfigId` FROM `periodconfig` WHERE `pType` != 3 and day = '" + day_rs.getString(1) + "')");
                //System.out.println("Assigning for " + day_rs.getString(1));
                String[] values = new String[cols+1];
                values[0] = day_rs.getString(1);
                int k=1;
                while(table_rs.next()){
                    shortname_rs = Utilfunctions.executeQuery("select subShortName from subject where subCode='"+table_rs.getString(1)+"'");
                    shortname_rs.next();
                    values[k++]=shortname_rs.getString(1);
                    //System.out.println("----"+table_rs.getString(1));
                }
                data[i++] = values;
            }
            
            /*while(day_rs.next()){
                System.out.println(day_rs.getString(1) + " " + i);
                data[i++][0] = day_rs.getString(1);
            }
            i=1;
            ResultSet table_rs = Utilfunctions.executeQuery("select subCode from classperiod where classCode = "+ClassPeriodViewForm.classCode+" and pconfigId IN(SELECT `pconfigId` FROM `periodconfig` WHERE `pType` != 3 and day = 'Monday')");
            while(table_rs.next()) {
                data[0][i] = table_rs.getString(1);
                System.out.println(data[0][i]);
                i++;
            } */ 
           
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
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {
        
    }

}  

class ClassScheduleDetailsTableModel extends AbstractTableModel {
        private String[] columnNames = {"Abbrevation","Subject Name","Assigned Faculty"};
        private Object[][] data;
        
        public ClassScheduleDetailsTableModel() throws SQLException{
            ResultSet rowcnt_rs = Utilfunctions.executeQuery("SELECT COUNT(*) FROM subclass"
                    + " WHERE classCode = "+ClassPeriodViewForm.classCode);
            rowcnt_rs.next();
         
            data = new Object[rowcnt_rs.getInt(1)][3];
            
            
            ResultSet details_rs = Utilfunctions.executeQuery("SELECT subCode,userCode FROM subclass"
                    + " WHERE classCode = "+ClassPeriodViewForm.classCode);
            int i=0;
            //ResultSet user_rs,subject_rs;
            
            while(details_rs.next()){
                String[] values = new String[3];
                //System.out.println(details_rs.getString(1)+" "+details_rs.getString(2));
                ResultSet user_rs = Utilfunctions.executeQuery("select CONCAT(name,'(',dept,')') from user where"
                        + " userCode = '"+details_rs.getString(2)+"'");
                user_rs.next();
                ResultSet subject_rs = Utilfunctions.executeQuery("select subShortName,subName from subject "
                        + "where subCode ='"+details_rs.getString(1)+"'");
                subject_rs.next();
                //System.out.println(subject_rs.getString(1)+" "+subject_rs.getString(2)+" "+user_rs.getString(1));
                values[0] = subject_rs.getString(1);
                values[1] = subject_rs.getString(2);
                values[2] = user_rs.getString(1);
                data[i++]=values;
            }
  
            
            /*while(day_rs.next()){
                System.out.println(day_rs.getString(1) + " " + i);
                data[i++][0] = day_rs.getString(1);
            }
            i=1;
            ResultSet table_rs = Utilfunctions.executeQuery("select subCode from classperiod where classCode = "+ClassPeriodViewForm.classCode+" and pconfigId IN(SELECT `pconfigId` FROM `periodconfig` WHERE `pType` != 3 and day = 'Monday')");
            while(table_rs.next()) {
                data[0][i] = table_rs.getString(1);
                System.out.println(data[0][i]);
                i++;
            } */ 
           
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
    * data can change.
    */
    @Override
    public void setValueAt(Object value, int row, int col) {
        
    }

}