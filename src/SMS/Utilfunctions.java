package SMS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sasi Praveen
 */
public class Utilfunctions {
    
    public static ResultSet executeQuery(String query) {
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            String dbpwd = Utilfunctions.getDbConfig("password");
            if(con == null)
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro", "root", dbpwd);
            
            PreparedStatement statement = con.prepareStatement(query);
            result = statement.executeQuery();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //Logger.getLogger(DayWisePeriodConfigChooseForm.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return result;
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
    
    public static int executeUpdate(String query) {
        int rowsAffected = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbpwd = Utilfunctions.getDbConfig("password");
            if(con == null)
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro", "root", dbpwd);
            PreparedStatement statement;
            statement = con.prepareStatement(query);
            
            rowsAffected = statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowsAffected;
    }
    
    
    public static String randomStringGenerator(int length) {
        Random rand = new Random();
        String password = "";
        int count = 0;
        ArrayList temp = new ArrayList();
        while (count < length) {
            temp.add((char) (rand.nextInt(90 - 65 + 1) + 65));
            count++;
            temp.add((char) (rand.nextInt(122 - 97 + 1) + 97));
            count++;
            temp.add((char) (rand.nextInt(57 - 48 + 1) + 48));
            count++;
        }
        Collections.shuffle(temp, rand);
        int i = 0;
        while (i < length) {
            password += temp.get(i);
            i++;
        }
        return password;
    }
    
    public static BigInteger MD5(String input) throws NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        MD5.update(input.getBytes());
        BigInteger output = new BigInteger(1, MD5.digest());
        return output;
    }
    
    private static ResultSet result;
    private static Connection con;
}
