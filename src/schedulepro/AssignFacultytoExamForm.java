/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class AssignFacultytoExamForm extends javax.swing.JFrame {
    public static ExamScheduleViewForm ChooseInvoker;

    private int examCode = 0;
    private String examDate = "";
    private boolean flag = false;
    private String Query;
    private Vector assignedFaculty = new Vector();
    private String userRole;

    /**
     * Creates new form AssignFacultytoExamForm
     */
    public AssignFacultytoExamForm() throws ParseException {
        initComponents();
        //JOptionPane.showMessageDialog(null,ExamScheduleViewForm.timeFrom + " " + ExamScheduleViewForm.timeTo);
        examCode = ExamScheduleViewForm.examCode;
        examDate = ExamScheduleViewForm.examDate;
        
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = sf1.parse(examDate);
        
        SimpleDateFormat sf2 = new SimpleDateFormat("EEEE");
        String examDay = sf2.format(dt1);
        JOptionPane.showMessageDialog(null,examDay);
        ResultSet result = Utilfunctions.executeQuery("select userCode from examinvigilation where examCode=" + examCode);
        try {
            if (result.next()) {
                ResultSet result1 = Utilfunctions.executeQuery("SELECT CONCAT(name,'(',userCode,')') FROM `user` WHERE userCode='" + result.getString(1) + "'");
                if (result1.next()) {
                    assignedFacultyTextField.setText(result1.getString(1));
                    flag = true;
                    assignButton.setText("change");
                    this.setTitle("SchedulePro - Change Faculty");
                } else {
                    flag = true;
                }
            } else {
                assignedFacultyTextField.setText("");
                flag = false;
                assignButton.setText("Assign");
                this.setTitle("SchedulePro - Assign Faculty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Query = "SELECT `userCode` FROM `examinvigilation` WHERE `examCode`= ANY (SELECT `examCode` FROM `exam` WHERE `examDate`='"+examDate+"')";
        result = Utilfunctions.executeQuery(Query);
        ResultSet r1;
        try {
            while(result.next()){
                assignedFaculty.addElement(result.getString(1));
            }

            userRole = LoginForm.userRole;
            if(userRole.equals("sa")){
                Query = "SELECT userCode, CONCAT(name,'(',userCode,')') FROM user order by name asc";
            }else{
            Query = "SELECT userCode, CONCAT(name,'(',userCode,')') FROM user WHERE  dept =  '" + LoginForm.userDept + "' order by name asc";
            }
            r1 = Utilfunctions.executeQuery(Query);
            while(r1.next()){
                
                ResultSet p_exc = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pconfigId IN(SELECT pconfigId FROM staffperiodexception WHERE userCode = '" + r1.getString(1) + "')");
                boolean clash = false;
                while(p_exc.next()){
                    String timeFrom = p_exc.getString(3);
                    String timeTo = p_exc.getString(4);
                    String day = p_exc.getString(2);
                    if(day.equals(examDay)){
                        if(ConstraintsCheck.isPeriodOverlap(timeFrom,timeTo,ExamScheduleViewForm.timeFrom,ExamScheduleViewForm.timeTo)){
                            clash=true;
                            break;
                        }
                    }
                }
                
                ResultSet workhours = Utilfunctions.executeQuery("SELECT * FROM staffworkhour WHERE workHourConfigId IN(SELECT workHourConfigId FROM userworkid WHERE userCode = '" + r1.getString(1) + "')");
                while(workhours.next()){
                    int eTimeFrom = Integer.parseInt(ExamScheduleViewForm.timeFrom.replace(":",""));
                    int eTimeTo = Integer.parseInt(ExamScheduleViewForm.timeTo.replace(":",""));
                    int wTimeFrom = Integer.parseInt(workhours.getString(3).replace(":",""));
                    int wTimeTo  = Integer.parseInt(workhours.getString(4).replace(":",""));
                    
                    if(!(eTimeFrom <= wTimeFrom && eTimeTo >= wTimeTo)){
                        clash=true;
                        break;
                    }
                }
                if(clash) continue;
                //System.out.println(r1.getString(1)+"\n"+r1.getString(2));
            if (assignedFaculty.contains(r1.getString(1))) {
                        changeFacultyComboBox.addItem("<html><font color=red>" + r1.getString(2) + "</font></html>");
                    } else {
                        changeFacultyComboBox.addItem("<html><font color=green>" + r1.getString(2) + "</font></html>");
                    }
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        assignedFacultyTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        changeFacultyComboBox = new javax.swing.JComboBox();
        assignButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Change Faculty");
        setResizable(false);

        jLabel1.setText("Assigned Faculty:");

        assignedFacultyTextField.setEditable(false);

        jLabel2.setText("Change Faculty:");

        assignButton.setText("Assign");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changeFacultyComboBox, 0, 189, Short.MAX_VALUE)
                            .addComponent(assignedFacultyTextField))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addComponent(assignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(assignedFacultyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(changeFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(assignButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        // TODO add your handling code here:
        ResultSet r;
        ResultSet r1;
        ResultSet r2;
        ResultSet r3;
        ResultSet r4;
        if (changeFacultyComboBox.getSelectedItem().toString().contains("green")) {
            if (flag) {
                Utilfunctions.executeUpdate("UPDATE `examinvigilation` SET `userCode`='" + Utilfunctions.getWithinBrackets(changeFacultyComboBox.getSelectedItem().toString()) + "' WHERE `examCode`=" + examCode);
            } else {
                Utilfunctions.executeUpdate("INSERT INTO `examinvigilation`(`id`, `examCode`, `userCode`) VALUES (NULL," + examCode + ",'" + Utilfunctions.getWithinBrackets(changeFacultyComboBox.getSelectedItem().toString()) + "')");
            }
            this.setVisible(false);
            ChooseInvoker.jTable1.setValueAt(changeFacultyComboBox.getSelectedItem().toString(), ChooseInvoker.selectedRow, 9);
            try {
                ChooseInvoker.jTable1.setModel(new ExamTableModel());

                ChooseInvoker.jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
                ChooseInvoker.jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
                ChooseInvoker.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
                ChooseInvoker.jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
                ChooseInvoker.jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
                ChooseInvoker.jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
                ChooseInvoker.jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
                ChooseInvoker.jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
            } catch (SQLException ex) {
                Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                r = Utilfunctions.executeQuery("select examCode from examinvigilation where userCode ='" + Utilfunctions.getWithinBrackets(changeFacultyComboBox.getSelectedItem().toString()) + "'");
                r.next();
                r1 = Utilfunctions.executeQuery("select examDate, classCode, subCode, roomId from exam where examCode =" + r.getString(1));
                r1.next();
                r2 = Utilfunctions.executeQuery("select CONCAT(subName,'(',subcode,')') from subject where subcode = '" + r1.getString(3) + "'");
                r2.next();
                r3 = Utilfunctions.executeQuery("select year, course, section from class where classCode = " + r1.getString(2));
                r3.next();
                r4 = Utilfunctions.executeQuery("select roomNo from classroom where roomId=" + r1.getString(4));
                r4.next();
                JOptionPane.showMessageDialog(null, "Alreay assigned to:\nSubject = " + r2.getString(1) + "\nClass = " + r3.getString(1) + "-" + r3.getString(3) + " " + r3.getString(2) + "\nRoom No. = " + r4.getString(1));
            } catch (SQLException ex) {
                Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_assignButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AssignFacultytoExamForm().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(AssignFacultytoExamForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JTextField assignedFacultyTextField;
    private javax.swing.JComboBox changeFacultyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
