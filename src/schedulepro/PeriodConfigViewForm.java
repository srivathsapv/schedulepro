/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author srivathsa
 */
public class PeriodConfigViewForm extends javax.swing.JFrame {

    /**
     * Creates new form PeriodViewForm
     */
    public PeriodConfigViewForm() throws SQLException {
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
        jTable1.setModel(new PeriodConfigTableModel());
        jTable1.getTableHeader().setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        
        //DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        for(int i=0;i<jTable1.getColumnCount();i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(new PeriodConfigCellRenderer());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchedulePro - Period Configuration");
        setResizable(false);

        jTable1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setMinimumSize(new java.awt.Dimension(100, 72));
        jTable1.setPreferredSize(new java.awt.Dimension(400, 400));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(80);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PeriodConfigViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeriodConfigViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeriodConfigViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeriodConfigViewForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new PeriodConfigViewForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PeriodConfigViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

class PeriodConfigTableModel extends AbstractTableModel {
    private String[] columnNames = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    
    private Object[][] data;
    
    public PeriodConfigTableModel() throws SQLException{
        
        String query = "SELECT COUNT(*) as cnt FROM periodconfig GROUP BY day ORDER BY cnt DESC LIMIT 0,1";
        ResultSet rs = Utilfunctions.executeQuery(query);
        rs.next();
        int rows = rs.getInt(1);
        data = new Object[rows][7];
        
        for(int i=0;i<columnNames.length;i++){
            int k=0;
            query = "SELECT * FROM periodconfig WHERE day = '" + columnNames[i] + "' ORDER BY timeFrom";
            rs = Utilfunctions.executeQuery(query);
            String ptype;
            
            while(rs.next()){
                if(rs.getInt(5) == 1)
                    ptype = "Period";
                else
                    ptype = "Recess";
                data[k++][i] = rs.getString(3) + "\n to \n" + rs.getString(4) + "\n(" + ptype + ")";
            }
        }
        
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

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
        
    }
    
    @Override
    public void setValueAt(Object value,int row,int column){
        data[row][column] = value;
    }
}

class PeriodConfigCellRenderer extends JTextPane implements TableCellRenderer {
 
  public PeriodConfigCellRenderer() {
    StyledDocument doc = getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

    setOpaque(true);
    
  }
 
  public Component getTableCellRendererComponent(JTable table, Object value,
               boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    if (hasFocus) {
      setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
      if (table.isCellEditable(row, column)) {
        setForeground( UIManager.getColor("Table.focusCellForeground") );
        setBackground( UIManager.getColor("Table.focusCellBackground") );
      }
    } else {
      setBorder(new EmptyBorder(1, 2, 1, 2));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}