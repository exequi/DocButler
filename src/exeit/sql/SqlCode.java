/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeit.sql;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GDZC0003
 */
public class SqlCode {
    
    private Date createTime;
    
    private String content;
    
    private String tableName;
    
    private SqlType sqlType;
    
    public String getTableName() {
        return this.tableName;
    }
    
    public SqlType getSqlType() {
        return this.sqlType;
    }
        
    public SqlCode(){
        
    }
    
    public SqlCode(String sqltext){
        this.content=sqltext.toLowerCase();
        this.createTime=new Date();
        this.analySqlType();
        this.analySqlTableName();
    }
    
    /*
    sql type    
    */
    private void analySqlType(){
        if(this.content.contains("select")){
            this.sqlType=SqlType.select;
        }
        else if(this.content.contains("create")){
            this.sqlType=SqlType.create;
        }
        else if(this.content.contains("insert")){
            this.sqlType=SqlType.insert;
        }
        else if(this.content.contains("delete")){
            this.sqlType=SqlType.delete;
        }        
        else if(this.content.contains("update")){
            this.sqlType=SqlType.update;
        }
        else{
            this.sqlType=SqlType.unknow;
        }
    }
    
    /*
    get sql table name
    */
    private void analySqlTableName(){
        if(this.sqlType!=SqlType.unknow){
            switch (this.sqlType){
                case create:
                    break;
                case insert:
                    break;
                case select:
                    Pattern ps=Pattern.compile("from\\s*\\w*\\s*where");
                    Matcher ms = ps.matcher(this.content);
                    if(ms.find()){
                        this.tableName=ms.group(0).replace("from","").replace("where","").trim();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public boolean isPass(){
        return !(this.tableName==null || this.sqlType==SqlType.unknow);
    }

    
}

