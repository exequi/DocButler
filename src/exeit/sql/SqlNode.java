/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeit.sql;

/**
 *
 * @author GDZC0003
 */
public class SqlNode {
    
    public SqlFile sqlFile;
    
    public String getText(){
        return this.sqlFile.getFileName();
    }
    
    
}
