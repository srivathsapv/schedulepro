/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
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
    
    public void insertRows() throws FileNotFoundException, IOException{
        try{
            BufferedReader csv = new BufferedReader(new FileReader(this.filename));
            String dataRow = csv.readLine();            
            int i=1;
            while(dataRow != null){
                if(i==1){
                    dataRow = csv.readLine();
                }
                else {
                    String query="INSERT INTO " + this.tablename + " VALUES(";
                    String[] dataArray = dataRow.split(",");
                    for(String item:dataArray){
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
}
