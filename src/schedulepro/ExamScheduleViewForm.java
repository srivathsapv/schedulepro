/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author srivathsa
 */
public class ExamScheduleViewForm extends javax.swing.JFrame {
    public int selectedRow;
    public int selectedColumn;
    public static int examCode;
    public static String examDate;
    private String userRole;
    public static String timeTo;
    public static String timeFrom;

    /**
     * Creates new form ExamScheduleViewForm
     */
    public ExamScheduleViewForm() throws SQLException {
        initComponents();
        
        String query = "";
        
        if(LoginForm.userRole.equals("sa"))
            query = "SELECT CONCAT(course,' ',dept,' ',year,' - ',section) FROM class WHERE classCode IN(SELECT DISTINCT(classCode) FROM exam)";
        else 
            query = "SELECT CONCAT(course,' ',dept,' ',year,' - ',section) FROM class WHERE classCode IN(SELECT DISTINCT(classCode) FROM exam) AND dept = '" + LoginForm.userDept + "'";
        
        
        Utilfunctions.populateComboBoxwithQuery(jComboBox1,query);
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
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setModel(new ExamTableModel());
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
        
        
        JComboBox sectionCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(sectionCombo, "SELECT DISTINCT(section) FROM class ORDER BY section");
        
        JComboBox yearCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(yearCombo, "SELECT DISTINCT(year) FROM class ORDER BY year");
        
        JComboBox courseCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(courseCombo, "SELECT DISTINCT(course) FROM class");
        
        JComboBox deptCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(deptCombo,"SELECT dept FROM dept ORDER BY dept");
        
        JComboBox subCombo = new JComboBox();
        Utilfunctions.populateComboBoxwithQuery(subCombo, "SELECT subName FROM subject ORDER BY subName");
        
        JFormattedTextField fft = new JFormattedTextField(new SimpleDateFormat("dd-MMM-yyyy"));
        
        TableColumn col = jTable1.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(subCombo));
        
        col = jTable1.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(fft));
        
        col = jTable1.getColumnModel().getColumn(4);
        col.setCellEditor(new DefaultCellEditor(deptCombo));
        
        col = jTable1.getColumnModel().getColumn(5);
        col.setCellEditor(new DefaultCellEditor(courseCombo));
        
        col = jTable1.getColumnModel().getColumn(6);
        col.setCellEditor(new DefaultCellEditor(yearCombo));
        
        col = jTable1.getColumnModel().getColumn(7);
        col.setCellEditor(new DefaultCellEditor(sectionCombo));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        assignFacultyMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        assignFacultyMenuItem.setText("Assign/Change Faculty");
        assignFacultyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignFacultyMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(assignFacultyMenuItem);

        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - View Exam Schedule");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Exam Schedule");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel2.setText("Class");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        userRole = LoginForm.userRole;
        if (userRole.equals("sa") || userRole.equals("ds") || userRole.equals("hod")) {
            if (evt.getClickCount() == 2) {
                evt.consume();
                JTable source = (JTable) evt.getSource();
                if (source.columnAtPoint(evt.getPoint()) == 3) {
                    PeriodConfigViewForm pcvf;
                    try {
                        pcvf = new PeriodConfigViewForm();
                        Utilfunctions.setLocation(pcvf);
                        Utilfunctions.setIconImage(pcvf);
                        PeriodConfigViewForm.source = "exam";
                        PeriodConfigViewForm.srcTable = jTable1;
                        PeriodConfigViewForm.tableRow = source.rowAtPoint(evt.getPoint());
                        pcvf.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(ExamScheduleViewForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (SwingUtilities.isRightMouseButton(evt)) {
                JTable source = (JTable) evt.getSource();
                selectedRow = source.rowAtPoint(evt.getPoint());
                selectedColumn = source.columnAtPoint(evt.getPoint());
                examCode = ExamTableModel.examCodes[selectedRow];
                examDate = ExamTableModel.examDates[selectedRow];
                timeFrom = ExamTableModel.timeFroms[selectedRow];
                timeTo = ExamTableModel.timeTos[selectedRow];
                if (!source.isRowSelected(selectedRow)) {
                    source.changeSelection(selectedRow, selectedColumn, false, false);
                }

                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void assignFacultyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignFacultyMenuItemActionPerformed
        // TODO add your handling code here:
        AssignFacultytoExamForm.ChooseInvoker = this;
        AssignFacultytoExamForm ef;
        try {
            ef = new AssignFacultytoExamForm();
            Utilfunctions.setIconImage(ef);
            Utilfunctions.setLocation(ef);
            ef.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(ExamScheduleViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_assignFacultyMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this exam?","Delete Exam",JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){
            Utilfunctions.executeUpdate("DELETE FROM exam WHERE examCode = '" + ExamTableModel.examCodes[selectedRow] + "'");
            Utilfunctions.executeUpdate("DELETE FROM `examinvigilation` WHERE `examCode`='" + ExamTableModel.examCodes[selectedRow] + "'");
            ExamTableModel model = (ExamTableModel)jTable1.getModel();
            try {
                jTable1.setModel(new ExamTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(EquipmentViewForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            classCode = Utilfunctions.getClassCode(jComboBox1.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(ExamScheduleViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(ExamScheduleViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamScheduleViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamScheduleViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamScheduleViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new ExamScheduleViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ExamScheduleViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem assignFacultyMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    public static int classCode;
}
class ExamTableModel extends AbstractTableModel {
        private String[] columnNames = {"Exam Name","Subject","Exam Date","Time Slot","Department","Course","Year","Section","Room No","Assigned Faculty"};
        private Object[][] data;
	
        public  static int[] examCodes;
        private String[] examNames;
        private String[] subCodes;
        public static String[] examDates;
        private String[] pconfigIds;
        private String[] classCodes;
        private static int msgCount=0;
        public static String[] timeFroms;
        public static String[] timeTos;
        private String[] roomId;
        private String roomNo;
        private final String userRole;
        
        public ExamTableModel() throws SQLException{
            
            userRole = LoginForm.userRole;
            String query;
            
            query = query = "SELECT `examCode`,`examName`,`subCode`,`examDate`,`pconfigId`,`classCode`,`roomId` FROM exam WHERE classCode = " + ExamScheduleViewForm.classCode + " ORDER BY examName,examDate";
            
            ResultSet rs = Utilfunctions.executeQuery(query);
            
            int cnt = 0;
            while(rs.next())
                cnt++;
            
            data = new Object[cnt][8];
            examCodes = new int[cnt];
            subCodes = new String[cnt];
            examNames = new String[cnt];
            subCodes = new String[cnt];
            examDates = new String[cnt];
            pconfigIds = new String[cnt];
            classCodes = new String[cnt];
            roomId = new String[cnt];
            timeFroms = new String[cnt];
            timeTos = new String[cnt];
            
            int i = 0;
            rs = Utilfunctions.executeQuery(query);
            while(rs.next()){
                String assignedFaculty="";
                query = "SELECT subName FROM subject WHERE subcode = '" + rs.getString(3) + "'";
                ResultSet subResult = Utilfunctions.executeQuery(query);
                subResult.next();
                
                query = "SELECT day,timeFrom,timeTo FROM periodconfig WHERE pconfigId = '" + rs.getString(5) + "'";
                ResultSet pconfigResult = Utilfunctions.executeQuery(query);
                pconfigResult.next();
                timeFroms[i] = pconfigResult.getString(2);
                timeTos[i] = pconfigResult.getString(3);
                query = "SELECT dept,course,year,section FROM class WHERE classCode = '" + rs.getString(6) + "'";
                ResultSet classResult = Utilfunctions.executeQuery(query);
                classResult.next();
         
                query = "select roomNo from classroom where roomId="+rs.getString(7);
                ResultSet roomResult = Utilfunctions.executeQuery(query);
                if(roomResult.next()){
                    roomNo = roomResult.getString(1);
                }else
                {
                    roomNo="";
                }
                
                query = "SELECT userCode FROM examinvigilation WHERE examCode = " + rs.getString(1);
                ResultSet userResult = Utilfunctions.executeQuery(query);
                if (userResult.next()) {
                    query = "SELECT CONCAT(name,'(',userCode,')') FROM user WHERE userCode = '" + userResult.getString(1) + "'";
                    userResult = Utilfunctions.executeQuery(query);
                    if (userResult.next()) {
                        assignedFaculty = userResult.getString(1);
                    } else {
                        assignedFaculty = "";
                    }
                }
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String examDate = df.format(rs.getDate(4));
                
                examCodes[i] = rs.getInt(1);
                examNames[i] = rs.getString(2);
                subCodes[i] = rs.getString(3);
                examDates[i] = rs.getString(4);
                pconfigIds[i] = rs.getString(5);
                classCodes[i] = rs.getString(6);
                roomId[i]=rs.getString(7);
                
                Object[] values = {rs.getString(2),subResult.getString(1),examDate,pconfigResult.getString(2).substring(0,5) + " to " + pconfigResult.getString(3).substring(0,5),classResult.getString(1),classResult.getString(2),classResult.getString(3),classResult.getString(4),roomNo,assignedFaculty};
                data[i++] = values;
            }   
            fireTableDataChanged();
        }
        
    @Override
        public int getColumnCount() {
            return columnNames.length;
        }

    @Override
        public int getRowCount() {
            return data.length;
        }

    @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

    @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
            
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
    @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
    @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if(col == 3 || col == 9) return false;
            else if(!LoginForm.userRole.equals("sa") && col == 4){
                return false;
            }
            else {
                return true;
            }
        }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
        public void setValueAt(Object value, int row, int col) {
            msgCount++;
            String query;
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            df.setLenient(false);
            String dept=data[row][4].toString(),course=data[row][5].toString(),year=data[row][6].toString(),section=data[row][7].toString();
            ResultSet rs;
            
            if(value.equals(data[row][col].toString())) {
                return;
            }
            
            switch(col){
                case 0:
                    examNames[row] = value.toString();
                    break;
                case 1:
                    query = "SELECT subcode FROM subject WHERE subName = '" + value.toString() + "'";
                    rs = Utilfunctions.executeQuery(query);
                    try {
                        rs.next();
                        subCodes[row] = rs.getString(1);
                    } catch (SQLException ex) {
                        Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    examDates[row] = value.toString();
                    break;
                case 3:
                    try {
                        Date dt = df.parse((data[row][2]).toString());
                        Calendar cl = Calendar.getInstance();
                        cl.setTime(dt);

                        query = "SELECT day FROM periodconfig where pconfigId = " + PeriodConfigViewForm.pConfigId;
                        rs = Utilfunctions.executeQuery(query);
                        try {
                            rs.next();
                            cl.set(Calendar.DAY_OF_WEEK,Utilfunctions.getDayNumber(rs.getString(1)));
                            String changedDate = df.format(cl.getTime());
                            
                            setValueAt(changedDate,row,2);
                        } catch (SQLException ex) {
                            Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    } catch (ParseException ex) {
                        Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pconfigIds[row] = Integer.toString(PeriodConfigViewForm.pConfigId);
                    break;
                case 4:
                case 5:                    
                case 6:
                case 7:
                   if(col == 4) dept = value.toString();
                   else if(col == 5) course = value.toString();
                   else if(col == 6) year = value.toString();
                   else if(col == 7) section = value.toString() ;
                   
                   query = "SELECT classCode FROM class WHERE dept = '" + dept + 
                            "' AND course = '" + course + "' AND year = '" + 
                            year + "' AND section = '" + section + "'";
                   rs = Utilfunctions.executeQuery(query);
                    try {
                        rs.next();
                        classCodes[row] = rs.getString(1);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"Class " + year + " '" + section 
                                                           + "' " + course + " - " + dept 
                                                           + " does not exist");
                    }
                    break;  
                case 8:
                    query = "SELECT COUNT(*) FROM classroom WHERE roomNo = '" + value.toString()  + "'";
                    rs = Utilfunctions.executeQuery(query);
                    try {
                        rs.next();
                        if(rs.getInt(1) == 1){
                            query = "SELECT roomId FROM classroom WHERE roomNo = '" + value.toString() + "'";
                            rs = Utilfunctions.executeQuery(query);
                            rs.next();
                            int roomId = rs.getInt(1);
                            query = "UPDATE exam SET roomId = '" + roomId + "' WHERE examCode = '" + examCodes[row] + "'";
                            int x = Utilfunctions.executeUpdate(query);
                            if(x >= 1) JOptionPane.showMessageDialog(null,"Value Updates Successfully");
                        }
                        else {
                            query = "INSERT INTO classroom(roomNo) VALUES('" + value.toString() + "')";
                            int x = Utilfunctions.executeUpdate(query);
                            if(x >= 1) JOptionPane.showMessageDialog(null,"Value Updates Successfully");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
            
            //a schedule should not have a subject occuring more than once
            query = "SELECT COUNT(*) FROM exam WHERE examName = '" + examNames[row] 
                    + "' AND subcode = '"  + subCodes[row] + "' AND examCode != " + examCodes[row];
            
            rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"A schedule should not have a subject occuring more than once");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //duplicate exam schedule
            query = "SELECT COUNT(*) FROM exam WHERE subCode = '" + subCodes[row] + "' AND examName = '" + examNames[row] 
                            + "' AND examDate = '" + examDates[row] + "' AND pconfigId = " 
                            + pconfigIds[row] + " AND classCode = '" + classCodes[row] 
                            + "' AND examCode != " + examCodes[row];
            rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Duplicate exam schedule");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //two different subjects on the same day,same time and for the same class , in a same schedule shouldn't be conducted
            query = "SELECT COUNT(*) FROM exam WHERE examName = '" + examNames[row] 
                            + "' AND examDate = '" + examDates[row] + "' AND pconfigId = " 
                            + pconfigIds[row] + " AND classCode = '" + classCodes[row] 
                            + "' AND examCode != " + examCodes[row];
            
            rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Two different subjects on the same day,same time and for the same class , in a same schedule shouldn't be conducted");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //the subject should be the ones already assigned to the class
            query = "SELECT COUNT(*) FROM subclass WHERE classCode = '" + classCodes[row] + "' AND subCode = '" + subCodes[row] + "'";
            rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(null,"The subject should be the one among those already assigned to the class");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //two different exams should not have a schedule on the same day , same time
            query = "SELECT COUNT(*) FROM exam WHERE examDate = '" + examDates[row] + "' AND pconfigId = " + pconfigIds[row] + " AND examCode != " + examCodes[row];
            rs = Utilfunctions.executeQuery(query);
            try {
                rs.next();
                if(rs.getInt(1) >= 1) {
                    JOptionPane.showMessageDialog(null,"Two different exams should not have a schedule on the same day and same time");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExamTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String fDate="";
            try {    
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = df2.parse(examDates[row]);
                fDate = df2.format(dt);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null,"Invalid Date");
                return;
            }
            
            query = "UPDATE exam SET examName = '" + examNames[row] 
                    + "', subCode = '" + subCodes[row] + "', examDate = '" 
                    + fDate + "' , pconfigId = '" + pconfigIds[row] 
                    + "', classCode = '" + classCodes[row] + "' WHERE examCode = " + examCodes[row];
            
            int n = Utilfunctions.executeUpdate(query);
            if(msgCount==2)
                if(n >= 1) JOptionPane.showMessageDialog(null,"Value Updated Successfully");
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);
            if(msgCount > 1) msgCount=0;
        }
    }