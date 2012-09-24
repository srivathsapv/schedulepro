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
        
        ResultSet rs = Utilfunctions.executeQuery("SELECT * FROM subject");
        while(rs.next()){
            if(rs.getString(2).indexOf("Lab") >= 0){
                int n = Utilfunctions.executeUpdate("UPDATE subjectconstraint SET subType = 2 WHERE subCode = '" + rs.getString(1) + "'");
                System.out.println("Updated " + rs.getString(2));
            }
        }
        
    }
}
