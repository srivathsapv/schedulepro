/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

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
public class AssignClassPeriodConfigForm extends javax.swing.JFrame {

    /**
     * Creates new form AssignClassPeriodConfigForm
     */
    public AssignClassPeriodConfigForm() throws SQLException {
        initComponents();
        model = new DefaultListModel();
        pConfigIds = new Vector<Integer>();
        ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pconfigId IN(SELECT pconfigId FROM classperiod WHERE classCode = " + classCode + ")");
        int i=0;
        while(rs.next()){
            String type="";
            if(rs.getInt(5) == 1) type = "(Period)";
            else if(rs.getInt(5) == 2) type = "(Lunch)";
            else if(rs.getInt(5) == 4) type = "(Recess)";
            model.add(i++,rs.getString(2).substring(0,3) + " - " + rs.getString(3).substring(0,5) + " to " + rs.getString(4).substring(0,5) + type);
            pConfigIds.add(rs.getInt(1));
        }
        
        jList1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Schedule Pro - Assign Period Slots");
        setResizable(false);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assign Period Slots");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
            DayWisePeriodConfigChooseForm dwp = new DayWisePeriodConfigChooseForm();
            Utilfunctions.setLocation(dwp);
            Utilfunctions.setIconImage(dwp);
            dwp.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        boolean brk = false;
        for(int i=0;i<pConfigIds.size();i++){
            ResultSet cnt_rs = Utilfunctions.executeQuery("SELECT COUNT(*) FROM classperiod WHERE classCode = " + classCode + " AND pconfigId = " + pConfigIds.get(i));
            try {
                cnt_rs.next();
                if(cnt_rs.getInt(1) >= 1) {
                    continue;
                }
                
                //check for overlapping hours
                
                ResultSet pconfig_rs = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pconfigId = " + pConfigIds.get(i));
                pconfig_rs.next();
                String s = pconfig_rs.getString(3);
                String e = pconfig_rs.getString(4);
                String day = pconfig_rs.getString(2);
                int pType = pconfig_rs.getInt(5);
                
                String overlap_query = "SELECT * FROM periodconfig WHERE day = '" + day + "' AND " +
                                        " ((timeFrom < '" + s + "' AND timeTo < '" + e + "' AND timeFrom < '" + e + "' AND timeTo > '" + s + "') OR " +
                                        " (timeFrom > '" + s + "' AND timeTo > '" + e + "' AND timeFrom < '" + e + "' AND timeTo > '" + s + "') OR " +
                                        " (timeFrom > '" + s + "' AND timeTo < '" + e + "' AND timeFrom < '" + e + "' AND timeTo > '" + s + "') OR " +
                                        " (timeFrom < '" + s + "' AND timeTo > '" + e + "' AND timeFrom < '" + e + "' AND timeTo > '" + s + "')) " +
                                        "AND pconfigId != " + pconfig_rs.getInt(1);
                String type = "";
                if(pconfig_rs.getInt(5) == 1) type = "(Period)";
                else if(pconfig_rs.getInt(5) == 2) type = "(Lunch)";
                else if(pconfig_rs.getInt(5) == 4) type = "(Recess)";
                
                ResultSet olap_rs = Utilfunctions.executeQuery(overlap_query);
                
                while(olap_rs.next()){
                    if(pConfigIds.contains(olap_rs.getInt(1))){
                        JOptionPane.showMessageDialog(null,"The following two period slots are overlapping. Avoid overlaps by removing one period slot from below\n" +
                                                       pconfig_rs.getString(2).substring(0,3) + " - " + pconfig_rs.getString(3).substring(0,5) + " to " + pconfig_rs.getString(4).substring(0,5) + type + "\n" +
                                                       olap_rs.getString(2).substring(0,3) + " - " + olap_rs.getString(3).substring(0,5) + " to " + olap_rs.getString(4).substring(0,5) + type);
                        brk=true;
                        break;
                    }
                }
                if(brk) break;
                //end of overlap check
                
                String query = "INSERT INTO classperiod(classCode,subCode,pconfigId) VALUES(" + classCode + ",'-'," + pConfigIds.get(i) + ")";
                int n = Utilfunctions.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!brk) {
            JOptionPane.showMessageDialog(null,"Period Slots saved successfully");
            this.dispose();
        }
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        if(jList1.getSelectedIndex() != -1) jButton2.setEnabled(true);
        else jButton2.setEnabled(false);
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete these items?", "SchedulePro - Assign Period Slots", JOptionPane.YES_NO_OPTION);
        if(ans == JOptionPane.YES_OPTION){
            int indices[] = jList1.getSelectedIndices();
            int deletedComponents=0;
            for(int i:indices){
                for(int k=0;k<pConfigIds.size();k++){
                    int pid = Integer.parseInt(pConfigIds.get(k).toString());
                    ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM periodconfig where pconfigId = " + pid);
                    try {
                        rs.next();
                        String type="";
                        if(rs.getInt(5) == 1) type = "(Period)";
                        else if(rs.getInt(5) == 2) type = "(Lunch)";
                        else if(rs.getInt(5) == 4) type = "(Recess)";
                        String pstring = rs.getString(2).substring(0,3) + " - " + rs.getString(3).substring(0,5) + " to " + rs.getString(4).substring(0,5) + type;
                        if(pstring.equals(model.get(i))){
                            pConfigIds.removeElementAt(k-deletedComponents);
                            int n = Utilfunctions.executeUpdate("DELETE FROM classperiod WHERE pconfigId = " + rs.getInt(1));
                            break;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                model.remove(i-deletedComponents);
                deletedComponents++;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new AssignClassPeriodConfigForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AssignClassPeriodConfigForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public static int classCode;
    public static DefaultListModel model;
    public static Vector pConfigIds;
}
