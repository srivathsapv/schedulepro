/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class WorkHourForm extends javax.swing.JFrame {

    private static String timeFrom;
    private static String timeTo;
    private String day;
    private String userCode;

    /**
     * Creates new form PeriodConfigForm
     */
    public WorkHourForm() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    StaffConstraintForm sf = new StaffConstraintForm();
                    Utilfunctions.setIconImage(sf);
                    Utilfunctions.setLocation(sf);
                    setVisible(false);
                    sf.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(WorkHourForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Period Configuration - SchedulePro");
        setResizable(false);

        jLabel1.setText("Time Slot:");

        jLabel3.setText("Day:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Set Work Hour");

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_small.png"))); // NOI18N
        addButton.setText("Add");
        addButton.setMaximumSize(new java.awt.Dimension(85, 25));
        addButton.setMinimumSize(new java.awt.Dimension(85, 25));
        addButton.setPreferredSize(new java.awt.Dimension(85, 25));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(9, 1, 12, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(9, 1, 12, 1));

        jLabel2.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinner4)
                                            .addComponent(jSpinner2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        userCode = StaffConstraintForm.userCode;
        
        String h1,h2,m1,m2;
        int t1,t2;
        
        if(jComboBox2.getSelectedItem().toString().equals("AM") || jSpinner1.getValue().toString().equals("12")){
            h1 = jSpinner1.getValue().toString();
            m1 = jSpinner2.getValue().toString();
            
        }
        else{
            h1 = String.valueOf(Integer.parseInt(jSpinner1.getValue().toString())+12);
            m1 = jSpinner2.getValue().toString();
        }
        t1 = (Integer.parseInt(h1) * 100) + Integer.parseInt(m1);
        
        if(jComboBox3.getSelectedItem().toString().equals("AM") || jSpinner3.getValue().toString().equals("12")){
            h2 = jSpinner3.getValue().toString();
            m2 = jSpinner4.getValue().toString();
            
        }
        else{
            h2 = String.valueOf(Integer.parseInt(jSpinner3.getValue().toString())+12);
            m2 = jSpinner4.getValue().toString();
        }
        t2 = (Integer.parseInt(h2) * 100) + Integer.parseInt(m2);
        if(t1 >= t2) {
            JOptionPane.showMessageDialog(null,"Start time cannot be later than end time");
            return;
        }
        
        timeFrom = h1 + ":" + m1;
        timeTo = h2 + ":" + m2;
        day = jComboBox1.getSelectedItem().toString();

        String query = "SELECT COUNT(*) FROM staffworkhour WHERE workHourFrom = '" + timeFrom +
                        "' AND workHourTo = '" + timeTo + "' AND day = '" + day + "'";
        ResultSet cnt_rs = Utilfunctions.executeQuery(query);
        try {
            cnt_rs.next();
            int workHourConfigId=0;
            
            if(cnt_rs.getInt(1) >= 1){    
                query = "SELECT * FROM staffworkhour WHERE workHourFrom = '" + timeFrom +
                        "' AND workHourTo = '" + timeTo + "' AND day = '" + day + "'";
                ResultSet rs = Utilfunctions.executeQuery(query);
                rs.next();
                workHourConfigId=rs.getInt(1);             
                ResultSet rs2 = Utilfunctions.executeQuery("SELECT COUNT(*) FROM userworkid WHERE userCode = '" + userCode + "' AND workHourConfigId = " + rs.getInt(1));
                rs2.next();
                if(rs2.getInt(1) >= 1){
                    JOptionPane.showMessageDialog(null,"Duplicate Work Hour data");
                    return;
                }
            }
            else {
                workHourConfigId = Utilfunctions.insertWithGeneratedKey("INSERT INTO staffworkhour(day,workHourFrom,workHourTo) VALUES('" + day + "','" + timeFrom + "','" + timeTo + "')");
            }
            
            Utilfunctions.executeUpdate("INSERT INTO userworkid(userCode,workHourConfigId) VALUES('" + userCode + "'," + workHourConfigId + ")"); 
            
            /*ResultSet r = Utilfunctions.executeQuery("SELECT `pconfigId` FROM `periodconfig` WHERE day ='"+day+"' and timeFrom and timeTo not between '"+timeFrom+"' and '"+timeTo+"'");
            while(r.next()){
                Utilfunctions.executeUpdate("INSERT INTO `staffperiodexception`(`id`, `userCode`, `pconfigId`) VALUES (NULL,'"+userCode+"',"+r.getString(1)+")");
            }*/
            StaffConstraintForm sf = new StaffConstraintForm();
            Utilfunctions.setIconImage(sf);
            Utilfunctions.setLocation(sf);
            setVisible(false);
            sf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(WorkHourForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WorkHourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkHourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkHourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkHourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkHourForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    // End of variables declaration//GEN-END:variables
}
