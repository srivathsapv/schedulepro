/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi praveen
 */
public class UserSignupForm extends javax.swing.JFrame {

    /**
     * Creates new form UserSignup
     */
    public UserSignupForm() {
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

        jComboBox1 = new javax.swing.JComboBox();
        nameLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        salutationLabel = new javax.swing.JLabel();
        idnumberLabel = new javax.swing.JLabel();
        idnumberText = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        emailidLabel = new javax.swing.JLabel();
        emailidText = new javax.swing.JTextField();
        phonenumberLabel = new javax.swing.JLabel();
        phonenumberText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        retypepasswordText = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        retypepasswordLabel = new javax.swing.JLabel();
        mandotaryfieldLabel = new javax.swing.JLabel();
        departmentCombobox = new javax.swing.JComboBox();
        salutationComboBox = new javax.swing.JComboBox();
        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox();
        gradeLabel = new javax.swing.JLabel();
        gradeText = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        nameLabel.setText("*Name:");

        nameText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFocusLost(evt);
            }
        });

        salutationLabel.setText("Salutation:");

        idnumberLabel.setText("*Id number:");

        idnumberText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idnumberTextFocusLost(evt);
            }
        });

        departmentLabel.setText("*Department:");

        emailidLabel.setText("Email ID:");

        emailidText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailidTextActionPerformed(evt);
            }
        });
        emailidText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailidTextFocusLost(evt);
            }
        });

        phonenumberLabel.setText("*Phone number:");

        phonenumberText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phonenumberTextFocusLost(evt);
            }
        });

        passwordLabel.setText("*Password:");

        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTextFocusLost(evt);
            }
        });

        retypepasswordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                retypepasswordTextFocusLost(evt);
            }
        });

        submitButton.setMnemonic('s');
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        retypepasswordLabel.setText("*Retype Password:");

        mandotaryfieldLabel.setText("* mandotary fileds");

        departmentCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BME", "CIV", "CSE", "ECE", "EEE", "IT" }));
        departmentCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboboxActionPerformed(evt);
            }
        });

        salutationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr.", "Mrs.", "Dr." }));
        salutationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salutationComboBoxActionPerformed(evt);
            }
        });

        usernameLabel.setText("*Username:");

        usernameText.setToolTipText("");
        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });
        usernameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTextFocusLost(evt);
            }
        });

        jLabel1.setText("Role:");

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Head of the Department", "Faculty Member", "Department Secretary", "System Adminstrator" }));
        roleComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                roleComboBoxFocusLost(evt);
            }
        });

        gradeLabel.setText("Grade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mandotaryfieldLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailidLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salutationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phonenumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(retypepasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(idnumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameText, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(departmentCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailidText)
                        .addComponent(nameText)
                        .addComponent(salutationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idnumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gradeText)
                        .addComponent(passwordText)
                        .addComponent(retypepasswordText, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addComponent(phonenumberText)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idnumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idnumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salutationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salutationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeLabel)
                    .addComponent(gradeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailidText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonenumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phonenumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retypepasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retypepasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mandotaryfieldLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailidTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailidTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailidTextActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            for (int i = 0; i < 7; i++) {
                if (testValidity[i] == 1) {
                    errorLocation = i;
                    throw new Exception();
                }
            }
            Utilfunctions.executeUpdate("INSERT INTO `schedulepro`.`user` (`userCode`, `name`, `salutation`, `dept`, `grade`, `email`, `phone`) VALUES ('" + idnumberText.getText() + "', '" + nameText.getText() + "', '" + salutation + "', '" + department + "', '" + gradeText.getText() + "', '" + emailidText.getText() + "', '" + phonenumberText.getText() + "');");
            Utilfunctions.executeUpdate("INSERT INTO `schedulepro`.`login` (`id`, `userCode`, `password`, `role`) VALUES ('" + usernameText.getText() + "', '" + idnumberText.getText() + "', '" + Utilfunctions.MD5(passwordText.getText()).toString(16) + "', '" + role + "');");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Check the errors");
            switch (errorLocation) {
                case 0:
                    nameText.setText("");
                    break;
                case 1:
                    idnumberText.setText("");
                    break;
                case 2:
                    emailidText.setText("");
                    break;
                case 3:
                    phonenumberText.setText("");
                    break;
                case 4:
                    usernameText.setText("");
                    break;
                case 5:
                    passwordText.setText("");
                    break;
                case 6:
                    retypepasswordText.setText("");
                    passwordText.setText("");
                    break;
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost
        if (!nameText.getText().isEmpty()) {
            if (!Validation.isStringWithSpace(nameText.getText())) {
                JOptionPane.showMessageDialog(null, "Name should no contain 0-9,#$%^...");
                nameText.setText("");
                nameText.requestFocus();
                testValidity[0] = 1;
            } else {
                testValidity[0] = 0;
            }
        }
    }//GEN-LAST:event_nameTextFocusLost

    private void idnumberTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idnumberTextFocusLost
        if (!idnumberText.getText().isEmpty()) {
            if (!Validation.isNumber(idnumberText.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid ID number");
                idnumberText.setText("");
                idnumberText.requestFocus();
                testValidity[1] = 1;
            } else {
                testValidity[1] = 0;
            }
        }
    }//GEN-LAST:event_idnumberTextFocusLost

    private void emailidTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailidTextFocusLost
        if (!emailidText.getText().isEmpty()) {
            if (!Validation.isEmailId(emailidText.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid E-mail Id");
                emailidText.setText("");
                emailidText.requestFocus();
                testValidity[2] = 1;
            } else {
                testValidity[2] = 0;
            }
        }
    }//GEN-LAST:event_emailidTextFocusLost

    private void phonenumberTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phonenumberTextFocusLost
        if (!phonenumberText.getText().isEmpty()) {
            if (!Validation.isPhoneNumber(phonenumberText.getText())) {
                JOptionPane.showMessageDialog(null, "Invaid phone number");
                phonenumberText.setText("");
                phonenumberText.requestFocus();
                testValidity[3] = 1;
            } else {
                testValidity[3] = 0;
            }
        }
    }//GEN-LAST:event_phonenumberTextFocusLost

    private void passwordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusLost
        if (!passwordText.getText().isEmpty()) {
            if (!Validation.isPassword(passwordText.getText())) {
                JOptionPane.showMessageDialog(null, "Password must be atleast 6 characters long");
                passwordText.setText("");
                passwordText.requestFocus();
                testValidity[5] = 1;
            } else {
                testValidity[5] = 0;
            }
        }
    }//GEN-LAST:event_passwordTextFocusLost

    private void retypepasswordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_retypepasswordTextFocusLost
        if (!retypepasswordText.getText().isEmpty()) {
            if (!retypepasswordText.getText().equals(passwordText.getText())) {
                JOptionPane.showMessageDialog(null, "Password doesn't match");
                retypepasswordText.setText("");
                retypepasswordText.requestFocus();
                testValidity[6] = 1;
            } else {
                testValidity[6] = 0;
            }
        }
    }//GEN-LAST:event_retypepasswordTextFocusLost

    private void departmentComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboboxActionPerformed
        department = departmentCombobox.getSelectedItem().toString();
    }//GEN-LAST:event_departmentComboboxActionPerformed

    private void salutationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salutationComboBoxActionPerformed
        salutation = salutationComboBox.getSelectedItem().toString();
    }//GEN-LAST:event_salutationComboBoxActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void usernameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusLost
        if (!usernameText.getText().isEmpty()) {
            if (!Validation.isUsername(usernameText.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid username");
                usernameText.setText("");
                usernameText.requestFocus();
                testValidity[4] = 1;
            } else {
                testValidity[4] = 0;
            }
        }
    }//GEN-LAST:event_usernameTextFocusLost

    private void roleComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roleComboBoxFocusLost
        // TODO add your handling code here:
        if (roleComboBox.getSelectedIndex() == 0) {
            role = "HOD";
        } else if (roleComboBox.getSelectedIndex() == 1) {
            role = "staff";
        } else if (roleComboBox.getSelectedIndex() == 2) {
            role = "ds";
        }else if (roleComboBox.getSelectedIndex() == 3) {
            role = "sa";
        }
    }//GEN-LAST:event_roleComboBoxFocusLost

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
            java.util.logging.Logger.getLogger(UserSignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSignupForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox departmentCombobox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel emailidLabel;
    private javax.swing.JTextField emailidText;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JTextField gradeText;
    private javax.swing.JLabel idnumberLabel;
    private javax.swing.JTextField idnumberText;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mandotaryfieldLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JTextField phonenumberText;
    private javax.swing.JLabel retypepasswordLabel;
    private javax.swing.JPasswordField retypepasswordText;
    private javax.swing.JComboBox roleComboBox;
    private javax.swing.JComboBox salutationComboBox;
    private javax.swing.JLabel salutationLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
    private int testValidity[] = {1, 1, 1, 1, 1, 1, 1};
    private int errorLocation;
    private String salutation;
    private String department;
    private String role = "";
}
