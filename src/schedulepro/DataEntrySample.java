/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author srivathsa
 */
public class DataEntrySample {
    public static void main(String args[]) throws SQLException, NoSuchAlgorithmException{
        ResultSet rs = Utilfunctions.executeQuery("SELECT classCode FROM class");
        while(rs.next()){
            int n = Utilfunctions.executeUpdate("INSERT INTO classschedule VALUES(" + rs.getInt(1) + ",1,1)");
        }
    }
}
