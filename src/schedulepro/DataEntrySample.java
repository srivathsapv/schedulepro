/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author srivathsa
 */
public class DataEntrySample {
    public static void main(String args[]) throws SQLException{
        
        ResultSet rs = Utilfunctions.executeQuery("SELECT pconfigId FROM classperiod WHERE classCode = 1");
        while(rs.next()){
            int n = Utilfunctions.executeUpdate("INSERT INTO classperiod(classCode,pconfigId) VALUES(5," + rs.getInt(1) + ")");
            System.out.println("INSERTED "+rs.getInt(1));
        }
        
    }
}
