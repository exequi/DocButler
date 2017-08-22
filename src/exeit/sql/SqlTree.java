/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeit.sql;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GDZC0003
 */
public class SqlTree {
    public String title="SQL";
    
    private SqlNode[] nodeList;
    
    public String[] getNodeText(){
        List<String> list=new ArrayList<String>(); 
       // String[] r=new String[this.nodeList.length];
        for (SqlNode i:this.nodeList){
            list.add(i.getText());        
        }        
        return (String[])list.toArray();
    }
    
}
