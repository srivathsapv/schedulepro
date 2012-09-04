/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulepro;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;


/**
 *
 * @author srivathsa
 */
public class RedRenderer extends DefaultListCellRenderer {
        private static final String START = "<html><span style='color:";  
        private static final String MIDDLE = "'>";  
        private static final String END = "</span></html>";  
  
    @Override
        public Component getListCellRendererComponent(JList list, Object value,  
            int index, boolean isSelected, boolean cellHasFocus)  
        {  
            super.getListCellRendererComponent(  
                list, value, index, isSelected, cellHasFocus);  
            
            Item item = new Item(String.valueOf(index),value.toString());  
            if(index % 2 == 0)
                setText(START + "red" + MIDDLE + item.getDescription() + END);  
            else
                setText(START + "green" + MIDDLE + item.getDescription() + END);  
  
            return this;  
            
        }  
    }  
class Item  
    {  
        private String id;  
        private String description;  
  
        public Item(String id, String description)  
        {  
            this.id = id;  
            this.description = description;  
        }  
  
        public String getId()  
        {  
            return id;  
        }  
  
        public String getDescription()  
        {  
            return description;  
        }  
  
        public String toString()  
        {  
            return description;  
        }  
    }  