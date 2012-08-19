/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author srivathsa
 */
public class Utilfunctions {

    public static void setLocation(JFrame jf) {
        toolkit = Toolkit.getDefaultToolkit();
        dim = toolkit.getScreenSize();

        width = dim.width;
        height = dim.height;

        Dimension dm = jf.getContentPane().getSize();

        int x = (width - dm.width) / 2;
        int y = (height - dm.height) / 2;

        jf.setLocation(x, y);

    }

    public static void setIconImage(JFrame jf) {
        File directory = new File(".");
        try {
            String path = directory.getCanonicalPath();
            String s = File.separator;
            jf.setIconImage(Toolkit.getDefaultToolkit().getImage(path + s + "src" + s + "images" + s + "logo.gif"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected Error. Exiting application");
        }
    }

    public static String getDbConfig(String field) {
        String value = "";
        try {
            File directory = new File(".");
            String path = directory.getCanonicalPath();
            String s = File.separator;
            FileInputStream fstream = new FileInputStream(path + s + "src" + s + "config" + s + "dbconfig.cfg");

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                if (strLine.indexOf("password") >= 0 && field.equals("password") == true) {
                    value = strLine.substring(strLine.indexOf('\t') + 1);
                    break;
                }

                if (strLine.indexOf("username") >= 0 && field.equals("username") == true) {
                    value = strLine.substring(strLine.indexOf('\t') + 1);
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return value;

    }

    public static ResultSet executeQuery(String query) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            String dbpwd = Utilfunctions.getDbConfig("password");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro", "root", dbpwd);
            PreparedStatement statement = con.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return result;
    }

    public static BigInteger MD5(String input) throws NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        MD5.update(input.getBytes());
        BigInteger output = new BigInteger(1, MD5.digest());
        return output;
    }

    public static int executeUpdate(String query) {
        int rowsAffected = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbpwd = Utilfunctions.getDbConfig("password");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro", "root", dbpwd);
            PreparedStatement statement = con.prepareStatement(query);
            rowsAffected = statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowsAffected;
    }

    public static void setClosePrompt(JFrame jf) {
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit SchedulePro?", "SchedulePro - Exit", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void showCSVFileOpenDialog(String tablename, String parentTable, int parentKeyColumn, int passwordField) throws FileNotFoundException, IOException, SQLException, NoSuchAlgorithmException {
        JFileChooser fopen = new JFileChooser();

        javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("Comma Separated Values(CSV) Files", "csv");
        fopen.addChoosableFileFilter(filter);

        int ret = fopen.showDialog(null, "Open File");
        if (ret == JFileChooser.APPROVE_OPTION) {
            CSVRead loginCSV = new CSVRead();
            loginCSV.setFilename(fopen.getSelectedFile().toString());
            loginCSV.setTablename(tablename);
            if (parentTable != null) {
                loginCSV.setParentTable(parentTable);
            }
            if (parentKeyColumn != 0) {
                loginCSV.setParentKeyColumn(parentKeyColumn);
            }
            if (passwordField != 0) {
                loginCSV.setPasswordField(passwordField);
            }
            try {
                loginCSV.insertRows();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Invalid File");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Data");
            }
        } else {
            fopen.setVisible(false);
        }
    }

    public static void populateComboBoxwithQuery(JComboBox ComboBox, String Query) {
        ComboBox.removeAllItems();
        ResultSet result = Utilfunctions.executeQuery(Query);
        try {
            while (result.next() != false) {
                ComboBox.addItem(result.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private static Toolkit toolkit;
    private static Dimension dim;
    private static int width;
    private static int height;
    private static ResultSet result;
}
