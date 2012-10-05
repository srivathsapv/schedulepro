/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class StaffConstraintForm extends javax.swing.JFrame {
    private String workingPeriod="0";
    private boolean flag = false;
    private Vector workHourConfigId = new Vector();
    private Vector day = new Vector();
    private Vector timeFrom = new Vector();
    private Vector timeTo = new Vector();
    private final String userRole;
    public static String userCode="";
    private String setname=""; 
   

    /**
     * Creates new form StaffConstraintForm
     */
    public StaffConstraintForm() throws SQLException {
        initComponents();
        
        DefaultListModel model1 = new DefaultListModel();
        model1.addElement("Periods Exceptions");
        
        jList1.setModel(model1);
        pConfigs = new Vector();
        ResultSet result, r1;
        userRole = LoginForm.userRole;
        if (userRole.equals("sa")) {
            Utilfunctions.populateComboBoxwithQuery(facultyComboBox, "select CONCAT(name,'(',userCode,')') from user order by name");
        } else if (userRole.equals("ds") || userRole.equals("hod")) {
            Utilfunctions.populateComboBoxwithQuery(facultyComboBox, "select CONCAT(name,'(',userCode,')') from user where dept='" + LoginForm.userDept + "' order by name");
        } else {
            jLabel7.setVisible(false);
            facultyComboBox.setVisible(false);
            userCode = LoginForm.userCode;
            jCheckBox1.setVisible(false);
            try {
                result = Utilfunctions.executeQuery("select * from staffconstraint where userCode = '" + userCode + "'");
                if (result.next()) {
                    workingPeriod = result.getString(2);
                    workingPeriodsTextField.setText(workingPeriod);
                    flag = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultListModel model = new DefaultListModel();
            result = Utilfunctions.executeQuery("SELECT `workHourConfigId` FROM `userworkid` WHERE `userCode`='" + userCode + "'");
            try {
                while (result.next()) {
                    r1 = Utilfunctions.executeQuery("SELECT * FROM `staffworkhour` WHERE `workHourConfigId`=" + result.getString(1));
                    r1.next();
                    day.addElement(r1.getString(2));
                    timeFrom.addElement(r1.getString(3));
                    timeTo.addElement(r1.getString(4));
                    model.addElement(r1.getString(2) + " " + r1.getString(3) + " - " + r1.getString(4));
                    workHourConfigId.addElement(r1.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            workHourList.setModel(model);
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
        workingPeriodsTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workHourList = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        addButton1 = new javax.swing.JButton();
        removeButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Faculty Constraints - SchedulePro");
        setResizable(false);

        jLabel1.setText("Working Periods:");

        workingPeriodsTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                workingPeriodsTextFieldFocusLost(evt);
            }
        });

        jLabel2.setText("per week");

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_small.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setMaximumSize(new java.awt.Dimension(85, 25));
        saveButton.setMinimumSize(new java.awt.Dimension(85, 25));
        saveButton.setPreferredSize(new java.awt.Dimension(85, 25));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        workHourList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workHourListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workHourList);

        jLabel6.setText("Work Hours:");

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_small.png"))); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove_small.png"))); // NOI18N
        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Faculty:");

        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });

        jCheckBox1.setText("mine");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel8.setText("Period Exceptions:");

        addButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_small.png"))); // NOI18N
        addButton1.setText("Add");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        removeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove_small.png"))); // NOI18N
        removeButton1.setText("Remove");
        removeButton1.setEnabled(false);
        removeButton1.setMaximumSize(new java.awt.Dimension(71, 25));
        removeButton1.setMinimumSize(new java.awt.Dimension(71, 25));
        removeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton1ActionPerformed(evt);
            }
        });

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setText("Faculty Constraint");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(workingPeriodsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(facultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(workingPeriodsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void workingPeriodsTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_workingPeriodsTextFieldFocusLost
        // TODO add your handling code here:
        if (!workingPeriodsTextField.getText().isEmpty()) {
            if (!Validation.isNumber(workingPeriodsTextField.getText())) {
                JOptionPane.showMessageDialog(null, "Please Enter a numeric value");
                workingPeriodsTextField.setText(workingPeriod);
                workingPeriodsTextField.requestFocus();
            }else
            {
                workingPeriod = workingPeriodsTextField.getText(); 
            }
    
    }
    }//GEN-LAST:event_workingPeriodsTextFieldFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int n;
        if (flag) {
            n = Utilfunctions.executeUpdate("UPDATE `staffconstraint` SET `totalPPW`=" + workingPeriod + " WHERE userCode = '" + userCode + "'");
            Utilfunctions.executeUpdate("DELETE FROM staffperiodexception WHERE userCode = '" + userCode + "'");
        } else {
            n = Utilfunctions.executeUpdate("INSERT INTO `staffconstraint`(`userCode`, `totalPPW`) VALUES ('" + userCode + "'," + workingPeriod + ")");
        }
        for(int i=0;i<pConfigs.size();i++){
            String query = "INSERT INTO staffperiodexception(userCode,pconfigId) VALUES('" + userCode + "'," + Integer.parseInt(pConfigs.get(i).toString()) + ")";
            Utilfunctions.executeUpdate(query);
        }
        if (n != 1) {
            JOptionPane.showMessageDialog(null, "Please Check the errors");
        } else {
            JOptionPane.showMessageDialog(null, "Saved");
            workingPeriodsTextField.setText(workingPeriod);
        }
        DashboardForm df = new DashboardForm();
        Utilfunctions.setIconImage(df);
        Utilfunctions.setLocation(df);
        setVisible(false);
        df.setVisible(true);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        WorkHourForm wf = new WorkHourForm();
        Utilfunctions.setLocation(wf);
        Utilfunctions.setIconImage(wf);
        wf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void workHourListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workHourListMouseClicked
        // TODO add your handling code here:
            removeButton.setEnabled(true);
    }//GEN-LAST:event_workHourListMouseClicked

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        ResultSet r;
        int x = workHourList.getSelectedIndex();
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this workHour?", "SchedulePro - Faculty Constraints", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){    
            Utilfunctions.executeUpdate("DELETE FROM `userworkid` WHERE `workHourConfigId`="+workHourConfigId.get(x));
            DefaultListModel model = (DefaultListModel)workHourList.getModel();
            workHourConfigId.removeElementAt(x);
            model.remove(x);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        // TODO add your handling code here:
        ResultSet result,r1;
        userCode = Utilfunctions.getWithinBrackets(facultyComboBox.getSelectedItem().toString());
        try {
                result = Utilfunctions.executeQuery("select * from staffconstraint where userCode = '" + userCode + "'");
                if (result.next()) {
                    workingPeriod = result.getString(2);
                    workingPeriodsTextField.setText(workingPeriod);
                    flag = true;
                }else{
                    workingPeriodsTextField.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultListModel model = new DefaultListModel();
            result = Utilfunctions.executeQuery("SELECT `workHourConfigId` FROM `userworkid` WHERE `userCode`='" + userCode + "'");
            try {
                while (result.next()) {
                    r1 = Utilfunctions.executeQuery("SELECT * FROM `staffworkhour` WHERE `workHourConfigId`=" + result.getString(1));
                    r1.next();
                    day.addElement(r1.getString(2));
                    timeFrom.addElement(r1.getString(3));
                    timeTo.addElement(r1.getString(4));
                    model.addElement(r1.getString(2) + " " + r1.getString(3) + " - " + r1.getString(4));
                    workHourConfigId.addElement(r1.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            workHourList.setModel(model);
    }//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            setname = LoginForm.userName+"("+LoginForm.userCode+")";
            facultyComboBox.setSelectedItem(setname);
            facultyComboBox.setEnabled(false);
        }else{
            facultyComboBox.setEnabled(true);
            userCode = Utilfunctions.getWithinBrackets(facultyComboBox.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
        PeriodConfigViewForm.source = "staffconstraint";
        PeriodConfigViewForm.pConfigChooseInvoker = this;
        PeriodConfigViewForm.srcListModel = (DefaultListModel) jList1.getModel();
        try {
            PeriodConfigViewForm pcv = new PeriodConfigViewForm();
            Utilfunctions.setIconImage(pcv);
            Utilfunctions.setLocation(pcv);
            pcv.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentIssueForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButton1ActionPerformed

    private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton1ActionPerformed
        int x = jList1.getSelectedIndex();
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this period?", "SchedulePro - Subject Constraints", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){    
            DefaultListModel model = (DefaultListModel)jList1.getModel();
            pConfigs.removeElementAt(x-1);
            model.remove(x);
        }
    }//GEN-LAST:event_removeButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(jList1.getSelectedIndex() > 0) {
            removeButton1.setEnabled(true);
        }
        else {
            removeButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        String query = "SELECT * FROM staffperiodexception WHERE userCode = '" + userCode + "'";
        ResultSet rs = Utilfunctions.executeQuery(query);
        try {
            DefaultListModel model = (DefaultListModel)jList1.getModel();
            model.clear();
            model.addElement("Period Exceptions");
            while(rs.next()){
                query = "SELECT * FROM periodconfig WHERE pconfigId = " + rs.getInt(3);
                ResultSet rs2 = Utilfunctions.executeQuery(query);
                rs2.next();
                model.addElement(rs2.getString(2).substring(0,3) + " - " + rs2.getString(3).substring(0,5) + " to " + rs2.getString(4).substring(0,5)); 
                pConfigs.add(rs2.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_facultyComboBoxActionPerformed

  
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
            java.util.logging.Logger.getLogger(StaffConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StaffConstraintForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(StaffConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton removeButton1;
    private javax.swing.JButton saveButton;
    private javax.swing.JList workHourList;
    private javax.swing.JTextField workingPeriodsTextField;
    // End of variables declaration//GEN-END:variables
    public static Vector pConfigs;
}
