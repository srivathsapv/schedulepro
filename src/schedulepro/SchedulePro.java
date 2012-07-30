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
    public static void main(String[] args) {
        // TODO code application logic here
        SplashForm sf = new SplashForm();
        
        Utilfunctions.setLocation(sf);
        Utilfunctions.setIconImage(sf);
        
        sf.setVisible(true);
        
    }
}
