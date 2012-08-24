/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class DashboardForm extends javax.swing.JFrame {

    /**
     * Creates new form testform
     */
    public DashboardForm() {
        initComponents();
        jLabel1.setText("Welcome " + LoginForm.userSalutation + LoginForm.userName);
        Utilfunctions.setClosePrompt(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu24 = new javax.swing.JMenu();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        addEquipmentManualMenu = new javax.swing.JMenuItem();
        addEquipmentsCSVUploadMenu = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu10.setText("jMenu10");

        jMenu24.setText("File");
        jMenuBar2.add(jMenu24);

        jMenu25.setText("Edit");
        jMenuBar2.add(jMenu25);

        jMenuItem20.setText("jMenuItem20");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu9.setText("File");
        jMenuBar3.add(jMenu9);

        jMenu11.setText("Edit");
        jMenuBar3.add(jMenu11);

        jMenu13.setText("File");
        jMenuBar4.add(jMenu13);

        jMenu14.setText("Edit");
        jMenuBar4.add(jMenu14);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenuItem24.setText("jMenuItem24");

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Dashboard");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schedulepro/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");

        jMenu1.setText("Courses");

        jMenu8.setText("Add Course Details");

        jMenuItem5.setText("Manual");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenuItem6.setText("Upload CSV File");
        jMenu8.add(jMenuItem6);

        jMenu1.add(jMenu8);

        jMenuItem3.setText("View");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Constraints");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Faculty");

        jMenuItem8.setText("Constraints");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Classes");

        jMenu15.setText("Add Class Details");

        jMenuItem13.setText("Manual");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem13);

        jMenuItem14.setText("Upload CSV File");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem14);

        jMenu3.add(jMenu15);

        jMenuItem11.setText("View");
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Constraints");
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Periods");

        jMenuItem25.setText("Add Period Configuration");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem25);

        jMenuItem26.setText("View Period Configuration");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem26);

        jMenuBar1.add(jMenu4);

        jMenu16.setText("Academic Schedule");

        jMenuItem23.setText("Generate");
        jMenu16.add(jMenuItem23);

        jMenu17.setText("View Schedule");

        jMenuItem21.setText("By Class");
        jMenu17.add(jMenuItem21);

        jMenuItem22.setText("By Faculty");
        jMenu17.add(jMenuItem22);

        jMenu16.add(jMenu17);

        jMenuBar1.add(jMenu16);

        jMenu6.setText("Exam Schedule");

        jMenuItem15.setText("Create New Schedule");
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("View");
        jMenu6.add(jMenuItem16);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Equipments");

        jMenu12.setText("Add Equipments Details");

        addEquipmentManualMenu.setText("Manual");
        addEquipmentManualMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEquipmentManualMenuActionPerformed(evt);
            }
        });
        jMenu12.add(addEquipmentManualMenu);

        addEquipmentsCSVUploadMenu.setText("Upload CSV File");
        addEquipmentsCSVUploadMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEquipmentsCSVUploadMenuActionPerformed(evt);
            }
        });
        jMenu12.add(addEquipmentsCSVUploadMenu);

        jMenu5.add(jMenu12);

        jMenuItem10.setText("View");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Manage Account");

        jMenu18.setText("Administer Accounts");

        jMenuItem27.setText("Add User Manually");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem27);

        jMenu19.setText("Upload CSV File");

        jMenuItem29.setText("Login CSV File");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem29);

        jMenuItem30.setText("User CSV File");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem30);

        jMenu18.add(jMenu19);

        jMenuItem17.setText("View Users");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem17);

        jMenu7.add(jMenu18);

        jMenuBar1.add(jMenu7);

        jMenu21.setText("My Account");

        jMenuItem18.setText("Personal Details");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem18);

        jMenuItem19.setText("Change Password");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem19);

        jMenuItem7.setText("Logout");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem7);

        jMenuBar1.add(jMenu21);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to logoff?", "SchedulePro - Logoff", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            LoginForm lf = new LoginForm();
            Utilfunctions.setLocation(lf);
            Utilfunctions.setLocation(lf);
            lf.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        ClassDetailsForm cdf = new ClassDetailsForm();
        Utilfunctions.setIconImage(cdf);
        Utilfunctions.setLocation(cdf);
        cdf.setTitle("Class Detail");
        this.setVisible(false);
        cdf.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        String tablename = "class";
        try {
            try {
                Utilfunctions.showCSVFileOpenDialog(tablename, null, 0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        ChangePasswordForm cpf = new ChangePasswordForm();
        Utilfunctions.setIconImage(cpf);
        Utilfunctions.setLocation(cpf);
        this.setVisible(false);
        cpf.setVisible(true);

    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void addEquipmentManualMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquipmentManualMenuActionPerformed
        // TODO add your handling code here:
        EquipmentDetailsForm aedf = new EquipmentDetailsForm();
        Utilfunctions.setIconImage(aedf);
        Utilfunctions.setLocation(aedf);
        aedf.setVisible(true);
    }//GEN-LAST:event_addEquipmentManualMenuActionPerformed

    private void addEquipmentsCSVUploadMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquipmentsCSVUploadMenuActionPerformed
        // TODO add your handling code here:

        String tablename = "equipment";
        try {
            try {
                Utilfunctions.showCSVFileOpenDialog(tablename, null, 0, 0);
            } catch (SQLException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }//GEN-LAST:event_addEquipmentsCSVUploadMenuActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        PersonalDetailsForm pd;
        try {
            pd = new PersonalDetailsForm();
            Utilfunctions.setIconImage(pd);
            Utilfunctions.setLocation(pd);
            this.setVisible(false);
            pd.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        EquipmentViewForm evf;
        try {
            evf = new EquipmentViewForm();
            Utilfunctions.setIconImage(evf);
            Utilfunctions.setLocation(evf);
            this.setVisible(false);
            evf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        PeriodConfigForm pcf = new PeriodConfigForm();
        Utilfunctions.setIconImage(pcf);
        Utilfunctions.setLocation(pcf);
        this.setVisible(false);
        pcf.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        PeriodConfigViewForm pvf;
        try {
            pvf = new PeriodConfigViewForm();
            Utilfunctions.setIconImage(pvf);
            Utilfunctions.setLocation(pvf);
            this.setVisible(false);
            pvf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        UserSignupForm newUserForm = new UserSignupForm();
        Utilfunctions.setLocation(newUserForm);
        Utilfunctions.setIconImage(newUserForm);
        this.setVisible(false);
        newUserForm.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        UserViewForm uv = null;
        try {
            uv = new UserViewForm();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Utilfunctions.setIconImage(uv);
        Utilfunctions.setLocation(uv);
        this.setVisible(false);
        uv.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        String tablename = "login";
        String parentTable = "login";
        int parentKeyColumn = 2;
        try {
            try {
                try {
                    Utilfunctions.showCSVFileOpenDialog(tablename, parentTable, parentKeyColumn, 3);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String tablename = "user";
        try {
            try {
                try {
                    Utilfunctions.showCSVFileOpenDialog(tablename, null, 0, 0);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        String tablename = "user";
        try {
            try {
                try {
                    Utilfunctions.showCSVFileOpenDialog(tablename, null, 0, 0);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    }//GEN-LAST:event_jMenuItem30ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addEquipmentManualMenu;
    private javax.swing.JMenuItem addEquipmentsCSVUploadMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}
