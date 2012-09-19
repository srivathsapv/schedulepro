/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

/**
 *
 * @author srivathsa
 */
public class ConstraintsCheck {
    public static boolean isPeriodOverlap(String s1,String e1,String s2,String e2){
        
        int st1 = Integer.parseInt(s1.replace(":",""));
        int en1 = Integer.parseInt(e1.replace(":",""));
        int st2 = Integer.parseInt(s2.replace(":",""));
        int en2 = Integer.parseInt(e2.replace(":",""));
        
        if((st1 < st2 && en1 > en2 && st1 < en2 && en1 > st2) || 
           (st1 > st2 && en1 > en2 && st1 < en2 && en1 > st2) || 
           (st1 < st2 && en1 < en2 && st1 < en2 && en1 > st2) || 
           (st1 > st2 && en1 < en2 && st1 < en2 && en1 > st2)){
            return true;
        }
        else {
            return false;
        }
    }
    
}
