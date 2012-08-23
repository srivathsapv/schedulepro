/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

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
        SplashForm sf = new SplashForm();        
        Utilfunctions.setLocation(sf);
        Utilfunctions.setIconImage(sf);
        sf.setVisible(true);
        
        LoginForm lf = new LoginForm();
        Utilfunctions.setLocation(lf);
        Utilfunctions.setIconImage(lf);
        
        Thread.sleep(1000);
        sf.setVisible(false);
        lf.setVisible(true);
        
        UserViewForm us = new UserViewForm();
        us.setVisible(true);
    }
}
