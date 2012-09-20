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
        
        ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM subjectconstraint ORDER BY RAND() LIMIT 0,15");
        while(rs.next()){
            if(rs.getInt(4) != 3){
                int n = Utilfunctions.executeUpdate("UPDATE subjectconstraint SET combinedNo = 2 WHERE subCode = '" + rs.getString(1) + "'");
                System.out.println("Changed for " + rs.getString(1));
            }
        }
        
    }
}
