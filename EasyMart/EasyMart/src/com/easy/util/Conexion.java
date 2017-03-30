package com.easy.util;
import java.sql.*; 
public class Conexion {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String user = "easymart"; //usuario de ejemplo
    private String password = "sa"; //pass de ejemplo
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=EasyMart";

    public Conexion() {
        
    }
    public Connection Conectar(){
    	try{ 
    		Class.forName(driver);
    		return (DriverManager.getConnection(url,user,password));	
    	}catch(Exception e){}
    	return null;
    }
    public void Desconectar(Connection cn){
    	try{
    		cn.close();
    	}catch(Exception e){}
    	
    }
}