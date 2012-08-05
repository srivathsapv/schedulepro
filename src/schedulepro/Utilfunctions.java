/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
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
            jf.setIconImage(Toolkit.getDefaultToolkit().getImage(path + s + "src" + s + "schedulepro" + s + "logo.gif"));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Unexpected Error. Exiting application");
        }
    }
    public static ResultSet executeQuery(String query) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulepro","root","");
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
