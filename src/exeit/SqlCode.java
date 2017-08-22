/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeit;

import java.util.Date;

/**
 *
 * @author GDZC0003
 */
public class SqlCode {
    
    private Date createTime;
    
    private String content;
    
    private String tableName;
    
    private SqlType sqlType;
    
    public SqlCode(){
        
    }
    
    public SqlCode(String sqltext){
        this.content=sqltext.toLowerCase();
        this.createTime=new Date();
        this.analySql(this.content);
        
    }
    
    private void analySql(String sqltext){
        if(sqltext.indexOf("select")>-1){
            this.sqlType=SqlType.select;
        }
        else if(sqltext.indexOf("create")>-1){
            this.sqlType=SqlType.create;
        }
        else if(sqltext.indexOf("insert")>-1){
            this.sqlType=SqlType.insert;
        }
        else if(sqltext.indexOf("delete")>-1){
            this.sqlType=SqlType.delete;
        }        
        else if(sqltext.indexOf("update")>-1){
            this.sqlType=SqlType.update;
        }
    }
    
}

