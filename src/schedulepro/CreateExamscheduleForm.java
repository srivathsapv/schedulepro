/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class CreateExamscheduleForm extends javax.swing.JFrame {
    private final String userRole;
    private String userDept="";

    /**
     * Creates new form CreateExamscheduleForm
     */
    public CreateExamscheduleForm() {
        initComponents();
        Utilfunctions.populateComboBoxwithQuery(roomNoComboBox,"select roomNo from classroom");
        userRole = LoginForm.userRole;
            String query;
            if(userRole.equals("sa")){
                query = "SELECT dept from dept";
                Utilfunctions.populateComboBoxwithQuery(departmentComboBox,query);
            }else{
                departmentComboBox.addItem(LoginForm.userDept);
                departmentComboBox.setSelectedItem(LoginForm.userDept);
                departmentComboBox.setEnabled(false);
                userDept = LoginForm.userDept;
                Utilfunctions.populateComboBoxwithQuery(courseComboBox, "SELECT DISTINCT(`course`) FROM `class` WHERE dept='" + userDept + "'");
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
        courseComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        sectionComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        roomNoComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Create Exam Schedule");
        setResizable(false);

        jLabel1.setText("Exam Name:");

        jLabel2.setText("Course:");

        courseComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setText("Year:");

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });

        jLabel4.setText("Subject:");

        jLabel5.setText("Date:");

        jLabel6.setText("YYYY-MM-DD");

        dateTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateTextFieldFocusLost(evt);
            }
        });

        jLabel7.setText("Period:");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField2PropertyChange(evt);
            }
        });

        jButton2.setText("Choose");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Section:");

        sectionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sectionComboBoxItemStateChanged(evt);
            }
        });

        jLabel9.setText("Room No.:");

        jLabel10.setText("Department:");

        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(roomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_courseComboBoxItemStateChanged
        // TODO add your handling code here:
        Utilfunctions.populateComboBoxwithQuery(yearComboBox, "SELECT distinct(`year`) FROM `class` WHERE `dept`='" + userDept + "' AND course='" + courseComboBox.getSelectedItem() + "' order by `year` asc");

    }//GEN-LAST:event_courseComboBoxItemStateChanged

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        // TODO add your handling code here:
        Utilfunctions.populateComboBoxwithQuery(sectionComboBox, "SELECT distinct(`section`) FROM `class` WHERE `dept`='" + userDept + "' AND course='" + courseComboBox.getSelectedItem() + "' AND year=" + yearComboBox.getSelectedItem() + " order by `year` asc");
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void dateTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTextFieldFocusLost
        // TODO add your handling code here:    
        if (!dateTextField.getText().isEmpty()) {
            String DayOfWeek = "";
            String input = dateTextField.getText().toString();
            int y = Integer.parseInt(input.substring(0, 4));
            int m = Integer.parseInt(input.substring(5, 7));
            int d = Integer.parseInt(input.substring(8));
            if (!Validation.isValidDate(d, m, y)) {
                JOptionPane.showMessageDialog(null, "Invalid date");
                dateTextField.setText("");
                dateTextField.requestFocus();
                return;
            } else {
                DayOfWeek = Utilfunctions.getDayOFWeek(dateTextField.getText());
            }
        }
        changeDate();
    }//GEN-LAST:event_dateTextFieldFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:PeriodConfigViewForm.pConfigChooseInvoker = this;
        if (!dateTextField.getText().isEmpty()) {
            PeriodConfigViewForm.pConfigChooseInvoker = this;
            PeriodConfigViewForm.pConfigTextField = jTextField2;
            try {
                PeriodConfigViewForm pcv = new PeriodConfigViewForm();
                Utilfunctions.setIconImage(pcv);
                Utilfunctions.setLocation(pcv);
                pcv.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(EquipmentIssueForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(subjectComboBox, "Please Enter a date");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        if (!jTextField1.getText().equals("")) {
            if (!Validation.isalphanumeric(jTextField1.getText())) {
                JOptionPane.showMessageDialog(null, "Exam Name should be alphanumeric");
            }
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int classCode = 0;
        int n = 0;
        ResultSet r;
        ResultSet result = Utilfunctions.executeQuery("SELECT `classCode` FROM `class` WHERE `dept`='" + userDept + "' AND `year`=" + yearComboBox.getSelectedItem() + " AND `course`='" + courseComboBox.getSelectedItem() + "' AND section='" + sectionComboBox.getSelectedItem() + "'");
        r = Utilfunctions.executeQuery("select roomId from classroom where roomNo='"+roomNoComboBox.getSelectedItem()+"'");
        try {
            result.next();
            r.next();
            
            String query = "SELECT COUNT(*) FROM exam WHERE examDate = '" + dateTextField.getText()
                    + "' AND pconfigId = " + PeriodConfigViewForm.pConfigId + " AND "
                    + " roomId = " + r.getInt(1);
            ResultSet countrs = Utilfunctions.executeQuery(query);
            countrs.next();
            boolean cont=true;
            if(countrs.getInt(1) >= 1){
                int opt = JOptionPane.showConfirmDialog(null, "Room - " +roomNoComboBox.getSelectedItem().toString() + " already occupied for another exam. Want to accomodate another class?", "SchedulePro - Logoff", JOptionPane.YES_NO_OPTION);
                if(opt != JOptionPane.YES_OPTION){
                    cont=false;
                }   
            }
            if(cont){
                classCode = Integer.parseInt(result.getString(1));
                n = Utilfunctions.executeUpdate("INSERT INTO `schedulepro`.`exam` (`examCode`, `subCode`, `examDate`, `pconfigId`, `classCode`, `examName`, roomId) VALUES (NULL, '" + Utilfunctions.getWithinBrackets(subjectComboBox.getSelectedItem().toString()) + "', '" + dateTextField.getText() + "', " + PeriodConfigViewForm.pConfigId + ", " + classCode + ", '" + jTextField1.getText() + "', '"+r.getString(1)+"')");
                if(n >= 1) JOptionPane.showMessageDialog(null,"Exam added successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateExamscheduleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sectionComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sectionComboBoxItemStateChanged
        // TODO add your handling code here:
        try {
            subjectComboBox.removeAllItems();
            ResultSet result;
            ResultSet result1;
            ResultSet result2;
            result = Utilfunctions.executeQuery("SELECT `classCode` FROM `class` WHERE `dept`='" + LoginForm.userDept + "' AND `year`=" + yearComboBox.getSelectedItem() + " AND section = '" + sectionComboBox.getSelectedItem() + "' AND `course`='" + courseComboBox.getSelectedItem() + "'");
            if (result.next()) {
                result1 = Utilfunctions.executeQuery("SELECT `subCode` FROM `subclass` WHERE `classCode`=" + result.getString(1));
                while (result1.next()) {
                    result2 = Utilfunctions.executeQuery("select CONCAT(`subName`,'(',`subcode`,')') from `subject` WHERE `subcode`='" + result1.getString(1) + "' order by `subName` asc");
                    result2.next();
                    subjectComboBox.addItem(result2.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateExamscheduleForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_sectionComboBoxItemStateChanged

    private void jTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField2PropertyChange
        
        
    }//GEN-LAST:event_jTextField2PropertyChange

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        changeDate();
    }//GEN-LAST:event_jTextField2FocusGained

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
       userDept = departmentComboBox.getSelectedItem().toString();
       Utilfunctions.populateComboBoxwithQuery(courseComboBox, "SELECT DISTINCT(`course`) FROM `class` WHERE dept='" + userDept + "'");
    }//GEN-LAST:event_departmentComboBoxItemStateChanged
    
    private void changeDate(){
        if(jTextField2.getText().equals("")) return;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = df.parse(dateTextField.getText());
            Calendar cl = Calendar.getInstance();
            cl.setTime(dt);
            
            String query = "SELECT day FROM periodconfig where pconfigId = " + PeriodConfigViewForm.pConfigId;
            ResultSet rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                cl.set(Calendar.DAY_OF_WEEK,Utilfunctions.getDayNumber(rs.getString(1)));
                String changedDate = df.format(cl.getTime());
                dateTextField.setText(changedDate);
            } catch (SQLException ex) {
                Logger.getLogger(CreateExamscheduleForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CreateExamscheduleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(CreateExamscheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateExamscheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateExamscheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateExamscheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateExamscheduleForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox courseComboBox;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox roomNoComboBox;
    private javax.swing.JComboBox sectionComboBox;
    private javax.swing.JComboBox subjectComboBox;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
}
