/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author srivathsa
 */
public class Utilfunctions {
    
    public static void setLocation(JFrame jf) {
        toolkit =  Toolkit.getDefaultToolkit ();
        dim = toolkit.getScreenSize();
        
        width = dim.width;
        height  = dim.height;
        
        Dimension dm = jf.getContentPane().getSize();
        
        int x = (width - dm.width)/2;
        int y = (height - dm.height)/2;
        
        jf.setLocation(x,y);
        
    }
    
    public static void setIconImage(JFrame jf){
        File directory = new File(".");
        try{
            String path = directory.getCanonicalPath();
            String s = File.separator;
            jf.setIconImage(Toolkit.getDefaultToolkit().getImage(path + s + "src" + s + "images" + s + "logo.gif"));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Unexpected Error. Exiting application");
        }
    }
    public static ResultSet executeQuery(String query) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            File directory = new File(".");
            String path = directory.getCanonicalPath();
            String s = File.separator;
            FileInputStream fstream = new FileInputStream(path + s + "src" + s + "config" + s + "dbconfig.cfg");
            
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String dbpwd="";
            
            while ((strLine = br.readLine()) != null)   {
                if(strLine.indexOf("password") >= 0 ) {
                    dbpwd = strLine.substring(strLine.indexOf('\t')+1);
                    break;
                }
            }
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro","root",dbpwd);
            PreparedStatement statement = con.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return result;
    }
    private static Toolkit toolkit;
    private static Dimension dim;
    private static int width;
    private static int height;
    private static ResultSet result;
}
