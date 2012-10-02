/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;

/**
 *
 * @author srivathsa
 */
public class SchedulePro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        /*SplashForm sf = new SplashForm();        
        Utilfunctions.setLocation(sf);
        Utilfunctions.setIconImage(sf);
        sf.setVisible(true);*/
        Properties props = new Properties();
        props.put("logoString","");
        HiFiLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        Thread.sleep(1000);
        LoginForm lf = new LoginForm();
        Utilfunctions.setLocation(lf);
        Utilfunctions.setIconImage(lf);
        
        //Thread.sleep(1000);
        //sf.setVisible(false);
        lf.setVisible(true);
    }
}
