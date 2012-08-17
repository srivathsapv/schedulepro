/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author srivathsa
 */
public class CSVRead {
    
    public void setFilename(String fname) {
        filename=fname;
    }
    
    public void setTablename(String tname){
        tablename=tname;
    }
    
    public void setParentTable(String ptable){
        parentTable = ptable;
    }
    
    public void setParentKeyColumn(int pkcolumn){
        parentKeyColumn = pkcolumn;
    }
    
    public void setPasswordField(int pwdField){
        passwordField = pwdField;
    }
    
    public void insertRows() throws FileNotFoundException, IOException, SQLException, NoSuchAlgorithmException{
        String parentKeyColumnName = "";
        String[] dataArray;
        try{
            BufferedReader csv = new BufferedReader(new FileReader(this.filename));
            String dataRow = csv.readLine();            
            int i=1;
            while(dataRow != null){
                if(i==1){
                    dataArray = dataRow.split(",");
                    parentKeyColumnName = dataArray[parentKeyColumn-1];
                    dataRow = csv.readLine();                    
                }
                else {
                    dataArray = dataRow.split(",");
                    if(parentTable != null && parentKeyColumn != 0){  
                        String query = "SELECT * FROM "+parentTable + " WHERE " + parentKeyColumnName + " = '" + dataArray[parentKeyColumn-1] + "'";
                        ResultSet rs = Utilfunctions.executeQuery(query);
                        rs.next();
                        if(rs.getRow() == 0) {
                            JOptionPane.showMessageDialog(null,"Invalid data found. Skipping insertion of this row");
                            dataRow = csv.readLine();
                            continue;
                        }
                    }
                    String query="INSERT INTO " + this.tablename + " VALUES(";
                    int k = 1;
                    for(String item:dataArray){
                        if(k++ == passwordField)
                            item = Utilfunctions.MD5(item).toString(16);
                        query = query + "'" + item + "',";
                    }
                    query = query.substring(0, query.length()-1);
                    query = query + ")";
                    int ra = Utilfunctions.executeUpdate(query);                
                    dataRow = csv.readLine();
                }
                i++;
            }
            JOptionPane.showMessageDialog(null, "Rows inserted successfully");
            csv.close();
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Specified file not found");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"Illegal CSV format");
        }
        
        
    }
    
    String filename;
    String tablename;
    String parentTable;
    int parentKeyColumn;
    int passwordField;
}
