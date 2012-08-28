package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sasi Praveen
 */
public class ClassDetailsForm extends javax.swing.JFrame {

    /**
     * Creates new form ClassDetailsForm
     */
    public ClassDetailsForm() {
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomNoLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        strengthLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        classCodeLabel = new javax.swing.JLabel();
        roomNoText = new javax.swing.JTextField();
        strengthText = new javax.swing.JTextField();
        classCodeText = new javax.swing.JTextField();
        courseComboBox = new javax.swing.JComboBox();
        departmentComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        saveButton = new javax.swing.JButton();
        sectionComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Class Details");
        setResizable(false);

        roomNoLabel.setText("Room No.:");

        departmentLabel.setText("Department:");

        courseLabel.setText("Course:");

        yearLabel.setText("Year:");

        strengthLabel.setText("Strength:");

        sectionLabel.setText("Section:");

        classCodeLabel.setText("Class Code:");

        roomNoText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomNoTextFocusLost(evt);
            }
        });

        strengthText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                strengthTextFocusLost(evt);
            }
        });

        classCodeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classCodeTextActionPerformed(evt);
            }
        });
        classCodeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                classCodeTextFocusLost(evt);
            }
        });

        courseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "B.E", "B.Tech", "M.E", "M.Tech" }));
        courseComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                courseComboBoxItemStateChanged(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        sectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(strengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(strengthText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(roomNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomNoText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(classCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(classCodeText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sectionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strengthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strengthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classCodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classCodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classCodeTextActionPerformed

    private void courseComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_courseComboBoxItemStateChanged

        // TODO add your handling code here:
        Utilfunctions.populateComboBoxwithQuery(departmentComboBox, "SELECT `dept` FROM `dept` WHERE `Course`=\"" + courseComboBox.getSelectedItem() + "\"");
        yearComboBox.removeAllItems();
        if (courseComboBox.getSelectedItem() == "B.E" || courseComboBox.getSelectedItem() == "B.Tech") {
            yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"1", "2", "3", "4"}));
        }
        if (courseComboBox.getSelectedItem() == "M.E" || courseComboBox.getSelectedItem() == "M.Tech") {
            yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"1", "2"}));
        }
    }//GEN-LAST:event_courseComboBoxItemStateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int test = 0;
        if (!classCodeText.getText().isEmpty()) {
            test = Utilfunctions.executeUpdate("INSERT INTO `schedulepro`.`class` (`classCode`, `dept`, `year`, `course`, `section`, `roomNo`, `strength`) VALUES (" + classCodeText.getText() + ", '" + departmentComboBox.getSelectedItem() + "', '" + yearComboBox.getSelectedItem() + "', '" + courseComboBox.getSelectedItem() + "', '" + sectionComboBox.getSelectedItem() + "', '" + roomNoText.getText() + "', " + strengthText.getText() + ")");
        } else {
            test = Utilfunctions.executeUpdate("INSERT INTO `schedulepro`.`class` (`classCode`, `dept`, `year`, `course`, `section`, `roomNo`, `strength`) VALUES (NULL, '" + departmentComboBox.getSelectedItem() + "', '" + yearComboBox.getSelectedItem() + "', '" + courseComboBox.getSelectedItem() + "', '" + sectionComboBox.getSelectedItem() + "', '" + roomNoText.getText() + "', " + strengthText.getText() + ")");
        }
        if (test == 1) {
            JOptionPane.showMessageDialog(null, "Saved");
            //this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void roomNoTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNoTextFocusLost
        // TODO add your handling code here:
        if (!courseComboBox.getSelectedItem().toString().isEmpty()) {
            if (!roomNoText.getText().isEmpty()) {
                if (!Validation.isalphanumeric(roomNoText.getText())) {
                    JOptionPane.showMessageDialog(null, "Please Enter a valid Room No.");
                    roomNoText.setText("");
                    roomNoText.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_roomNoTextFocusLost

    private void strengthTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_strengthTextFocusLost
        // TODO add your handling code here:
        if (!courseComboBox.getSelectedItem().toString().isEmpty()) {
            if (!strengthText.getText().isEmpty()) {
                if (!Validation.isNumber(strengthText.getText())) {
                    JOptionPane.showMessageDialog(null, "Please Enter a numeric value");
                    strengthText.setText("");
                    strengthText.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_strengthTextFocusLost

    private void classCodeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classCodeTextFocusLost
        // TODO add your handling code here:
        if (!courseComboBox.getSelectedItem().toString().isEmpty()) {
            if (!classCodeText.getText().isEmpty()) {
                if (!Validation.isalphanumericOrNull(classCodeText.getText())) {
                    JOptionPane.showMessageDialog(null, "Class Code should contain alphanumeric characters");
                    classCodeText.setText("");
                    classCodeText.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_classCodeTextFocusLost

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
            java.util.logging.Logger.getLogger(ClassDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassDetailsForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classCodeLabel;
    private javax.swing.JTextField classCodeText;
    private javax.swing.JComboBox courseComboBox;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel roomNoLabel;
    private javax.swing.JTextField roomNoText;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox sectionComboBox;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JLabel strengthLabel;
    private javax.swing.JTextField strengthText;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
