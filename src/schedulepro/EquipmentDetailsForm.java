/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class EquipmentDetailsForm extends javax.swing.JFrame {

    private int existingqty;
    private int netqty;
    private String equipId;

    /**
     * Creates new form AddEquipmentDetailsForm
     */
    public EquipmentDetailsForm() {
        initComponents();
        Utilfunctions.populateComboBoxwithQuery(departmentComboBox, "SELECT distinct(`dept`) FROM `dept`");
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
        equipmentIdLabel = new javax.swing.JLabel();
        equipmentIdText = new javax.swing.JTextField();
        equipmentNameLabel = new javax.swing.JLabel();
        equipmentNameText = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        quantityLabel = new javax.swing.JLabel();
        quantityText = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SchedulePro - Add Equipment");
        setResizable(false);

        equipmentIdLabel.setText("Equipment Id:");

        equipmentIdText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                equipmentIdTextFocusLost(evt);
            }
        });

        equipmentNameLabel.setText("Equipment Name:");

        equipmentNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                equipmentNameTextFocusLost(evt);
            }
        });

        departmentLabel.setText("Department:");

        quantityLabel.setText("Quantity:");

        quantityText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityTextFocusLost(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(equipmentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(equipmentIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(equipmentIdText)
                            .addComponent(equipmentNameText)
                            .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentIdLabel)
                    .addComponent(equipmentIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentNameLabel)
                    .addComponent(equipmentNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLabel)
                    .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void equipmentNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_equipmentNameTextFocusLost
        // TODO add your handling code here:
        if (!equipmentNameText.getText().isEmpty()) {
            if (!Validation.isalphanumeric(equipmentNameText.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Equipment name");
                equipmentNameText.setText("");
                equipmentNameText.requestFocus();
                test[0] = 1;
            } else {
                test[0] = 0;
            }
        }
    }//GEN-LAST:event_equipmentNameTextFocusLost

    private void equipmentIdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_equipmentIdTextFocusLost
        // TODO add your handling code here:
        if (!equipmentIdText.getText().isEmpty()) {
            if (!Validation.isNumber(equipmentIdText.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a numeric value");
                equipmentIdText.setText("");
                equipmentIdText.requestFocus();
            } else {
                equipId = equipmentIdText.getText();
            }
        } else {
            equipId = "NULL";
        }
    }//GEN-LAST:event_equipmentIdTextFocusLost

    private void quantityTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityTextFocusLost
        // TODO add your handling code here:
        if (!quantityText.getText().isEmpty()) {
            if (!Validation.isNumber(quantityText.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a numeric value");
                quantityText.setText("");
                quantityText.requestFocus();
                test[1] = 1;
            } else {
                test[1] = 0;
            }
        }
    }//GEN-LAST:event_quantityTextFocusLost

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        int n = 0;
        if (test[0] == 0 && test[1] == 0) {
            try {
                ResultSet result = Utilfunctions.executeQuery("SELECT `equipId`, `quantity` FROM `equipment` WHERE `equipName` = '" + equipmentNameText.getText().toUpperCase() + "' AND `dept` = '" + departmentComboBox.getSelectedItem() + "'");
                if (result.next()) {
                    JOptionPane.showMessageDialog(null, "Equipment already exists, Please make the the changes in 'View'");
                } else {
                    throw new Exception();
                }
                //existingqty = Integer.parseInt(result.getString(2));
                //netqty = existingqty + Integer.parseInt(quantityText.getText());
                //n = Utilfunctions.executeUpdate("UPDATE `equipment` SET `quantity`=" + netqty + " WHERE `equipId`=" + result.getString(1));
            } catch (Exception e) {
                n = Utilfunctions.executeUpdate("INSERT INTO `equipment`(`equipId`, `equipName`, `dept`, `quantity`) VALUES (" + equipId + ",'" + equipmentNameText.getText().toUpperCase() + "', '" + departmentComboBox.getSelectedItem() + "'," + quantityText.getText() + ")");
            }
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Error in query");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Check the errors");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GlobalVars.pConfigChooseInvoker = this;
        try {
            PeriodConfigViewForm pvf = new PeriodConfigViewForm();
            this.setVisible(false);
            pvf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,GlobalVars.pConfigId);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EquipmentDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentDetailsForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel equipmentIdLabel;
    private javax.swing.JTextField equipmentIdText;
    private javax.swing.JLabel equipmentNameLabel;
    private javax.swing.JTextField equipmentNameText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityText;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    private int test[] = {1, 1};
}
