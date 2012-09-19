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
        ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM class ORDER BY classCode");
        
        while(rs.next()){
            ResultSet prs = Utilfunctions.executeQuery("SELECT * FROM periodconfig WHERE pType = 4");
            while(prs.next()){
                int n = Utilfunctions.executeUpdate("INSERT INTO classperiod(classCode,pconfigId) VALUES(" + rs.getInt(1) + "," + prs.getInt(1) + ")");
                System.out.println("Inserted " + rs.getInt(1) + "," + prs.getInt(1));
            }
        }
    }
}
