/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srivathsa
 */
public class ConstraintsCheck {
    public static void main(String args[]) throws SQLException{
        System.out.println(ConstraintsCheck.getPeriodDiff(61,64,1,"Thursday"));
    }
    
    public static int getTimeValue(String time){
        return Integer.parseInt(time.replace(":",""));
    }
    
    public static boolean isPeriodOverlap(String s1,String e1,String s2,String e2){
        
        int st1 = getTimeValue(s1);
        int en1 = getTimeValue(e1);
        int st2 = getTimeValue(s2);
        int en2 = getTimeValue(e2);
        
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
    
    public static boolean ispconfigOverlap(int p1,int p2) throws SQLException{
        
        ResultSet pc1 = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pconfigId = " + p1);
        pc1.next();
        
        ResultSet pc2 = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pconfigId = " + p2);
        pc2.next();
        
        int st1 = getTimeValue(pc1.getString("timeFrom"));
        int en1 = getTimeValue(pc1.getString("timeTo"));
        int st2 = getTimeValue(pc2.getString("timeFrom"));
        int en2 = getTimeValue(pc2.getString("timeTo"));
        
        return isPeriodOverlap(pc1.getString("timeFrom"),pc1.getString("timeTo"),pc2.getString("timeFrom"),pc2.getString("timeTo"));
        
    }
    
    public static void getCombinedpconfigs(Vector<Integer> vc,String day,Vector<Integer> pconfigs,int classcode,int cno){
        
        /*String query = "SELECT * FROM periodconfig WHERE pconfigId IN(" + pconfigs.toString().substring(1,pconfigs.toString().length()-1) + ") "
                + " AND day = '" + day + "'"; */
        
        
        try {
            ResultSet rsc = Utilfunctions.executeQuery("SELECT COUNT(*) FROM periodconfig WHERE pconfigId "
                    + "IN(" + pconfigs.toString().substring(1,pconfigs.toString().length()-1) + ") "
                    + "AND day = '" + day + "' ORDER BY timeFrom");
            rsc.next();
            
            ResultSet rs2c = Utilfunctions.executeQuery("SELECT COUNT(*) FROM periodconfig WHERE pconfigId "
                    + "IN(SELECT pconfigId FROM classperiod WHERE classCode = " + classcode + ") "
                    + " AND day = '" + day + "' ORDER BY timeFrom");
            
            rs2c.next();
            
            if(rsc.getInt(1) == 0 || rs2c.getInt(1) == 0) return;
            
            String query = "SELECT * FROM periodconfig WHERE pconfigId "
                    + "IN(" + pconfigs.toString().substring(1,pconfigs.toString().length()-1) + ") "
                    + "AND day = '" + day + "' ORDER BY timeFrom";
            
            ResultSet rs = Utilfunctions.executeQuery(query);
            rs.next();
            
            query = "SELECT * FROM periodconfig WHERE pconfigId "
                    + "IN(SELECT pconfigId FROM classperiod WHERE classCode = " + classcode + ") "
                    + " AND day = '" + day + "' ORDER BY timeFrom";
            
            ResultSet rs2 = Utilfunctions.executeQuery(query);
            rs2.next();
            int x=0;
            Vector<Integer> temp = new Vector<Integer>();
            
            boolean b1=true,b2=true;
            do {
                if(getTimeValue(rs.getString(3)) > getTimeValue(rs2.getString(3))){
                    b2=rs2.next();
                    temp.clear();
                    x=0;
                }
                else if(getTimeValue(rs.getString(3)) < getTimeValue(rs2.getString(3))){
                    b1=rs.next();
                    temp.clear();
                    x=0;
                }
                else if(getTimeValue(rs.getString(3)) == getTimeValue(rs2.getString(3))){
                    if(rs.getInt(5) == 1){
                        temp.add(rs.getInt(1));
                        x++;
                    }
                    if(x == cno){
                        boolean pdiff_zero=true;
                        for(int k=0;k<temp.size()-1;k++){
                            if(ConstraintsCheck.getPeriodDiff(temp.get(k),temp.get(k+1),classcode,day) != 0){
                                pdiff_zero=false;
                                break;
                            }
                        }
                        if(pdiff_zero){
                            for(int i=0;i<temp.size();i++)
                                vc.add(temp.get(i));
                        }
                        temp.clear();
                        x=0;
                    }
                    b1=rs.next();
                    b2=rs2.next();
                }
            }while(b1 && b2);
        } catch (SQLException ex) {
            Logger.getLogger(ConstraintsCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getpconfigDay(int pid) throws SQLException{
        ResultSet rs = Utilfunctions.executeQuery("SELECT day FROM periodconfig WHERE pconfigId = " + pid);
        rs.next();
        
        return rs.getString(1);
    }
    
    public static int getPeriodDiff(int p1,int p2,int classCode,String day) throws SQLException{
        
        String query = "SELECT COUNT(*) FROM periodconfig WHERE "
                + "pconfigId IN(SELECT pconfigId FROM classperiod WHERE classCode = " + classCode + ") AND pType != 3 AND"
                + " timeFrom > (SELECT timeFrom FROM periodconfig WHERE pconfigId = " + p1 + ")"
                + " AND timeTo <= (SELECT timeTo FROM periodconfig WHERE pconfigId = " + p2 + ") AND day = '" + day + "' AND pconfigId NOT IN(" + p1 + "," + p2+ ") ORDER BY timeFrom";
        
        ResultSet rs = Utilfunctions.executeQuery(query);
        rs.next();
        
        return rs.getInt(1);
    }
    
}
