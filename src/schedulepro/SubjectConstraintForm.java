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
 * @author srivathsa
 */
public class SubjectConstraintForm extends javax.swing.JFrame {
    private final String userRole;
    private String dept;
    private String query="";

    /**
     * Creates new form SubjectConstraintForm
     */
    public SubjectConstraintForm() throws SQLException {
        initComponents();
        pConfigs = new Vector();
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
        
        DefaultListModel model = new DefaultListModel();
        model.addElement("Periods in which the subject is not prefered");
        jList1.setModel(model);
        userRole = LoginForm.userRole;
        if(userRole.equals("sa")){
            query = "SELECT CONCAT(subcode,CONCAT(' - ',CONCAT(subname,CONCAT(' (',CONCAT(subShortName,')'))))) FROM subject order by subcode";
        }else{
            query = "SELECT CONCAT(subcode,CONCAT(' - ',CONCAT(subname,CONCAT(' (',CONCAT(subShortName,')'))))) FROM subject WHERE dept = '" + LoginForm.userDept + "' ORDER BY subcode";
        }
        Utilfunctions.populateComboBoxwithQuery(jComboBox1, query);
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
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Subject Constraints");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Subject Constraints");

        jLabel2.setText("Choose Subject");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("(No. of Credits - 3)");

        jLabel4.setText("Total Periods / Week");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jTextField2.setToolTipText("Minimum Interval Between Two Consequtive Periods");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jLabel5.setText("Minimum Interval");
        jLabel5.setToolTipText("Minimum Interval Between Two Consequtive Periods");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Combination Number");

        jTextField3.setToolTipText("Minimum Interval Between Two Consequtive Periods");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jLabel7.setText("Clash Check");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(229, 229, 229))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex() == -1) return;
        
        String value = jComboBox1.getSelectedItem().toString();
        subcode = value.substring(0,value.indexOf("-")-1);
        
        String que = "SELECT credits FROM subject WHERE subcode = '" + subcode + "'";
        
        ResultSet rs = Utilfunctions.executeQuery(que);
        try {
            rs.next();
            jLabel3.setText("No. of Credits - " + rs.getString(1));
            
            que = "SELECT COUNT(*) FROM subjectconstraint WHERE subcode = '" + subcode + "'";
            rs = Utilfunctions.executeQuery(que);
            rs.next();
            
            if(rs.getInt(1) >= 1) {
                que = "SELECT * FROM subjectconstraint WHERE subcode = '" + subcode + "'";
                rs = Utilfunctions.executeQuery(que);
                rs.next();
                jTextField1.setText(rs.getString(2));
                jTextField2.setText(rs.getString(3));
                jTextField3.setText(rs.getString(4));
                if(rs.getInt(5) == 1)
                    jCheckBox1.setSelected(true);
                else
                    jCheckBox1.setSelected(false);
            }
            else {
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jCheckBox1.setSelected(false);
            }
            
            que = "SELECT COUNT(*) FROM subperiodexception WHERE subcode = '" + subcode + "'";
            rs = Utilfunctions.executeQuery(que);
            rs.next();
            DefaultListModel model = (DefaultListModel)jList1.getModel();
            if(rs.getInt(1) >= 1){
                que = "SELECT s.subCode,s.pconfigId,p.day,p.timeFrom,p.timeTo FROM subperiodexception s,periodconfig p WHERE s.pconfigId = p.pconfigId AND s.subCode = '" + subcode + "'";
                rs = Utilfunctions.executeQuery(que);
                if(!model.isEmpty()) model.clear();
                if(!pConfigs.isEmpty()) pConfigs.clear();
                while(rs.next()){
                    model.addElement(rs.getString(3).substring(0,3) + " - " + rs.getString(4).substring(0,5) + " to " + rs.getString(5).substring(0,5)); 
                    pConfigs.add(rs.getInt(2));
                }
                
            }
            else {
                model.clear();
                pConfigs.clear();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PeriodConfigViewForm.pConfigChooseInvoker = this;
        PeriodConfigViewForm.source = "subconstraint";
        PeriodConfigViewForm.srcListModel = (DefaultListModel) jList1.getModel();
        try {
            PeriodConfigViewForm pcv = new PeriodConfigViewForm();
            Utilfunctions.setIconImage(pcv);
            Utilfunctions.setLocation(pcv);
            pcv.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentIssueForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(jList1.getSelectedIndex() >= 0) {
            jButton2.setEnabled(true);
        }
        else {
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = jList1.getSelectedIndex();
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this period?", "SchedulePro - Subject Constraints", JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){    
            DefaultListModel model = (DefaultListModel)jList1.getModel();
            for(int i=0;i<pConfigs.size();i++){
                ResultSet crs = Utilfunctions.executeQuery("SELECT * FROM periodconfig where pconfigId = " + pConfigs.get(i));
                try {
                    crs.next();
                    String config_string = crs.getString(2).substring(0,3) + " - " + crs.getString(3).substring(0,5) + " to " + crs.getString(4).substring(0,5);               
                    if(config_string.equals(model.get(x))){
                        int m = Utilfunctions.executeUpdate("DELETE FROM subperiodexception WHERE subCode = '" + subcode + "' AND pconfigId = " + pConfigs.get(i));
                        pConfigs.removeElementAt(i);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            model.remove(x);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
     if(jTextField1.getText().equals("")) return;
        if(!Validation.isNumber(jTextField1.getText())){
            JOptionPane.showMessageDialog(null,"Numeric Value Expected");
            jTextField1.setText("");
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
     if(jTextField2.getText().equals("")) return;
        if(!Validation.isNumber(jTextField2.getText())){
            JOptionPane.showMessageDialog(null,"Numeric Value Expected");
            jTextField2.setText("");
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int ppw = Integer.parseInt(jTextField1.getText());
        int minInterval = Integer.parseInt(jTextField2.getText());
        int comb;
        if(jTextField3.getText().equals("")) comb = 0;
        else comb = Integer.parseInt(jTextField3.getText());
        
        if(!Validation.isNumber(jTextField1.getText())){
            JOptionPane.showMessageDialog(null,"Periods/Week should be a numeric value");
            return;
        }
        if(!Validation.isNumber(jTextField2.getText())){
            JOptionPane.showMessageDialog(null,"Minimum Interval should be a numeric value");
            return;
        }
        if(!Validation.isNumber(jTextField3.getText()) && comb != 0){
            JOptionPane.showMessageDialog(null,"Combination number should be a numeric value");
            return;
        }
        
        if(ppw < comb){
            JOptionPane.showMessageDialog(null,"Combined number should be less than or equal to total periods/week");
            return;
        }
        
        int cCheck=0;
        if(jCheckBox1.isSelected())
            cCheck=1;
        
        String que2 = "SELECT COUNT(*) FROM subjectconstraint WHERE subcode = '" + subcode + "'";
        ResultSet rs = Utilfunctions.executeQuery(que2);
        try {
            rs.next();
            int n=0;
            int m=0;
            if(rs.getInt(1) == 0) {
                que2 = "INSERT INTO subjectconstraint VALUES('" + subcode + "'," + ppw + "," + minInterval + "," + comb + ")";
                n = Utilfunctions.executeUpdate(que2);
            }
            else {
                que2 = "UPDATE subjectconstraint SET totalPPW = " + ppw +", minInterval = " + minInterval + ",combinedNo = " + comb + ",clashCheck = " + cCheck + " WHERE subcode = '" + subcode + "'";
                m=Utilfunctions.executeUpdate(que2);   
            }
            que2="DELETE FROM subperiodexception WHERE subCode = '" + subcode + "'";
            m=Utilfunctions.executeUpdate(que2);
            for(int i=0;i<pConfigs.size();i++){
                que2 = "INSERT INTO subperiodexception(subCode,pconfigId) VALUES('" + subcode + "'," + Integer.parseInt(pConfigs.get(i).toString()) + ")";
                m=Utilfunctions.executeUpdate(que2);
            }
            if(n+m >= 1) JOptionPane.showMessageDialog(null,"Subject Constraints saved");
        } catch (SQLException ex) {
            Logger.getLogger(SubjectConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost

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
            java.util.logging.Logger.getLogger(SubjectConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectConstraintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new SubjectConstraintForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectConstraintForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
    private static String subcode;
    public static Vector pConfigs;
}
