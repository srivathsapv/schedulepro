/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author srivathsa
 */
public class GenerateScheduleForm extends javax.swing.JFrame {
    /**
     * Creates new form GenerateScheduleForm
     */
    public GenerateScheduleForm() throws SQLException {
        initComponents();
        
        String query = "";
        
        if(LoginForm.userRole.equals("sa"))
            query = "SELECT classCode,CONCAT(course,' ',dept,' ',year,' - ',section) FROM class WHERE classCode IN(SELECT DISTINCT(classCode) FROM classperiod) ORDER BY classCode";
        else
            query = "SELECT classCode,CONCAT(course,' ',dept,' ',year,' - ',section) FROM class WHERE dept = '" + LoginForm.userDept + "' AND classCode IN(SELECT DISTINCT(classCode) FROM classperiod) ORDER BY classCode";
        
        ResultSet classrs = Utilfunctions.executeQuery(query);
        while(classrs.next()){
            ResultSet scount = Utilfunctions.executeQuery("SELECT SUM(totalPPW) FROM subjectconstraint WHERE subCode IN(SELECT subCode FROM subclass WHERE classcode = " + classrs.getInt(1) + ")");
            scount.next();
            if(scount.getInt(1) > 0){
                jComboBox1.addItem(classrs.getString(2));
            }
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
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Schedule - SchedulePro");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generate Schedule");

        jLabel2.setText("Choose Class:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel3.setText("Room");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel4.setText("Room");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate.png"))); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel6.setText("Room");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel7.setText("Room");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel8.setText("Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))))
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            classCode = Utilfunctions.getClassCode(jComboBox1.getSelectedItem().toString());
            ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM class WHERE classCode = " + classCode);
            rs.next();
            int strength = rs.getInt(7);
            ResultSet rs2 = Utilfunctions.executeQuery("SELECT roomNo FROM classroom WHERE roomId = "+rs.getInt(6));
            rs2.next();
            String roomNo = rs2.getString(1);
            jLabel3.setText("Room - " + roomNo);
            jLabel4.setText("Strength - " + strength);
            
            ResultSet ppw = Utilfunctions.executeQuery("SELECT SUM(totalPPW) FROM subjectconstraint"
                                                + " WHERE subCode IN (SELECT subCode FROM subclass WHERE classCode = " + classCode + ")");
            ppw.next();
            
            jLabel6.setText("Sum of total periods/week: " + ppw.getInt(1));
            
            ResultSet cls = Utilfunctions.executeQuery("SELECT COUNT(*) FROM classperiod WHERE pconfigId IN(SELECT pconfigId FROM periodconfig WHERE pType = 1) AND classCode = " + classCode);
            cls.next();
            
            jLabel7.setText("Total periods slots alloted: " + cls.getInt(1));
            
            if(ppw.getInt(1) < cls.getInt(1)){
                jLabel6.setForeground(Color.red);
                jLabel7.setForeground(Color.red);
                jLabel8.setText("<html><body>Cannot generate timetable. Total periods/week of all <br>"
                                                 + "subjects is less than the number of period slots <br>"
                                                 + "alloted to this class. Go to subject constraints <br>"
                                                 + "and increase the number of periods/week</body></html>");
                jLabel8.setForeground(Color.red);
                jButton1.setEnabled(false);
            }
            else if(ppw.getInt(1) > cls.getInt(1)){
                jLabel6.setForeground(Color.red);
                jLabel7.setForeground(Color.red);
                jLabel8.setText("<html><body>Cannot generate timetable. Total periods/week of all <br>"
                                                 + "subjects is more than the number of period slots <br>"
                                                 + "alloted to this class. Go to subject constraints <br>"
                                                 + "and reduce the number of periods/week</body></html>");
                jLabel8.setForeground(Color.red);
                jButton1.setEnabled(false);
            }
            else {
                jLabel6.setForeground(Color.green);
                jLabel7.setForeground(Color.green);
                jLabel8.setVisible(false);
                jButton1.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenerateScheduleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //generate the schedule
        try {
            ResultSet cnt_rs = Utilfunctions.executeQuery("SELECT COUNT(*) FROM classperiod WHERE subCode != '-' AND classCode = " + classCode);
            cnt_rs.next();
            if(cnt_rs.getInt(1) != 0){
                int n = JOptionPane.showConfirmDialog(null,"Periods already generated for this class. Do you want to generate a new set?","SchedulePro - Academic Schedule",JOptionPane.YES_NO_OPTION);
                if(n != JOptionPane.YES_OPTION){
                    return;
                }
            }
            
            /*StatusForm sf = new StatusForm();
            Thread sThread = new Thread(sf);
            sThread.start();*/
  
            while(true){
                int infinite_count=0;
                boolean infinity=false;
                ResultSet subclass = Utilfunctions.executeQuery("SELECT * FROM subclass WHERE classCode = " + classCode + " ORDER BY SUBTYPE(subCode) DESC,COMBNO(subCode) DESC,CLASH(subCode) DESC");
                
                
                int k = Utilfunctions.executeUpdate("UPDATE classperiod SET subCode = '-' WHERE classCode = " + classCode);
                
                while(subclass.next()){    
                    k=Utilfunctions.executeUpdate("DELETE FROM staffperiod WHERE classCode = " + classCode + " AND userCode = '" + subclass.getString(4) + "'");
                    
                    /*
                    * Get the concerned subject's constraints
                    */
                    ResultSet subconstraint = Utilfunctions.executeQuery("SELECT * FROM subjectconstraint WHERE subCode = '" + subclass.getString(3) + "'");
                    subconstraint.next();
                    
                    /*
                    * Get the concerned staff's constraints
                    */
                    ResultSet staffconstraint = Utilfunctions.executeQuery("SELECT * FROM staffconstraint WHERE userCode = '" + subclass.getString(4) + "'");
                    staffconstraint.next();
                    
                    /*
                    * check if total periods assigned to user is <= his totalPPW. if no -> report
                    * error
                    */
                        /*obtain no. of periods assigned already to the user + no. of periods going to be 
                        * assigned
                        */
                        ResultSet periods_assigned = Utilfunctions.executeQuery("SELECT COUNT(*) + " 
                                + subconstraint.getInt(2) + " FROM staffperiod WHERE "
                                + "userCode = '" + subclass.getString(4) + "'");
                        periods_assigned.next();

                        if(periods_assigned.getInt(1) > staffconstraint.getInt(2)){
                            ResultSet user = Utilfunctions.executeQuery("SELECT * FROM user WHERE userCode = '" + subclass.getString(4) + "'");
                            user.next();

                            String name = user.getString(1) + " - " + user.getString(3) + user.getString(2) + "(" + user.getString(4) + ")";

                            JOptionPane.showMessageDialog(null,"Cannot generate schedule.\n"
                                    + "Total periods/week constraint of " + name + " is being violated.\n"
                                    + "Go to staffconstraints and increase the total periods/week");
                            return;
                        }
                    //end of total periods assigned check     

                    /*choose the assignable pconfigs by applying the following filters
                    * filter #0 - the pconfig should belong to the period slots assigned to that class
                    * filter #1 - the pconfig should not belong to subperiodexception of the subject
                    * filter #2 - the pconfig should not belong to staffperiodexception of the staff who is handling the subject
                    * filter #3 - the pconfig should not be assigned to that faculty already
                    * filter #4 - the pconfig should not be assigned to that class already
                    * filter #5 - the pconfig should lie in between the work hours of the staff
                    */
                    
                    ResultSet periodconfig = Utilfunctions.executeQuery("SELECT * FROM periodconfig "
                    + " WHERE pconfigId IN(SELECT pconfigId FROM classperiod WHERE classcode = " + classCode + " AND subCode = '-') AND pconfigId NOT IN(SELECT pconfigId FROM staffperiodexception WHERE userCode = '" + subclass.getString(4) + "') "
                    + "AND pconfigId NOT IN(SELECT pconfigId FROM subperiodexception WHERE subCode = '" + subclass.getString(3) + "')"
                            + " AND pconfigId NOT IN(SELECT pconfigId FROM staffperiod WHERE userCode = '" + subclass.getString(4) + "') AND pType = 1 ORDER BY GETDAYNUMBER(day)");
                    Vector<Integer> assignable_periods = new Vector<Integer>();
                    while(periodconfig.next()) {
                        ResultSet workhour = 
                        Utilfunctions.executeQuery("SELECT u.userCode,w.day,w.workHourFrom,"
                                                + "w.workHourTo FROM userworkid u,staffworkhour w "
                                                + "WHERE w.workHourConfigId = u.workHourConfigId "
                                                + "AND u.userCode = '" + subclass.getString(4) + "'");
                        boolean overlaps = true;
                        while(workhour.next()){
                            if(workhour.getString(2).equals(periodconfig.getString(2))){
                                if(!ConstraintsCheck.isPeriodOverlap(workhour.getString(3),workhour.getString(4),periodconfig.getString(3),periodconfig.getString(4))) {
                                    overlaps=false;
                                    break;
                                }
                            }
                        }
                        if(overlaps) assignable_periods.add(periodconfig.getInt(1));
                    }
                    //filter #6 - clash check
                    
                    if(subconstraint.getInt(4) == 1){
                        Vector<Integer> other_classes = new Vector<Integer>();

                        ResultSet oc_rs = Utilfunctions.executeQuery("SELECT pconfigId FROM"
                                + " classperiod WHERE classCode != " + classCode + " AND "
                                + " subCode = '" + subclass.getString(3) + "'");
                        while(oc_rs.next()){
                            String oc_day = ConstraintsCheck.getpconfigDay(oc_rs.getInt(1));
                            for(int i=0;i<assignable_periods.size();i++){
                                String ass_day = ConstraintsCheck.getpconfigDay(assignable_periods.get(i));
                                if(oc_day.equals(ass_day)){
                                    if(oc_rs.getInt(1) == assignable_periods.get(i) || 
                                            ConstraintsCheck.ispconfigOverlap(oc_rs.getInt(1), assignable_periods.get(i))){
                                        assignable_periods.removeElementAt(i);
                                    }
                                }
                            }
                        }
                    }

                    /**
                    * filter #7 - combined number
                    * if combined number > 0 then assignable_periods should contain only those
                    * pconfigIds that occur as a continuous sequence. 
                    * 
                    * for example if combined number = 3 pconfigIds should contain only those 
                    * period slots which occur as triplets
                    * 
                    * for simplicity we will retain the 1st pconfigId of the triplet in
                    * assignable_periods
                    */
                    
                    String ass_str = assignable_periods.toString();
                    ass_str = ass_str.substring(1,ass_str.length()-1);
                    
                    if(subconstraint.getInt(5) == 2){
                        
                        String query = "SELECT pconfigId FROM "
                                + " periodconfig WHERE pconfigId IN(" + ass_str + ") AND "
                                + " day NOT IN(SELECT DISTINCT(day) FROM "
                                + " periodconfig WHERE pconfigId IN"
                                + " (SELECT pconfigId FROM classperiod WHERE classCode = " + classCode
                                + " AND subCode IN (SELECT subCode FROM subjectconstraint WHERE subType = 2)))";

                        ResultSet type_rs = Utilfunctions.executeQuery(query);

                        assignable_periods.clear();
                        while(type_rs.next()){
                            assignable_periods.add(type_rs.getInt(1));
                        }
                        
                    }
                    
                    if(assignable_periods.isEmpty()){
                        infinity=true;
                        break;
                    }
                    
                    int cno = 0;
                    boolean comb_applied = false;

                    if(subconstraint.getInt(3) > 0){
                        comb_applied = true;
                        cno = subconstraint.getInt(3);
                        Vector<Integer> vc = new Vector<Integer>();


                        ResultSet days = Utilfunctions.executeQuery("SELECT DISTINCT(day) FROM periodconfig"
                                + " WHERE pconfigId IN(" + ass_str + ")");
                        while(days.next()){                          
                            ConstraintsCheck.getCombinedpconfigs(vc,days.getString(1), assignable_periods, classCode, cno);
                        }
                        assignable_periods.clear();
                        for(int x:vc)
                            assignable_periods.add(x);

                        
                    }
                   /**
                    * 
                    * filter #8 - generate randomized sets of length = totalPPW of the subject
                    * until a set satisfying the min interval is obtained
                    * 
                    */
                    Vector<Integer> periods_set = new Vector<Integer>();

                    Vector<Integer> assignedIndices = new Vector<Integer>();                
                    
                    int ppw = subconstraint.getInt(2);
                    int i=1;
                    Random r = new Random();
                    if(!comb_applied){
                        infinite_count=0;
                        while(i<=ppw){
                            int index = r.nextInt(assignable_periods.size());
                            if(assignedIndices.indexOf(index) != -1){//checking for duplicates
                                infinite_count++;
                                if(infinite_count==1000){
                                    infinity=true;
                                    break;
                                }
                                continue;
                            }
                            if(infinity) break;
                            assignedIndices.add(index);
                            periods_set.add(assignable_periods.get(index));
                            i++;
                        }
                        
                    }
                    else {
                        int combinations = (int)(ppw/cno);
                        int singles = ppw%cno;
                        i=1;
                        infinite_count=0;
                        while(i<=combinations){
                            int index = r.nextInt(assignable_periods.size());
                            if(assignedIndices.indexOf(index) != -1){//checking for duplicates
                                infinite_count++;
                                if(infinite_count==1000){
                                    infinity=true;
                                    break;
                                }
                                continue;
                            }
                            if(infinity) break;
                            index = index-(index%cno);
                            for(int j=index;j<(index+cno);j++){
                                if(j >= assignable_periods.size()) break;
                                assignedIndices.add(j);
                                periods_set.add(assignable_periods.get(j));
                            }
                            i++;
                        }

                        i=1;
                        infinite_count=0;
                        while(i<=singles){
                            int index = r.nextInt(assignable_periods.size());
                            if(assignedIndices.indexOf(index) != -1){//checking for duplicates
                                infinite_count++;
                                if(infinite_count==1000){
                                    infinity=true;
                                    break;
                                }
                                continue;
                            }
                            if(infinity) break;
                            assignedIndices.add(index);
                            periods_set.add(assignable_periods.get(index));
                            i++;
                        }
                    }
                    
                    
                    /**
                    * insert subject code into the assignable periods
                    */
                    for(i=0;i<periods_set.size();i++){
                        int n = Utilfunctions.executeUpdate("UPDATE classperiod SET subCode = '" + subclass.getString(3) + "' WHERE classCode = " + classCode + " AND pconfigId = " + periods_set.get(i));
                        n = Utilfunctions.executeUpdate("INSERT INTO staffperiod(userCode,pconfigId,classCode) VALUES('" + subclass.getString(4) + "'," + periods_set.get(i) + "," + classCode + ")"); 
                    }
                }     
                if(infinity) continue;
                else break;
            }
           // sf.setVisible(false);
           // sThread.interrupt();
            JOptionPane.showMessageDialog(null,"Periods generated successfully");
            //end generate
        } catch (SQLException ex) {
            Logger.getLogger(GenerateScheduleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateScheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateScheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateScheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateScheduleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new GenerateScheduleForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GenerateScheduleForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
    private static int classCode;
}